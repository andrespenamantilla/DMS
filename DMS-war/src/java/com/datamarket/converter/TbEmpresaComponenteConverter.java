/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import com.datamarket.components.TbEmpresaComponente;
import com.datamarket.entidades.TbEmpresaComercial;
import com.datamarket.entidades.TbEmpresas;
import com.datamarket.facades.TbCiudadesFacade;
import com.datamarket.facades.TbDepartamentosFacade;
import com.datamarket.facades.TbPaisesFacade;
import com.datamarket.facades.TbSectorEconomicoFacade;
import com.sun.xml.ws.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author andre
 */
@Stateless
public class TbEmpresaComponenteConverter {

    @Inject
    TbPaisesFacade paisesFacade;
    @Inject
    TbDepartamentosFacade departamentosFacade;
    @Inject
    TbCiudadesFacade ciudadesFacade;
    @Inject
    TbSectorEconomicoFacade sectorEconomicoFacade;

    public List<TbEmpresaComponente> convertirAEmpresasComponente(List<TbEmpresaComercial> empresasComercial) {

        List<TbEmpresaComponente> empresasComercialComponente = new ArrayList<>();
        for (int i = 0; i < empresasComercial.size(); i++) {
            TbEmpresaComponente aux = new TbEmpresaComponente();

            aux.setEm_dv(empresasComercial.get(i).getTbEmpresas().getEmDv());
            aux.setEm_nombre(empresasComercial.get(i).getTbEmpresas().getEmNombre());
            aux.setEm_nit(empresasComercial.get(i).getTbEmpresas().getEmNit());
            aux.setEm_direccion(empresasComercial.get(i).getTbEmpresas().getEmDireccion());
            aux.setEm_telefono1(empresasComercial.get(i).getTbEmpresas().getEmTelefono1());
            aux.setEm_telefono1(empresasComercial.get(i).getTbEmpresas().getEmTelefono2());
            aux.setEm_id_empresas(empresasComercial.get(i).getTbEmpresas().getEmIdEmpresas());
            aux.setEm_pais(paisesFacade.findNombreById(empresasComercial.get(i).getTbEmpresas().getEmPais()));
            aux.setEm_depto(departamentosFacade.findNombreById(empresasComercial.get(i).getTbEmpresas().getEmPais(), empresasComercial.get(i).getTbEmpresas().getEmDepto()));
            aux.setEm_ciudad(ciudadesFacade.findNombreById(empresasComercial.get(i).getTbEmpresas().getEmPais(), empresasComercial.get(i).getTbEmpresas().getEmDepto(), empresasComercial.get(i).getTbEmpresas().getEmCiudad()));
            aux.setEm_sector(sectorEconomicoFacade.buscarNombreSector(empresasComercial.get(i).getTbEmpresas().getEmSector()));
            aux.setEm_sector("NO IMPLEMENTADO");

            empresasComercialComponente.add(aux);

        }

        return empresasComercialComponente;
    }

    public TbEmpresaComponente convertirEntidadAComponente(TbEmpresas empresa) {
        TbEmpresaComponente empresaComponente = new TbEmpresaComponente();
        empresaComponente.setEm_id_empresas(empresa.getEmIdEmpresas());
        empresaComponente.setEm_nit(empresa.getEmNit());
        empresaComponente.setEm_nombre(StringUtils.capitalize(empresa.getEmNombre()));
        empresaComponente.setEm_telefono1(empresa.getEmTelefono1());
        empresaComponente.setEm_telefono2(empresa.getEmTelefono2());
        empresaComponente.setEm_direccion(empresa.getEmDireccion());
        empresaComponente.setEm_pais(empresa.getEmPais());
        empresaComponente.setEm_depto(empresa.getEmDepto());
        empresaComponente.setEm_ciudad(empresa.getEmCiudad());
        empresaComponente.setEm_sector_index(empresa.getEmSector());
        empresaComponente.setEm_subsector("NO IMPLEMENTADO");
        empresaComponente.setEm_telefono3(empresa.getEmTelefono3());
        empresaComponente.setEm_fax(empresa.getEmFax());
        empresaComponente.setEm_web(empresa.getEmWeb());
        empresaComponente.setEm_anio_fundacion(empresa.getEmAnioFundacion());
        empresaComponente.setEm_email(empresa.getEmEmail());
        empresaComponente.setEm_actividad_principal(empresa.getEmActividadPrinc());
        empresaComponente.setEm_ciiu1(empresa.getEmCiiu1());
        empresaComponente.setEm_ciiu2(empresa.getEmCiiu2());
        empresaComponente.setEm_ciiu3(empresa.getEmCiiu3());
        empresaComponente.setEm_celular(empresa.getEmCelular());
        empresaComponente.setEm_num_empleados(empresa.getEmNumEmpleados());
        empresaComponente.setEm_nro_comp(empresa.getEmNroComp());
        empresaComponente.setEm_observaciones(empresa.getEmObservaciones());
        empresaComponente.setEm_tipo_per(empresa.getEmTipoPer());
        empresaComponente.setEm_origen(empresa.getEmOrigen());
        empresaComponente.setEm_estado(empresa.getEmEstado());
        return empresaComponente;
    }

    public TbEmpresas convertirComponenteAEntidad(TbEmpresaComponente empresaComponente) {
        TbEmpresas aux = new TbEmpresas();

        aux.setEmNit(empresaComponente.getEm_nit());
        aux.setEmDv(empresaComponente.getEm_dv());
        aux.setEmNombre(empresaComponente.getEm_nombre());
        aux.setEmSector((empresaComponente.getEm_sector_index()));
        aux.setEmSubsector(empresaComponente.getEm_sector_index());
        aux.setEmPais(empresaComponente.getEm_pais());
        aux.setEmDepto(empresaComponente.getEm_depto());
        aux.setEmCiudad(empresaComponente.getEm_ciudad());
        aux.setEmTelefono1(empresaComponente.getEm_telefono1());
        aux.setEmTelefono2(empresaComponente.getEm_telefono2());
        aux.setEmTelefono3(empresaComponente.getEm_telefono3());
        aux.setEmDireccion(empresaComponente.getEm_direccion());
        aux.setEmFax(empresaComponente.getEm_fax());
        aux.setEmAnioFundacion(empresaComponente.getEm_anio_fundacion());
        aux.setEmEmail(empresaComponente.getEm_email());
        aux.setEmActividadPrinc(empresaComponente.getEm_actividad_principal());
        aux.setEmCiiu1(empresaComponente.getEm_ciiu1());
        aux.setEmCiiu2(empresaComponente.getEm_ciiu2());
        aux.setEmCiiu3(empresaComponente.getEm_ciiu3());
        aux.setEmNumEmpleados(empresaComponente.getEm_num_empleados());
        aux.setEmCelular(empresaComponente.getEm_celular());
        aux.setEmNroComp(empresaComponente.getEm_nro_comp());
        aux.setEmObservaciones(empresaComponente.getEm_observaciones());
        aux.setEmOrigen(empresaComponente.getEm_origen());
        aux.setEmTipoPer(empresaComponente.getEm_tipo_per());
        aux.setEmEstado(empresaComponente.getEm_estado());

        return aux;
    }

}
