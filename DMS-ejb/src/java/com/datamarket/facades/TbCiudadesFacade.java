/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbCiudades;
import com.datamarket.entidades.TbCiudadesPK;
import com.datamarket.entidades.TbDepartamentos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
@Stateless
public class TbCiudadesFacade extends ManejadorPersistencia<TbCiudades> {

    /*
     Funcion que persiste en la base de datos una entidad de tipo TbCiudades a la tabla 'Tb_Ciudades'
     */
    public void guardarTbCiudades(TbCiudades ciudad) {
        persistir(ciudad);
    }

    /*
     Funcion que elimina en la base de datos una entidad de tipo TbCiudades a la tabla 'Tb_Ciudades'
     */
    public void eliminarTbCiudades(TbCiudades ciudad) {
        Query q = em.createNamedQuery("TbCiudades.findByCiNombre", TbCiudades.class).setParameter("CiDescripcion", ciudad.getCiNombre());
        TbCiudades paisEliminar = (TbCiudades) q.getSingleResult();
        eliminar(ciudad);
    }

    /*
     Funcion que modifica  en la base de datos una entidad de tipo TbCiudades a la tabla 'Tb_Ciudades'
     */
    public void modificarTbCiudades(TbCiudades ciudad) {
        em.merge(ciudad);
    }

    public List<TbCiudades> buscarCiudadesPorDepartamento(TbDepartamentos departamento) {
        List<TbCiudades> ciudadesPorDepartamento;
        Query q = em.createQuery("SELECT t FROM TbCiudades t WHERE t.tbCiudadesPK.ciDepto = :departamento AND t.tbCiudadesPK.ciPais = :pais ORDER BY t.ciNombre");
        q.setParameter("departamento", departamento.getTbDepartamentosPK().getDeCodigo());
        q.setParameter("pais", departamento.getTbDepartamentosPK().getDePais());
        ciudadesPorDepartamento = q.getResultList();
        return ciudadesPorDepartamento;
    }
    
    
    public String findNombreById(String ciPais,String ciDepto, String ciCiudad)
    {
    TbCiudadesPK id = new TbCiudadesPK();
    id.setCiCiudad(ciCiudad);
    id.setCiDepto(ciDepto);
    id.setCiPais(ciPais);
    TbCiudades ciudad = em.find(TbCiudades.class, id);
    return ciudad.getCiNombre().toUpperCase();
    }
}
