/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import com.datamarket.components.TbEmpresaComercialComponente;
import com.datamarket.components.TbEmpresaComercialComponenteVista;
import com.datamarket.entidades.TbEmpresaComercial;
import com.datamarket.facades.TbAdmUsuariosFacade;
import com.datamarket.facades.TbDetalleCatalogoFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbEmpresasComercialConverter {

    @Inject
    TbAdmUsuariosFacade usuarioFacade;
    @Inject
    TbDetalleCatalogoFacade detalleCatalogoFacade;

    public TbEmpresaComercialComponente convertirEntidadAComponente(TbEmpresaComercial empresaComercial) {
        TbEmpresaComercialComponente empresaComercialComponente = new TbEmpresaComercialComponente();
        empresaComercialComponente.setEc_empresa(empresaComercial.getEcEmpresa());
        empresaComercialComponente.setEc_linea_negocio(empresaComercial.getEcLineaNegocio());
        empresaComercialComponente.setEc_prov_tecn(empresaComercial.getEcProvTecn());
        empresaComercialComponente.setEc_ejecutivo(empresaComercial.getEcEjecutivo().getEjCodigo());
        empresaComercialComponente.setEc_clasificacion(empresaComercial.getEcClasificacion());
        empresaComercialComponente.setEc_ejecutivo_nombre(usuarioFacade.findNombreById(empresaComercial.getEcEjecutivo().getEjCodigo()));
        return empresaComercialComponente;
    }

    public TbEmpresaComercialComponenteVista convertirEntidadAComponenteVista(TbEmpresaComercial empresaComercial) {

        TbEmpresaComercialComponenteVista empresaComercialComponenteVista = new TbEmpresaComercialComponenteVista();
        empresaComercialComponenteVista.setEc_empresa(empresaComercial.getEcEmpresa());
        empresaComercialComponenteVista.setEc_clasificacion(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(empresaComercial.getEcClasificacion(), "CA_CLASIF_CLIEN"));
        empresaComercialComponenteVista.setEc_linea_negocio(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(empresaComercial.getEcLineaNegocio(), "CA_LINEA_NEG"));
        empresaComercialComponenteVista.setEc_prov_tecn(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(empresaComercial.getEcProvTecn(), "CA_PROV_TEC"));
        empresaComercialComponenteVista.setEc_ejecutivo(usuarioFacade.findNombreById(empresaComercial.getEcEjecutivo().getEjCodigo()));

        return empresaComercialComponenteVista;
    }

    public TbEmpresaComercialComponenteVista convertirEntidadNulaAComponenteVista() {

        TbEmpresaComercialComponenteVista empresaComercialComponenteVista = new TbEmpresaComercialComponenteVista();

        empresaComercialComponenteVista.setEc_empresa(null);
        empresaComercialComponenteVista.setEc_clasificacion("SIN ASIGNAR");
        empresaComercialComponenteVista.setEc_linea_negocio("SIN ASIGNAR");
        empresaComercialComponenteVista.setEc_prov_tecn("SIN ASIGNAR");
        empresaComercialComponenteVista.setEc_ejecutivo("SIN ASIGNAR");

        return empresaComercialComponenteVista;
    }

}


