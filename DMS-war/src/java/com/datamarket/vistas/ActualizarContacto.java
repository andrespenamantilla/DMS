/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TbContactosEmpresaComponente;
import com.datamarket.converter.TbContactosEmpresasConverter;
import com.datamarket.entidades.TbContactosEmpresas;
import com.datamarket.entidades.TbDepartamentosPK;
import com.datamarket.facades.TbCiudadesFacade;
import com.datamarket.facades.TbContactosEmpresasFacade;
import com.datamarket.facades.TbDepartamentosFacade;
import com.datamarket.facades.TbEmpresasFacade;
import com.datamarket.facades.TbPaisesFacade;
import com.datamarket.servicios.TbPaisesServicio;
import java.io.Serializable;
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
 * @author andre
 */
@Named
@ViewScoped
public class ActualizarContacto implements Serializable {

    @Inject
    ObjetosSesion session;
    @Inject
    TbContactosEmpresasConverter contactosEmpresasConverter;
    @Inject
    TbContactosEmpresasFacade contactosEmpresasFacade;
    @Inject
    TbPaisesServicio paisesServicio;
    @Inject
    TbPaisesFacade paisFacade;
    @Inject
    TbDepartamentosFacade departamentosFacade;
    @Inject
    TbCiudadesFacade ciudadesFacade;
    @Inject
    TbEmpresasFacade empresasFacade;

    private TbContactosEmpresas contactoActualizar;
    private TbContactosEmpresaComponente contactoActualizarComponente;
    private Map<String, String> paisesMap;
    private Map<String, String> departamentosMap;
    private Map<String, String> ciudadesMap;
    private String paisId;
    private String departamentoId;
    private String ciudadId;

    @PostConstruct
    public void init() {
        contactoActualizar = session.getContactoEmpresa();
        contactoActualizarComponente = contactosEmpresasConverter.convertirEntidadAComponente(contactoActualizar);
        paisesMap = paisesServicio.getAllPaisesMap();

        TbDepartamentosPK pk = new TbDepartamentosPK();
        paisesMap = paisesServicio.getAllPaisesMap();

        if (contactoActualizar.getCePais() != null && contactoActualizar.getCeDepto() != null && contactoActualizar.getCeCiudad() != null) {
            paisId = contactoActualizar.getCePais();
            departamentoId = contactoActualizar.getCeDepto();
            ciudadId = contactoActualizar.getCeCiudad();

            pk.setDeCodigo(departamentoId);
            pk.setDePais(paisId);
            departamentosMap = paisesServicio.getAllDepartamentosMap(paisFacade.buscarPaisPorId(paisId));
            ciudadesMap = paisesServicio.getAllCiudadesMap(departamentosFacade.findById(pk));
        }

        if (contactoActualizar.getCePais() != null && contactoActualizar.getCeDepto() != null && contactoActualizar.getCeCiudad() == null) {
            paisId = contactoActualizar.getCePais();
            departamentoId = contactoActualizar.getCeDepto();
            ciudadId = null;
            departamentosMap = paisesServicio.getAllDepartamentosMap(paisFacade.buscarPaisPorId(paisId));
            ciudadesMap = new HashMap<>();
        }

        if (contactoActualizar.getCePais() != null && contactoActualizar.getCeDepto() == null && contactoActualizar.getCeCiudad() == null) {
            paisId = contactoActualizar.getCePais();
            departamentoId = null;
            ciudadId = null;
        }

    }

    public void modificarContactoEmpresa() {

        System.out.println(ciudadId);

        contactoActualizar = new TbContactosEmpresas();
        contactoActualizar = contactosEmpresasConverter.convertirComponenteToEntidad(contactoActualizarComponente);
        contactoActualizar.setCeCodigoEmpresa(empresasFacade.buscarPorId(contactoActualizarComponente.getCe_codigo_empresa()));
        contactoActualizar.setCeCiudad(ciudadId);
        contactoActualizar.setCeDepto(departamentoId);
        contactoActualizar.setCePais(paisId);
        contactosEmpresasFacade.modificarTbContactosEmpresas(contactoActualizar);

        FacesContext.getCurrentInstance().addMessage("actualizarContactoEmpresaId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se realizó la actualización del contacto satisfactoriamente."));

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
        contactoActualizarComponente.setCe_ciudad(ciudadId);
        ciudadesMap = paisesServicio.getAllCiudadesMap(departamentosFacade.findById(pk));
    }

    /*Getters & Setters*/
    public TbContactosEmpresaComponente getContactoActualizarComponente() {
        return contactoActualizarComponente;
    }

    public void setContactoActualizarComponente(TbContactosEmpresaComponente contactoActualizarComponente) {
        this.contactoActualizarComponente = contactoActualizarComponente;
    }

    public TbContactosEmpresas getContactoActualizar() {
        return contactoActualizar;
    }

    public void setContactoActualizar(TbContactosEmpresas contactoActualizar) {
        this.contactoActualizar = contactoActualizar;
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
