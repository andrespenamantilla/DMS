/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.components;

import javax.validation.constraints.Min;

/**
 *
 * @author andre
 */
public class CasoEmpresaComponente {

    private Integer ce_sec_caso;
    private Integer ce_empresa;
    private Integer ce_contacto;
    private Integer ce_etapa;
    private String ce_linea_negocio;
    private String ce_estado;
    private String ce_descripcion;
    private String ce_causal;
    private String ce_tipo_cont;

   

    /*Getters & Setters*/
    public Integer getCe_sec_caso() {
        return ce_sec_caso;
    }

    public void setCe_sec_caso(Integer ce_sec_caso) {
        this.ce_sec_caso = ce_sec_caso;
    }

    public Integer getCe_empresa() {
        return ce_empresa;
    }

    public void setCe_empresa(Integer ce_empresa) {
        this.ce_empresa = ce_empresa;
    }

    public Integer getCe_contacto() {
        return ce_contacto;
    }

    public void setCe_contacto(Integer ce_contacto) {
        this.ce_contacto = ce_contacto;
    }

    public Integer getCe_etapa() {
        return ce_etapa;
    }

    public void setCe_etapa(Integer ce_etapa) {
        this.ce_etapa = ce_etapa;
    }

    public String getCe_linea_negocio() {
        return ce_linea_negocio;
    }

    public void setCe_linea_negocio(String ce_linea_negocio) {
        this.ce_linea_negocio = ce_linea_negocio;
    }

    public String getCe_estado() {
        return ce_estado;
    }

    public void setCe_estado(String ce_estado) {
        this.ce_estado = ce_estado;
    }

    public String getCe_descripcion() {
        return ce_descripcion;
    }

    public void setCe_descripcion(String ce_descripcion) {
        this.ce_descripcion = ce_descripcion;
    }

    public String getCe_causal() {
        return ce_causal;
    }

    public void setCe_causal(String ce_causal) {
        this.ce_causal = ce_causal;
    }

    public String getCe_tipo_cont() {
        return ce_tipo_cont;
    }

    public void setCe_tipo_cont(String ce_tipo_cont) {
        this.ce_tipo_cont = ce_tipo_cont;
    }

}
