/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import com.datamarket.components.TbHistorialCasosComponente;
import com.datamarket.entidades.TbHistorialCasos;
import com.datamarket.facades.TbAdmUsuariosFacade;
import com.datamarket.facades.TbDetalleCatalogoFacade;
import com.datamarket.facades.TbEmpresasFacade;
import com.datamarket.facades.TbEtapasProcesoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author andre
 */
@Stateless
public class TbHistorialCasosConverter {

    @Inject
    TbAdmUsuariosFacade usuariosFacade;
    @Inject
    TbDetalleCatalogoFacade detalleCatalogoFacade;
    @Inject
    TbEmpresasFacade empresaFacade;
    @Inject
    TbEtapasProcesoFacade etapasProcesoFacade;

    public List<TbHistorialCasosComponente> convertirAHistorialComponente(List<TbHistorialCasos> historialList) {
        List<TbHistorialCasosComponente> historialComponentesLista = new ArrayList<>();

        for (TbHistorialCasos aux : historialList) {
            TbHistorialCasosComponente componente = new TbHistorialCasosComponente();
            componente.setHc_sec_historial(aux.getHcSecHistorial());
            componente.setHc_sec_caso(aux.getHcSecCaso());
            componente.setHc_cod_empresa(empresaFacade.findById(aux.getHcCodEmpresa()));
            componente.setHc_cod_contacto(aux.getHCodContacto());
            if (aux.getHcEstadoCaso() == null) {
                componente.setHc_estado_caso("NO REGISTRA");
            } else {
                componente.setHc_estado_caso(detalleCatalogoFacade.nombreCatalogoEstadoProceso(aux.getHcEstadoCaso()));

            }
            if (aux.getHcEvento() == null) {
                componente.setHc_evento("NO REGISTRA");
            } else {
                componente.setHc_evento(detalleCatalogoFacade.nombreCatalogoEvento(aux.getHcEvento()));

            }
            componente.setHc_estado_tarea(aux.getHcEstadoTarea());
            if (aux.getHcEstadoTarea() == null) {
                componente.setHc_estado_tarea("NO REGISTRA");

            } else {
                componente.setHc_estado_tarea(detalleCatalogoFacade.nombreCatalogoEstadoTarea(aux.getHcEstadoTarea()));

            }
            componente.setHc_anotacion(aux.getHcAnotacion());
            componente.setHc_fecha(aux.getHcFecha());
            componente.setHc_usuario(usuariosFacade.buscarPorId(aux.getHcUsuario()));
            componente.setHc_cod_etapa(etapasProcesoFacade.buscarDescripcionEtapasProcesoPorCodigo(Integer.parseInt(aux.getHcCodEtapa())));
            historialComponentesLista.add(componente);
        }
        return historialComponentesLista;

    }

    

    
}
