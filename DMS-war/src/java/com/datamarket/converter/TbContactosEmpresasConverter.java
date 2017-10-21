/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import com.datamarket.components.TbContactosEmpresaComponente;
import com.datamarket.entidades.TbContactosEmpresas;
import com.datamarket.facades.TbDetalleCatalogoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author andre
 */
@Stateless
public class TbContactosEmpresasConverter {

    @Inject
    TbDetalleCatalogoFacade detalleCatalogoFacade;

    public List<TbContactosEmpresaComponente> convertirContactosEmpresasComponente(List<TbContactosEmpresas> contactosEmpresas) {
        List<TbContactosEmpresaComponente> contactosEmpresasComponente = new ArrayList<>();
        TbContactosEmpresaComponente aux = new TbContactosEmpresaComponente();
        for (int i = 0; i < contactosEmpresas.size(); i++) {
            aux.setCe_secuencial(contactosEmpresas.get(i).getCeSecuencial());
            aux.setCe_codigo_empresa(contactosEmpresas.get(i).getCeCodigoEmpresa().getEmIdEmpresas());
            aux.setCe_nombres(contactosEmpresas.get(i).getCeNombres().toUpperCase());
            aux.setCe_apellidos(contactosEmpresas.get(i).getCeApellidos().toUpperCase());
            aux.setCe_area(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(contactosEmpresas.get(i).getCeArea(), "CA_AREAS"));
            aux.setCe_cargo(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(contactosEmpresas.get(i).getCeCargo(), "CA_CARGOS"));
            aux.setNombre_empresa(contactosEmpresas.get(i).getCeCodigoEmpresa().getEmNombre());
            contactosEmpresasComponente.add(aux);
            aux = new TbContactosEmpresaComponente();
        }
        return contactosEmpresasComponente;

    }

    public TbContactosEmpresaComponente convertirEntidadAComponente(TbContactosEmpresas contactoEmpresa) {
        TbContactosEmpresaComponente aux = new TbContactosEmpresaComponente();
        aux.setCe_secuencial(contactoEmpresa.getCeSecuencial());
        aux.setCe_codigo_empresa(contactoEmpresa.getCeCodigoEmpresa().getEmIdEmpresas());
        aux.setCe_nombres(contactoEmpresa.getCeNombres());
        aux.setCe_apellidos(contactoEmpresa.getCeApellidos());
        aux.setNombre_empresa(contactoEmpresa.getCeCodigoEmpresa().getEmNombre());
        aux.setCe_area(contactoEmpresa.getCeArea());
        aux.setCe_cargo(contactoEmpresa.getCeCargo());
        aux.setCe_descripcion_funcion(contactoEmpresa.getCeDescripcionFuncion());
        aux.setCe_telefono(contactoEmpresa.getCeTelefono());
        if (contactoEmpresa.getCeExtTel() == null) {
            aux.setCe_ext_tel(null);
        } else {
            aux.setCe_ext_tel(contactoEmpresa.getCeExtTel().toString());
        }
        aux.setCe_direccion(contactoEmpresa.getCeDireccion());
        aux.setCe_pais(contactoEmpresa.getCePais());
        aux.setCe_depto(contactoEmpresa.getCeDepto());
        aux.setCe_ciudad(contactoEmpresa.getCeCiudad());
        aux.setCe_email_corp(contactoEmpresa.getCeEmailCorp());
        aux.setCe_email_personal(contactoEmpresa.getCeEmailPersonal());
        aux.setCe_estado(contactoEmpresa.getCeEstado());
        aux.setCe_celular(contactoEmpresa.getCeCelular());
        aux.setCe_sw_contacto(contactoEmpresa.getCeSwContacto());
        aux.setCe_fecha_crea(contactoEmpresa.getCeFechaCrea());
        aux.setCe_fecha_ult_mod(contactoEmpresa.getCeFechaUltMod());
        return aux;

    }

    public TbContactosEmpresas convertirComponenteToEntidad(TbContactosEmpresaComponente contactoComponente) {

        TbContactosEmpresas aux = new TbContactosEmpresas();

        aux.setCeSecuencial(contactoComponente.getCe_secuencial());
        aux.setCeNombres(contactoComponente.getCe_nombres());
        aux.setCeApellidos(contactoComponente.getCe_apellidos());
        aux.setCeArea(contactoComponente.getCe_area());
        aux.setCeCargo(contactoComponente.getCe_cargo());
        aux.setCeDescripcionFuncion(contactoComponente.getCe_descripcion_funcion());
        aux.setCeTelefono(contactoComponente.getCe_telefono());

        if (contactoComponente.getCe_ext_tel() == null) {
            aux.setCeExtTel(null);
        } else {
            aux.setCeExtTel(Integer.parseInt(contactoComponente.getCe_ext_tel()));

        }
        aux.setCeDireccion(contactoComponente.getCe_direccion());
        aux.setCePais(contactoComponente.getCe_pais());
        aux.setCeDepto(contactoComponente.getCe_depto());
        aux.setCeCiudad(contactoComponente.getCe_ciudad());
        aux.setCeEmailCorp(contactoComponente.getCe_email_corp());
        aux.setCeEmailPersonal(contactoComponente.getCe_email_personal());
        aux.setCeEstado(contactoComponente.getCe_estado());
        aux.setCeCelular(contactoComponente.getCe_celular());
        aux.setCeSwContacto(contactoComponente.getCe_sw_contacto());
        aux.setCeFechaCrea(contactoComponente.getCe_fecha_crea());
        aux.setCeFechaUltMod(contactoComponente.getCe_fecha_ult_mod());
        return aux;
    }

    public TbContactosEmpresaComponente convertirContactosEmpresasComponente(TbContactosEmpresas contactoEmpresas) {

        TbContactosEmpresaComponente aux = new TbContactosEmpresaComponente();

        aux.setCe_secuencial(contactoEmpresas.getCeSecuencial());
        aux.setCe_codigo_empresa(contactoEmpresas.getCeCodigoEmpresa().getEmIdEmpresas());
        aux.setCe_nombres(contactoEmpresas.getCeNombres());
        aux.setCe_apellidos(contactoEmpresas.getCeApellidos());
        aux.setCe_area(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(contactoEmpresas.getCeArea(), "CA_AREAS"));
        aux.setCe_cargo(detalleCatalogoFacade.getStringForDcCatalogoAndDcCodigo(contactoEmpresas.getCeCargo(), "CA_CARGOS"));
        aux.setNombre_empresa(contactoEmpresas.getCeCodigoEmpresa().getEmNombre());

        aux = new TbContactosEmpresaComponente();

        return aux;

    }
}
