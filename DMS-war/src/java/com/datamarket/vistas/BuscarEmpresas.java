/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TbEmpresaComponente;
import com.datamarket.converter.TbEmpresaComponenteConverter;
import com.datamarket.entidades.TbDepartamentosPK;
import com.datamarket.entidades.TbEmpresaComercial;
import com.datamarket.entidades.TbEmpresas;
import com.datamarket.facades.TbCiudadesFacade;
import com.datamarket.facades.TbDepartamentosFacade;
import com.datamarket.facades.TbEmpresaComercialFacade;
import com.datamarket.facades.TbEmpresasFacade;
import com.datamarket.facades.TbPaisesFacade;
import com.datamarket.servicios.TbPaisesServicio;
import com.datamarket.servicios.TbSectorEconomicoServicio;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Andrés
 */
@Named
@ViewScoped
public class BuscarEmpresas implements Serializable {

    @Inject
    TbEmpresasFacade empresasFacade;
    @Inject
    ObjetosSesion session;
    @Inject
    TbEmpresaComercialFacade empresasComercialFacade;
    @Inject
    TbPaisesServicio paisesServicio;
    @Inject
    TbPaisesFacade paisFacade;
    @Inject
    TbDepartamentosFacade departamentosFacade;
    @Inject
    TbCiudadesFacade ciudadesFacade;
    @Inject
    TbSectorEconomicoServicio sectorEconomicoServicio;
    @Inject
    TbEmpresaComponenteConverter TbEmpresaComponenteConverter;

    private Map<String, String> paisesMap;
    private Map<String, String> departamentosMap;
    private Map<String, String> ciudadesMap;

    private String paisId;
    private String departamentoId;
    private String ciudadId;
    private String emNombre;
    private String emNit;
    private String emTelefono1;
    private String emTelefono2;
    private Integer emSector;

    private List<String> empresasHalladas;
    private List<String> empresasHalladasNit;
    private TbEmpresas empresaHallada;
    private TbEmpresaComercial empresaComercialHallada;
    private Map<String, Integer> sectores;
    private List<TbEmpresas> empresasHalladasPorFiltros;
    private List<TbEmpresaComponente> empresasHalladasComponentes;
    private TbEmpresaComponente empresaComponenteEliminar;
    private String nombreReporte;
    private String hora;

    @PostConstruct
    public void init() {
        sectores = sectorEconomicoServicio.getAllSectores();
        paisesMap = paisesServicio.getAllPaisesMap();

    }

    public List buscarEmpresasPorNombre(String query) {
        return empresasHalladas = empresasFacade.buscarEmpresaPorNombre(emNombre);

    }

    public List buscarEmpresasPorNit(String query) {
        return empresasHalladas = empresasFacade.buscarEmpresaPorNit(emNit);

    }

    public void vaciarCampos() {
        this.emNombre = null;
        this.ciudadId = null;
        this.departamentoId = null;
        this.paisId = null;
        this.emNit = null;
        this.emSector = null;
        this.emTelefono1 = null;
        this.emTelefono2 = null;
        this.empresasHalladasComponentes = null;
        this.empresasHalladasPorFiltros = null;
    }

    public String buscarInformacionPorNombre() {
        empresaHallada = new TbEmpresas();
        empresaHallada = empresasFacade.buscarPorNombre(emNombre);
        session.setEmpresaSesion(empresaHallada);
        buscarDatosEmpresaComercial();
        return "irDetalleEmpresa";
    }

    public String buscarInformacionPorNit() {
        empresaHallada = new TbEmpresas();
        empresaHallada = empresasFacade.buscarPorNit(emNit);
        session.setEmpresaSesion(empresaHallada);
        buscarDatosEmpresaComercial();
        return "irDetalleEmpresa";
    }

    public String buscarInformacionGeneralPorNombre() {
        empresaHallada = new TbEmpresas();
        empresaHallada = empresasFacade.buscarPorNombre(emNombre);
        session.setEmpresaSesion(empresaHallada);
        buscarDatosEmpresaComercial();
        return "irDetalleEmpresaGeneral";
    }

    public String buscarInformacionGeneralPorNit() {
        empresaHallada = new TbEmpresas();
        empresaHallada = empresasFacade.buscarPorNit(emNit);
        session.setEmpresaSesion(empresaHallada);
        buscarDatosEmpresaComercial();
        return "irDetalleEmpresaGeneral";
    }

    public void buscarDatosEmpresaComercial() {
        empresaComercialHallada = new TbEmpresaComercial();
        empresaComercialHallada = empresasComercialFacade.findByid(empresaHallada.getEmIdEmpresas());

        if (empresaComercialHallada != null) {
            session.setEmpresaComercialSesion(empresaComercialHallada);

        } else {
            session.setEmpresaComercialSesion(null);

        }

    }

    public void buscarDepartamentosPorPais() {

        departamentosMap = new HashMap<>();
        ciudadesMap = new HashMap<>();
        departamentoId = null;
        ciudadId = null;
        departamentosMap = paisesServicio.getAllDepartamentosMap(paisFacade.buscarPaisPorId(paisId));
        ciudadesMap = new HashMap<>();
    }

    public void buscarCiudadesPorDepartamento() {
        ciudadId = null;
        TbDepartamentosPK pk = new TbDepartamentosPK();
        pk.setDeCodigo(departamentoId);
        pk.setDePais(paisId);
        ciudadesMap = paisesServicio.getAllCiudadesMap(departamentosFacade.findById(pk));
    }

    public void buscarEmpresasPorFiltros() {
        if (emNombre == null && ciudadId == null && departamentoId == null && paisId == null && emNit == null && emSector == null && emTelefono1 == null && emTelefono2 == null) {
            FacesContext.getCurrentInstance().addMessage("buscarEmpresaId:messageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "USTED NO INGRESÓ NINGUN PARAMETRO DE BÚSQUEDA"));

        } else {
            formatearFecha();
            empresasHalladasPorFiltros = empresasFacade.buscarEmpresasPorParametrosDeBusqueda(emNombre, emNit, emSector, paisId, departamentoId, ciudadId, emTelefono1, emTelefono2);
            nombreReporte = "Busqueda de Empresas generado " + hora;
            empresasHalladasComponentes = new ArrayList<>();
            for (int i = 0; i < empresasHalladasPorFiltros.size(); i++) {
                TbEmpresaComponente aux = new TbEmpresaComponente();
                aux = TbEmpresaComponenteConverter.convertirEntidadAComponente(empresasHalladasPorFiltros.get(i));
                empresasHalladasComponentes.add(aux);

            }
            //FacesContext.getCurrentInstance().addMessage("buscarEmpresaId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Información: Su búsqueda obtuvo " + empresasHalladasPorFiltros.size() + " Resultados"));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));

        }
    }

    public String irDetalleEmpresaGeneral(TbEmpresaComponente row) {
        empresaHallada = empresasFacade.findById(row.getEm_id_empresas());
        session.setEmpresaSesion(empresaHallada);
        buscarDatosEmpresaComercial();
        return "irDetalleEmpresaGeneral";

    }

    public String irDetalleEmpresa(TbEmpresaComponente row) {
        empresaHallada = empresasFacade.findById(row.getEm_id_empresas());
        session.setEmpresaSesion(empresaHallada);
        buscarDatosEmpresaComercial();
        return "irDetalleEmpresa";

    }

    public void asignarEmpresaEliminar(TbEmpresaComponente row) {
        empresaHallada = empresasFacade.findById(row.getEm_id_empresas());
        empresaComponenteEliminar = row;

    }

    public void eliminarEmpresa() {

        if (empresasComercialFacade.findById(empresaHallada.getEmIdEmpresas()) == null) {
            empresasFacade.eliminarEmpresas(empresaHallada);
            empresasHalladasComponentes.remove(empresaComponenteEliminar);
            FacesContext.getCurrentInstance().addMessage("buscarEmpresaId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "LA EMPRESA FUE ELIMINADA SATISFACTORIAMENTE."));

        } else {
            FacesContext.getCurrentInstance().addMessage("buscarEmpresaId:messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "LA EMPRESA NO PUEDE SER ELIMINADA, YA QUE TIENE INFORMACIÓN DE CARACTER COMERCIAL ASIGNADA."));

        }

    }

    public void formatearFecha() {
        Date fechaActual = new Date();
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        hora = "a las: " + formatoHora.format(fechaActual) + " del dia: " + formatoFecha.format(fechaActual);
    }

    /*Getters & Setters*/
    public String getEmNombre() {
        return emNombre;
    }

    public void setEmNombre(String emNombre) {
        this.emNombre = emNombre;
    }

    public List<String> getEmpresasHalladas() {
        return empresasHalladas;
    }

    public void setEmpresasHalladas(List<String> empresasHalladas) {
        this.empresasHalladas = empresasHalladas;
    }

    public void onItemSelect(SelectEvent event) {
        emNombre = event.getObject().toString();
    }

    public String getEmNit() {
        return emNit;
    }

    public void setEmNit(String emNit) {
        this.emNit = emNit;
    }

    public List<String> getEmpresasHalladasNit() {
        return empresasHalladasNit;
    }

    public void setEmpresasHalladasNit(List<String> empresasHalladasNit) {
        this.empresasHalladasNit = empresasHalladasNit;
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

    public String getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(String ciudadId) {
        this.ciudadId = ciudadId;
    }

    public TbEmpresas getEmpresaHallada() {
        return empresaHallada;
    }

    public void setEmpresaHallada(TbEmpresas empresaHallada) {
        this.empresaHallada = empresaHallada;
    }

    public TbEmpresaComercial getEmpresaComercialHallada() {
        return empresaComercialHallada;
    }

    public void setEmpresaComercialHallada(TbEmpresaComercial empresaComercialHallada) {
        this.empresaComercialHallada = empresaComercialHallada;
    }

    public Map<String, Integer> getSectores() {
        return sectores;
    }

    public void setSectores(Map<String, Integer> sectores) {
        this.sectores = sectores;
    }

    public String getEmTelefono1() {
        return emTelefono1;
    }

    public void setEmTelefono1(String emTelefono1) {
        this.emTelefono1 = emTelefono1;
    }

    public String getEmTelefono2() {
        return emTelefono2;
    }

    public void setEmTelefono2(String emTelefono2) {
        this.emTelefono2 = emTelefono2;
    }

    public Integer getEmSector() {
        return emSector;
    }

    public void setEmSector(Integer emSector) {
        this.emSector = emSector;
    }

    public List<TbEmpresas> getEmpresasHalladasPorFiltros() {
        return empresasHalladasPorFiltros;
    }

    public void setEmpresasHalladasPorFiltros(List<TbEmpresas> empresasHalladasPorFiltros) {
        this.empresasHalladasPorFiltros = empresasHalladasPorFiltros;
    }

    public List<TbEmpresaComponente> getEmpresasHalladasComponentes() {
        return empresasHalladasComponentes;
    }

    public void setEmpresasHalladasComponentes(List<TbEmpresaComponente> empresasHalladasComponentes) {
        this.empresasHalladasComponentes = empresasHalladasComponentes;
    }

    public String getNombreReporte() {
        return nombreReporte;
    }

    public void setNombreReporte(String nombreReporte) {
        this.nombreReporte = nombreReporte;
    }

}
