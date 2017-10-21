/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.Query;
import com.datamarket.entidades.TbEmpresasProspecto;

/**
 *
 * @author Andres
 */
@Stateless
public class TbEmpresasProspectoFacade extends ManejadorPersistencia<TbEmpresasProspecto> {

    /* 
     En este método de guarda el objeto que llega lleno de la clase 
    
     */
    public void guardarTbEmpresasProspecto(TbEmpresasProspecto ep) {

        em.persist(ep);
    }

    public boolean validadExistenciaEmpresasProspecto() {
        Query q = em.createNamedQuery("TbEmpresasProspecto.findAll", TbEmpresasProspecto.class);
        List<TbEmpresasProspecto> prospectos = q.getResultList();
        if (prospectos.isEmpty()) {
            return false;
        }
        return true;

    }

    public boolean validarExistencia(String id) {
        TbEmpresasProspecto empresaProspecto;
        empresaProspecto = em.find(TbEmpresasProspecto.class, Integer.parseInt(id));
        if (empresaProspecto != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarNitExistente(String nit) {

        Query q = em.createNamedQuery("TbEmpresasProspecto.findByPeNumeroId", TbEmpresasProspecto.class).setParameter("peNumeroId", nit);
        return q.getResultList().isEmpty();
    }

    public boolean validarNombreExistente(String nombre) {

        Query q = em.createNamedQuery("TbEmpresasProspecto.findByPeNombre", TbEmpresasProspecto.class).setParameter("peNombre", nombre);
        return q.getResultList().isEmpty();
    }

    public List<TbEmpresasProspecto> listarTodosLosProspectos() {
        List<TbEmpresasProspecto> empresasProspectadas;
        Query q = em.createNamedQuery("TbEmpresasProspecto.findAll", TbEmpresasProspecto.class);
        empresasProspectadas = q.getResultList();
        return empresasProspectadas;
    }

    public void eliminarEmpresaProspecto(TbEmpresasProspecto empresaProspecto) {
        Query q = em.createQuery("DELETE FROM TbEmpresasProspecto t WHERE t.peEmpresa =:peEmpresa");
        q.setParameter("peEmpresa", empresaProspecto.getPeEmpresa());
        q.executeUpdate();
    }

    public List<TbEmpresasProspecto> consultarProspectosPorEjecutivo(Integer idEjecutivo) {
        List<TbEmpresasProspecto> prospectosPorEjecutivo;
        Query q = em.createQuery("SELECT T FROM TbEmpresasProspecto T WHERE T.peEjecutivo = :idEjecutivo");
        q.setParameter("idEjecutivo", idEjecutivo);
        prospectosPorEjecutivo = q.getResultList();
        return prospectosPorEjecutivo;
    }

    public TbEmpresasProspecto findById(Integer id) {
        TbEmpresasProspecto empresaProspecto;
        empresaProspecto = em.find(TbEmpresasProspecto.class, id);
        return empresaProspecto;
    }

    public void actualizarEmpresaProspecto(TbEmpresasProspecto empresaProspectoActualizar) {
        em.merge(empresaProspectoActualizar);
    }
}
