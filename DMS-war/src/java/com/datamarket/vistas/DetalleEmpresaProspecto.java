/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.entidades.TbEjecutivos;
import com.datamarket.entidades.TbEmpresasProspecto;
import com.datamarket.facades.TbCiudadesFacade;
import com.datamarket.facades.TbDepartamentosFacade;
import com.datamarket.facades.TbDetalleCatalogoFacade;
import com.datamarket.facades.TbEjecutivosFacade;
import com.datamarket.facades.TbPaisesFacade;
import java.io.Serializable;
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
public class DetalleEmpresaProspecto implements Serializable {

    @Inject
    ObjetosSesion session;
    @Inject
    TbEjecutivosFacade ejecutivosFacade;
    @Inject
    TbPaisesFacade paisesFacade;
    @Inject
    TbDepartamentosFacade departamentoFacade;
    @Inject
    TbCiudadesFacade ciudadFacade;
    @Inject
    TbDetalleCatalogoFacade catalogoFacade;

    private TbEmpresasProspecto empresaProspectoDetalle;
    private TbEjecutivos ejecutivo;
    private String nombreEjecutivo;
    private String nombrePais;
    private String nombreDepto;
    private String nombreCiudad;
    private final String camposNulos = "NO REGISTRA";
    private String nombreReferencia;
    private String nombreCargo;
    private String nombreArea;
    private String nombreSector;

    @PostConstruct()
    public void init() {
        empresaProspectoDetalle = session.getEmpresaProspectoSesion();
        ejecutivo = ejecutivosFacade.buscarPorId(empresaProspectoDetalle.getPeEjecutivo());
        nombreEjecutivo = ejecutivo.getTbAdmUsuarios().getUsNombre();
        nombrePais = paisesFacade.findNombreById(empresaProspectoDetalle.getPePais());
        nombreDepto = departamentoFacade.findNombreById(empresaProspectoDetalle.getPePais(), empresaProspectoDetalle.getPeDepartamento());
        nombreCiudad = ciudadFacade.findNombreById(empresaProspectoDetalle.getPePais(), empresaProspectoDetalle.getPeDepartamento(), empresaProspectoDetalle.getPeCiudad());
        nombreReferencia = catalogoFacade.nombreCatalogoReferido(empresaProspectoDetalle.getPeReferencia());
        nombreSector = catalogoFacade.nombreCatalogoSector(empresaProspectoDetalle.getPeSector());
        camposNoRegistrados();
    }

    public void camposNoRegistrados() {
        if (empresaProspectoDetalle.getPeEmail() == null) {
            empresaProspectoDetalle.setPeEmail(camposNulos);
        }
        if (empresaProspectoDetalle.getPeSitioWeb() == null) {
            empresaProspectoDetalle.setPeSitioWeb(camposNulos);
        }
        if (empresaProspectoDetalle.getPeNombreContacto() == null) {
            empresaProspectoDetalle.setPeNombreContacto(camposNulos);
        }
        if (empresaProspectoDetalle.getPeApellidoContacto() == null) {
            empresaProspectoDetalle.setPeApellidoContacto(camposNulos);
        }
        if (empresaProspectoDetalle.getPeDescripcionFuncion() == null) {
            empresaProspectoDetalle.setPeDescripcionFuncion(camposNulos);
        }
        if (empresaProspectoDetalle.getPeArea() == null) {
            nombreArea = camposNulos;
        } else {
            nombreArea = catalogoFacade.nombreCatalogoArea(empresaProspectoDetalle.getPeArea());
        }

        if (empresaProspectoDetalle.getPeCargo() == null) {
            nombreCargo = camposNulos;
        } else {
            nombreCargo = catalogoFacade.nombreCatalogoCargo(empresaProspectoDetalle.getPeCargo());
        }

    }

    /*Getters & Setters*/
    public TbEmpresasProspecto getEmpresaProspectoDetalle() {
        return empresaProspectoDetalle;
    }

    public void setEmpresaProspectoDetalle(TbEmpresasProspecto empresaProspectoDetalle) {
        this.empresaProspectoDetalle = empresaProspectoDetalle;
    }

    public String getNombreEjecutivo() {
        return nombreEjecutivo;
    }

    public void setNombreEjecutivo(String nombreEjecutivo) {
        this.nombreEjecutivo = nombreEjecutivo;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getNombreReferencia() {
        return nombreReferencia;
    }

    public void setNombreReferencia(String nombreReferencia) {
        this.nombreReferencia = nombreReferencia;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getNombreSector() {
        return nombreSector;
    }

    public void setNombreSector(String nombreSector) {
        this.nombreSector = nombreSector;
    }
    
    
    

}
