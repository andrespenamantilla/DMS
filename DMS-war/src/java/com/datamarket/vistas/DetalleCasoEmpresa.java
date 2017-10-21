/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.Ifacades.ITbCotizacionesFacadeLocal;
import com.datamarket.Ifacades.ITbDetalleCotizacionFacadeLocal;
import com.datamarket.components.CasoEmpresaComponente;
import com.datamarket.components.TbCotizacionesComponente;
import com.datamarket.converter.TbCotizacionesConverter;
import com.datamarket.entidades.TbCasosEmpresas;
import com.datamarket.entidades.TbCotizaciones;
import com.datamarket.facades.TbCasosEmpresasFacade;
import com.datamarket.servicios.TbDetalleCatalogoServicio;
import com.datamarket.servicios.TbEtapasProcesoServicio;
import com.datamarket.utils.ConverterTbContactosEmpresas;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author andre
 */
@ViewScoped
@Named
public class DetalleCasoEmpresa implements Serializable {

    @Inject
    ObjetosSesion sesion;
    @Inject
    TbDetalleCatalogoServicio catalogoServicio;
    @Inject
    TbEtapasProcesoServicio etapasProcesoServicio;
    @Inject
    ConverterTbContactosEmpresas converterContactos;
    @Inject
    TbCasosEmpresasFacade casoEmpresaFacade;
    @Inject
    ITbCotizacionesFacadeLocal cotizacionesFacade;
    @Inject
    TbCotizacionesConverter cotizacionesConverter;
    

    private TbCasosEmpresas casosEmpresaDetalle;
    private CasoEmpresaComponente casoEmpresaComponenteDetalle;
    private Map<String, String> lineasNegocio;
    private Map<String, String> tipoContacto;
    private Map<String, String> estadoProceso;
    private Map<String, String> cambioEstadoProceso;
    private Map<String, Integer> contactosSelectItem;
    private Map<String, Integer> etapasProceso;
    private boolean habilitarCamposFormulario;
    private List<TbCotizaciones> cotizacionesPorCaso;
    private String nombreEmpresa;
    private List<TbCotizacionesComponente> listaCotizacionesComponente;
    private TbCotizacionesComponente selected;

    @PostConstruct
    public void init() {

        habilitarCamposFormulario = true;
        contactosSelectItem = new HashMap<>();
        lineasNegocio = new HashMap<>();
        tipoContacto = new HashMap<>();
        estadoProceso = new HashMap<>();
        cambioEstadoProceso = new HashMap<>();
        casosEmpresaDetalle = sesion.getCasoEmpresaSesion();
        inicializarComponenteCasoDetalle();
        cargarCatalogos();
        contactosSelectItem = converterContactos.converterContactosEmpresasToHashMap(sesion.getContactosEmpresas());
        cotizacionesPorCaso = cotizacionesFacade.listarTodosLasCotizacionesPorCaso(sesion.getCasoEmpresaSesion().getCeSecCaso());
        nombreEmpresa = sesion.getEmpresaComercialSesion().getTbEmpresas().getEmNombre();
        listaCotizacionesComponente = cotizacionesConverter.convertirListasEntidadAComponente(cotizacionesPorCaso, nombreEmpresa);
    }

    public void habilitarCamposFormulario() {
        habilitarCamposFormulario = false;

    }

    public void deshabilitarCamposFormulario() {
        habilitarCamposFormulario = true;

    }

    public void cargarCatalogos() {
        lineasNegocio = catalogoServicio.getAllLineaNegocio();
        tipoContacto = catalogoServicio.getAllTipoContacto();
        estadoProceso = catalogoServicio.getAllEstadoProceso();
        cambioEstadoProceso = catalogoServicio.getAllCambioEstadoProceso();
        etapasProceso = etapasProcesoServicio.getAllEtapasProcesoMap();

    }

    public void inicializarComponenteCasoDetalle() {
        casoEmpresaComponenteDetalle = new CasoEmpresaComponente();

        casoEmpresaComponenteDetalle.setCe_causal(casosEmpresaDetalle.getCeCausal());
        casoEmpresaComponenteDetalle.setCe_descripcion(casosEmpresaDetalle.getCeDescripcion());
        casoEmpresaComponenteDetalle.setCe_empresa(casosEmpresaDetalle.getCeEmpresa().getEcEmpresa());
        casoEmpresaComponenteDetalle.setCe_etapa(casosEmpresaDetalle.getCeEtapa());
        casoEmpresaComponenteDetalle.setCe_contacto(casosEmpresaDetalle.getCeContacto());
        casoEmpresaComponenteDetalle.setCe_estado(casosEmpresaDetalle.getCeEstado());
        casoEmpresaComponenteDetalle.setCe_tipo_cont(casosEmpresaDetalle.getCeTipoCont());
        casoEmpresaComponenteDetalle.setCe_linea_negocio(casosEmpresaDetalle.getCeLineaNegocio());
        casoEmpresaComponenteDetalle.setCe_sec_caso(casosEmpresaDetalle.getCeSecCaso());

    }

    public void modificarCasoEmpresa() {

        casosEmpresaDetalle.setCeSecCaso(casoEmpresaComponenteDetalle.getCe_sec_caso());
        casosEmpresaDetalle.setCeContacto(casoEmpresaComponenteDetalle.getCe_contacto());
        casosEmpresaDetalle.setCeLineaNegocio(casoEmpresaComponenteDetalle.getCe_linea_negocio());
        casosEmpresaDetalle.setCeDescripcion(casoEmpresaComponenteDetalle.getCe_descripcion());
        casosEmpresaDetalle.setCeTipoCont(casoEmpresaComponenteDetalle.getCe_tipo_cont());
        casosEmpresaDetalle.setCeEtapa(casosEmpresaDetalle.getCeEtapa());
        casosEmpresaDetalle.setCeEstado(casoEmpresaComponenteDetalle.getCe_estado());
        casosEmpresaDetalle.setCeCausal(casosEmpresaDetalle.getCeCausal());
        casoEmpresaFacade.actualizar(casosEmpresaDetalle);
        FacesContext.getCurrentInstance().addMessage("detalleCasoEmpresaId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se realizó la actualización del caso satisfactoriamente."));

    }

    public String irNuevaCotizacion() {

        return "irNuevaCotizacion";
    }

    public void test() {
        System.out.println("Usted Seleccionó un registro");
    }

    public String irDetalleCotizacion(TbCotizacionesComponente componenteSeleccionado) {

        sesion.setCotizacionComponente(componenteSeleccionado);
        sesion.setCotizacion(cotizacionesFacade.findById(componenteSeleccionado.getCo_cod_cotiz()));
        return "irDetalleCotizacion";
    }


    /*Getters & Setters*/
    public CasoEmpresaComponente getCasoEmpresaComponenteDetalle() {
        return casoEmpresaComponenteDetalle;
    }

    public void setCasoEmpresaComponenteDetalle(CasoEmpresaComponente casoEmpresaComponenteDetalle) {
        this.casoEmpresaComponenteDetalle = casoEmpresaComponenteDetalle;
    }

    public TbCasosEmpresas getCasosEmpresaDetalle() {
        return casosEmpresaDetalle;
    }

    public void setCasosEmpresaDetalle(TbCasosEmpresas casosEmpresaDetalle) {
        this.casosEmpresaDetalle = casosEmpresaDetalle;
    }

    public Map<String, String> getLineasNegocio() {
        return lineasNegocio;
    }

    public void setLineasNegocio(Map<String, String> lineasNegocio) {
        this.lineasNegocio = lineasNegocio;
    }

    public Map<String, String> getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(Map<String, String> tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public Map<String, String> getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(Map<String, String> estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    public Map<String, String> getCambioEstadoProceso() {
        return cambioEstadoProceso;
    }

    public void setCambioEstadoProceso(Map<String, String> cambioEstadoProceso) {
        this.cambioEstadoProceso = cambioEstadoProceso;
    }

    public Map<String, Integer> getContactosSelectItem() {
        return contactosSelectItem;
    }

    public void setContactosSelectItem(Map<String, Integer> contactosSelectItem) {
        this.contactosSelectItem = contactosSelectItem;
    }

    public Map<String, Integer> getEtapasProceso() {
        return etapasProceso;
    }

    public void setEtapasProceso(Map<String, Integer> etapasProceso) {
        this.etapasProceso = etapasProceso;
    }

    public boolean isHabilitarCamposFormulario() {
        return habilitarCamposFormulario;
    }

    public void setHabilitarCamposFormulario(boolean habilitarCamposFormulario) {
        this.habilitarCamposFormulario = habilitarCamposFormulario;
    }

    public List<TbCotizaciones> getCotizacionesPorCaso() {
        return cotizacionesPorCaso;
    }

    public void setCotizacionesPorCaso(List<TbCotizaciones> cotizacionesPorCaso) {
        this.cotizacionesPorCaso = cotizacionesPorCaso;
    }

    public List<TbCotizacionesComponente> getListaCotizacionesComponente() {
        return listaCotizacionesComponente;
    }

    public void setListaCotizacionesComponente(List<TbCotizacionesComponente> listaCotizacionesComponente) {
        this.listaCotizacionesComponente = listaCotizacionesComponente;
    }

    public TbCotizacionesComponente getSelected() {
        return selected;
    }

    public void setSelected(TbCotizacionesComponente selected) {
        this.selected = selected;
    }

}
