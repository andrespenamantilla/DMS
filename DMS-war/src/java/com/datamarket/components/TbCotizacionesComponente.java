/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.components;

import java.util.Date;

/**
 *
 * @author andres
 */
public class TbCotizacionesComponente {

    private Integer co_cod_cotiz;
    private Integer co_cod_empresa;
    private String nombre_empresa;
    private Integer co_ejecutivo;
    private String nombre_ejecutivo;
    private Date co_fecha;
    private Integer co_caso;

    /*Getters & Setters*/
    public Integer getCo_cod_cotiz() {
        return co_cod_cotiz;
    }

    public void setCo_cod_cotiz(Integer co_cod_cotiz) {
        this.co_cod_cotiz = co_cod_cotiz;
    }

    public Integer getCo_cod_empresa() {
        return co_cod_empresa;
    }

    public void setCo_cod_empresa(Integer co_cod_empresa) {
        this.co_cod_empresa = co_cod_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public Integer getCo_ejecutivo() {
        return co_ejecutivo;
    }

    public void setCo_ejecutivo(Integer co_ejecutivo) {
        this.co_ejecutivo = co_ejecutivo;
    }

    public String getNombre_ejecutivo() {
        return nombre_ejecutivo;
    }

    public void setNombre_ejecutivo(String nombre_ejecutivo) {
        this.nombre_ejecutivo = nombre_ejecutivo;
    }

    public Date getCo_fecha() {
        return co_fecha;
    }

    public void setCo_fecha(Date co_fecha) {
        this.co_fecha = co_fecha;
    }

    public Integer getCo_caso() {
        return co_caso;
    }

    public void setCo_caso(Integer co_caso) {
        this.co_caso = co_caso;
    }

}
