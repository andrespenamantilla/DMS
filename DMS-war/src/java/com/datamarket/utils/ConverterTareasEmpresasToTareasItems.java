/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.utils;

import com.datamarket.components.TbTareasEmpresasItems;
import com.datamarket.entidades.TbTareasEmpresas;
import com.datamarket.facades.TbAdmUsuariosFacade;
import com.datamarket.facades.TbDetalleCatalogoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés
 */
@Stateless
public class ConverterTareasEmpresasToTareasItems {

    private final static String CA_EVENTOS = "CA_EVENTOS";
    private final static String CA_ESTADO_TAR = "CA_ESTADO_TAR";

    @Inject
    TbDetalleCatalogoFacade detalleCatalogoFacade;
    @Inject
    TbAdmUsuariosFacade usuariosFacade;

    public List<TbTareasEmpresasItems> convertirTbCasosEmpresasToCasosEmpresasItems(List<TbTareasEmpresas> tareasEmpresas) {
        {

            List<TbTareasEmpresasItems> tareasItems = new ArrayList<>();
            for (int i = 0; i < tareasEmpresas.size(); i++) {
                TbTareasEmpresasItems aux = new TbTareasEmpresasItems();
                aux.setTe_caso(tareasEmpresas.get(i).getTeCaso().getCeSecCaso());
                aux.setTe_empresa(tareasEmpresas.get(i).getTeCaso().getCeEmpresa().getEcEmpresa());
                aux.setTe_evento(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(tareasEmpresas.get(i).getTeEvento(), CA_EVENTOS));
                aux.setTe_responsable(tareasEmpresas.get(i).getTeResponsable());
                aux.setTe_fecha_inicial(tareasEmpresas.get(i).getTeFechaInicial());
                aux.setTe_fecha_fin(tareasEmpresas.get(i).getTeFechaFin());
                aux.setTe_sec_tarea(tareasEmpresas.get(i).getTeSecTarea());
                aux.setTe_estado(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(tareasEmpresas.get(i).getTeEstado(), CA_ESTADO_TAR));
                aux.setTe_descripcion(tareasEmpresas.get(i).getTeDescripcion());
                aux.setNombreResponsable(usuariosFacade.findNombreById(tareasEmpresas.get(i).getTeResponsable()).toUpperCase());
                tareasItems.add(aux);
            }
            return tareasItems;
        }
    }

    public TbTareasEmpresasItems convertirTbCasosEmpresasToObjectEmpresasItem(TbTareasEmpresas tareasEmpresas) {
        {
            TbTareasEmpresasItems aux = new TbTareasEmpresasItems();

            aux.setTe_caso(tareasEmpresas.getTeCaso().getCeSecCaso());
            aux.setTe_empresa(tareasEmpresas.getTeCaso().getCeEmpresa().getEcEmpresa());
            aux.setTe_evento(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(tareasEmpresas.getTeEvento(), CA_EVENTOS));
            aux.setTe_responsable(tareasEmpresas.getTeResponsable());
            aux.setTe_fecha_inicial(tareasEmpresas.getTeFechaInicial());
            aux.setTe_fecha_fin(tareasEmpresas.getTeFechaFin());
            aux.setTe_sec_tarea(tareasEmpresas.getTeSecTarea());
            aux.setTe_estado(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(tareasEmpresas.getTeEstado(), CA_ESTADO_TAR));

            return aux;
        }

    }
}
