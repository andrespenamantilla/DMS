/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TbEmpresasProspectoComponente;
import com.datamarket.converter.TbEmpresasProspectoConverter;
import com.datamarket.entidades.TbEmpresasProspecto;
import com.datamarket.facades.TbEmpresasProspectoFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class ListaEmpresasProspecto implements Serializable {

    @Inject
    TbEmpresasProspectoFacade empresasProspectoFacade;
    @Inject
    ObjetosSesion session;
    @Inject
    TbEmpresasProspectoConverter empresasProspectoConverter;
    private List<TbEmpresasProspecto> empresasProspectadas;
    private TbEmpresasProspecto empresaProspectoTarget;
    private Integer idEjecutivo;
    private List<TbEmpresasProspectoComponente> empresasProspectadasComponente;
    private TbEmpresasProspectoComponente empresasProspectoComponenteEliminar;

    @PostConstruct
    public void init() {
        idEjecutivo = session.getUsuarioEnSesion().getUsCodUsuario();
        empresaProspectoTarget = new TbEmpresasProspecto();
        empresasProspectoComponenteEliminar = new TbEmpresasProspectoComponente();
        empresasProspectadasComponente = new ArrayList<>();
        if (session.getUsuarioEnSesion().getUsRol().getRoDescripcion().equals("ADMIN_BD")) {

        } else {
            empresasProspectadas = empresasProspectoFacade.consultarProspectosPorEjecutivo(idEjecutivo);
        }

        empresasProspectadas = empresasProspectoFacade.listarTodosLosProspectos();
        empresasProspectadasComponente = empresasProspectoConverter.convertirTbEmpresasProspectoToEmpresasProspectoComponente(empresasProspectadas);
    }

    public String detalleEmpresaProspectada(TbEmpresasProspectoComponente empresaProspectada) {
        session.setEmpresaProspectoSesion(empresasProspectoFacade.findById(empresaProspectada.getPe_empresa()));
        return "irDetalleEmpresaProspecto";
    }

    public void eliminarEmpresaProspecto() {
        try {
            empresaProspectoTarget = empresasProspectoFacade.findById(empresasProspectoComponenteEliminar.getPe_empresa());
            empresasProspectoFacade.eliminarEmpresaProspecto(empresaProspectoTarget);
            empresasProspectadas.remove(empresaProspectoTarget);
            empresasProspectadasComponente.remove(empresasProspectoComponenteEliminar);
            FacesContext.getCurrentInstance().addMessage("formEmpresasProspectadasId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se eliminó el prospecto"));

        } catch (Exception e) {
        }

    }

    public String editarEmpresaProspecto(TbEmpresasProspectoComponente empresaProspectoComponente) {
        session.setEmpresaProspectoSesion(empresasProspectoFacade.findById(empresaProspectoComponente.getPe_empresa()));
        return "irEditarEmpresaProspecto";
    }

    /*Getters & Setters*/
    public List<TbEmpresasProspecto> getEmpresasProspectadas() {
        return empresasProspectadas;
    }

    public void setEmpresasProspectadas(List<TbEmpresasProspecto> empresasProspectadas) {
        this.empresasProspectadas = empresasProspectadas;
    }

    public TbEmpresasProspecto getEmpresaProspectoTarget() {
        return empresaProspectoTarget;
    }

    public void setEmpresaProspectoTarget(TbEmpresasProspecto empresaProspectoTarget) {
        this.empresaProspectoTarget = empresaProspectoTarget;
    }

    public List<TbEmpresasProspectoComponente> getEmpresasProspectadasComponente() {
        return empresasProspectadasComponente;
    }

    public void setEmpresasProspectadasComponente(List<TbEmpresasProspectoComponente> empresasProspectadasComponente) {
        this.empresasProspectadasComponente = empresasProspectadasComponente;
    }

    public TbEmpresasProspectoComponente getEmpresasProspectoComponenteEliminar() {
        return empresasProspectoComponenteEliminar;
    }

    public void setEmpresasProspectoComponenteEliminar(TbEmpresasProspectoComponente empresasProspectoComponenteEliminar) {
        this.empresasProspectoComponenteEliminar = empresasProspectoComponenteEliminar;
    }

}
