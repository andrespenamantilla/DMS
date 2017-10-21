/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.components;

/**
 *
 * @author andres
 */
public class PonderadoTotalOpcion {

    private String sinDescuento;
    private String descuento;
    private String totalAntesDeIva;

    
    public String getSinDescuento() {
        return "$ "+sinDescuento;
    }

    /*Getters & Setters*/
    public void setSinDescuento(String sinDescuento) {
        this.sinDescuento = sinDescuento;
    }

    public String getDescuento() {
        return  "$ "+descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getTotalAntesDeIva() {
        return "$ "+totalAntesDeIva ;
    }

    public void setTotalAntesDeIva(String totalAntesDeIva) {
        this.totalAntesDeIva = totalAntesDeIva;
    }

}
