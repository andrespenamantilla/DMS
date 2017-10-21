/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.Ifacades;

import com.datamarket.entidades.TbObservaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andrés
 */
@Local
public interface ITbObservacionesFacadeLocal {

    void persistirObservacion(TbObservaciones observacion);

    void eliminarObservacion(TbObservaciones observacion);

    void actualizarObservacion(TbObservaciones observacion);

    TbObservaciones findById(Integer id);

    List<TbObservaciones> listarTodasLasObservaciones();

    Integer retornarDcCodigo();

}
