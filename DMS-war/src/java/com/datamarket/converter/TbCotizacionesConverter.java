/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import com.datamarket.components.TbCotizacionesComponente;
import com.datamarket.entidades.TbCotizaciones;
import com.datamarket.facades.TbAdmUsuariosFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;


/**
 *
 * @author andres
 */
@Stateless
public class TbCotizacionesConverter {

    @Inject
    TbAdmUsuariosFacade usuariosFacade;

    public List<TbCotizacionesComponente> convertirListasEntidadAComponente(List<TbCotizaciones> cotizaciones, String nombreEmpresa) {
        List<TbCotizacionesComponente> listaCotizacionesComponente = new ArrayList<>();

        for (TbCotizaciones item : cotizaciones) {

            TbCotizacionesComponente componenteCotizacion = new TbCotizacionesComponente();

            componenteCotizacion.setCo_caso(item.getCoCaso());
            componenteCotizacion.setCo_cod_cotiz(item.getCoCodCotiz());
            componenteCotizacion.setCo_ejecutivo(item.getCoEjecutivo());
            componenteCotizacion.setCo_fecha(item.getCoFecha());
            componenteCotizacion.setCo_cod_empresa(item.getCoEmpresa());
            componenteCotizacion.setNombre_empresa(nombreEmpresa);
            componenteCotizacion.setNombre_ejecutivo(usuariosFacade.findNombreById(item.getCoEjecutivo()));
            listaCotizacionesComponente.add(componenteCotizacion);

        }

        return listaCotizacionesComponente;
    }

    
    /*This method will be defined in the future*/
    public List<TbCotizaciones> convertirListasComponenteAEntidad(List<TbCotizacionesComponente> cotizacionComponente) {

        List<TbCotizaciones> cotizaciones = new ArrayList<>();

        
        
        
        
        return cotizaciones;
    }

}
