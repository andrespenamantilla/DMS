/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.components;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Andrés
 */
public class TbObservacionesComponente {

    private Integer dc_codigo;
    private String dc_clase;
    @NotNull(message = "La descripción es requerida")
    private String dc_texto;
    private Integer ob_dc;
    private Integer ob_fac;
    private TbDetalleCotizacionComponente detalleCotizacionComponente;

    public TbDetalleCotizacionComponente getDetalleCotizacionComponente() {
        return detalleCotizacionComponente;
    }

    public void setDetalleCotizacionComponente(TbDetalleCotizacionComponente detalleCotizacionComponente) {
        this.detalleCotizacionComponente = detalleCotizacionComponente;
    }

    /*Getters & Setters*/
    public Integer getDc_codigo() {
        return dc_codigo;
    }

    public void setDc_codigo(Integer dc_codigo) {
        this.dc_codigo = dc_codigo;
    }

    public String getDc_clase() {
        return dc_clase;
    }

    public void setDc_clase(String dc_clase) {
        this.dc_clase = dc_clase;
    }

    public String getDc_texto() {
        return dc_texto;
    }

    public void setDc_texto(String dc_texto) {
        this.dc_texto = dc_texto;
    }

    public Integer getOb_dc() {
        return ob_dc;
    }

    public void setOb_dc(Integer ob_dc) {
        this.ob_dc = ob_dc;
    }

    public Integer getOb_fac() {
        return ob_fac;
    }

    public void setOb_fac(Integer ob_fac) {
        this.ob_fac = ob_fac;
    }

}
