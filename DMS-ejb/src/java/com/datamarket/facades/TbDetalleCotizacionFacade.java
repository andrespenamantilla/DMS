/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.Ifacades.ITbDetalleCotizacionFacadeLocal;
import com.datamarket.entidades.TbCotizaciones;
import com.datamarket.entidades.TbDetalleCotizacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbDetalleCotizacionFacade extends ManejadorPersistencia<TbDetalleCotizacion> implements ITbDetalleCotizacionFacadeLocal {

    @Override
    public Integer retornarDcCotizacion() {
        Query q = em.createNamedQuery("TbDetalleCotizacion.findAll");
        if (q.getResultList().isEmpty()) {
            return 0;
        } else {
            Integer aux = q.getResultList().size();
            TbDetalleCotizacion cotizacion = (TbDetalleCotizacion) q.getResultList().get(aux - 1);
            return cotizacion.getTbDetalleCotizacionPK().getDcCotizacion();
        }
    }

    @Override
    public Integer retornarDcNumDetalle() {
        Query q = em.createNamedQuery("TbDetalleCotizacion.findAll");
        if (q.getResultList().isEmpty()) {
            return 0;
        } else {
            Integer aux = q.getResultList().size();
            TbDetalleCotizacion cotizacion = (TbDetalleCotizacion) q.getResultList().get(aux - 1);
            return cotizacion.getTbDetalleCotizacionPK().getDcNumDetalle();
        }
    }

    @Override
    public void persistirDetalleCotizacion(TbDetalleCotizacion detalleCotizacion) {
        em.persist(detalleCotizacion);
    }

    @Override
    public void eliminarDetalleCotizacion(TbDetalleCotizacion detalleCotizacion) {
        em.remove(detalleCotizacion);
    }

    @Override
    public void actualizarDetalleCotizacion(TbDetalleCotizacion detalleCotizacion) {
        em.merge(detalleCotizacion);
    }

    @Override
    public TbDetalleCotizacion findById(Integer id) {
        return em.find(TbDetalleCotizacion.class, id);
    }

    @Override
    public List<TbDetalleCotizacion> buscarPorCodigoCotizacion(TbCotizaciones cotizacion) {
        Query q = em.createQuery("SELECT t FROM TbDetalleCotizacion t WHERE t.tbDetalleCotizacionPK.dcCotizacion = :dcCotizacion");
        q.setParameter("dcCotizacion", cotizacion.getCoCodCotiz());
        return q.getResultList();
    }

}
