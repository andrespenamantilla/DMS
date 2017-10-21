/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import com.datamarket.components.TareaEmpresaComponente;
import com.datamarket.entidades.TbTareasEmpresas;
import com.datamarket.facades.TbCasosEmpresasFacade;
import com.datamarket.facades.TbDetalleCatalogoFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbTareasEmpresasConverter {

    @Inject
    TbCasosEmpresasFacade casosEmpresasFacade;
    @Inject
    TbDetalleCatalogoFacade detalleCatalogoFacade;

    public TbTareasEmpresas tareaComponenteToEntity(TareaEmpresaComponente tareaComponente) {
        TbTareasEmpresas tarea = new TbTareasEmpresas();
        /**/
        tarea.setTeDescripcion(tareaComponente.getTe_descripcion());
        tarea.setTeEstado(tareaComponente.getTe_estado());
        tarea.setTeEvento(tareaComponente.getTe_evento());
        tarea.setTeResponsable(tareaComponente.getTe_responsable());
        tarea.setTeSecTarea(tareaComponente.getTe_sec_tarea());
        tarea.setTeFechaInicial(tareaComponente.getTe_fecha_inicial());
        tarea.setTeCaso(casosEmpresasFacade.buscarPorId(tareaComponente.getTe_caso()));
        return tarea;
    }

    public TareaEmpresaComponente entityToComponente(TbTareasEmpresas tareaEmpresa) {
        TareaEmpresaComponente tareaComponente = new TareaEmpresaComponente();
        tareaComponente.setTe_sec_tarea(tareaEmpresa.getTeSecTarea());
        tareaComponente.setTe_caso(tareaEmpresa.getTeCaso().getCeSecCaso());
        tareaComponente.setTe_evento(tareaEmpresa.getTeEvento());
        tareaComponente.setTe_fecha_inicial(tareaEmpresa.getTeFechaInicial());
        tareaComponente.setTe_fecha_fin(tareaEmpresa.getTeFechaFin());
        tareaComponente.setTe_responsable(tareaEmpresa.getTeResponsable());
        tareaComponente.setTe_descripcion(tareaEmpresa.getTeDescripcion());
        tareaComponente.setTe_estado(tareaEmpresa.getTeEstado());

        return tareaComponente;

    }

    public TareaEmpresaComponente entityToComponenteVisualizar(TbTareasEmpresas tareaEmpresa) {
        TareaEmpresaComponente tareaComponente = new TareaEmpresaComponente();
        tareaComponente.setTe_sec_tarea(tareaEmpresa.getTeSecTarea());
        tareaComponente.setTe_caso(tareaEmpresa.getTeCaso().getCeSecCaso());
        tareaComponente.setTe_evento(detalleCatalogoFacade.nombreCatalogoEvento(tareaEmpresa.getTeEvento()));
        tareaComponente.setTe_fecha_inicial(tareaEmpresa.getTeFechaInicial());
        tareaComponente.setTe_fecha_fin(tareaEmpresa.getTeFechaFin());
        tareaComponente.setTe_responsable(tareaEmpresa.getTeResponsable());
        tareaComponente.setTe_descripcion(tareaEmpresa.getTeDescripcion());
        tareaComponente.setTe_estado(detalleCatalogoFacade.nombreCatalogoEstadoTarea(tareaEmpresa.getTeEstado()));

        return tareaComponente;

    }

}
