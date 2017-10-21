/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.Ifacades;

import com.datamarket.entidades.TbCotizaciones;
import com.datamarket.entidades.TbDetalleCotizacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andrés
 */
@Local
public interface ITbDetalleCotizacionFacadeLocal {
    Integer retornarDcCotizacion();
    Integer retornarDcNumDetalle();
    void persistirDetalleCotizacion(TbDetalleCotizacion detalleCotizacion);
    void eliminarDetalleCotizacion(TbDetalleCotizacion detalleCotizacion);
    void actualizarDetalleCotizacion(TbDetalleCotizacion detalleCotizacion);
    TbDetalleCotizacion findById(Integer id);
    List<TbDetalleCotizacion> buscarPorCodigoCotizacion(TbCotizaciones cotizacion);
}
