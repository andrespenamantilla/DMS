/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbEtapasProceso;
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author Andres
 */
@Stateless
public class TbEtapasProcesoFacade extends ManejadorPersistencia<TbEtapasProceso> {

    public TbEtapasProceso buscarPorId(Integer epProceso) {
        Query query = em.createNamedQuery("TbEtapasProceso.findByEpProceso", TbEtapasProceso.class).setParameter("epProceso", epProceso);
        TbEtapasProceso etapasProcesoByEpProceso = (TbEtapasProceso) (query.getResultList().get(0));
        if (etapasProcesoByEpProceso == null) {
            return null;
        } else {
            return etapasProcesoByEpProceso;
        }
    }

    /*
     Funcion que ejecuta el  query 
     "Seleccionar  todos los registros de la tabla 'Tb_Etapas_Proceso'
     */
    public List getAllEtapasProceso() {
        Query q = em.createNamedQuery("TbEtapasProceso.findAll", TbEtapasProceso.class);
        List<TbEtapasProceso> etapasProcesoLista = q.getResultList();
        return etapasProcesoLista;
    }

    /*
     Funcion que persiste en la base de datos una entidad de tipo TbAdmRoles a la tabla 'Tb_Etapas_Proceso'
     */
    public void guardarTbEtapasProceso(TbEtapasProceso etapasProceso) {
        persistir(etapasProceso);
    }

    /*
     Funcion que elimina en la base de datos una entidad de tipo TbAdmRoles a la tabla 'Tb_Etapas_Proceso'
     */
    /*public void eliminarTbEtapasProceso(TbEtapasProceso etapasProceso) {
     Query q = em.createNamedQuery("TbEtapasProceso.findByEpProceso", TbEtapasProceso.class).setParameter("epProceso", etapasProceso.getTbEtapasProcesoPK().getEpProceso());
     TbEtapasProceso etapasProcesoEliminar = (TbEtapasProceso) q.getSingleResult();
     eliminar(etapasProcesoEliminar);
     }*/
    /*
     Funcion que modifica  en la base de datos una entidad de tipo TbAdmRoles a la tabla 'Tb_Adm_roles'
     */
    public void modificarTbEtapasProceso(TbEtapasProceso etapasProceso) {
        em.merge(etapasProceso);
    }

    public String buscarDescripcionEtapasProcesoPorCodigo(Integer epEtapa) {
        Query q = em.createQuery("SELECT t FROM TbEtapasProceso t WHERE t.tbEtapasProcesoPK.epEtapa = :epEtapa");
        q.setParameter("epEtapa", epEtapa.toString());
        TbEtapasProceso etapasProceso;
        String descripcion;
        etapasProceso = (TbEtapasProceso) q.getSingleResult();

        descripcion = etapasProceso.getEpDescEtapa();
        return descripcion;
    }
 
    
    
}
