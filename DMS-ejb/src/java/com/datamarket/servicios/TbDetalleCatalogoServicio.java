/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.servicios;

import com.datamarket.entidades.TbDetalleCatalogo;
import com.datamarket.facades.TbDetalleCatalogoFacade;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andres
 */
@Stateless
public class TbDetalleCatalogoServicio {

    @Inject
    TbDetalleCatalogoFacade CatalogoFacade;

    /*
     Este método retorna una variable de tipo Map<> que es llenada por la lista que retorna la función
     'getCatalogosByCargo'
     */
    public Map<String, String> getAllCargosMap() {

        List<TbDetalleCatalogo> catalogosByCargo = CatalogoFacade.getCatalogosByCargo();
        Map<String, String> catalogosByCargoMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByCargo) {
            catalogosByCargoMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByCargoMap;
    }

    /*
     Este método retorna una variable de tipo Map<> que es llenada por la lista que retorna la función
     'getAllCAreasMap'
     */
    public Map<String, String> getAllAreasMap() {

        List<TbDetalleCatalogo> catalogosByArea = CatalogoFacade.getCatalogosByAreas();
        Map<String, String> catalogosByAreasMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByArea) {
            catalogosByAreasMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByAreasMap;
    }

    /*
     Este método retorna una variable de tipo Map<> que es llenada por la lista que retorna la función
     'getCatalogosByNivel'
     */
    public Map<String, String> getAllNivelEjecutivo() {

        List<TbDetalleCatalogo> catalogosByNivelEjecutivo = CatalogoFacade.getCatalogosByNivel();
        Map<String, String> catalogosByNivelEjecutivoMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByNivelEjecutivo) {
            catalogosByNivelEjecutivoMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByNivelEjecutivoMap;
    }

    /*
     Este método retorna una variable de tipo Map<> que es llenada por la lista que retorna la función
     'getCatalogosByClisificacionClientes'
     */
    public Map<String, String> getAllClasificacionClientes() {

        List<TbDetalleCatalogo> catalogosByClasificacionClientes = CatalogoFacade.getCatalogosByClisificacionClientes();
        Map<String, String> catalogosByClasificacionClientesMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByClasificacionClientes) {
            catalogosByClasificacionClientesMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByClasificacionClientesMap;
    }

    /*
     Este método retorna una variable de tipo Map<> que es llenada por la lista que retorna la función
     'getCatalogosByEstadoProceso'
     */
    public Map<String, String> getAllEstadoProceso() {

        List<TbDetalleCatalogo> catalogosByEstadoProceso = CatalogoFacade.getCatalogosByEstadoProceso();
        Map<String, String> catalogosByEstadoProcesoMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByEstadoProceso) {
            catalogosByEstadoProcesoMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByEstadoProcesoMap;
    }

    /*
     Este método retorna una variable de tipo Map<> que es llenada por la lista que retorna la función
     'getCatalogosByEstadoTarea'
     */
    public Map<String, String> getAllEstadoTarea() {

        List<TbDetalleCatalogo> catalogosByEstadoTarea = CatalogoFacade.getCatalogosByEstadoTarea();
        Map<String, String> catalogosByEstadoTareaMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByEstadoTarea) {
            catalogosByEstadoTareaMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByEstadoTareaMap;
    }

    /*
     Este método retorna una variable de tipo Map<> que es llenada por la lista que retorna la función
     'getCatalogosByEstadoTarea'
     */
    public Map<String, String> getAllEstadoUsuario() {

        List<TbDetalleCatalogo> catalogosByEstadoUsuario = CatalogoFacade.getCatalogosByEstadoUsuario();
        Map<String, String> catalogosByEstadoUsuarioMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByEstadoUsuario) {
            catalogosByEstadoUsuarioMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByEstadoUsuarioMap;
    }

    /*
     Este método retorna una variable de tipo Map<> que es llenada por la lista que retorna la función
     'getCatalogosByEventos'
     */
    public Map<String, String> getAllEventos() {

        List<TbDetalleCatalogo> catalogosByEventos = CatalogoFacade.getCatalogosByEventos();
        Map<String, String> catalogosByEventosMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByEventos) {
            catalogosByEventosMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByEventosMap;
    }

    /*
     Este método retorna una variable de tipo Map<> que es llenada por la lista que retorna la función
     'getCatalogosByLineaNegocio'
     */
    public Map<String, String> getAllLineaNegocio() {

        List<TbDetalleCatalogo> catalogosByLineaNegocio = CatalogoFacade.getCatalogosByLineaNegocio();
        Map<String, String> catalogosByLineaNegocioMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByLineaNegocio) {
            catalogosByLineaNegocioMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByLineaNegocioMap;
    }

    /*
     Este método retorna una variable de tipo Map<> que es llenada por la lista que retorna la función
     'getCatalogosByProcesoEmpresa'
     */
    public Map<String, String> getAllProcesosEmpresa() {

        List<TbDetalleCatalogo> catalogosByProcesoEmpresa = CatalogoFacade.getCatalogosByProcesoEmpresa();
        Map<String, String> catalogosByProcesoEmpresaMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByProcesoEmpresa) {
            catalogosByProcesoEmpresaMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByProcesoEmpresaMap;
    }

    /*
     Este método retorna una variable de tipo Map<> que es llenada por la lista que retorna la función
     'getCatalogosByReferidoProspectoEmpresa'
     */
    public Map<String, String> getAllReferidoProspectoEmpresa() {

        List<TbDetalleCatalogo> catalogosByReferidoProspectoEmpresa = CatalogoFacade.getCatalogosByReferidoProspectoEmpresa();
        Map<String, String> catalogosByReferidoProspectoEmpresaMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByReferidoProspectoEmpresa) {
            catalogosByReferidoProspectoEmpresaMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByReferidoProspectoEmpresaMap;
    }

    public Map<String, String> getAllTipoContacto() {

        List<TbDetalleCatalogo> catalogosByTipoContacto = CatalogoFacade.getCatalogosByTipoContacto();
        Map<String, String> catalogosByReferidoProspectoEmpresaMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByTipoContacto) {
            catalogosByReferidoProspectoEmpresaMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByReferidoProspectoEmpresaMap;
    }

    public Map<String, String> getAllCambioEstadoProceso() {

        List<TbDetalleCatalogo> catalogosByReferidoProspectoEmpresa = CatalogoFacade.getCatalogosByCambioEstadoProceso();
        Map<String, String> catalogosByReferidoProspectoEmpresaMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByReferidoProspectoEmpresa) {
            catalogosByReferidoProspectoEmpresaMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByReferidoProspectoEmpresaMap;
    }

    public Map<String, String> getAllSector() {

        List<TbDetalleCatalogo> catalogosByReferidoProspectoEmpresa = CatalogoFacade.getCatalogosBySector();
        Map<String, String> catalogosByReferidoProspectoEmpresaMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByReferidoProspectoEmpresa) {
            catalogosByReferidoProspectoEmpresaMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByReferidoProspectoEmpresaMap;
    }

    public Map<String, String> getAllProveedorTecnologia() {

        List<TbDetalleCatalogo> catalogosByProveedor = CatalogoFacade.getCatalogosByProveedorTecnologia();
        Map<String, String> catalogosByNivelEjecutivoMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByProveedor) {
            catalogosByNivelEjecutivoMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByNivelEjecutivoMap;
    }

    public Map<String, String> getAllEstadoEmpresa() {

        List<TbDetalleCatalogo> catalogosByProveedor = CatalogoFacade.getCatalogosByEstadoEmpresa();
        Map<String, String> catalogosByNivelEjecutivoMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByProveedor) {
            catalogosByNivelEjecutivoMap.put(aux.getDcDescripcion(), aux.getTbDetalleCatalogoPK().getDcCodigo());
        }
        return catalogosByNivelEjecutivoMap;
    }

      public Map<String, String> filtrosAreasMap() {

        List<TbDetalleCatalogo> catalogosByArea = CatalogoFacade.getCatalogosByAreas();
        Map<String, String> catalogosByAreasMap = new HashMap<>();
        for (TbDetalleCatalogo aux : catalogosByArea) {
            catalogosByAreasMap.put(aux.getDcDescripcion(), aux.getDcDescripcion());
        }
        return catalogosByAreasMap;
    }
    
}
