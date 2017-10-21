/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.componentes.TbEmpresaComercialComponente;
import com.datamarket.components.TbContactosEmpresaComponente;
import com.datamarket.components.TbEmpresaComercialComponenteVista;
import com.datamarket.components.TbEmpresaComponente;
import com.datamarket.converter.TbContactosEmpresasConverter;
import com.datamarket.converter.TbEmpresaComponenteConverter;
import com.datamarket.converter.TbEmpresasComercialConverter;
import com.datamarket.entidades.TbContactosEmpresas;
import com.datamarket.entidades.TbEmpresaComercial;
import com.datamarket.entidades.TbEmpresas;
import com.datamarket.facades.TbContactosEmpresasFacade;
import com.datamarket.facades.TbEjecutivosFacade;
import com.datamarket.facades.TbEmpresaComercialFacade;
import com.datamarket.servicios.TbDetalleCatalogoServicio;
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
 * @author Andrés Peña mantilla
 *
 */
@Named
@ViewScoped
public class DetalleEmpresa implements Serializable {

    @Inject
    ObjetosSesion session;
    @Inject
    TbEmpresaComercialFacade empresaComercialFacade;
    @Inject
    TbDetalleCatalogoServicio catalogoServicio;
    @Inject
    TbContactosEmpresasFacade contactosFacade;
    @Inject
    TbEmpresaComponenteConverter TbEmpresaComponenteConverter;
    @Inject
    TbContactosEmpresasConverter contactosEmpresasConverter;
    @Inject
    TbContactosEmpresasFacade contactosEmpresasFacade;
    @Inject
    TbEmpresasComercialConverter empresaComercialConverter;
    @Inject
    TbEjecutivosServicio ejecutivosServicio;
    @Inject
    TbEjecutivosFacade ejecutivosFacade;

    private TbEmpresas empresa;
    private TbEmpresaComercial empresaComercial;
    private List<TbContactosEmpresas> contactos;
    private TbEmpresaComercialComponente empresaComercialComponente;
    private TbEmpresaComponente empresaComponente;
    private TbContactosEmpresaComponente contactosEmpresaComponente;
    private List<TbContactosEmpresaComponente> contactosComponente;
    private TbEmpresaComercialComponenteVista empresaComercialComponenteVista;
    private Integer cargarFormularioEmpresaComercial;
    private Map<String, Integer> ejecutivos;
    private Integer ecEjecutivo;
    private String ecLineaNegocio;
    private String ecClasificacion;
    private String ecProvTecn;


    @PostConstruct
    public void init() {
        ejecutivos = ejecutivosServicio.getAllEjecutivosMap();
        empresa = new TbEmpresas();
        empresa = session.getEmpresaSesion();

        empresaComponente = TbEmpresaComponenteConverter.convertirEntidadAComponente(empresa);
        empresaComercial = new TbEmpresaComercial();
        empresaComercialComponenteVista = new TbEmpresaComercialComponenteVista();

        if (session.getEmpresaComercialSesion() == null) {
            empresaComercial = new TbEmpresaComercial();
            empresaComercialComponenteVista = empresaComercialConverter.convertirEntidadNulaAComponenteVista();
            session.setEmpresaComercialComponenteVista(empresaComercialComponenteVista);
            cargarFormularioEmpresaComercial = 1;
        } else {
            asignarInformacion();
        }

        contactos = contactosFacade.getAllTbContactosEmpresasByEmpresa(empresa);
        session.setContactosEmpresas(contactos);
        contactosComponente = contactosEmpresasConverter.convertirContactosEmpresasComponente(contactos);

    }

    public void asignarInformacion() {
        empresaComercial = empresaComercialFacade.buscarPorId(empresa.getEmIdEmpresas());
        empresaComercialComponente = new TbEmpresaComercialComponente();

        session.setEmpresaComercialSesion(empresaComercial);
        empresaComercialComponenteVista = empresaComercialConverter.convertirEntidadAComponenteVista(empresaComercial);
        empresaComercialComponente.setEc_prov_tecn(empresaComercial.getEcProvTecn());
        empresaComercialComponente.setEc_clasificacion(empresaComercial.getEcClasificacion());
        empresaComercialComponente.setEc_ejecutivo(empresaComercial.getEcEjecutivo().getEjCodigo());
        empresaComercialComponente.setEc_lineaNegocio(empresaComercial.getEcLineaNegocio());
        empresaComercialComponente.setEc_empresa(empresaComercial.getEcEmpresa());

    }

    /*Getters & Setters*/
    public List<TbContactosEmpresas> getContactos() {
        return contactos;
    }

    public void setContactos(List<TbContactosEmpresas> contactos) {
        this.contactos = contactos;
    }

    public TbEmpresaComercialComponente getEmpresaComercialComponente() {
        return empresaComercialComponente;
    }

    public void setEmpresaComercialComponente(TbEmpresaComercialComponente empresaComercialComponente) {
        this.empresaComercialComponente = empresaComercialComponente;
    }

    public TbEmpresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(TbEmpresas empresa) {
        this.empresa = empresa;
    }

    public String agregarNuevoCasoEmpresa() {
        return "irNuevoCasoEmpresa";
    }

    public TbEmpresaComponente getEmpresaComponente() {
        return empresaComponente;
    }

    public void setEmpresaComponente(TbEmpresaComponente empresaComponente) {
        this.empresaComponente = empresaComponente;
    }

    public String irDetalleContactoEmpresa(TbContactosEmpresaComponente contactoActualizar) {
        session.setContactoEmpresa(contactosEmpresasFacade.findById(contactoActualizar.getCe_secuencial()));
        return "irDetalleContacto";
    }

    public List<TbContactosEmpresaComponente> getContactosComponente() {
        return contactosComponente;
    }

    public void setContactosComponente(List<TbContactosEmpresaComponente> contactosComponente) {
        this.contactosComponente = contactosComponente;
    }

    public TbEmpresaComercialComponenteVista getEmpresaComercialComponenteVista() {
        return empresaComercialComponenteVista;
    }

    public void setEmpresaComercialComponenteVista(TbEmpresaComercialComponenteVista empresaComercialComponenteVista) {
        this.empresaComercialComponenteVista = empresaComercialComponenteVista;
    }

    public Integer getCargarFormularioEmpresaComercial() {
        return cargarFormularioEmpresaComercial;
    }

    public void setCargarFormularioEmpresaComercial(Integer cargarFormularioEmpresaComercial) {
        this.cargarFormularioEmpresaComercial = cargarFormularioEmpresaComercial;
    }

    public TbEmpresaComercial getEmpresaComercial() {
        return empresaComercial;
    }

    public void setEmpresaComercial(TbEmpresaComercial empresaComercial) {
        this.empresaComercial = empresaComercial;
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

    public String getEcLineaNegocio() {
        return ecLineaNegocio;
    }

    public void setEcLineaNegocio(String ecLineaNegocio) {
        this.ecLineaNegocio = ecLineaNegocio;
    }

    public String getEcClasificacion() {
        return ecClasificacion;
    }

    public void setEcClasificacion(String ecClasificacion) {
        this.ecClasificacion = ecClasificacion;
    }

    public String getEcProvTecn() {
        return ecProvTecn;
    }

    public void setEcProvTecn(String ecProvTecn) {
        this.ecProvTecn = ecProvTecn;
    }

    public String irActualizarEmpresa() {

        if (session.getEmpresaComercialSesion() == null) {
            session.setEmpresaComercialSesion(null);
        } else {
            session.setEmpresaComercialSesion(empresaComercial);
            session.setEmpresaSesion(empresa);
            session.setEmpresaComercialComponenteVista(empresaComercialComponenteVista);
            session.setEmpresaComponente(empresaComponente);
        }
        return "irActualizarEmpresa";
    }

    public void guardarEmpresaComercial() {

        TbEmpresaComercial aux = new TbEmpresaComercial();
        aux.setTbEmpresas(empresa);
        aux.setEcEjecutivo(ejecutivosFacade.buscarPorId(ecEjecutivo));
        aux.setEcLineaNegocio(ecLineaNegocio);
        aux.setEcProvTecn(ecProvTecn);
        aux.setEcClasificacion(ecClasificacion);
        aux.setEcEmpresa(empresa.getEmIdEmpresas());
        empresaComercial = aux;

        empresaComercialFacade.actualizar(aux);
        cargarFormularioEmpresaComercial = 2;
        session.setEmpresaComercialSesion(empresaComercial);
        empresaComercialComponenteVista = empresaComercialConverter.convertirEntidadAComponenteVista(aux);
        session.setEmpresaComercialComponenteVista(empresaComercialComponenteVista);
    }

}
