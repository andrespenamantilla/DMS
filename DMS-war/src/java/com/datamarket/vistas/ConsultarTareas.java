/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TareaEmpresaComponente;
import com.datamarket.components.TbCasoEmpresaComponenteVista;
import com.datamarket.components.TbTareasEmpresasItems;
import com.datamarket.converter.TbCasosEmpresasConverter;
import com.datamarket.converter.TbTareasEmpresasConverter;
import com.datamarket.entidades.TbTareasEmpresas;
import com.datamarket.facades.TbAdmUsuariosFacade;
import com.datamarket.facades.TbTareasEmpresasFacade;
import com.datamarket.servicios.TbEjecutivosServicio;
import com.datamarket.utils.ConverterTareasEmpresasToTareasItems;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class ConsultarTareas implements Serializable {

    @Inject
    TbEjecutivosServicio ejecutivosServicio;
    @Inject
    TbAdmUsuariosFacade usuariosFacade;
    @Inject
    TbTareasEmpresasFacade tareasEmpresasFacade;
    @Inject
    ConverterTareasEmpresasToTareasItems converter;
    @Inject
    TbTareasEmpresasConverter tareasEmpresasConverter;
    @Inject
    TbCasosEmpresasConverter casosEmpresasConverter;

    private Map<String, Integer> ejecutivos;
    private String teEvento;
    private String teEstado;
    private Integer teResponsable;
    private Date teFechaInicial;
    private Date teFechaFin;
    private String nombreEjecutivo;
    private List<TbTareasEmpresas> tareasFiltradas;
    private List<TbTareasEmpresasItems> tareasItems;
    private TbCasoEmpresaComponenteVista casoEmpresaComponente;
    private TareaEmpresaComponente tareaComponente;
    private TbTareasEmpresas tarea;

    @PostConstruct
    public void init() {

        teEstado = null;
        teEvento = null;
        teResponsable = null;
        teFechaInicial = null;
        teFechaFin = null;
        ejecutivos = ejecutivosServicio.getAllEjecutivosMap();
        tareasFiltradas = new ArrayList<>();
        tareasItems = new ArrayList<>();
        tarea = new TbTareasEmpresas();

    }

    public void busquedaDeTareasPorFiltros() {

        if (teFechaInicial == null && teFechaFin != null) {

            FacesContext.getCurrentInstance().addMessage("consultarTareaId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "SI REALIZA UNA CONSULTA CON FECHAS, LA FECHA INICIAL ES REQUERIDA"));
        }
        if (teFechaInicial != null && teFechaFin == null) {

            FacesContext.getCurrentInstance().addMessage("consultarTareaId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "SI REALIZA UNA CONSULTA CON FECHAS, LA FECHA FINAL ES REQUERIDA"));
        }
        if (teFechaInicial != null && teFechaFin != null) {
            Calendar c = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();

            c.setTime(teFechaInicial);
            c2.setTime(teFechaFin);
            int compareTo = c.compareTo(c2);

            if (compareTo == 1) {
                c = Calendar.getInstance();
                c2 = Calendar.getInstance();

                FacesContext.getCurrentInstance().addMessage("consultarTareaId:messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "LA FECHA DE INICIO ES MAYOR QUE LA FECHA FINAL"));

            } else if (compareTo == 0) {
                c = Calendar.getInstance();
                c2 = Calendar.getInstance();

                FacesContext.getCurrentInstance().addMessage("consultarTareaId:messageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "LAS FECHAS SON IDENTICAS SELECCIONE OTRAS FECHAS QUE NO SEAN IGUALES"));
            }

        }

    }

    public void test() {

        if (teResponsable == null) {
            nombreEjecutivo = "Búsqueda por todos los ejecutivos";
        } else {
            nombreEjecutivo = "EJECUTIVO: " + "" + usuariosFacade.findNombreById(teResponsable);
        }

        if (teEstado == null && teEvento == null && teFechaInicial == null && teResponsable == null && teFechaFin == null) {
            FacesContext.getCurrentInstance().addMessage("consultarTareaId:messageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "NO HA SELECCIONADO NINGUN CRITERIO"));

        } else {
            tareasFiltradas = tareasEmpresasFacade.buscarPorCriterios(teEstado, teEvento, teResponsable, teFechaInicial, teFechaFin);
            tareasItems = converter.convertirTbCasosEmpresasToCasosEmpresasItems(tareasFiltradas);

        }
    }

    public void tareaSeleccionada(TbTareasEmpresasItems tareaSeleccionada) {

        tarea = tareasEmpresasFacade.buscarPorId(tareaSeleccionada.getTe_sec_tarea());
        casoEmpresaComponente = casosEmpresasConverter.convertirEntidadAComponenteVista(tarea.getTeCaso());
        tareaComponente = tareasEmpresasConverter.entityToComponenteVisualizar(tarea);

    }

    public void limpiarCampos() {
        teEstado = null;
        teEvento = null;
        teResponsable = null;
        teFechaInicial = null;
        teFechaFin = null;
        tareasFiltradas = new ArrayList<>();
        tareasItems = new ArrayList<>();

    }

    /*Getters & Setters*/
    public Map<String, Integer> getEjecutivos() {
        return ejecutivos;
    }

    public void setEjecutivos(Map<String, Integer> ejecutivos) {
        this.ejecutivos = ejecutivos;
    }

    public String getTeEvento() {
        return teEvento;
    }

    public void setTeEvento(String teEvento) {
        this.teEvento = teEvento;
    }

    public String getTeEstado() {
        return teEstado;
    }

    public void setTeEstado(String teEstado) {
        this.teEstado = teEstado;
    }

    public Integer getTeResponsable() {
        return teResponsable;
    }

    public void setTeResponsable(Integer teResponsable) {
        this.teResponsable = teResponsable;
    }

    public Date getTeFechaInicial() {
        return teFechaInicial;
    }

    public void setTeFechaInicial(Date teFechaInicial) {
        this.teFechaInicial = teFechaInicial;
    }

    public Date getTeFechaFin() {
        return teFechaFin;
    }

    public void setTeFechaFin(Date teFechaFin) {
        this.teFechaFin = teFechaFin;
    }

    public String getNombreEjecutivo() {
        return nombreEjecutivo;
    }

    public void setNombreEjecutivo(String nombreEjecutivo) {
        this.nombreEjecutivo = nombreEjecutivo;
    }

    public List<TbTareasEmpresasItems> getTareasItems() {
        return tareasItems;
    }

    public void setTareasItems(List<TbTareasEmpresasItems> tareasItems) {
        this.tareasItems = tareasItems;
    }

    public TbCasoEmpresaComponenteVista getCasoEmpresaComponente() {
        return casoEmpresaComponente;
    }

    public void setCasoEmpresaComponente(TbCasoEmpresaComponenteVista casoEmpresaComponente) {
        this.casoEmpresaComponente = casoEmpresaComponente;
    }

    public TareaEmpresaComponente getTareaComponente() {
        return tareaComponente;
    }

    public void setTareaComponente(TareaEmpresaComponente tareaComponente) {
        this.tareaComponente = tareaComponente;
    }

    public List<TbTareasEmpresas> getTareasFiltradas() {
        return tareasFiltradas;
    }

    public void setTareasFiltradas(List<TbTareasEmpresas> tareasFiltradas) {
        this.tareasFiltradas = tareasFiltradas;
    }

    public TbTareasEmpresas getTarea() {
        return tarea;
    }

    public void setTarea(TbTareasEmpresas tarea) {
        this.tarea = tarea;
    }

    
    
}
