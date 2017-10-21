/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbPaises;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
@Stateless
public class TbPaisesFacade extends ManejadorPersistencia<TbPaises> {

    /*
     Funcion que persiste en la base de datos una entidad de tipo TbPaises a la tabla 'Tb_Paises'
     */
    public void guardarTbPaises(TbPaises pais) {
        persistir(pais);
    }

    /*
     Funcion que elimina en la base de datos una entidad de tipo TbPaises a la tabla 'Tb_Paises'
     */
    public void eliminarTbPaises(TbPaises pais) {
        Query q = em.createNamedQuery("TbPaises.findByPaNombre", TbPaises.class).setParameter("PaNombre", pais.getPaNombre());
        TbPaises paisEliminar = (TbPaises) q.getSingleResult();
        eliminar(pais);
    }

    /*
     Funcion que modifica  en la base de datos una entidad de tipo TbPaises a la tabla 'Tb_Paises'
     */
    public void modificarTbAdmRoles(TbPaises pais) {
        em.merge(pais);
    }

    /*Esta función busca todos los paises existentes en la base de datos*/
    public List<TbPaises> todosLosPaises() {

        Query q = em.createNamedQuery("TbPaises.findAll", TbPaises.class);
        List<TbPaises> listaPaises = q.getResultList();
        /*Retorna la lista llena*/
        return listaPaises;
    }

    /*Busca un pais por nombre*/
    public TbPaises buscarPaisPorNombre(String nombrePais) {
        TbPaises paisHallado;
        Query q = em.createNamedQuery("TbPaises.findByPaNombre", TbPaises.class).setParameter("paNombre", nombrePais);
        paisHallado = (TbPaises) q.getSingleResult();

        return paisHallado;
    }

    /*Busca un pais por id*/
    public TbPaises buscarPaisPorId(String codigoPais) {
        TbPaises paisHallado;
        Query q = em.createNamedQuery("TbPaises.findByPaCodigo", TbPaises.class).setParameter("paCodigo", codigoPais.toString());
        paisHallado = (TbPaises) q.getSingleResult();

        return paisHallado;
    }

    public TbPaises findById(String paisId) {
        TbPaises paisHallado = new TbPaises();
        paisHallado = em.find(TbPaises.class, paisId);
        return paisHallado;
    }

    public boolean validarExistenciaPaisPorNombre(String paNombre) {
        Query q = em.createNamedQuery("TbPaises.findByPaNombre").setParameter("paNombre", paNombre);
        if (q.getResultList().size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List listarTodosLosPaises() {
        Query query = em.createNativeQuery("SELECT * FROM tb_paises ORDER BY tb_paises.pa_nombre", TbPaises.class);
        List<TbPaises> paisesHallados = (List<TbPaises>) query.getResultList();
        return paisesHallados;
    }
    
     public String findNombreById(String paisId) {
        TbPaises paisHallado = new TbPaises();
        paisHallado = em.find(TbPaises.class, paisId);
        return paisHallado.getPaNombre().toUpperCase();
    }

    
}
