/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.listas;

import com.datamarket.IServicios.ITbProductosServiciosLocal;
import com.datamarket.servicios.TbAdmRolesServicio;
import com.datamarket.servicios.TbDetalleCatalogoServicio;
import com.datamarket.servicios.TbEjecutivosServicio;
import com.datamarket.servicios.TbEtapasProcesoServicio;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author andre
 */
@Named
@Singleton
@Startup
public class ListasComunes implements Serializable {

    @Inject
    TbDetalleCatalogoServicio detalleCatalogoServicio;
    @Inject
    TbEtapasProcesoServicio etapasProcesoServicio;
    @Inject
    TbEjecutivosServicio ejecutivosServicio;
    @Inject
    TbAdmRolesServicio rolesServicio;
    @Inject
    ITbProductosServiciosLocal productosServicio;

    private Map<String, String> cargos;
    private Map<String, String> areas;
    private Map<String, String> nivelEjecutivo;
    private Map<String, String> clasificacionClientes;
    private Map<String, String> estadoProceso;
    private Map<String, String> estadoTarea;
    private Map<String, String> estadoUsuario;
    private Map<String, String> eventos;
    private Map<String, String> lineaNegocio;
    private Map<String, String> procesosEmpresa;
    private Map<String, String> referidoProspectoEmpresa;
    private Map<String, String> tipoContacto;
    private Map<String, String> cambiosEstadoProceso;
    private Map<String, String> sectores;
    private Map<String, Integer> etapasProceso;
    private Map<String, Integer> ejecutivos;
    private Map<String, String> proveedorTecnología;
    private Map<String, String> estadoEmpresa;
    private Map<String, String> filtrosAreasMap;
    private Map<String, Integer> rolesMap;
    private Map<String, Integer> productosMap;
    private Map<String, Integer> opcionesMap;
    private final String unidades = "unidades";

    @PostConstruct
    public void init() {
        cargos = detalleCatalogoServicio.getAllCargosMap();
        areas = detalleCatalogoServicio.getAllAreasMap();
        nivelEjecutivo = detalleCatalogoServicio.getAllNivelEjecutivo();
        clasificacionClientes = detalleCatalogoServicio.getAllClasificacionClientes();
        estadoProceso = detalleCatalogoServicio.getAllEstadoProceso();
        estadoTarea = detalleCatalogoServicio.getAllEstadoTarea();
        estadoUsuario = detalleCatalogoServicio.getAllEstadoUsuario();
        eventos = detalleCatalogoServicio.getAllEventos();
        lineaNegocio = detalleCatalogoServicio.getAllLineaNegocio();
        procesosEmpresa = detalleCatalogoServicio.getAllProcesosEmpresa();
        referidoProspectoEmpresa = detalleCatalogoServicio.getAllReferidoProspectoEmpresa();
        tipoContacto = detalleCatalogoServicio.getAllTipoContacto();
        cambiosEstadoProceso = detalleCatalogoServicio.getAllCambioEstadoProceso();
        sectores = detalleCatalogoServicio.getAllSector();
        etapasProceso = etapasProcesoServicio.getAllEtapasProcesoMap();
        ejecutivos = ejecutivosServicio.getAllEjecutivosMap();
        proveedorTecnología = detalleCatalogoServicio.getAllProveedorTecnologia();
        estadoEmpresa = detalleCatalogoServicio.getAllEstadoEmpresa();
        filtrosAreasMap = detalleCatalogoServicio.filtrosAreasMap();
        rolesMap = rolesServicio.getAllRolesMap();
        productosMap = productosServicio.productosMap();
        opcionesDetalleCatalogo();

    }

    public void opcionesDetalleCatalogo() {
        opcionesMap = new LinkedHashMap<>();

        for (int i = 1; i <= 5; i++) {
            opcionesMap.put("Opción " + i, i);
        }

    }

    /*Getters & Setters*/
    public TbDetalleCatalogoServicio getDetalleCatalogoServicio() {
        return detalleCatalogoServicio;
    }

    public void setDetalleCatalogoServicio(TbDetalleCatalogoServicio detalleCatalogoServicio) {
        this.detalleCatalogoServicio = detalleCatalogoServicio;
    }

    public Map<String, String> getCargos() {
        return cargos;
    }

    public void setCargos(Map<String, String> cargos) {
        this.cargos = cargos;
    }

    public Map<String, String> getAreas() {
        return areas;
    }

    public void setAreas(Map<String, String> areas) {
        this.areas = areas;
    }

    public Map<String, String> getNivelEjecutivo() {
        return nivelEjecutivo;
    }

    public void setNivelEjecutivo(Map<String, String> nivelEjecutivo) {
        this.nivelEjecutivo = nivelEjecutivo;
    }

    public Map<String, String> getClasificacionClientes() {
        return clasificacionClientes;
    }

    public void setClasificacionClientes(Map<String, String> clasificacionClientes) {
        this.clasificacionClientes = clasificacionClientes;
    }

    public Map<String, String> getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(Map<String, String> estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    public Map<String, String> getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(Map<String, String> estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public Map<String, String> getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Map<String, String> estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Map<String, String> getEventos() {
        return eventos;
    }

    public void setEventos(Map<String, String> eventos) {
        this.eventos = eventos;
    }

    public Map<String, String> getLineaNegocio() {
        return lineaNegocio;
    }

    public void setLineaNegocio(Map<String, String> lineaNegocio) {
        this.lineaNegocio = lineaNegocio;
    }

    public Map<String, String> getProcesosEmpresa() {
        return procesosEmpresa;
    }

    public void setProcesosEmpresa(Map<String, String> procesosEmpresa) {
        this.procesosEmpresa = procesosEmpresa;
    }

    public Map<String, String> getReferidoProspectoEmpresa() {
        return referidoProspectoEmpresa;
    }

    public void setReferidoProspectoEmpresa(Map<String, String> referidoProspectoEmpresa) {
        this.referidoProspectoEmpresa = referidoProspectoEmpresa;
    }

    public Map<String, String> getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(Map<String, String> tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public Map<String, String> getCambiosEstadoProceso() {
        return cambiosEstadoProceso;
    }

    public void setCambiosEstadoProceso(Map<String, String> cambiosEstadoProceso) {
        this.cambiosEstadoProceso = cambiosEstadoProceso;
    }

    public Map<String, String> getSectores() {
        return sectores;
    }

    public void setSectores(Map<String, String> sectores) {
        this.sectores = sectores;
    }

    public Map<String, Integer> getEtapasProceso() {
        return etapasProceso;
    }

    public void setEtapasProceso(Map<String, Integer> etapasProceso) {
        this.etapasProceso = etapasProceso;
    }

    public Map<String, Integer> getEjecutivos() {
        return ejecutivos;
    }

    public void setEjecutivos(Map<String, Integer> ejecutivos) {
        this.ejecutivos = ejecutivos;
    }

    public Map<String, String> getProveedorTecnología() {
        return proveedorTecnología;
    }

    public void setProveedorTecnología(Map<String, String> proveedorTecnología) {
        this.proveedorTecnología = proveedorTecnología;
    }

    public Map<String, String> getEstadoEmpresa() {
        return estadoEmpresa;
    }

    public void setEstadoEmpresa(Map<String, String> estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa;
    }

    public Map<String, String> getFiltrosAreasMap() {
        return filtrosAreasMap;
    }

    public void setFiltrosAreasMap(Map<String, String> filtrosAreasMap) {
        this.filtrosAreasMap = filtrosAreasMap;
    }

    public Map<String, Integer> getRolesMap() {
        return rolesMap;
    }

    public void setRolesMap(Map<String, Integer> rolesMap) {
        this.rolesMap = rolesMap;
    }

    public Map<String, Integer> getProductosMap() {
        return productosMap;
    }

    public void setProductosMap(Map<String, Integer> productosMap) {
        this.productosMap = productosMap;
    }

    public Map<String, Integer> getOpcionesMap() {
        return opcionesMap;
    }

    public void setOpcionesMap(Map<String, Integer> opcionesMap) {
        this.opcionesMap = opcionesMap;
    }

}
