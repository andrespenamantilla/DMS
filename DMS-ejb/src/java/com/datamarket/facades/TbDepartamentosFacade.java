/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbDepartamentos;
import com.datamarket.entidades.TbDepartamentosPK;
import com.datamarket.entidades.TbPaises;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
@Stateless
public class TbDepartamentosFacade extends ManejadorPersistencia<TbDepartamentos> {

    /*
     Funcion que persiste en la base de datos una entidad de tipo TbDepartamentos a la tabla 'Tb_Departamentos'
     */
    public void guardarTbDepartamento(TbDepartamentos departamento) {
        persistir(departamento);
    }

    /*
     Funcion que elimina en la base de datos una entidad de tipo TbDepartamentos a la tabla 'Tb_Departamentos'
     */
    public void eliminarTbDepartamentoc(TbDepartamentos departamento) {
        Query q = em.createNamedQuery("TbDepartamentos.findByDeNombre", TbDepartamentos.class).setParameter("DeNombre", departamento.getDeNombre());
        TbDepartamentos paisEliminar = (TbDepartamentos) q.getSingleResult();
        eliminar(departamento);
    }

    /*
     Funcion que modifica  en la base de datos una entidad de tipo TbDepartamentos a la tabla 'Tb_Departamentos'
     */
    public void modificarTbDepartamento(TbDepartamentos departamento) {
        em.merge(departamento);
    }

    public List<TbDepartamentos> buscarDepartamentosPorPais(TbPaises pais) {
        List<TbDepartamentos> departamentosPorPais;
        Query q = em.createQuery("SELECT t FROM TbDepartamentos t WHERE t.tbPaises = :tbPaises ORDER BY T.deNombre");
        q.setParameter("tbPaises", pais);
        departamentosPorPais = q.getResultList();

        return departamentosPorPais;
    }
    
    public TbDepartamentos findById(TbDepartamentosPK id)
    {
    TbDepartamentos departamentoHallado;
    departamentoHallado = em.find(TbDepartamentos.class, id);
    return departamentoHallado;
    }
    
    public boolean validarExistenciaDepartamentoPorNombre()
    {
    
    return true;
    }
    
    
    public String findNombreById(String dePais, String deCodigo)
    {
    TbDepartamentos departamentoHallado;
    TbDepartamentosPK id = new TbDepartamentosPK();
    id.setDePais(dePais);
    id.setDeCodigo(deCodigo);
    departamentoHallado = em.find(TbDepartamentos.class, id);
    return departamentoHallado.getDeNombre().toUpperCase();
    }
    
    
    
}
