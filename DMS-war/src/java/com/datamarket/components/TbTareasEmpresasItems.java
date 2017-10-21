/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.components;

import java.util.Date;

/**
 *
 * @author Andrés
 */
public class TbTareasEmpresasItems {

    private Integer te_sec_tarea;
    private Integer te_caso;
    private Integer te_empresa;
    private String te_evento;
    private Date te_fecha_inicial;
    private Integer te_responsable;
    private String te_estado;
    private Date te_fecha_fin;
    private String te_descripcion;
    private String nombreResponsable;

    /*Getters & Setters*/
    public Integer getTe_sec_tarea() {
        return te_sec_tarea;
    }

    public void setTe_sec_tarea(Integer te_sec_tarea) {
        this.te_sec_tarea = te_sec_tarea;
    }

    public Integer getTe_caso() {
        return te_caso;
    }

    public void setTe_caso(Integer te_caso) {
        this.te_caso = te_caso;
    }

    public Integer getTe_empresa() {
        return te_empresa;
    }

    public void setTe_empresa(Integer te_empresa) {
        this.te_empresa = te_empresa;
    }

    public String getTe_evento() {
        return te_evento;
    }

    public void setTe_evento(String te_evento) {
        this.te_evento = te_evento;
    }

    public Date getTe_fecha_inicial() {
        return te_fecha_inicial;
    }

    public void setTe_fecha_inicial(Date te_fecha_inicial) {
        this.te_fecha_inicial = te_fecha_inicial;
    }

    public Integer getTe_responsable() {
        return te_responsable;
    }

    public void setTe_responsable(Integer te_responsable) {
        this.te_responsable = te_responsable;
    }

    public String getTe_estado() {
        return te_estado;
    }

    public void setTe_estado(String te_estado) {
        this.te_estado = te_estado;
    }

    public Date getTe_fecha_fin() {
        return te_fecha_fin;
    }

    public void setTe_fecha_fin(Date te_fecha_fin) {
        this.te_fecha_fin = te_fecha_fin;
    }

    public String getTe_descripcion() {
        return te_descripcion;
    }

    public void setTe_descripcion(String te_descripcion) {
        this.te_descripcion = te_descripcion;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }
    
}
