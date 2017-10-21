/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TbHistorialCasosComponente;
import com.datamarket.converter.TbHistorialCasosConverter;
import com.datamarket.entidades.TbHistorialCasos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class DetalleHistorialEjecutivo implements Serializable {

    @Inject
    ObjetosSesion sesion;
    @Inject
    TbHistorialCasosConverter historialConverter;

    private TbHistorialCasos historialDetalle;
    private TbHistorialCasosComponente historialDetalleComponente;

    @PostConstruct
    public void init() {
        historialDetalle = sesion.getHistorialCaso();
        convertirHistorialAHistorialComponente();

    }

    public void convertirHistorialAHistorialComponente() {
        List<TbHistorialCasos> aux = new ArrayList();
        aux.add(historialDetalle);
        List<TbHistorialCasosComponente> auxComp = historialConverter.convertirAHistorialComponente(aux);
        historialDetalleComponente = auxComp.get(0);
    }


    /*Getters & Setters*/
    public TbHistorialCasosComponente getHistorialDetalleComponente() {
        return historialDetalleComponente;
    }

    public void setHistorialDetalleComponente(TbHistorialCasosComponente historialDetalleComponente) {
        this.historialDetalleComponente = historialDetalleComponente;
    }
    
    


}
