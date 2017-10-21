/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Andrés
 */
@Named
@ViewScoped
public class Navegacion implements Serializable {

    public String irNuevoEmpresaProspecto() {

        return "irNuevaEmpresaProspecto";
    }

    public String irListaEmpresasProspectadas() {

        return "irTodasEmpresasProspectadas";
    }

    public String irEmpresasDelComercial() {
        return "verEmpresasComercial";

    }

    public String irListaHistoriales() {
        return "irListaHistorial";
    }

    public String irEventos() {
        return "irCalendarioEventos";
    }

    public String irBuscarEmpresa() {

        return "irBuscarEmpresa";
    }

    public String irConsultaCasos() {
        return "irBuscarCasos";
    }

    public String irConsultaTareas() {
        return "irBuscarTareas";
    }

    public String irNuevoProducto() {

        return "irNuevoProducto";
    }

    public String irBusquedaListaProductos() {

        return "irBusquedaListaProductos";
    }

}
