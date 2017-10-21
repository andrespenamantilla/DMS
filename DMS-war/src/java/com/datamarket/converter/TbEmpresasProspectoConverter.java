/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import com.datamarket.components.TbEmpresasProspectoComponente;
import com.datamarket.entidades.TbAdmUsuarios;
import com.datamarket.entidades.TbEmpresasProspecto;
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
public class TbEmpresasProspectoConverter {

    @Inject
    TbDetalleCatalogoFacade detalleCatalogoFacade;
    @Inject
    TbAdmUsuariosFacade usuariosFacade;

    public List<TbEmpresasProspectoComponente> convertirTbEmpresasProspectoToEmpresasProspectoComponente(List<TbEmpresasProspecto> empresasProspectadas) {
        List<TbEmpresasProspectoComponente> empresasProspectadasComponente = new ArrayList<>();

        for (TbEmpresasProspecto iterator : empresasProspectadas) {
            TbAdmUsuarios usuario = new TbAdmUsuarios();
            usuario = usuariosFacade.findById(iterator.getPeEjecutivo());
            TbEmpresasProspectoComponente aux = new TbEmpresasProspectoComponente();

            aux.setPe_empresa(iterator.getPeEmpresa());
            aux.setPe_nombre(iterator.getPeNombre());
            aux.setPe_numero_id(iterator.getPeNumeroId());
            if (iterator.getPeDv() == null) {
                aux.setPe_dv(null);
            } else {
                aux.setPe_dv(iterator.getPeDv());
            }
            aux.setPe_direccion(iterator.getPeDireccion());
            aux.setPe_pais((iterator.getPePais()));
            aux.setPe_departamento((iterator.getPeDepartamento()));
            aux.setPe_ciudad((iterator.getPeCiudad()));
            aux.setPe_telefono(iterator.getPeTelefono());
            if (iterator.getPeEmail() == null) {
                aux.setPe_email("NO REGISTRA");
            } else {
                aux.setPe_email(iterator.getPeEmail());
            }
            if (iterator.getPeSitioWeb() == null) {
                aux.setPe_sitio_web("NO REGISTRA");

            } else {
                aux.setPe_sitio_web(iterator.getPeSitioWeb());
            }
            aux.setPe_sector((iterator.getPeSector()));
            aux.setPe_productos(iterator.getPeProductos());
            aux.setPe_referencia((iterator.getPeReferencia()));
            if (iterator.getPeNombreContacto() == null) {
                aux.setPe_nombre_contacto("NO REGISTRA");
            } else {
                aux.setPe_nombre_contacto(iterator.getPeNombreContacto());
            }
            if (iterator.getPeApellidoContacto() == null) {
                aux.setPe_apellido_contacto("NO REGISTRA");
            } else {
                aux.setPe_apellido_contacto(iterator.getPeApellidoContacto());
            }

            if (iterator.getPeDescripcionFuncion() == null) {
                aux.setPe_descripcion_funcion("NO REGISTRA");
            } else {
                aux.setPe_descripcion_funcion(iterator.getPeDescripcionFuncion());
            }
            aux.setPe_fecha_creacion(iterator.getPeFechaCreacion());
            aux.setPe_ejecutivo(usuario.getUsNombre());
            aux.setPe_cargo((iterator.getPeCargo()));
            aux.setPe_area((iterator.getPeArea()));
            empresasProspectadasComponente.add(aux);

        }

        return empresasProspectadasComponente;
    }

}
