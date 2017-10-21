/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.entidades.TbEjecutivos;
import com.datamarket.entidades.TbEmpresasProspecto;
import com.datamarket.facades.TbEmpresasProspectoFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author andre
 */
@Named
@ViewScoped
public class ProspectosEjecutivo implements Serializable {

    @Inject
    ObjetosSesion session;
    @Inject
    TbEmpresasProspectoFacade empresasProspectoFacade;
    private List<TbEmpresasProspecto> prospectosEjecutivo;
    private TbEjecutivos ejecutivo;

    @PostConstruct
    public void init() {
        ejecutivo = session.getEjecutivoSesion();
        prospectosEjecutivo = empresasProspectoFacade.consultarProspectosPorEjecutivo(ejecutivo.getEjCodigo());

    }

    /*Getters & Setters*/
    public List<TbEmpresasProspecto> getProspectosEjecutivo() {
        return prospectosEjecutivo;
    }

    public void setProspectosEjecutivo(List<TbEmpresasProspecto> prospectosEjecutivo) {
        this.prospectosEjecutivo = prospectosEjecutivo;
    }

    
    
    public String verDetalleProspecto(TbEmpresasProspecto prospecto)
    {
    session.setEmpresaProspectoSesion(prospecto);
    return "irDetalleProspectoEjecutivo";
    }
}
