/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Andres
 */
public abstract class ManejadorPersistencia<T> implements Serializable {

    @PersistenceContext(unitName = "EnterpriseApplicationDMS-ejbPU")
    EntityManager em;

    /*Este método persiste un objeto*/
    public void persistir(T obj) {
        em.persist(obj);
    }

    /*Este método elimina un objeto*/
    public void eliminar(T obj) {
        em.remove(obj);
    }
    
    /*Este método actualiza un objeto*/
    public void actualizar(T obj) {
        em.merge(obj);
    }
       
}
