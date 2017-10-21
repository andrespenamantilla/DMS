/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TareaEmpresaComponente;
import com.datamarket.converter.TbTareasEmpresasConverter;
import com.datamarket.entidades.TbEmpresas;
import com.datamarket.entidades.TbTareasEmpresas;
import com.datamarket.facades.TbTareasEmpresasFacade;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
@Named
@ViewScoped
public class ActualizarTarea implements Serializable {

    @Inject
    ObjetosSesion session;
    @Inject
    TbTareasEmpresasConverter tareasEmpresasConverter;
    @Inject
    TbTareasEmpresasFacade tareasEmpresasFacade;
    private TbTareasEmpresas tareaActualizar;
    private TareaEmpresaComponente tareaActualizarComponente;
    private TbEmpresas empresa;

    @PostConstruct
    public void init() {
        empresa = session.getEmpresaSesion();
        tareaActualizar = session.getTareaEmpresaSesion();
        tareaActualizarComponente = tareasEmpresasConverter.entityToComponente(tareaActualizar);
    }

    public void compararFechas() {

    }

    public void actualizarTareaF() {

        Date date = new Date();
        Date date2 = new Date();

        tareaActualizar.setTeFechaFin(tareaActualizarComponente.getTe_fecha_fin());
        tareaActualizar.setTeFechaInicial(tareaActualizarComponente.getTe_fecha_inicial());
        date = tareaActualizar.getTeFechaInicial();
        date2 = tareaActualizar.getTeFechaFin();
        Calendar c = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c.setTime(date);
        c2.setTime(date2);
        int compareTo = c.compareTo(c2);

        if (compareTo == 1) 
        {
            FacesContext.getCurrentInstance().addMessage("actualizarTareaId:messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "La fecha de inicio es mayor a la final"));

        } else if (compareTo == 0) {
            FacesContext.getCurrentInstance().addMessage("actualizarTareaId:messageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Las fechas son identicas, seleccione otra"));

        } else {
            tareaActualizar.setTeDescripcion(tareaActualizarComponente.getTe_descripcion());
            tareaActualizar.setTeEvento(tareaActualizarComponente.getTe_evento());
            tareaActualizar.setTeFechaFin(tareaActualizarComponente.getTe_fecha_fin());
            tareaActualizar.setTeFechaInicial(tareaActualizarComponente.getTe_fecha_inicial());
            tareaActualizar.setTeResponsable(tareaActualizarComponente.getTe_responsable());
            tareaActualizar.setTeEstado(tareaActualizarComponente.getTe_estado());
            tareasEmpresasFacade.actualizar(tareaActualizar);

            FacesContext.getCurrentInstance().addMessage("actualizarTareaId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se actualizó la tarea con éxito"));
        }
    }

    /*Getters & Setters*/
    public TbTareasEmpresas getTareaActualizar() {
        return tareaActualizar;
    }

    public void setTareaActualizar(TbTareasEmpresas tareaActualizar) {
        this.tareaActualizar = tareaActualizar;
    }

    public TareaEmpresaComponente getTareaActualizarComponente() {
        return tareaActualizarComponente;
    }

    public void setTareaActualizarComponente(TareaEmpresaComponente tareaActualizarComponente) {
        this.tareaActualizarComponente = tareaActualizarComponente;
    }

    public TbEmpresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(TbEmpresas empresa) {
        this.empresa = empresa;
    }
}
