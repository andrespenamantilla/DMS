/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbDetalleCatalogo;
import com.datamarket.entidades.TbDetalleCatalogoPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
@Stateless
public class TbDetalleCatalogoFacade extends ManejadorPersistencia<TbDetalleCatalogo> {

    /*
     Se ejecuta el query que trae todos los catalogos por 
     los parametros dcCatalogo = 'CA_CARGOS' y dcEstado = 'V'
     */
    public List getCatalogosByCargo() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoCargoAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_CARGOS").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> cargos = q.getResultList();
        return cargos;
    }

    /*
     Se ejecuta el query que trae todos los catalogos por 
     los parametros dcCatalogo = 'CA_NIVEL_EJE' y dcEstado = 'V'
     */
    public List getCatalogosByNivel() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoNivelAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_NIVEL_EJE").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> niveles = q.getResultList();
        return niveles;
    }

    /*
     Se ejecuta el query que trae todos los catalogos por 
     los parametros dcCatalogo = 'CA_AREAS' y dcEstado = 'V'
     */
    public List getCatalogosByAreas() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoAreasAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_AREAS").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> areas = q.getResultList();
        return areas;
    }

    /*
     Se ejecuta el query que trae todos los catalogos por 
     los parametros dcCatalogo = 'CA_NIVEL_EJE' y dcEstado = 'V'
     */
    public List getCatalogosByClisificacionClientes() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoClasifacionClienteAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_CLASIF_CLIEN").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> clasificacionClientes = q.getResultList();
        return clasificacionClientes;
    }

    /*
     Se ejecuta el query que trae todos los catalogos por 
     los parametros dcCatalogo = 'CA_ESTADO_PROC' y dcEstado = 'V'
     */
    public List getCatalogosByEstadoProceso() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoEstadoProcesoAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_ESTADO_PROC").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> estadoDeProcesos = q.getResultList();
        return estadoDeProcesos;
    }

    /*
     Se ejecuta el query que trae todos los catalogos por 
     los parametros dcCatalogo = 'CA_ESTADO_TAR' y dcEstado = 'V'
     */
    public List getCatalogosByEstadoTarea() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoEstadoTareaAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_ESTADO_TAR").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> estadosDeTareas = q.getResultList();
        return estadosDeTareas;
    }

    /*
     Se ejecuta el query que trae todos los catalogos por 
     los parametros dcCatalogo = 'CA_ESTADO_USU' y dcEstado = 'V'
     */
    public List getCatalogosByEstadoUsuario() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoEstadoTareaAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_ESTADO_USU").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> estadosDeUsuario = q.getResultList();
        return estadosDeUsuario;
    }

    /*
     Se ejecuta el query que trae todos los catalogos por 
     los parametros dcCatalogo = 'CA_EVENTOS' y dcEstado = 'V'
     */
    public List getCatalogosByEventos() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoEstadoTareaAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_EVENTOS").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> eventos = q.getResultList();
        return eventos;
    }

    /*
     Se ejecuta el query que trae todos los catalogos por 
     los parametros dcCatalogo = 'CA_LINEA_NEG' y dcEstado = 'V'
     */
    public List getCatalogosByLineaNegocio() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoEstadoTareaAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_LINEA_NEG").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> lineasNegocio = q.getResultList();
        return lineasNegocio;
    }

    /*
     Se ejecuta el query que trae todos los catalogos por 
     los parametros dcCatalogo = 'CA_PROCESOS_EMP' y dcEstado = 'V'
     */
    public List getCatalogosByProcesoEmpresa() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoEstadoTareaAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_PROCESOS_EMP").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> procesosEmpresa = q.getResultList();
        return procesosEmpresa;
    }

    /*
     Se ejecuta el query que trae todos los catalogos por 
     los parametros dcCatalogo = 'CA_REF_PROSP_EM' y dcEstado = 'V'
     */
    public List getCatalogosByReferidoProspectoEmpresa() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoEstadoTareaAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_REF_PROSP_EM").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> referidosProspecto = q.getResultList();
        return referidosProspecto;
    }

    public List getCatalogosByTipoContacto() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcTipoContactoAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_TIPOCONT_INI").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> tipoContacto = q.getResultList();
        return tipoContacto;
    }

    public List getCatalogosByCambioEstadoProceso() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCambioEstadoProcesoAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_ESTADO_PROC").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> cambioEstadoProceso = q.getResultList();
        return cambioEstadoProceso;

    }

    public List getCatalogosBySector() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoSectorAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_SECTOR").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> sector = q.getResultList();
        return sector;

    }

    public String getStringForDcCatalogoAndDcCodigo(String dcCodigo, String dcCatalogo) {
        Query q = em.createQuery("SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK = :primaryKey");

        TbDetalleCatalogoPK primaryKey = new TbDetalleCatalogoPK();
        primaryKey.setDcCatalogo(dcCatalogo);
        primaryKey.setDcCodigo(dcCodigo);

        q.setParameter("primaryKey", primaryKey);

        TbDetalleCatalogo catalogo;
        catalogo = (TbDetalleCatalogo) q.getSingleResult();
        String descripcion = catalogo.getDcDescripcion();
        return descripcion;

    }

    public String nombreCatalogoReferido(String codigo) {
        Query q = em.createQuery("SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.tbDetalleCatalogoPK.dcCodigo = :dcCodigo");
        q.setParameter("dcCodigo", codigo);
        q.setParameter("dcCatalogo", "CA_REF_PROSP_EM");
        TbDetalleCatalogo catalogoHallado;
        catalogoHallado = (TbDetalleCatalogo) q.getSingleResult();
        return catalogoHallado.getDcDescripcion();
    }

    public String nombreCatalogoCargo(String codigo) {
        Query q = em.createQuery("SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.tbDetalleCatalogoPK.dcCodigo = :dcCodigo");
        q.setParameter("dcCodigo", codigo);
        q.setParameter("dcCatalogo", "CA_CARGOS");
        TbDetalleCatalogo catalogoHallado;
        catalogoHallado = (TbDetalleCatalogo) q.getSingleResult();
        return catalogoHallado.getDcDescripcion();
    }
    
        public String nombreCatalogoEstadoUsuario(String codigo) {
        Query q = em.createQuery("SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.tbDetalleCatalogoPK.dcCodigo = :dcCodigo");
        q.setParameter("dcCodigo", codigo);
        q.setParameter("dcCatalogo", "CA_ESTADO_USU");
        TbDetalleCatalogo catalogoHallado;
        catalogoHallado = (TbDetalleCatalogo) q.getSingleResult();
        return catalogoHallado.getDcDescripcion();
    }
    
    

    public String nombreCatalogoArea(String codigo) {
        Query q = em.createQuery("SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.tbDetalleCatalogoPK.dcCodigo = :dcCodigo");
        q.setParameter("dcCodigo", codigo);
        q.setParameter("dcCatalogo", "CA_AREAS");
        TbDetalleCatalogo catalogoHallado;
        catalogoHallado = (TbDetalleCatalogo) q.getSingleResult();
        return catalogoHallado.getDcDescripcion();
    }

    public String nombreCatalogoSector(Integer codigo) {
        Query q = em.createQuery("SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.tbDetalleCatalogoPK.dcCodigo = :dcCodigo");
        q.setParameter("dcCodigo", codigo.toString());
        q.setParameter("dcCatalogo", "CA_SECTOR");
        TbDetalleCatalogo catalogoHallado;
        catalogoHallado = (TbDetalleCatalogo) q.getSingleResult();
        return catalogoHallado.getDcDescripcion();
    }

    public String nombreCatalogoEstadoProceso(String codigo) {
        Query q = em.createQuery("SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.tbDetalleCatalogoPK.dcCodigo = :dcCodigo");
        q.setParameter("dcCodigo", codigo);
        q.setParameter("dcCatalogo", "CA_ESTADO_PROC");
        TbDetalleCatalogo catalogoHallado;
        catalogoHallado = (TbDetalleCatalogo) q.getSingleResult();
        return catalogoHallado.getDcDescripcion();
    }

    public String nombreCatalogoEvento(String codigo) {
        Query q = em.createQuery("SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.tbDetalleCatalogoPK.dcCodigo = :dcCodigo");
        q.setParameter("dcCodigo", codigo);
        q.setParameter("dcCatalogo", "CA_EVENTOS");
        TbDetalleCatalogo catalogoHallado;
        catalogoHallado = (TbDetalleCatalogo) q.getSingleResult();
        return catalogoHallado.getDcDescripcion();
    }

    public String nombreCatalogoEstadoTarea(String codigo) {
        Query q = em.createQuery("SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.tbDetalleCatalogoPK.dcCodigo = :dcCodigo");
        q.setParameter("dcCodigo", codigo);
        q.setParameter("dcCatalogo", "CA_ESTADO_TAR");
        TbDetalleCatalogo catalogoHallado;
        catalogoHallado = (TbDetalleCatalogo) q.getSingleResult();
        return catalogoHallado.getDcDescripcion();
    }

    public String nombreCatalogoLineaNegocio(String codigo) {
        Query q = em.createQuery("SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.tbDetalleCatalogoPK.dcCodigo = :dcCodigo");
        q.setParameter("dcCodigo", codigo);
        q.setParameter("dcCatalogo", "CA_LINEA_NEG");
        TbDetalleCatalogo catalogoHallado;
        catalogoHallado = (TbDetalleCatalogo) q.getSingleResult();
        return catalogoHallado.getDcDescripcion();
    }

    public String nombreCatalogoCasusalEstadoProceso(String codigo) {
        Query q = em.createQuery("SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.tbDetalleCatalogoPK.dcCodigo = :dcCodigo");
        q.setParameter("dcCodigo", codigo);
        q.setParameter("dcCatalogo", "CA_CAU_EST_PRO");
        TbDetalleCatalogo catalogoHallado;
        catalogoHallado = (TbDetalleCatalogo) q.getSingleResult();
        return catalogoHallado.getDcDescripcion();
    }

    public String nombreCatalogoTipoContactoInicial(String codigo) {
        Query q = em.createQuery("SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.tbDetalleCatalogoPK.dcCodigo = :dcCodigo");
        q.setParameter("dcCodigo", codigo);
        q.setParameter("dcCatalogo", "CA_TIPOCONT_INI");
        TbDetalleCatalogo catalogoHallado;
        catalogoHallado = (TbDetalleCatalogo) q.getSingleResult();
        return catalogoHallado.getDcDescripcion();
    }

    public List getCatalogosByProveedorTecnologia() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoNivelAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_PROV_TEC").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> niveles = q.getResultList();
        return niveles;
    }

    public List getCatalogosByEstadoEmpresa() {
        Query q = em.createNamedQuery("TbDetalleCatalogo.findByDcCatalogoNivelAndDcEstado", TbDetalleCatalogo.class).setParameter("dcCatalogo", "CA_ESTADO_EMP").setParameter("dcEstado", "V");
        List<TbDetalleCatalogo> niveles = q.getResultList();
        return niveles;
    }

}
