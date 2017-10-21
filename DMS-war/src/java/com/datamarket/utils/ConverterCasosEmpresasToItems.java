/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.utils;

import com.datamarket.components.TbCasosEmpresasItems;
import com.datamarket.entidades.TbCasosEmpresas;
import com.datamarket.facades.TbContactosEmpresasFacade;
import com.datamarket.facades.TbDetalleCatalogoFacade;
import com.datamarket.facades.TbEtapasProcesoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés
 */
@Stateless
public class ConverterCasosEmpresasToItems {

    private final static String CA_LINEA_NEG = "CA_LINEA_NEG";
    private final static String CA_TIPOCONT_INI = "CA_TIPOCONT_INI";
    private final static String CA_ESTADO_PROC = "CA_ESTADO_PROC";
    private final static String CA_CAU_EST_PRO = "CA_CAU_EST_PRO";
    private String ce_contacto;

    @Inject
    TbContactosEmpresasFacade contactoEmpresaFacade;
    @Inject
    TbDetalleCatalogoFacade detalleCatalogoFacade;
    @Inject
    TbEtapasProcesoFacade etapasProcesoFacade;

    private List<TbCasosEmpresasItems> casosEmpresasItems;

    public List<TbCasosEmpresasItems> convertirTbCasosEmpresasToCasosEmpresasItems(List<TbCasosEmpresas> casosEmpresas) {
        casosEmpresasItems = new ArrayList();

        TbCasosEmpresasItems aux = new TbCasosEmpresasItems();

        for (int i = 0; i < casosEmpresas.size(); i++) {

            ce_contacto = contactoEmpresaFacade.buscarContactoPorCeSecuencialAndCeCodigoEmpresa(casosEmpresas.get(i).getCeContacto(), casosEmpresas.get(i).getCeEmpresa().getEcEmpresa());

            /**/
            aux.setCe_tipo_cont(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(casosEmpresas.get(i).getCeTipoCont(), CA_TIPOCONT_INI));
            aux.setCe_estado(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(casosEmpresas.get(i).getCeEstado(), CA_ESTADO_PROC));
            aux.setCe_linea_negocio(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(casosEmpresas.get(i).getCeLineaNegocio(), CA_LINEA_NEG));
            if (casosEmpresas.get(i).getCeCausal() == null) {
                aux.setCe_causal("");
            } else {
                aux.setCe_causal(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(casosEmpresas.get(i).getCeCausal(), CA_CAU_EST_PRO));
            }
            aux.setCe_empresa(casosEmpresas.get(i).getCeEmpresa().getEcEmpresa());
            aux.setCe_sec_caso(casosEmpresas.get(i).getCeSecCaso());
            aux.setCe_contacto(ce_contacto);
            aux.setCe_descripcion(casosEmpresas.get(i).getCeDescripcion());
            aux.setCe_etapa(etapasProcesoFacade.buscarDescripcionEtapasProcesoPorCodigo(casosEmpresas.get(i).getCeEtapa()));

            casosEmpresasItems.add(aux);
            aux = new TbCasosEmpresasItems();

        }

        ce_contacto = "";
        return casosEmpresasItems;
    }

    public TbCasosEmpresasItems convertirTbCasoEmpresaToCasosEmpresaItem(TbCasosEmpresas casosEmpresas) {

        TbCasosEmpresasItems aux = new TbCasosEmpresasItems();

        ce_contacto = contactoEmpresaFacade.buscarContactoPorCeSecuencialAndCeCodigoEmpresa(casosEmpresas.getCeContacto(), casosEmpresas.getCeEmpresa().getEcEmpresa());

        aux.setCe_tipo_cont(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(casosEmpresas.getCeTipoCont(), CA_TIPOCONT_INI));
        aux.setCe_estado(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(casosEmpresas.getCeEstado(), CA_ESTADO_PROC));
        aux.setCe_linea_negocio(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(casosEmpresas.getCeLineaNegocio(), CA_LINEA_NEG));
        if (casosEmpresas.getCeCausal() == null) {
            aux.setCe_causal("");
        } else {
            aux.setCe_causal(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(casosEmpresas.getCeCausal(), CA_CAU_EST_PRO));
        }
        aux.setCe_empresa(casosEmpresas.getCeEmpresa().getEcEmpresa());
        aux.setCe_sec_caso(casosEmpresas.getCeSecCaso());
        aux.setCe_contacto(ce_contacto);
        aux.setCe_descripcion(casosEmpresas.getCeDescripcion());
        aux.setCe_etapa(etapasProcesoFacade.buscarDescripcionEtapasProcesoPorCodigo(casosEmpresas.getCeEtapa()));

        return aux;
    }

}
