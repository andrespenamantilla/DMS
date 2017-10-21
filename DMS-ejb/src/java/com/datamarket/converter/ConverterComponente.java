/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import com.datamarket.entidades.TbEmpresaComercial;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class ConverterComponente implements Serializable {

    public TbEmpresaComercial convertirempresaComercialComponenteToEmpresaComercial(TbEmpresaComercial componente) {
        TbEmpresaComercial empresaComercial = new TbEmpresaComercial();
        empresaComercial.setEcEmpresa(componente.getEcEmpresa());
        empresaComercial.setEcLineaNegocio(componente.getEcLineaNegocio());
        empresaComercial.setEcProvTecn(componente.getEcProvTecn());
        empresaComercial.setEcEjecutivo(componente.getEcEjecutivo());
        empresaComercial.setEcClasificacion(componente.getEcLineaNegocio());

        return empresaComercial;
    }

}
