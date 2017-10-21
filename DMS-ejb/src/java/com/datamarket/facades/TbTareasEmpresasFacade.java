/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbCasosEmpresas;
import com.datamarket.entidades.TbTareasEmpresas;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.Date;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbTareasEmpresasFacade extends ManejadorPersistencia<TbTareasEmpresas> {

    public TbTareasEmpresas buscarPorId(Integer Id) {
        TbTareasEmpresas tareaEmpresa;
        tareaEmpresa = em.find(TbTareasEmpresas.class, Id);
        return tareaEmpresa;
    }

    public List<TbTareasEmpresas> buscarTareasPorCaso(TbCasosEmpresas casoEmpresa) {
        List<TbTareasEmpresas> tareasPorCaso;
        Query q = em.createQuery("SELECT t FROM TbTareasEmpresas t WHERE t.teCaso = :casoEmpresa");
        q.setParameter("casoEmpresa", casoEmpresa);
        tareasPorCaso = q.getResultList();
        return tareasPorCaso;
    }

    public void persistirTareasEmpresas(TbTareasEmpresas tareasEmpresas) {
        em.persist(tareasEmpresas);
    }

    public void eliminarTareaEmpresas(TbTareasEmpresas empresaEliminar) {
        Query q = em.createQuery("DELETE FROM TbTareasEmpresas t WHERE t.teSecTarea =:teSecTarea");
        q.setParameter("teSecTarea", empresaEliminar.getTeSecTarea());
        q.executeUpdate();
    }

    public List<TbTareasEmpresas> buscarTareasPorEjecutivo(Integer teResponsable) {
        List<TbTareasEmpresas> tareasPorEjecutivo;
        Query q = em.createNamedQuery("TbTareasEmpresas.findByTeResponsable");
        q.setParameter("teResponsable", teResponsable);
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            tareasPorEjecutivo = q.getResultList();

            return tareasPorEjecutivo;
        }
    }

    public List<TbTareasEmpresas> buscarPorCriterios(String teEstado, String teEvento, Integer teResponsable, Date teFechaInicial, Date teFechaFin) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT t ");
        query.append("FROM TbTareasEmpresas t ");
        query.append("WHERE ");

        List<String> criteria = new ArrayList<String>();

        if (teEstado != null) {
            criteria.add("t.teEstado = :teEstado");
        }
        if (teEvento != null) {
            criteria.add("t.teEvento = :teEvento");
        }
        if (teResponsable != null) {
            criteria.add("t.teResponsable = :teResponsable");
        }

        if (teFechaInicial != null) {
            criteria.add("t.teFechaInicial BETWEEN :fechaInicial AND :fechaFinal");
        }

        if (teFechaFin != null) {
            criteria.add("t.teFechaFin BETWEEN :fechaInicial AND :fechaFinal");
        }

        for (int i = 0; i < criteria.size(); i++) {
            if (i > 0) {
                query.append(" AND ");
            }
            query.append(criteria.get(i));
        }

        Query q = em.createQuery(query.toString());
        if (teEstado != null) {
            q.setParameter("teEstado", teEstado);
        }
        if (teEvento != null) {
            q.setParameter("teEvento", teEvento);
        }
        if (teResponsable != null) {
            q.setParameter("teResponsable", teResponsable);
        }

        if (teFechaInicial != null) {
            q.setParameter("fechaInicial", teFechaInicial);
            q.setParameter("fechaFinal", teFechaFin);
        }

        if (teFechaFin != null) {
            q.setParameter("fechaFinal", teFechaFin);
            q.setParameter("fechaInicial", teFechaInicial);
        }
        return (q.getResultList());
    }

    public List<TbTareasEmpresas> buscarTareasPorEmpresaEjecutivo(Integer teResponsable, Integer ecEmpresa) {
        List<TbTareasEmpresas> tareas;
        Query q = em.createQuery("SELECT t FROM TbTareasEmpresas t WHERE t.teResponsable = :teResponsable AND t.teCaso.ceEmpresa.ecEmpresa =:ecEmpresa AND t.teEstado =:pendiente");
        q.setParameter("teResponsable", teResponsable);
        q.setParameter("ecEmpresa", ecEmpresa);
        q.setParameter("pendiente", "2");

        return tareas = q.getResultList();

    }
    
    
     public List<TbTareasEmpresas> buscarTareasPorEjecutivoYEstadoPendiente(Integer teResponsable) {
        List<TbTareasEmpresas> tareas;
        Query q = em.createQuery("SELECT t FROM TbTareasEmpresas t WHERE t.teResponsable = :teResponsable AND t.teEstado =:pendiente");
        q.setParameter("teResponsable", teResponsable);
        q.setParameter("pendiente", "2");

        return tareas = q.getResultList();

    }

    

}
