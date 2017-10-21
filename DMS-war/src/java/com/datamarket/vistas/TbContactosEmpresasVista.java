/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.entidades.TbContactosEmpresas;
import com.datamarket.servicios.TbDetalleCatalogoServicio;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Andres
 */
@Named
@ViewScoped
public class TbContactosEmpresasVista implements Serializable {

    Integer ce_secuencial_vista;
    TbEmpresasVista ce_codigo_empresa_vista;
    String ce_nombres_vista;
    String ce_apellidos_vista;
    protected Map<String, String> allCargos;
    protected Map<String, String> allAreas;

    @Inject
    TbDetalleCatalogoServicio TbDCS;

    private TbContactosEmpresas nuevoContactoEmpresa;

    @PostConstruct
    public void init() {
        allCargos = TbDCS.getAllCargosMap();
        allAreas = TbDCS.getAllAreasMap();
        nuevoContactoEmpresa = new TbContactosEmpresas();
    }

    public Integer getCe_secuencial_vista() {
        return ce_secuencial_vista;
    }

    public void setCe_secuencial_vista(Integer ce_secuencial_vista) {
        this.ce_secuencial_vista = ce_secuencial_vista;
    }

    public TbEmpresasVista getCe_codigo_empresa_vista() {
        return ce_codigo_empresa_vista;
    }

    public void setCe_codigo_empresa_vista(TbEmpresasVista ce_codigo_empresa_vista) {
        this.ce_codigo_empresa_vista = ce_codigo_empresa_vista;
    }

    public String getCe_nombres_vista() {
        return ce_nombres_vista;
    }

    public void setCe_nombres_vista(String ce_nombres_vista) {
        this.ce_nombres_vista = ce_nombres_vista;
    }

    public String getCe_apellidos_vista() {
        return ce_apellidos_vista;
    }

    public void setCe_apellidos_vista(String ce_apellidos_vista) {
        this.ce_apellidos_vista = ce_apellidos_vista;
    }

    public Map<String, String> getAllCargos() {
        return allCargos;
    }

    public void setAllCargos(Map<String, String> allCargos) {
        this.allCargos = allCargos;
    }

    public Map<String, String> getAllAreas() {
        return allAreas;
    }

    public void setAllAreas(Map<String, String> allAreas) {
        this.allAreas = allAreas;
    }

}
