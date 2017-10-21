/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TbEmpresaComercialComponenteVista;
import com.datamarket.components.TbEmpresaComponente;
import com.datamarket.entidades.TbDepartamentosPK;
import com.datamarket.entidades.TbEmpresaComercial;
import com.datamarket.entidades.TbEmpresas;
import com.datamarket.entidades.TbTareasEmpresas;
import com.datamarket.facades.TbDepartamentosFacade;
import com.datamarket.facades.TbEjecutivosFacade;
import com.datamarket.facades.TbEmpresaComercialFacade;
import com.datamarket.facades.TbEmpresasFacade;
import com.datamarket.facades.TbPaisesFacade;
import com.datamarket.facades.TbTareasEmpresasFacade;
import com.datamarket.servicios.TbDetalleCatalogoServicio;
import com.datamarket.servicios.TbEjecutivosServicio;
import com.datamarket.servicios.TbPaisesServicio;
import com.datamarket.servicios.TbSectorEconomicoServicio;
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
 * @author Andrés
 */
@Named
@ViewScoped
public class ActualizarEmpresaYEmpresaComercial implements Serializable {

    @Inject
    ObjetosSesion session;
    @Inject
    TbDetalleCatalogoServicio detalleCatalogoServicio;
    @Inject
    TbPaisesServicio paisesServicio;
    @Inject
    TbPaisesFacade paisFacade;
    @Inject
    TbDepartamentosFacade departamentosFacade;
    @Inject
    TbEmpresasFacade empresasFacade;
    @Inject
    TbEmpresaComercialFacade empresaComercialFacade;
    @Inject
    TbSectorEconomicoServicio sectorEcnonomicoServicio;
    @Inject
    TbEjecutivosFacade ejecutivosFacade;
    @Inject
    TbEjecutivosServicio ejecutivosServicio;
    @Inject
    TbTareasEmpresasFacade tareasEmpresasFacade;

    private TbEmpresaComercial empresaComercial;
    private TbEmpresas empresa;
    private TbEmpresaComercialComponenteVista empresaComercialComponenteVista;
    private TbEmpresaComponente empresaComponente;
    private Map<String, Integer> sector;
    private Map<String, String> proveedorTecnología;
    private Map<String, String> lineaNegocio;
    private Map<String, String> clasificacion;
    private Map<String, String> paisesMap;
    private Map<String, String> departamentosMap;
    private Map<String, String> ciudadesMap;
    private String paisId;
    private String departamentoId;
    private Integer estadoEmpresaComercial;
    protected Map<String, Integer> ejecutivos;
    private List<TbTareasEmpresas> tareasDeEjecutivo;
    private Integer ejecutivoAcualizacion;

    @PostConstruct
    public void init() {

        empresa = new TbEmpresas();
        empresa = session.getEmpresaSesion();
        empresaComercial = session.getEmpresaComercialSesion();
        if (empresaComercial != null) {
            ejecutivoAcualizacion = empresaComercial.getEcEjecutivo().getEjCodigo();

        } 

        if (empresaComercial == null) {
            empresaComercial = new TbEmpresaComercial();
            empresaComercial.setEcEjecutivo(null);
            empresaComercial.setEcEmpresa(null);
            empresaComercial.setEcProvTecn(null);
            empresaComercial.setEcLineaNegocio(null);
            empresaComercial.setTbEmpresas(null);
            estadoEmpresaComercial = 2;
        } else {
            estadoEmpresaComercial = 1;

        }

        empresaComercialComponenteVista = session.getEmpresaComercialComponenteVista();
        empresaComponente = session.getEmpresaComponente();
        cargarDetalleLocalizacionEmpresa();
        cargarCatalogos();
    }

    public void cargarCatalogos() {
        sector = new HashMap<>();
        proveedorTecnología = new HashMap<>();
        lineaNegocio = new HashMap<>();
        clasificacion = new HashMap<>();
        /**/
        sector = sectorEcnonomicoServicio.getAllSectores();
        proveedorTecnología = detalleCatalogoServicio.getAllProveedorTecnologia();
        lineaNegocio = detalleCatalogoServicio.getAllLineaNegocio();
        clasificacion = detalleCatalogoServicio.getAllClasificacionClientes();
        ejecutivos = ejecutivosServicio.getAllEjecutivosMap();
    }

    public void cargarDetalleLocalizacionEmpresa() {

        TbDepartamentosPK pk = new TbDepartamentosPK();
        pk.setDeCodigo(empresa.getEmDepto());
        pk.setDePais(empresa.getEmPais());
        paisesMap = paisesServicio.getAllPaisesMap();
        departamentosMap = paisesServicio.getAllDepartamentosMap(paisFacade.buscarPaisPorId(empresa.getEmPais()));
        ciudadesMap = paisesServicio.getAllCiudadesMap(departamentosFacade.findById(pk));

    }

    public void buscarDepartamentosPorPais() {

        paisId = empresa.getEmPais();
        departamentosMap = paisesServicio.getAllDepartamentosMap(paisFacade.buscarPaisPorId(paisId));
        ciudadesMap = new HashMap<>();
        departamentoId = "";
        empresa.setEmDepto(departamentoId);
        empresa.setEmCiudad("");
    }

    public void buscarCiudadesPorDepartamento() {

        departamentoId = empresa.getEmDepto();
        TbDepartamentosPK pk = new TbDepartamentosPK();
        pk.setDeCodigo(departamentoId);
        pk.setDePais(paisId);
        ciudadesMap = paisesServicio.getAllCiudadesMap(departamentosFacade.findById(pk));
    }

    public void actualizarEmpresaComercial() {

        try {

            tareasDeEjecutivo = tareasEmpresasFacade.buscarTareasPorEmpresaEjecutivo(empresaComercial.getEcEjecutivo().getEjCodigo(), empresaComercial.getEcEmpresa());
            if (tareasDeEjecutivo == null) {
                empresaComercial.setEcEjecutivo(ejecutivosFacade.buscarPorId(ejecutivoAcualizacion));
                empresaComercialFacade.actualizar(empresaComercial);
                FacesContext.getCurrentInstance().addMessage("actualizarEmpresaComercial:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "LOS DATOS COMERCIALES DE LA EMPRESA  SE  HAN ACTUALIZADO CORRECTAMENTE"));
            } else if (tareasDeEjecutivo != null) {
                TbTareasEmpresas aux;

                for (int i = 0; i < tareasDeEjecutivo.size(); i++) {
                    aux = new TbTareasEmpresas();
                    aux = tareasDeEjecutivo.get(i);
                    aux.setTeResponsable(ejecutivoAcualizacion);
                    tareasEmpresasFacade.actualizar(aux);
                }
                empresaComercial.setEcEjecutivo(ejecutivosFacade.buscarPorId(ejecutivoAcualizacion));
                empresaComercialFacade.actualizar(empresaComercial);
                FacesContext.getCurrentInstance().addMessage("actualizarEmpresaComercial:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "LOS DATOS COMERCIALES DE LA EMPRESA  SE  HAN ACTUALIZADO CORRECTAMENTE"));

            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("actualizarEmpresaComercial:messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "LOS DATOS COMERCIALES DE LA EMPRESA NO SE  HAN ACTUALIZADO CORRECTAMENTE"));
        }

    }

    public void actualizarEmpresa() {
        try {

            empresasFacade.actualizar(empresa);
            FacesContext.getCurrentInstance().addMessage("actualizarEmpresaId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "LOS DATOS GENERALES DE LA EMPRESA  SE  HAN ACTUALIZADO CORRECTAMENTE"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("actualizarEmpresaId:messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "LOS DATOS GENERALES DE LA EMPRESA NO SE  HAN ACTUALIZADO CORRECTAMENTE"));
        }

    }

    /*Getters & Setters*/
    public TbEmpresaComercial getEmpresaComercial() {
        return empresaComercial;
    }

    public void setEmpresaComercial(TbEmpresaComercial empresaComercial) {
        this.empresaComercial = empresaComercial;
    }

    public TbEmpresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(TbEmpresas empresa) {
        this.empresa = empresa;
    }

    public Map<String, Integer> getSector() {
        return sector;
    }

    public void setSector(Map<String, Integer> sector) {
        this.sector = sector;
    }

    public Map<String, String> getProveedorTecnología() {
        return proveedorTecnología;
    }

    public void setProveedorTecnología(Map<String, String> proveedorTecnología) {
        this.proveedorTecnología = proveedorTecnología;
    }

    public Map<String, String> getLineaNegocio() {
        return lineaNegocio;
    }

    public void setLineaNegocio(Map<String, String> lineaNegocio) {
        this.lineaNegocio = lineaNegocio;
    }

    public Map<String, String> getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Map<String, String> clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Map<String, String> getPaisesMap() {
        return paisesMap;
    }

    public void setPaisesMap(Map<String, String> paisesMap) {
        this.paisesMap = paisesMap;
    }

    public Map<String, String> getDepartamentosMap() {
        return departamentosMap;
    }

    public void setDepartamentosMap(Map<String, String> departamentosMap) {
        this.departamentosMap = departamentosMap;
    }

    public Map<String, String> getCiudadesMap() {
        return ciudadesMap;
    }

    public void setCiudadesMap(Map<String, String> ciudadesMap) {
        this.ciudadesMap = ciudadesMap;
    }

    public String getPaisId() {
        return paisId;
    }

    public void setPaisId(String paisId) {
        this.paisId = paisId;
    }

    public String getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(String departamentoId) {
        this.departamentoId = departamentoId;
    }

    public TbEmpresaComercialComponenteVista getEmpresaComercialComponenteVista() {
        return empresaComercialComponenteVista;
    }

    public void setEmpresaComercialComponenteVista(TbEmpresaComercialComponenteVista empresaComercialComponenteVista) {
        this.empresaComercialComponenteVista = empresaComercialComponenteVista;
    }

    public TbEmpresaComponente getEmpresaComponente() {
        return empresaComponente;
    }

    public void setEmpresaComponente(TbEmpresaComponente empresaComponente) {
        this.empresaComponente = empresaComponente;
    }

    public Integer getEstadoEmpresaComercial() {
        return estadoEmpresaComercial;
    }

    public void setEstadoEmpresaComercial(Integer estadoEmpresaComercial) {
        this.estadoEmpresaComercial = estadoEmpresaComercial;
    }

    public Map<String, Integer> getEjecutivos() {
        return ejecutivos;
    }

    public void setEjecutivos(Map<String, Integer> ejecutivos) {
        this.ejecutivos = ejecutivos;
    }

    public Integer getEjecutivoAcualizacion() {
        return ejecutivoAcualizacion;
    }

    public void setEjecutivoAcualizacion(Integer ejecutivoAcualizacion) {
        this.ejecutivoAcualizacion = ejecutivoAcualizacion;
    }

}
