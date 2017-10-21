/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Andres
 */

@Named
@ViewScoped
public class TbCasosEmpresasVista implements Serializable {

    Integer ce_sec_caso_vista ;
    String ce_cod_proceso_vista ;
    String ce_descripcion_vista ;
    Integer ce_etapa_vista ;
    String ce_estado_vista ;
    String ce_linea_negocio_vista ;
    Integer ce_empresa_vista ;

    public Integer getCe_sec_caso_vista() {
        return ce_sec_caso_vista;
    }

    public void setCe_sec_caso_vista(Integer ce_sec_caso_vista) {
        this.ce_sec_caso_vista = ce_sec_caso_vista;
    }

    public String getCe_cod_proceso_vista() {
        return ce_cod_proceso_vista;
    }

    public void setCe_cod_proceso_vista(String ce_cod_proceso_vista) {
        this.ce_cod_proceso_vista = ce_cod_proceso_vista;
    }

    public String getCe_descripcion_vista() {
        return ce_descripcion_vista;
    }

    public void setCe_descripcion_vista(String ce_descripcion_vista) {
        this.ce_descripcion_vista = ce_descripcion_vista;
    }

    public Integer getCe_etapa_vista() {
        return ce_etapa_vista;
    }

    public void setCe_etapa_vista(Integer ce_etapa_vista) {
        this.ce_etapa_vista = ce_etapa_vista;
    }

    public String getCe_estado_vista() {
        return ce_estado_vista;
    }

    public void setCe_estado_vista(String ce_estado_vista) {
        this.ce_estado_vista = ce_estado_vista;
    }

    public String getCe_linea_negocio_vista() {
        return ce_linea_negocio_vista;
    }

    public void setCe_linea_negocio_vista(String ce_linea_negocio_vista) {
        this.ce_linea_negocio_vista = ce_linea_negocio_vista;
    }

    public Integer getCe_empresa_vista() {
        return ce_empresa_vista;
    }

    public void setCe_empresa_vista(Integer ce_empresa_vista) {
        this.ce_empresa_vista = ce_empresa_vista;
    }
    
    
}
