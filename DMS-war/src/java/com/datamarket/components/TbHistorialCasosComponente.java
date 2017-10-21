/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.components;

import com.datamarket.entidades.TbAdmUsuarios;
import com.datamarket.entidades.TbEmpresas;
import java.util.Date;

/**
 *
 * @author andre
 */
public class TbHistorialCasosComponente {
   
    private Integer hc_sec_historial;
    private Integer hc_sec_caso;
    private TbEmpresas hc_cod_empresa;
    private Integer hc_cod_contacto;
    private String hc_cod_etapa;
    private String hc_estado_caso;
    private String hc_evento;
    private Integer hc_cod_tarea;
    private String hc_estado_tarea;
    private String hc_anotacion;
    private Date hc_fecha;
    private TbAdmUsuarios hc_usuario;
    
    /*Getters & Setters*/

    public Integer getHc_sec_historial() {
        return hc_sec_historial;
    }

    public void setHc_sec_historial(Integer hc_sec_historial) {
        this.hc_sec_historial = hc_sec_historial;
    }

    public Integer getHc_sec_caso() {
        return hc_sec_caso;
    }

    public void setHc_sec_caso(Integer hc_sec_caso) {
        this.hc_sec_caso = hc_sec_caso;
    }

    public TbEmpresas getHc_cod_empresa() {
        return hc_cod_empresa;
    }

    public void setHc_cod_empresa(TbEmpresas hc_cod_empresa) {
        this.hc_cod_empresa = hc_cod_empresa;
    }

    public Integer getHc_cod_contacto() {
        return hc_cod_contacto;
    }

    public void setHc_cod_contacto(Integer hc_cod_contacto) {
        this.hc_cod_contacto = hc_cod_contacto;
    }

    public String getHc_cod_etapa() {
        return hc_cod_etapa;
    }

    public void setHc_cod_etapa(String hc_cod_etapa) {
        this.hc_cod_etapa = hc_cod_etapa;
    }

    public String getHc_estado_caso() {
        return hc_estado_caso;
    }

    public void setHc_estado_caso(String hc_estado_caso) {
        this.hc_estado_caso = hc_estado_caso;
    }

    public String getHc_evento() {
        return hc_evento;
    }

    public void setHc_evento(String hc_evento) {
        this.hc_evento = hc_evento;
    }

    public Integer getHc_cod_tarea() {
        return hc_cod_tarea;
    }

    public void setHc_cod_tarea(Integer hc_cod_tarea) {
        this.hc_cod_tarea = hc_cod_tarea;
    }

    public String getHc_estado_tarea() {
        return hc_estado_tarea;
    }

    public void setHc_estado_tarea(String hc_estado_tarea) {
        this.hc_estado_tarea = hc_estado_tarea;
    }

    public String getHc_anotacion() {
        return hc_anotacion;
    }

    public void setHc_anotacion(String hc_anotacion) {
        this.hc_anotacion = hc_anotacion;
    }

    public Date getHc_fecha() {
        return hc_fecha;
    }

    public void setHc_fecha(Date hc_fecha) {
        this.hc_fecha = hc_fecha;
    }

    public TbAdmUsuarios getHc_usuario() {
        return hc_usuario;
    }

    public void setHc_usuario(TbAdmUsuarios hc_usuario) {
        this.hc_usuario = hc_usuario;
    }
    
    
    
}
