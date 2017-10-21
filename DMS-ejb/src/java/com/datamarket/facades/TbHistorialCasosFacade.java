/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbHistorialCasos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbHistorialCasosFacade extends ManejadorPersistencia<TbHistorialCasos> {

    public void persistirHistorial(TbHistorialCasos historial) {
        em.persist(historial);

    }

    public List<TbHistorialCasos> listarHistorialTransaccionesPorEjecutivo(Integer idEjecutivo) {
        List<TbHistorialCasos> historialPorEjecutivo = new ArrayList<>();
        Query q = em.createQuery("SELECT t FROM TbHistorialCasos t WHERE t.hcUsuario =:idEjecutivo");
        q.setParameter("idEjecutivo", idEjecutivo);
        historialPorEjecutivo = q.getResultList();
        return historialPorEjecutivo;
    }

    public TbHistorialCasos findById(Integer idHistorial)
    {
    TbHistorialCasos historial;
    return historial = em.find(TbHistorialCasos.class, idHistorial);
    }
}
