/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbContactosEmpresas;
import com.datamarket.entidades.TbEmpresas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
@Stateless
public class TbContactosEmpresasFacade extends ManejadorPersistencia<TbContactosEmpresas> {

    /*
     Funcion que persiste en la base de datos una entidad de tipo TbContactosEmpresas a la tabla 'Tb_contactos_empresas'
     */
    public void guardarTbContactosEmpresas(TbContactosEmpresas contacto) {
        persistir(contacto);
    }

    /*
     Funcion que modifica en la base de datos una entidad de tipo TbContactosEmpresas a la tabla 'Tb_contactos_empresas'
     */
    public void modificarTbContactosEmpresas(TbContactosEmpresas contacto) {
        em.merge(contacto);
    }

    /*   Funcion que ejecuta el  query 
     "Seleccionar  todos los registros de la tabla 'Tb_contactos_empresas' por 'ce_codigo_empresa'
     */
    public List getAllTbContactosEmpresasByEmpresa(TbEmpresas empresa) {
        Query q = em.createNamedQuery("TbContactosEmpresas.findByCeCodigoEmpresa", TbContactosEmpresas.class).setParameter("ceCodigoEmpresa", empresa);
        List<TbContactosEmpresas> contactos = q.getResultList();
        return contactos;
    }

    /*
     Funcion que elimina en la base de datos una entidad de tipo TbContactosEmpresas a la tabla 'Tb_contactos_empresas'
     */
    public void eliminarTbContactosEmpresas(Integer ce_secuencial) {
        Query q = em.createNamedQuery("TbContactosEmpresas.findByCeSecuencial", TbContactosEmpresas.class).setParameter("ceSecuencial", ce_secuencial);
        TbContactosEmpresas contactoEliminar = (TbContactosEmpresas) q.getSingleResult();
        em.remove(contactoEliminar);
    }

    /*
     Funcion que ejecuta el  query 
     "Buscar por 'ce_secuencial' en la tabla 'Tb_contactos_empresas'
     */
    public TbContactosEmpresas buscarPorId(Integer ce_secuencial) {
        Query query = em.createNamedQuery("TbContactosEmpresas.findByCeSecuencial", TbContactosEmpresas.class).setParameter("ejCodigo", ce_secuencial);
        TbContactosEmpresas contactoByCodigo = (TbContactosEmpresas) (query.getResultList().get(0));
        if (contactoByCodigo == null) {
            return null;
        } else {
            return contactoByCodigo;
        }
    }

    /*
     Funcion que ejecuta el  query 
     "Buscar por 'ce_codigo_empresa' en la tabla 'Tb_contactos_empresas'
     */
    public TbContactosEmpresas buscarContactosPorCeCodigoEmpresa(TbEmpresas ce_codigo_empresa) {
        Query query = em.createNamedQuery("TbContactosEmpresas.findByCeCodigoEmpresa", TbContactosEmpresas.class).setParameter("ceCodigoEmpresa", ce_codigo_empresa);
        TbContactosEmpresas contactoByCeCodigoEmpresa = (TbContactosEmpresas) (query.getResultList());
        if (contactoByCeCodigoEmpresa == null) {
            return null;
        } else {
            return contactoByCeCodigoEmpresa;
        }
    }

    public String buscarContactoPorCeSecuencialAndCeCodigoEmpresa(Integer ceSecuencial, Integer ceCodigoEmpresa) {
        Query q = em.createQuery("SELECT t FROM TbContactosEmpresas t WHERE t.ceSecuencial = :ceSecuencial AND t.ceCodigoEmpresa.emIdEmpresas = :ceCodigoEmpresa");
        q.setParameter("ceSecuencial", ceSecuencial);
        q.setParameter("ceCodigoEmpresa", ceCodigoEmpresa);
        TbContactosEmpresas contacto = (TbContactosEmpresas) q.getSingleResult();
        String nombreApellidos;

        nombreApellidos = contacto.getCeNombres() + " " + "" + contacto.getCeApellidos();
        return nombreApellidos;
    }

    public TbContactosEmpresas buscarPorIdYEmpresa(Integer ceSecuencial, Integer ceCodigoEmpresa) {
        Query q = em.createQuery("SELECT t FROM TbContactosEmpresas t WHERE t.ceSecuencial = :ceSecuencial AND t.ceCodigoEmpresa.emIdEmpresas = :ceCodigoEmpresa");
        q.setParameter("ceSecuencial", ceSecuencial);
        q.setParameter("ceCodigoEmpresa", ceCodigoEmpresa);
        TbContactosEmpresas contacto = (TbContactosEmpresas) q.getSingleResult();

        return contacto;
    }

    public TbContactosEmpresas findById(Integer ce_secuencial) {
        TbContactosEmpresas contacto;
        return contacto = em.find(TbContactosEmpresas.class, ce_secuencial);
    }

    public void actualizarContacto(TbContactosEmpresas contacto) {
        em.merge(contacto);
    }

    public void eliminarContactosEmpresas(TbContactosEmpresas contactoEmpresa) {
        Query q = em.createQuery("DELETE FROM TbContactosEmpresas t WHERE t.ceSecuencial =:ceSecuencial");
        q.setParameter("ceSecuencial", contactoEmpresa.getCeSecuencial());
        q.executeUpdate();
    }

}
