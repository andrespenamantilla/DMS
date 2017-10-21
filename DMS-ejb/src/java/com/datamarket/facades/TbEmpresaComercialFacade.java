/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbEjecutivos;
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
public class TbEmpresaComercialFacade extends ManejadorPersistencia<TbEmpresaComercial> {

    /*
     Funcion que ejecuta el  query 
     "Buscar por 'ecEmpresa' en la tabla 'tb_empresa_comercial'
     */
    public TbEmpresaComercial buscarPorId(Integer ecEmpresa) {
        Query query = em.createNamedQuery("TbEmpresaComercial.findByEcEmpresa", TbEmpresaComercial.class).setParameter("ecEmpresa", ecEmpresa);
        TbEmpresaComercial empresaByEcEmpresa = (TbEmpresaComercial) (query.getResultList().get(0));
        if (empresaByEcEmpresa == null) {
            return null;
        } else {
            return empresaByEcEmpresa;
        }
    }

    public TbEmpresaComercial findByid(Integer ecEmpresa) {
        TbEmpresaComercial empresaComercial = null;
        empresaComercial = em.find(TbEmpresaComercial.class, ecEmpresa);

        if (empresaComercial == null) {
            return null;
        } else {
            return empresaComercial;
        }
    }

    /*
     Funcion que ejecuta el  query 
     "Seleccionar  todos los registros de la tabla 'tb_empresa_comercial'
     */
    public List getAllEmpresasComercial() {
        Query q = em.createNamedQuery("TbEmpresaComercial.findAll", TbEmpresaComercial.class);
        List<TbEmpresaComercial> empresasComercial = q.getResultList();
        return empresasComercial;
    }

    /*
     Funcion que persiste en la base de datos una entidad de tipo TbEmpresaComercial a la tabla 'tb_empresa_comercial'
     */
    public void guardarTbEmpresaComercial(TbEmpresaComercial empresaComercial) {
        em.persist(empresaComercial);
    }

    /*
     Funcion que elimina en la base de datos una entidad de tipo TbEmpresaComercial a la tabla 'tb_empresa_comercial'
     */
    public void eliminarTbEmpresaComercial(TbEmpresaComercial empresaComercial) {
        Query q = em.createNamedQuery("TbEmpresaComercial.findByEcEmpresa", TbEmpresaComercial.class).setParameter("ecEmpresa", empresaComercial.getEcEmpresa());
        TbEmpresaComercial empresaComercialEliminar = (TbEmpresaComercial) q.getSingleResult();
        eliminar(empresaComercialEliminar);
    }

    /*
     Funcion que modifica  en la base de datos una entidad de tipo TbEmpresaComercial a la tabla 'tb_empresa_comercial'
     */
    public void modificarTbEmpresaComercial(TbEmpresaComercial empresaComercial) {
        em.merge(empresaComercial);
    }

    /*
     Funcion que consulta los registros de cuantas 'TbEmpresasComercial' estan asignadas a un 'Tb_Ejecutivo' 
     */
    public List buscarTbEmpresaComercialPorejecutivo(TbEjecutivos ejecutivoId) {
        Query query = em.createNamedQuery("TbEmpresaComercial.finbByEcEjecutivo", TbEmpresaComercial.class).setParameter("ecEjecutivo", ejecutivoId);
        List<TbEmpresaComercial> empresasComercial = query.getResultList();
        return empresasComercial;

    }

    public TbEmpresaComercial findById(Integer Id) {
        TbEmpresaComercial empresaComercial;

        empresaComercial = em.find(TbEmpresaComercial.class, Id);

        return empresaComercial;
    }

    public List<TbEmpresaComercial> buscarTbEmpresaComercialAllCrit3(String clasifEmp, String LineaNeg, TbEjecutivos ejecutivoId) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT t ");
        query.append("FROM TbEmpresaComercial t  ");
        query.append("WHERE ");

        List<String> criteria = new ArrayList<String>();
        if (LineaNeg != null) {
            criteria.add("t.ecLineaNegocio = :ecLineaNegocio");
        }
        if (clasifEmp != null) {
            criteria.add("t.ecClasificacion = :ecClasificacion");
        }
        if (ejecutivoId != null) {
            criteria.add("t.ecEjecutivo = :ecEjecutivo");
        }
        if (criteria.size() == 0) {
            //throw new RuntimeException("no criteria");

            Query query2 = em.createNamedQuery("TbEmpresaComercial.finbByEcEjecutivo", TbEmpresaComercial.class).setParameter("ecEjecutivo", ejecutivoId);
            List<TbEmpresaComercial> empresasComercial = query2.getResultList();
            return empresasComercial;

        }

        for (int i = 0; i < criteria.size(); i++) {
            if (i > 0) {
                query.append(" AND ");
            }
            query.append(criteria.get(i));
        }
        Query q = em.createQuery(query.toString());
        if (LineaNeg != null) {
            q.setParameter("ecLineaNegocio", LineaNeg);
        }
        if (clasifEmp != null) {
            q.setParameter("ecClasificacion", clasifEmp);
        }
        if (ejecutivoId != null) {
            q.setParameter("ecEjecutivo", ejecutivoId);
        }

        return (List<TbEmpresaComercial>) q.getResultList();
    }

    public boolean validarExistenciaEmpresasComerciales(Integer ecEjecutivo) {
        Query query = em.createQuery("SELECT T FROM TbEmpresaComercial T WHERE T.ecEjecutivo.ejCodigo =:ecEjecutivo");
        query.setParameter("ecEjecutivo", ecEjecutivo);
        List<TbEmpresaComercial> empresas = query.getResultList();
        if (empresas.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

}
