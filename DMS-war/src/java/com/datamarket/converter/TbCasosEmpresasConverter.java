/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import com.datamarket.components.CasoEmpresaComponente;
import com.datamarket.components.TbCasoEmpresaComponenteVista;
import com.datamarket.entidades.TbCasosEmpresas;
import com.datamarket.entidades.TbContactosEmpresas;
import com.datamarket.facades.TbContactosEmpresasFacade;
import com.datamarket.facades.TbDetalleCatalogoFacade;
import com.datamarket.facades.TbEmpresaComercialFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbCasosEmpresasConverter {

    @Inject
    TbEmpresaComercialFacade empresaComercialFacade;
    @Inject
    TbDetalleCatalogoFacade detalleCatalogoFacade;
    @Inject
    TbContactosEmpresasFacade contactosEmpresasFacade;

    private TbCasosEmpresas casoEmpresa;

    public TbCasosEmpresas TbCasosEmpresasComponenteToEntity(CasoEmpresaComponente casoEmpresaComponente) {
        casoEmpresa = new TbCasosEmpresas();

        /**/
        casoEmpresa.setCeCausal(casoEmpresaComponente.getCe_causal());
        casoEmpresa.setCeContacto(casoEmpresaComponente.getCe_contacto());
        casoEmpresa.setCeDescripcion(casoEmpresaComponente.getCe_descripcion());
        casoEmpresa.setCeEstado("A");
        casoEmpresa.setCeSecCaso(casoEmpresaComponente.getCe_sec_caso());
        casoEmpresa.setCeTipoCont(casoEmpresaComponente.getCe_tipo_cont());
        casoEmpresa.setCeLineaNegocio(casoEmpresaComponente.getCe_linea_negocio());
        casoEmpresa.setCeEtapa(casoEmpresaComponente.getCe_etapa());
        //casoEmpresa.setCeEmpresa(empresaComercialFacade.findById(casoEmpresaComponente.getCe_empresa()));

        return casoEmpresa;
    }

    public TbCasoEmpresaComponenteVista convertirEntidadAComponenteVista(TbCasosEmpresas casoEmpresa) {

        String contactoEmpresa;

        contactoEmpresa = contactosEmpresasFacade.buscarContactoPorCeSecuencialAndCeCodigoEmpresa(casoEmpresa.getCeContacto(), casoEmpresa.getCeEmpresa().getTbEmpresas().getEmIdEmpresas());
        TbCasoEmpresaComponenteVista casoEmpresaComponenteVista = new TbCasoEmpresaComponenteVista();

        casoEmpresaComponenteVista.setCe_empresa(casoEmpresa.getCeEmpresa().getTbEmpresas().getEmNombre());
        casoEmpresaComponenteVista.setCe_etapa(detalleCatalogoFacade.nombreCatalogoEstadoProceso(casoEmpresa.getCeEstado()));
        casoEmpresaComponenteVista.setCe_linea_negocio(detalleCatalogoFacade.nombreCatalogoLineaNegocio(casoEmpresa.getCeLineaNegocio()));
        casoEmpresaComponenteVista.setCe_estado(detalleCatalogoFacade.nombreCatalogoEstadoProceso(casoEmpresa.getCeLineaNegocio()));
        casoEmpresaComponenteVista.setCe_sec_caso(casoEmpresa.getCeSecCaso());
        casoEmpresaComponenteVista.setCe_descripcion(casoEmpresa.getCeDescripcion());
        casoEmpresaComponenteVista.setCe_tipo_cont(detalleCatalogoFacade.nombreCatalogoTipoContactoInicial(casoEmpresa.getCeTipoCont()));
        casoEmpresaComponenteVista.setCe_contacto(contactoEmpresa);
        if (casoEmpresa.getCeCausal() == null) {
            casoEmpresaComponenteVista.setCe_causal("NO REGISTRA");

        } else {
            casoEmpresaComponenteVista.setCe_causal(detalleCatalogoFacade.nombreCatalogoCasusalEstadoProceso(casoEmpresa.getCeCausal()));

        }
        return casoEmpresaComponenteVista;

    }

}
