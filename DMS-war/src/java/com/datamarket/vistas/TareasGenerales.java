/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TareaEmpresaComponente;
import com.datamarket.components.TbCasoEmpresaComponenteVista;
import com.datamarket.converter.TbCasosEmpresasConverter;
import com.datamarket.converter.TbTareasEmpresasConverter;
import com.datamarket.entidades.TbEmpresas;
import com.datamarket.entidades.TbTareasEmpresas;
import com.datamarket.facades.TbCasosEmpresasFacade;
import com.datamarket.facades.TbContactosEmpresasFacade;
import com.datamarket.facades.TbDetalleCatalogoFacade;
import com.datamarket.facades.TbEmpresaComercialFacade;
import com.datamarket.facades.TbTareasEmpresasFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author andre
 */
@Named
@ViewScoped
public class TareasGenerales implements Serializable {

    @Inject
    TbTareasEmpresasFacade tareasEmpresasFacade;
    @Inject
    ObjetosSesion session;
    @Inject
    TbDetalleCatalogoFacade detalleCatalogoFacade;
    @Inject
    TbTareasEmpresasConverter tareasEmpresasConverter;
    @Inject
    TbCasosEmpresasFacade casosEmpresasFacade;
    @Inject
    TbCasosEmpresasConverter casosEmpresasConverter;
    @Inject
    TbContactosEmpresasFacade contactosEmpresasFacade;

    private List<TbTareasEmpresas> tareasPorEjecutivo;
    private ScheduleModel tareasPorEjecutivoModel;
    private TbTareasEmpresas tarea;
    private ScheduleEvent evento;
    private TareaEmpresaComponente tareaComponente;
    private Integer teResponsable;
    private TbCasoEmpresaComponenteVista casoEmpresaComponente;

    @PostConstruct
    public void init() {
        teResponsable = session.getUsuarioEnSesion().getUsCodUsuario();
        tarea = new TbTareasEmpresas();
        tareasPorEjecutivo = tareasEmpresasFacade.buscarTareasPorEjecutivoYEstadoPendiente(teResponsable);
        tareasPorEjecutivoModel = new DefaultScheduleModel();
        cargarCalendarioDeTareas();

    }

    public void cargarCalendarioDeTareas() {
       if(tareasPorEjecutivo != null)
       {
        for (TbTareasEmpresas iterator : tareasPorEjecutivo) {
            DefaultScheduleEvent tareaEvento = new DefaultScheduleEvent();

            tareaEvento.setData(iterator.getTeSecTarea());
            tareaEvento.setStartDate(iterator.getTeFechaInicial());
            tareaEvento.setEndDate(iterator.getTeFechaFin());
            tareaEvento.setDescription(iterator.getTeDescripcion());
            tareaEvento.setTitle(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(iterator.getTeEvento(), "CA_EVENTOS"));
            if (Integer.parseInt(iterator.getTeEstado()) == 1) {
                tareaEvento.setAllDay(false);
            } else {
                tareaEvento.setAllDay(true);
            }
            tareaEvento.setEditable(false);

            if (iterator.getTeEstado().equals("1")) {
                tareaEvento.setStyleClass("state1");

            } else if (iterator.getTeEstado().equals("2")) {

                tareaEvento.setStyleClass("state2");
            }

            tareasPorEjecutivoModel.addEvent(tareaEvento);
        }

       
       }
    }

    /*Desde un click sobre una tarea ya existente se carga la informacion a un cuadro de dialogo*/
    public void tareaSeleccionada(SelectEvent selectEvent) {
        evento = (ScheduleEvent) selectEvent.getObject();

        for (TbTareasEmpresas iterator : tareasPorEjecutivo) {
            if (iterator.getTeSecTarea() == (Integer) evento.getData()) {
                tarea = iterator;
                casoEmpresaComponente = casosEmpresasConverter.convertirEntidadAComponenteVista(tarea.getTeCaso());

            }
        }

        tareaComponente = tareasEmpresasConverter.entityToComponenteVisualizar(tarea);
    }

    public String irListaCasos() {
      
        session.setEmpresaComercialSesion(tarea.getTeCaso().getCeEmpresa());
        session.setEmpresaSesion(tarea.getTeCaso().getCeEmpresa().getTbEmpresas());
        session.setContactosEmpresas(contactosEmpresasFacade.getAllTbContactosEmpresasByEmpresa(tarea.getTeCaso().getCeEmpresa().getTbEmpresas()));
        return "irNuevoCasoEmpresa";
    }

    public String irListaTareas() {
        session.setCasoEmpresaSesion(tarea.getTeCaso());
        return "irNuevaTareaEmpresa";

    }

    /*Getters & Setters*/
    public List<TbTareasEmpresas> getTareasPorEjecutivo() {
        return tareasPorEjecutivo;
    }

    public void setTareasPorEjecutivo(List<TbTareasEmpresas> tareasPorEjecutivo) {
        this.tareasPorEjecutivo = tareasPorEjecutivo;
    }

    public ScheduleModel getTareasPorEjecutivoModel() {
        return tareasPorEjecutivoModel;
    }

    public void setTareasPorEjecutivoModel(ScheduleModel tareasPorEjecutivoModel) {
        this.tareasPorEjecutivoModel = tareasPorEjecutivoModel;
    }

    public TbTareasEmpresas getTarea() {
        return tarea;
    }

    public void setTarea(TbTareasEmpresas tarea) {
        this.tarea = tarea;
    }

    public ScheduleEvent getEvento() {
        return evento;
    }

    public void setEvento(ScheduleEvent evento) {
        this.evento = evento;
    }

    public TareaEmpresaComponente getTareaComponente() {
        return tareaComponente;
    }

    public void setTareaComponente(TareaEmpresaComponente tareaComponente) {
        this.tareaComponente = tareaComponente;
    }

    public TbCasoEmpresaComponenteVista getCasoEmpresaComponente() {
        return casoEmpresaComponente;
    }

    public void setCasoEmpresaComponente(TbCasoEmpresaComponenteVista casoEmpresaComponente) {
        this.casoEmpresaComponente = casoEmpresaComponente;
    }

    
    
}
