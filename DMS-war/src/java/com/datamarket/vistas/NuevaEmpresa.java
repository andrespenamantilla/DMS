/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TbEmpresaComponente;
import com.datamarket.converter.TbEmpresaComponenteConverter;
import com.datamarket.entidades.TbDepartamentosPK;
import com.datamarket.entidades.TbEmpresas;
import com.datamarket.facades.TbCiudadesFacade;
import com.datamarket.facades.TbDepartamentosFacade;
import com.datamarket.facades.TbEmpresasFacade;
import com.datamarket.facades.TbPaisesFacade;
import com.datamarket.servicios.TbPaisesServicio;
import com.datamarket.servicios.TbSectorEconomicoServicio;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrés
 */
@Named
@ViewScoped
public class NuevaEmpresa implements Serializable {

    @Inject
    TbEmpresasFacade empresasFacade;
    @Inject
    TbSectorEconomicoServicio sectorServicio;
    @Inject
    TbPaisesServicio paisesServicio;
    @Inject
    TbPaisesFacade paisFacade;
    @Inject
    TbDepartamentosFacade departamentosFacade;
    @Inject
    TbCiudadesFacade ciudadesFacade;
    @Inject
    TbEmpresaComponenteConverter empresaConverter;

    private TbEmpresaComponente empresaComponente;
    private Integer emIdEmpresas;
    private Map<String, Integer> sectores;
    private Map<String, String> paisesMap;
    private Map<String, String> departamentosMap;
    private Map<String, String> ciudadesMap;
    private String paisId;
    private String departamentoId;
    private String ciudadId;

    @PostConstruct
    public void init() {
        empresaComponente = new TbEmpresaComponente();
        emIdEmpresas = empresasFacade.obtenerIdUltimoRegistro();
        paisesMap = paisesServicio.getAllPaisesMap();
        paisId = null;
        departamentoId = null;
        ciudadId = null;
        sectores = sectorServicio.getAllSectores();
    }

    public void buscarDepartamentosPorPais() {

        if (paisId == null) {
            departamentosMap = new HashMap<>();
            ciudadesMap = new HashMap<>();
            departamentoId = null;
            ciudadId = null;
        } else {
            departamentosMap = paisesServicio.getAllDepartamentosMap(paisFacade.buscarPaisPorId(paisId));
            ciudadesMap = new HashMap<>();

        }
    }

    public void buscarCiudadesPorDepartamento() {

        TbDepartamentosPK pk = new TbDepartamentosPK();
        pk.setDeCodigo(departamentoId);
        pk.setDePais(paisId);
        empresaComponente.setEm_pais(ciudadId);
        ciudadesMap = paisesServicio.getAllCiudadesMap(departamentosFacade.findById(pk));
    }

    public void crearEmpresa() {
        Date date = new Date();
        TbEmpresas empresaPersistir = new TbEmpresas();
        empresaPersistir = empresaConverter.convertirComponenteAEntidad(empresaComponente);
        empresaPersistir.setEmIdEmpresas(emIdEmpresas);
        empresaPersistir.setEmFechaCreacion(date);
        empresaPersistir.setEmPais(paisId);
        empresaPersistir.setEmDepto(departamentoId);
        empresaPersistir.setEmCiudad(ciudadId);
        empresasFacade.persistir(empresaPersistir);
        emIdEmpresas = emIdEmpresas + 1;
        FacesContext.getCurrentInstance().addMessage("nuevaEmpresa:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "SE CREÓ LA EMPRESA CORRECTAMENTE."));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Creación Correcta", "Se creo la empresa satisfactoriamente."));
        empresaComponente = new TbEmpresaComponente();
        paisId = null;
        departamentoId = null;
        ciudadId = null;
        departamentosMap = new HashMap<>();
        ciudadesMap = new HashMap<>();
    }


    /*Getters & Setters*/
    public TbEmpresaComponente getEmpresaComponente() {
        return empresaComponente;
    }

    public void setEmpresaComponente(TbEmpresaComponente empresaComponente) {
        this.empresaComponente = empresaComponente;
    }

    public Integer getEmIdEmpresas() {
        return emIdEmpresas;
    }

    public void setEmIdEmpresas(Integer emIdEmpresas) {
        this.emIdEmpresas = emIdEmpresas;
    }

    public Map<String, Integer> getSectores() {
        return sectores;
    }

    public void setSectores(Map<String, Integer> sectores) {
        this.sectores = sectores;
    }

    public Map<String, String> getPaisesMap() {
        return paisesMap;
    }

    public void setPaisesMap(Map<String, String> paisesMap) {
        this.paisesMap = paisesMap;
    }

    public Map<String, String> getDepartamentosMap() {
        return departamentosMap;
    }

    public void setDepartamentosMap(Map<String, String> departamentosMap) {
        this.departamentosMap = departamentosMap;
    }

    public Map<String, String> getCiudadesMap() {
        return ciudadesMap;
    }

    public void setCiudadesMap(Map<String, String> ciudadesMap) {
        this.ciudadesMap = ciudadesMap;
    }

    public String getPaisId() {
        return paisId;
    }

    public void setPaisId(String paisId) {
        this.paisId = paisId;
    }

    public String getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(String departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(String ciudadId) {
        this.ciudadId = ciudadId;
    }

}
