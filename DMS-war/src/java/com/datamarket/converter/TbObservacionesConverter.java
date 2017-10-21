/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import com.datamarket.components.TbObservacionesComponente;
import com.datamarket.entidades.TbObservaciones;
import javax.ejb.Stateless;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbObservacionesConverter {

    public TbObservaciones convertirComponenteAEntidad(TbObservacionesComponente observacionesComponente) {
        TbObservaciones observaciones = new TbObservaciones();
        observaciones.setDcTexto(observacionesComponente.getDc_texto());

        if (observacionesComponente.getDc_codigo() == null) {
            observaciones.setDcCodigo(null);

            
        }

        if (observacionesComponente.getDc_codigo() != null) {
            observaciones.setDcCodigo(observacionesComponente.getDc_codigo());

        }

        observaciones.setDcClase(observacionesComponente.getDc_clase());

        return observaciones;
    }

    public TbObservacionesComponente convertirEntidadAComponente(TbObservaciones observaciones) {

        TbObservacionesComponente observacionComponente = new TbObservacionesComponente();
        if (observaciones.getDcCodigo() == null) {
            observacionComponente.setDc_codigo(null);

        }

        if (observaciones.getDcCodigo() != null) {
            observacionComponente.setDc_codigo(observaciones.getDcCodigo());

        }

        if (observaciones.getDcClase() == null) {
            observacionComponente.setDc_clase(null);

        }

        if (observaciones.getDcClase() != null) {
            observacionComponente.setDc_clase(observaciones.getDcClase());

        }

        if (observaciones.getDcTexto() == null) {
            observacionComponente.setDc_texto(null);

        }

        if (observaciones.getDcTexto() != null) {
            observacionComponente.setDc_texto(observaciones.getDcTexto());

        }

        return observacionComponente;
    }

}
