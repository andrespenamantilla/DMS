/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.servicios;

import com.datamarket.IServicios.ITbCotizacionesServiciosLocal;
import com.datamarket.Ifacades.ITbCotizacionesFacadeLocal;
import com.datamarket.Ifacades.ITbDetalleCotizacionFacadeLocal;
import com.datamarket.Ifacades.ITbObservacionesFacadeLocal;
import com.datamarket.entidades.TbCotizaciones;
import com.datamarket.entidades.TbDetalleCotizacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbCotizacionesServicio implements ITbCotizacionesServiciosLocal {

    @Inject
    ITbObservacionesFacadeLocal observacionesFacade;
    @Inject
    ITbDetalleCotizacionFacadeLocal detalleCotizacionFacade;
    @Inject
    ITbCotizacionesFacadeLocal cotizacionFacade;

    @Override
    public void persistirCotizacion(List<TbDetalleCotizacion> detalles, TbCotizaciones cotizacion) {

        cotizacionFacade.persistirCotizacion(cotizacion);

        for (int i = 0; i < detalles.size(); i++) {

            observacionesFacade.persistirObservacion(detalles.get(i).getDcObservacion());
            detalleCotizacionFacade.persistirDetalleCotizacion(detalles.get(i));
            
        }

    }

}
