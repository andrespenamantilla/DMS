/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TareaEmpresaComponente;
import com.datamarket.components.TbTareasEmpresasItems;
import com.datamarket.converter.TbTareasEmpresasConverter;
import com.datamarket.entidades.TbCasosEmpresas;
import com.datamarket.entidades.TbHistorialCasos;
import com.datamarket.entidades.TbTareasEmpresas;
import com.datamarket.facades.TbCasosEmpresasFacade;
import com.datamarket.facades.TbHistorialCasosFacade;
import com.datamarket.facades.TbTareasEmpresasFacade;
import com.datamarket.servicios.TbDetalleCatalogoServicio;
import com.datamarket.utils.ConverterTareasEmpresasToTareasItems;
import java.io.Serializable;
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
public class NuevaTareaVista implements Serializable {
    
    @Inject
    ObjetosSesion sesion;
    @Inject
    TbCasosEmpresasFacade casosEmpresasFacade;
    @Inject
    TbTareasEmpresasFacade tareasEmpresasFacade;
    @Inject
    TbTareasEmpresasConverter converterTarea;
    @Inject
    ConverterTareasEmpresasToTareasItems converter;
    @Inject
    TbHistorialCasosFacade historialFacade;
    @Inject
    TbDetalleCatalogoServicio catalogoServicio;
    
    private TareaEmpresaComponente tareaComponente;
    private TbCasosEmpresas casoEmpresa;
    private List<TbTareasEmpresas> casosPorEmpresa;
    private List<TbTareasEmpresasItems> tareasItems;
    private Map<String, String> eventosMap;
    private Map<String, String> estadoMap;
    private TbTareasEmpresasItems selectedItem;
    
    @PostConstruct
    public void init() {
        casoEmpresa = sesion.getCasoEmpresaSesion();
        tareaComponente = new TareaEmpresaComponente();
        casosPorEmpresa = tareasEmpresasFacade.buscarTareasPorCaso(casoEmpresa);
        tareaComponente.setTe_caso(casoEmpresa.getCeSecCaso());
        tareasItems = converter.convertirTbCasosEmpresasToCasosEmpresasItems(casosPorEmpresa);
        eventosMap = catalogoServicio.getAllEventos();
        estadoMap = catalogoServicio.getAllEstadoTarea();
        
    }
    
    public void insertarNuevaTarea() {
        TbTareasEmpresasItems aux;
        TbTareasEmpresas nuevaTareaEmpresa = new TbTareasEmpresas();
        TbHistorialCasos historial = new TbHistorialCasos();
        /**/
        
        Date date = new Date();
        
        nuevaTareaEmpresa = converterTarea.tareaComponenteToEntity(tareaComponente);
        nuevaTareaEmpresa.setTeResponsable(casoEmpresa.getCeEmpresa().getEcEjecutivo().getEjCodigo());
        date = nuevaTareaEmpresa.getTeFechaInicial();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        nuevaTareaEmpresa.setTeFechaFin(date);
        
        tareasEmpresasFacade.persistirTareasEmpresas(nuevaTareaEmpresa);
        
        Integer etapa = nuevaTareaEmpresa.getTeCaso().getCeEtapa();
        
        historial.setHcSecCaso(nuevaTareaEmpresa.getTeCaso().getCeSecCaso());
        historial.setHcCodEtapa(etapa.toString());
        historial.setHcCodTarea(nuevaTareaEmpresa.getTeSecTarea());
        historial.setHcCodEmpresa(casoEmpresa.getCeEmpresa().getEcEmpresa());
        historial.setHcEvento(nuevaTareaEmpresa.getTeEvento());
        historial.setHcEstadoTarea(nuevaTareaEmpresa.getTeEstado());
        historial.setHcAnotacion(nuevaTareaEmpresa.getTeDescripcion());
        historial.setHcFecha(nuevaTareaEmpresa.getTeFechaInicial());
        historial.setHcUsuario(nuevaTareaEmpresa.getTeCaso().getCeEmpresa().getEcEjecutivo().getEjCodigo());
        aux = converter.convertirTbCasosEmpresasToObjectEmpresasItem(nuevaTareaEmpresa);
        historialFacade.persistirHistorial(historial);
        tareaComponente.setTe_descripcion("");
        tareaComponente = new TareaEmpresaComponente();
        casosPorEmpresa.add(nuevaTareaEmpresa);
        tareasItems.add(aux);
        FacesContext.getCurrentInstance().addMessage("nuevaTareaId:messageId2", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se agrego una tarea con éxito"));
        
    }
    
    public void eliminarTarea() {
        TbTareasEmpresas tareaEliminar;
        Integer tareaSec = selectedItem.getTe_sec_tarea();
        tareaEliminar = tareasEmpresasFacade.buscarPorId(selectedItem.getTe_sec_tarea());
        tareasEmpresasFacade.eliminarTareaEmpresas(tareaEliminar);
        casosPorEmpresa.remove(tareaEliminar);
        tareasItems.remove(selectedItem);
        FacesContext.getCurrentInstance().addMessage("listaTareasEmpresaId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se eliminó la tarea correctamente."));
        
    }
    
    public String irDetalleTarea(TbTareasEmpresasItems tareaActualizarComp) {
        TbTareasEmpresas tareaActualizar;
        tareaActualizar = tareasEmpresasFacade.buscarPorId(tareaActualizarComp.getTe_sec_tarea());
        sesion.setTareaEmpresaSesion(tareaActualizar);
        return "irDetalleTarea";
        
    }

    /*Getters & Setters*/
    public TbTareasEmpresasItems getSelectedItem() {
        return selectedItem;
    }
    
    public void setSelectedItem(TbTareasEmpresasItems selectedItem) {
        this.selectedItem = selectedItem;
    }
    
    public TareaEmpresaComponente getTareaComponente() {
        return tareaComponente;
    }
    
    public void setTareaComponente(TareaEmpresaComponente tareaComponente) {
        this.tareaComponente = tareaComponente;
    }
    
    public List<TbTareasEmpresas> getCasosPorEmpresa() {
        return casosPorEmpresa;
    }
    
    public void setCasosPorEmpresa(List<TbTareasEmpresas> casosPorEmpresa) {
        this.casosPorEmpresa = casosPorEmpresa;
    }
    
    public List<TbTareasEmpresasItems> getTareasItems() {
        return tareasItems;
    }
    
    public void setTareasItems(List<TbTareasEmpresasItems> tareasItems) {
        this.tareasItems = tareasItems;
    }
    
    public Map<String, String> getEventosMap() {
        return eventosMap;
    }
    
    public void setEventosMap(Map<String, String> eventosMap) {
        this.eventosMap = eventosMap;
    }
    
    public Map<String, String> getEstadoMap() {
        return estadoMap;
    }
    
    public void setEstadoMap(Map<String, String> estadoMap) {
        this.estadoMap = estadoMap;
    }
    
    public TbCasosEmpresas getCasoEmpresa() {
        return casoEmpresa;
    }
    
    public void setCasoEmpresa(TbCasosEmpresas casoEmpresa) {
        this.casoEmpresa = casoEmpresa;
    }
    
}
