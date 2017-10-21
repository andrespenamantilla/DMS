/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbCasosEmpresas;
import com.datamarket.entidades.TbEmpresaComercial;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
@Stateless
public class TbCasosEmpresasFacade extends ManejadorPersistencia<TbCasosEmpresas> {

    /*
     Funcion que persiste en la base de datos una entidad de tipo TbCasosEmpresas a la tabla 'Tb_Casos_Empresas'
     */
    public void guardarTbCasosEmpresas(TbCasosEmpresas casoEmpresa) {
        em.persist(casoEmpresa);
    }

    /*
     Funcion que modifica en la base de datos una entidad de tipo TbCasosEmpresas a la tabla 'Tb_Casos_Empresas'
     */
    public void modificarTbCasosEmpresas(TbCasosEmpresas casoEmpresa) {
        em.merge(casoEmpresa);
    }

    /*
     Funcion que elimina en la base de datos una entidad de tipo TbCasosEmpresas a la tabla 'Tb_Casos_Empresas'
     */
    public void eliminarTbCasosEmpresas(TbCasosEmpresas casoEmpresa) {
        Query q = em.createNamedQuery("TbCasosEmpresas.findByCeSecCaso", TbCasosEmpresas.class).setParameter("ceSecCaso", casoEmpresa.getCeSecCaso());
        TbCasosEmpresas casoEmpresaEliminar = (TbCasosEmpresas) q.getSingleResult();
        eliminar(casoEmpresaEliminar);
    }

    public List listarCasosEmpresasPorIdEmpresaComercial(TbEmpresaComercial empresaComercial) {
        Query q = em.createNamedQuery("TbCasosEmpresas.findByCeEmpresa", TbCasosEmpresas.class).setParameter("ceEmpresa", empresaComercial);
        return q.getResultList();
    }

    public TbCasosEmpresas buscarPorIdCasoEmpresa(Integer ceCasoEmpresa) {
        TbCasosEmpresas casoEmpresaHallado;
        casoEmpresaHallado = em.find(TbCasosEmpresas.class, ceCasoEmpresa);
        return casoEmpresaHallado;

    }

    public TbCasosEmpresas buscarPorId(Integer id) {
        TbCasosEmpresas casoEmpresaHallado;
        casoEmpresaHallado = em.find(TbCasosEmpresas.class, id);
        return casoEmpresaHallado;
    }

    public boolean seleccionarUltimoRow(Integer ejecutivo) {

        TbCasosEmpresas casoEmpresaHallado;
        Query q = em.createQuery("SELECT t FROM TbCasosEmpresas t WHERE t.ceEmpresa.ecEjecutivo.ejCodigo = :ejecutivo");
        q.setParameter("ejecutivo", ejecutivo);
        int max = q.getResultList().size();
        casoEmpresaHallado = (TbCasosEmpresas) q.getResultList().get(max - 1);
        if (casoEmpresaHallado.getCeEstado().equals("A")) {
            return true;
        } else {
            return false;
        }
    }

    public List<TbCasosEmpresas> buscarCasosPorCriterios(String ceEstado, String ceTipoCont, Integer ceEtapa, String ceLineaNegocio, Integer ecEjecutivo) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT t ");
        query.append("FROM TbCasosEmpresas t  ");
        query.append("WHERE ");

        List<String> criteria = new ArrayList<String>();
        if (ceEstado != null) {
            criteria.add("t.ceEstado = :ceEstado");
        }
        if (ceTipoCont != null) {
            criteria.add("t.ceTipoCont = :ceTipoCont");
        }
        if (ceEtapa != null) {
            criteria.add("t.ceEtapa = :ceEtapa");
        }

        if (ceLineaNegocio != null) {
            criteria.add("t.ceLineaNegocio = :ceLineaNegocio");
        }

        if (ecEjecutivo != null) {
            criteria.add("t.ceEmpresa.ecEjecutivo.ejCodigo = :ecEjecutivo");
        }

        if (criteria.size() == 0) {
            //throw new RuntimeException("no criteria");

            Query query2 = em.createNamedQuery("TbCasosEmpresas.findAll", TbEmpresaComercial.class);

            return query2.getResultList();

        }

        for (int i = 0; i < criteria.size(); i++) {
            if (i > 0) {
                query.append(" AND ");
            }
            query.append(criteria.get(i));
        }

        Query q = em.createQuery(query.toString());
        if (ceEstado != null) {
            q.setParameter("ceEstado", ceEstado);
        }
        if (ceTipoCont != null) {
            q.setParameter("ceTipoCont", ceTipoCont);
        }
        if (ceEtapa != null) {
            q.setParameter("ceEtapa", ceEtapa);
        }

        if (ceLineaNegocio != null) {
            q.setParameter("ceLineaNegocio", ceLineaNegocio);
        }

        if (ecEjecutivo != null) {
            q.setParameter("ecEjecutivo", ecEjecutivo);
        }

        return (q.getResultList());
    }

    public Boolean listarCasosEmpresasPorCeContacto(Integer ceContacto) {
        Query q = em.createNamedQuery("TbCasosEmpresas.findByCeContacto", TbCasosEmpresas.class).setParameter("ceContacto", ceContacto);
        if (q.getResultList().size() > 0) {
            return true;
        } else {
            return false;
        }
    }

}
