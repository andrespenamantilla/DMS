/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.IServicios;

import com.datamarket.entidades.TbCotizaciones;
import com.datamarket.entidades.TbDetalleCotizacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andrés
 */
@Local
public interface ITbCotizacionesServiciosLocal {

    void persistirCotizacion(List<TbDetalleCotizacion> detalles, TbCotizaciones cotizacion);

    

}
