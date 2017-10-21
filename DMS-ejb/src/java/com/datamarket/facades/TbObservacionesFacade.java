/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbObservaciones;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import com.datamarket.Ifacades.ITbObservacionesFacadeLocal;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbObservacionesFacade extends ManejadorPersistencia<TbObservaciones> implements ITbObservacionesFacadeLocal {

    @Override
    public void persistirObservacion(TbObservaciones observacion) {
        em.persist(observacion);
    }

    @Override
    public void eliminarObservacion(TbObservaciones observacion) {
        em.remove(observacion);
    }

    @Override
    public void actualizarObservacion(TbObservaciones observacion) {
        em.merge(observacion);
    }

    @Override
    public TbObservaciones findById(Integer id) {
        return em.find(TbObservaciones.class, id);
    }

    @Override
    public List<TbObservaciones> listarTodasLasObservaciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer retornarDcCodigo() {
        
        Query q = em.createNamedQuery("TbObservaciones.findAll");
        if (q.getResultList().isEmpty()) {
            return 1;
        } else {
            Integer aux = q.getResultList().size();
            System.out.println(aux);
            TbObservaciones observacion = (TbObservaciones) q.getResultList().get(aux - 1);
            return observacion.getDcCodigo();

        }

    }
}