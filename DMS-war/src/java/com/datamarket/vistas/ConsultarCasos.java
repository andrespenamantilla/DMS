/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TbCasoEmpresaComponenteVista;
import com.datamarket.components.TbCasosEmpresasItems;
import com.datamarket.converter.TbCasosEmpresasConverter;
import com.datamarket.entidades.TbCasosEmpresas;
import com.datamarket.facades.TbAdmUsuariosFacade;
import com.datamarket.facades.TbCasosEmpresasFacade;
import com.datamarket.servicios.TbEjecutivosServicio;
import com.datamarket.utils.ConverterCasosEmpresasToItems;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrés
 */
@Named
@ViewScoped
public class ConsultarCasos implements Serializable {

    @Inject
    TbCasosEmpresasFacade casosEmpresasFacade;
    @Inject
    ConverterCasosEmpresasToItems converterToItems;
    @Inject
    TbCasosEmpresasFacade casosEmpresas;
    @Inject
    ObjetosSesion sesion;
    @Inject
    TbCasosEmpresasConverter casosEmpresasConverter;
    @Inject
    TbEjecutivosServicio ejecutivosServicio;
    @Inject
    TbAdmUsuariosFacade usuariosFacade;

    private List<TbCasosEmpresas> casosFiltrados;
    private String ceEstado;
    private String ceTipoCont;
    private String ceLineaNegocio;
    private Integer ceEtapa;
    private List<TbCasosEmpresasItems> listaCasosEmpresasVista;
    private TbCasosEmpresas casoEmpresa;
    private TbCasoEmpresaComponenteVista casoEmpresaComponente;
    private Map<String, Integer> ejecutivos;
    private Integer ecEjecutivo;
    private String nombreEjecutivo;

    @PostConstruct
    public void init() {
        ceEstado = null;
        ceTipoCont = null;
        ceLineaNegocio = null;
        ceEtapa = null;
        ecEjecutivo = null;
        casosFiltrados = new ArrayList<>();
        listaCasosEmpresasVista = new ArrayList<>();
        casoEmpresaComponente = new TbCasoEmpresaComponenteVista();
        ejecutivos = ejecutivosServicio.getAllEjecutivosMap();
        nombreEjecutivo = null;

    }

    /*Getters & Setters*/
    public TbCasosEmpresasFacade getCasosEmpresasFacade() {
        return casosEmpresasFacade;
    }

    public void setCasosEmpresasFacade(TbCasosEmpresasFacade casosEmpresasFacade) {
        this.casosEmpresasFacade = casosEmpresasFacade;
    }

    public List<TbCasosEmpresas> getCasosFiltrados() {
        return casosFiltrados;
    }

    public void setCasosFiltrados(List<TbCasosEmpresas> casosFiltrados) {
        this.casosFiltrados = casosFiltrados;
    }

    public String getCeEstado() {
        return ceEstado;
    }

    public void setCeEstado(String ceEstado) {
        this.ceEstado = ceEstado;
    }

    public String getCeTipoCont() {
        return ceTipoCont;
    }

    public void setCeTipoCont(String ceTipoCont) {
        this.ceTipoCont = ceTipoCont;
    }

    public String getCeLineaNegocio() {
        return ceLineaNegocio;
    }

    public void setCeLineaNegocio(String ceLineaNegocio) {
        this.ceLineaNegocio = ceLineaNegocio;
    }

    public Integer getCeEtapa() {
        return ceEtapa;
    }

    public void setCeEtapa(Integer ceEtapa) {
        this.ceEtapa = ceEtapa;
    }

    public List<TbCasosEmpresasItems> getListaCasosEmpresasVista() {
        return listaCasosEmpresasVista;
    }

    public void setListaCasosEmpresasVista(List<TbCasosEmpresasItems> listaCasosEmpresasVista) {
        this.listaCasosEmpresasVista = listaCasosEmpresasVista;
    }

    public TbCasosEmpresas getCasoEmpresa() {
        return casoEmpresa;
    }

    public void setCasoEmpresa(TbCasosEmpresas casoEmpresa) {
        this.casoEmpresa = casoEmpresa;
    }

    public TbCasoEmpresaComponenteVista getCasoEmpresaComponente() {
        return casoEmpresaComponente;
    }

    public void setCasoEmpresaComponente(TbCasoEmpresaComponenteVista casoEmpresaComponente) {
        this.casoEmpresaComponente = casoEmpresaComponente;
    }

    public Map<String, Integer> getEjecutivos() {
        return ejecutivos;
    }

    public void setEjecutivos(Map<String, Integer> ejecutivos) {
        this.ejecutivos = ejecutivos;
    }

    public Integer getEcEjecutivo() {
        return ecEjecutivo;
    }

    public void setEcEjecutivo(Integer ecEjecutivo) {
        this.ecEjecutivo = ecEjecutivo;
    }

    public String getNombreEjecutivo() {
        return nombreEjecutivo;
    }

    public void setNombreEjecutivo(String nombreEjecutivo) {
        this.nombreEjecutivo = nombreEjecutivo;
    }

    public void consultarCasosEmpresasPorCriterios() {
        if (ecEjecutivo == null) {
            nombreEjecutivo = "Búsqueda por todos los ejecutivos";

        } else {
            nombreEjecutivo = "EJECUTIVO: "+""+usuariosFacade.findNombreById(ecEjecutivo);
        }

        casosFiltrados = casosEmpresasFacade.buscarCasosPorCriterios(ceEstado, ceTipoCont, ceEtapa, ceLineaNegocio, ecEjecutivo);
        listaCasosEmpresasVista = converterToItems.convertirTbCasosEmpresasToCasosEmpresasItems(casosFiltrados);

    }

    public void casoSeleccionado(TbCasosEmpresasItems selectedItem) {

        casoEmpresa = casosEmpresasFacade.buscarPorId(selectedItem.getCe_sec_caso());
        casoEmpresaComponente = casosEmpresasConverter.convertirEntidadAComponenteVista(casoEmpresa);
    }

}
