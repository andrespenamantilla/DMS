/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TbHistorialCasosComponente;
import com.datamarket.converter.TbHistorialCasosConverter;
import com.datamarket.entidades.TbHistorialCasos;
import com.datamarket.facades.TbHistorialCasosFacade;
import com.datamarket.servicios.TbEjecutivosServicio;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
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
public class HistorialEjecutivo implements Serializable {

    @Inject
    TbHistorialCasosFacade historialCasosFacade;
    @Inject
    TbEjecutivosServicio ejecutivosServicio;
    @Inject
    TbHistorialCasosConverter converter;
    @Inject
    ObjetosSesion sesion;
    private Map<String, Integer> ejecutivosMap;
    private Integer idEjecutivo;

    private List<TbHistorialCasos> historialPorEjecutivo;
    private List<TbHistorialCasosComponente> historialPorEjecutivoView;

    @PostConstruct
    public void init() {
        ejecutivosMap = ejecutivosServicio.getAllEjecutivosMap();
    }

    public void buscarHistorialPorEjecutivo() {
        historialPorEjecutivo = historialCasosFacade.listarHistorialTransaccionesPorEjecutivo(idEjecutivo);
        historialPorEjecutivoView = converter.convertirAHistorialComponente(historialPorEjecutivo);

    }
    
    
    public String irDetalleHistorialComercial(TbHistorialCasosComponente historialComponente)
    {
    TbHistorialCasos historial;
    historial = historialCasosFacade.findById(historialComponente.getHc_sec_historial());
    sesion.setHistorialCaso(historial);
    
    
    return "irDetalleHistorialComercial";
    }
    

    /*Getters & Setters*/
    public List<TbHistorialCasos> getHistorialPorEjecutivo() {
        return historialPorEjecutivo;
    }

    public void setHistorialPorEjecutivo(List<TbHistorialCasos> historialPorEjecutivo) {
        this.historialPorEjecutivo = historialPorEjecutivo;
    }

    public TbEjecutivosServicio getEjecutivosServicio() {
        return ejecutivosServicio;
    }

    public void setEjecutivosServicio(TbEjecutivosServicio ejecutivosServicio) {
        this.ejecutivosServicio = ejecutivosServicio;
    }

    public Integer getIdEjecutivo() {
        return idEjecutivo;
    }

    public void setIdEjecutivo(Integer idEjecutivo) {
        this.idEjecutivo = idEjecutivo;
    }

    public Map<String, Integer> getEjecutivosMap() {
        return ejecutivosMap;
    }

    public void setEjecutivosMap(Map<String, Integer> ejecutivosMap) {
        this.ejecutivosMap = ejecutivosMap;
    }

    public List<TbHistorialCasosComponente> getHistorialPorEjecutivoView() {
        return historialPorEjecutivoView;
    }

    public void setHistorialPorEjecutivoView(List<TbHistorialCasosComponente> historialPorEjecutivoView) {
        this.historialPorEjecutivoView = historialPorEjecutivoView;
    }

}
