/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbEjecutivos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
@Stateless
public class TbEjecutivosFacade extends ManejadorPersistencia<TbEjecutivos> {

    /*
     Funcion que persiste en la base de datos una entidad de tipo TbEjecutivos a la tabla 'Tb_Ejecutivos'
     */
    public void guardarTbEjecutivos(TbEjecutivos ejecutivo) {
        em.persist(ejecutivo);
    }

    /*
     Funcion que modifica en la base de datos una entidad de tipo TbEjecutivos a la tabla 'Tb_Ejecutivos'
     */
    public void modificarTbEjecutivos(TbEjecutivos ejecutivo) {
        em.merge(ejecutivo);
    }

    /*   Funcion que ejecuta el  query 
     "Seleccionar  todos los registros de la tabla 'Tb_Ejecutivos'
     */
    public List getAllEjecutivos() {
        Query q = em.createNamedQuery("TbEjecutivos.findAll", TbEjecutivos.class);
        List<TbEjecutivos> ejecutivos = q.getResultList();
        return ejecutivos;
    }

    /*
     Funcion que elimina en la base de datos una entidad de tipo TbEjecutivos a la tabla 'Tb_Ejecutivos'
     */
    public void eliminarTbEmpresa(TbEjecutivos ejecutivo) {
        Query q = em.createNamedQuery("TbEjecutivos.findByEjCodigo", TbEjecutivos.class).setParameter("ejCodigo", ejecutivo.getEjCodigo());
        TbEjecutivos ejecutivoEliminar = (TbEjecutivos) q.getSingleResult();
        eliminar(ejecutivoEliminar);
    }

    
    
      /*
     Funcion que ejecuta el  query 
     "Buscar por 'ej_codigo' en la tabla 'tb_ejecutivos'
     */

 public TbEjecutivos buscarPorId(Integer ejCodigo) {
        Query query = em.createNamedQuery("TbEjecutivos.findByEjCodigo", TbEjecutivos.class).setParameter("ejCodigo", ejCodigo);
        TbEjecutivos ejecutivoByEjCodigo = em.find(TbEjecutivos.class, ejCodigo);
        if (ejecutivoByEjCodigo == null) {
            return null;
        } else {
            return ejecutivoByEjCodigo;
        }
    }
    
}
