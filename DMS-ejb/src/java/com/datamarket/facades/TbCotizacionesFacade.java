/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.Ifacades.ITbCotizacionesFacadeLocal;
import com.datamarket.entidades.TbCotizaciones;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbCotizacionesFacade extends ManejadorPersistencia<TbCotizaciones> implements ITbCotizacionesFacadeLocal {

    @Override
    public Integer retornarCodCotizacion() {
        Query q = em.createNamedQuery("TbCotizaciones.findAll");
        if (q.getResultList().isEmpty()) {
            return 1;
        } else {
            Integer aux = q.getResultList().size();
            TbCotizaciones cotizacion = (TbCotizaciones) q.getResultList().get(aux - 1);
            return cotizacion.getCoCodCotiz();
        }
    }

    @Override
    public void persistirCotizacion(TbCotizaciones cotizacion) {
        em.persist(cotizacion);
    }

    @Override
    public void eliminarCotizacion(TbCotizaciones cotizacion) {
        em.remove(cotizacion);
    }

    @Override
    public void actualizarCotizacion(TbCotizaciones cotizacion) {
        em.merge(cotizacion);
    }

    @Override
    public TbCotizaciones findById(Integer id) {
        return em.find(TbCotizaciones.class, id);
    }

    @Override
    public List<TbCotizaciones> listarTodosLasCotizaciones() {
        Query q = em.createNamedQuery("TbCotizaciones.findAll");
        return q.getResultList();
    }

    @Override
    public List<TbCotizaciones> listarTodosLasCotizacionesPorCaso(Integer coCaso) {
        Query q = em.createNamedQuery("TbCotizaciones.findByCoCaso");
        q.setParameter("coCaso", coCaso);
        return q.getResultList();
    }

}
