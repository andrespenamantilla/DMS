/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.Ifacades;

import com.datamarket.entidades.TbCotizaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andrés
 */
@Local
public interface ITbCotizacionesFacadeLocal {

    Integer retornarCodCotizacion();
    
    
    void persistirCotizacion(TbCotizaciones cotizacion);

    void eliminarCotizacion(TbCotizaciones cotizacion);

    void actualizarCotizacion(TbCotizaciones cotizacion);

    TbCotizaciones findById(Integer id);

    List<TbCotizaciones> listarTodosLasCotizaciones();
    
    List<TbCotizaciones> listarTodosLasCotizacionesPorCaso(Integer coCaso);
}
