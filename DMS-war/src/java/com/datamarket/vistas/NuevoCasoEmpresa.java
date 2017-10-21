/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.CasoEmpresaComponente;
import com.datamarket.components.TbCasosEmpresasItems;
import com.datamarket.converter.TbCasosEmpresasConverter;
import com.datamarket.entidades.TbCasosEmpresas;
import com.datamarket.entidades.TbEmpresaComercial;
import com.datamarket.entidades.TbEmpresas;
import com.datamarket.facades.TbCasosEmpresasFacade;
import com.datamarket.facades.TbContactosEmpresasFacade;
import com.datamarket.facades.TbDetalleCatalogoFacade;
import com.datamarket.servicios.TbDetalleCatalogoServicio;
import com.datamarket.servicios.TbEtapasProcesoServicio;
import com.datamarket.utils.ConverterCasosEmpresasToItems;
import com.datamarket.utils.ConverterTareasEmpresasToTareasItems;
import com.datamarket.utils.ConverterTbContactosEmpresas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
 * @author Andrés
 */
@Named
@ViewScoped
public class NuevoCasoEmpresa implements Serializable {

    @Inject
    ObjetosSesion objetosSesion;
    @Inject
    ConverterTbContactosEmpresas converterContactos;
    @Inject
    TbDetalleCatalogoServicio catalogoServicio;
    @Inject
    TbCasosEmpresasFacade casosEmpresas;
    @Inject
    TbEtapasProcesoServicio etapasProcesoServicio;
    @Inject
    TbCasosEmpresasConverter converter;
    @Inject
    ConverterCasosEmpresasToItems converterToItems;
    @Inject
    TbContactosEmpresasFacade contactoEmpresaFacade;
    @Inject
    TbDetalleCatalogoFacade detalleCatalogoFacade;
    @Inject
    TbCasosEmpresasFacade casoEmpresaFacade;

    private boolean renderedFormAgregarCaso;

    private Map<String, Integer> contactosSelectItem;
    private TbEmpresas empresaSesion;
    private TbEmpresaComercial empresaComercialSesion;
    private CasoEmpresaComponente casoEmpresaComponente;
    private Map<String, String> lineasNegocio;
    private Map<String, String> tipoContacto;
    private Map<String, String> estadoProceso;
    private Map<String, String> cambioEstadoProceso;
    private List<TbCasosEmpresas> listaDeCasosPorEmpresa;
    private Map<String, Integer> etapasProceso;
    private List<TbCasosEmpresasItems> listaCasosEmpresasItems;
    private TbCasosEmpresasItems casoEmpresa;

    @PostConstruct
    public void init() {
        listaCasosEmpresasItems = new ArrayList();
        contactosSelectItem = new HashMap<>();
        lineasNegocio = new HashMap<>();
        tipoContacto = new HashMap<>();
        estadoProceso = new HashMap<>();
        cambioEstadoProceso = new HashMap<>();
        casoEmpresaComponente = new CasoEmpresaComponente();

        empresaSesion = new TbEmpresas();
        empresaComercialSesion = new TbEmpresaComercial();

        cargarCatalogos();
        empresaSesion = objetosSesion.getEmpresaSesion();
        empresaComercialSesion = objetosSesion.getEmpresaComercialSesion();
        casoEmpresaComponente.setCe_empresa(empresaSesion.getEmIdEmpresas());
        contactosSelectItem = converterContactos.converterContactosEmpresasToHashMap(objetosSesion.getContactosEmpresas());
        listaDeCasosPorEmpresa = casosEmpresas.listarCasosEmpresasPorIdEmpresaComercial(empresaComercialSesion);
        listaCasosEmpresasItems = converterToItems.convertirTbCasosEmpresasToCasosEmpresasItems(listaDeCasosPorEmpresa);

    }

    public void cargarCatalogos() {
        lineasNegocio = catalogoServicio.getAllLineaNegocio();
        tipoContacto = catalogoServicio.getAllTipoContacto();
        estadoProceso = catalogoServicio.getAllEstadoProceso();
        cambioEstadoProceso = catalogoServicio.getAllCambioEstadoProceso();
        etapasProceso = etapasProcesoServicio.getAllEtapasProcesoMap();

    }

    /**/
    public void insertarNuevoCasoEmpresa() {
        if (casosEmpresas.seleccionarUltimoRow(empresaComercialSesion.getEcEjecutivo().getEjCodigo()) == true) {
            FacesContext.getCurrentInstance().addMessage("nuevoCasoEmpresaId:messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "No puede generar un proceso nuevo, ya existe uno en estado abierto."));
        } else {
            TbCasosEmpresas casoNuevo;

            casoNuevo = converter.TbCasosEmpresasComponenteToEntity(casoEmpresaComponente);
            casoNuevo.setCeEmpresa(empresaComercialSesion);
            casosEmpresas.guardarTbCasosEmpresas(casoNuevo);
            listaDeCasosPorEmpresa.add(casoNuevo);
            TbCasosEmpresasItems casoAux;
            casoAux = converterToItems.convertirTbCasoEmpresaToCasosEmpresaItem(casoNuevo);
            listaCasosEmpresasItems.add(casoAux);
            //clear();
            FacesContext.getCurrentInstance().addMessage("nuevoCasoEmpresaId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se agrego un caso con éxito"));
            casoEmpresaComponente = new CasoEmpresaComponente();
            casoAux = new TbCasosEmpresasItems();
        }
    }


    /**/
    public void eliminarCasoEmpresa() {

        TbCasosEmpresas tbCasoEmpresa;

        Integer id = casoEmpresa.getCe_sec_caso();
        tbCasoEmpresa = casosEmpresas.buscarPorIdCasoEmpresa(id);

        casosEmpresas.eliminarTbCasosEmpresas(tbCasoEmpresa);
        listaDeCasosPorEmpresa.remove(tbCasoEmpresa);
        listaCasosEmpresasItems.remove(casoEmpresa);
        FacesContext.getCurrentInstance().addMessage("listaCasosEmpresaId:messageIdEliminar", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se  elimino el caso correctamente"));

    }

    /*Getters & Setters*/
    public Map<String, Integer> getContactosSelectItem() {
        return contactosSelectItem;
    }

    public void setContactosSelectItem(Map<String, Integer> contactosSelectItem) {
        this.contactosSelectItem = contactosSelectItem;
    }

    public TbEmpresas getEmpresaSesion() {
        return empresaSesion;
    }

    public void setEmpresaSesion(TbEmpresas empresaSesion) {
        this.empresaSesion = empresaSesion;
    }

    public TbEmpresaComercial getEmpresaComercialSesion() {
        return empresaComercialSesion;
    }

    public void setEmpresaComercialSesion(TbEmpresaComercial empresaComercialSesion) {
        this.empresaComercialSesion = empresaComercialSesion;
    }

    public CasoEmpresaComponente getCasoEmpresaComponente() {
        return casoEmpresaComponente;
    }

    public void setCasoEmpresaComponente(CasoEmpresaComponente casoEmpresaComponente) {
        this.casoEmpresaComponente = casoEmpresaComponente;
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

    public List<TbCasosEmpresas> getListaDeCasosPorEmpresa() {
        return listaDeCasosPorEmpresa;
    }

    public void setListaDeCasosPorEmpresa(List<TbCasosEmpresas> listaDeCasosPorEmpresa) {
        this.listaDeCasosPorEmpresa = listaDeCasosPorEmpresa;
    }

    public boolean isRenderedFormAgregarCaso() {
        return renderedFormAgregarCaso;
    }

    public void setRenderedFormAgregarCaso(boolean renderedFormAgregarCaso) {
        this.renderedFormAgregarCaso = renderedFormAgregarCaso;
    }

    public Map<String, Integer> getEtapasProceso() {
        return etapasProceso;
    }

    public void setEtapasProceso(Map<String, Integer> etapasProceso) {
        this.etapasProceso = etapasProceso;
    }

    public TbCasosEmpresasItems getCasoEmpresa() {
        return casoEmpresa;
    }

    public void setCasoEmpresa(TbCasosEmpresasItems casoEmpresa) {
        this.casoEmpresa = casoEmpresa;
    }

    public void clear() {
        casoEmpresaComponente.setCe_causal("");
        casoEmpresaComponente.setCe_etapa(null);
        casoEmpresaComponente.setCe_linea_negocio("");
        casoEmpresaComponente.setCe_sec_caso(null);
        casoEmpresaComponente.setCe_tipo_cont("");
        casoEmpresaComponente.setCe_contacto(null);
        casoEmpresaComponente.setCe_descripcion("");

    }

    public String irNuevaTarea(TbCasosEmpresasItems item) {
        TbCasosEmpresas casoEmpresa;
        casoEmpresa = casoEmpresaFacade.buscarPorId(item.getCe_sec_caso());
        objetosSesion.setCasoEmpresaSesion(casoEmpresa);
        return "irNuevaTareaEmpresa";
    }

    public List<TbCasosEmpresasItems> getListaCasosEmpresasItems() {
        return listaCasosEmpresasItems;
    }

    public void setListaCasosEmpresasItems(List<TbCasosEmpresasItems> listaCasosEmpresasItems) {
        this.listaCasosEmpresasItems = listaCasosEmpresasItems;
    }

    public String irDetalleCaso(TbCasosEmpresasItems item) {
        TbCasosEmpresas casoHallado;
        casoHallado = casosEmpresas.buscarPorId(item.getCe_sec_caso());
        objetosSesion.setCasoEmpresaSesion(casoHallado);
        return "irDetalleCasoEmpresa";
    }

}
