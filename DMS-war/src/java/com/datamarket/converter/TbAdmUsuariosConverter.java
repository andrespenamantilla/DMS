/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import com.datamarket.components.TbAdmUsuariosComponente;
import com.datamarket.entidades.TbAdmUsuarios;
import com.datamarket.facades.TbAdmRolesFacade;
import com.datamarket.facades.TbDetalleCatalogoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbAdmUsuariosConverter {
    
    @Inject
    TbAdmRolesFacade rolFacade;
    @Inject
    TbDetalleCatalogoFacade detalleCatalogoFacade;
    
    public TbAdmUsuarios convertirComponenteAEntidad(TbAdmUsuariosComponente componente) {
        TbAdmUsuarios aux = new TbAdmUsuarios();
        aux.setUsCodUsuario(componente.getUs_cod_usuario());
        aux.setUsLogin(componente.getUs_login());
        aux.setUsRol(rolFacade.finById(componente.getUs_rol()));
        aux.setUsTipoId(componente.getUs_tipo_id());
        aux.setUsEstado(componente.getUs_estado());
        aux.setUsId(componente.getUs_id());
        aux.setUsArea(componente.getUs_area());
        aux.setUsCargo(componente.getUs_cargo());
        aux.setUsNombre(componente.getUs_nombre());
        aux.setUsEmail(componente.getUs_email());
        if (componente.getUs_password() == null) {
            aux.setUsPassword(null);
        } else {
            aux.setUsPassword(componente.getUs_password());
        }
        return aux;
    }
    
    public List<TbAdmUsuariosComponente> convertirEntidadAComponenteMostrar(List<TbAdmUsuarios> usuarios) {
        List<TbAdmUsuariosComponente> usuariosComponente = new ArrayList<>();
        for (TbAdmUsuarios usuario : usuarios) {
            TbAdmUsuariosComponente aux = new TbAdmUsuariosComponente();
            aux.setUs_area_descripcion(detalleCatalogoFacade.nombreCatalogoArea(usuario.getUsArea()));
            aux.setUs_cargo_descripcion(detalleCatalogoFacade.nombreCatalogoCargo(usuario.getUsCargo()));
            aux.setUs_estado_descripcion(detalleCatalogoFacade.nombreCatalogoEstadoUsuario(usuario.getUsEstado().toString()));
            aux.setUs_email(usuario.getUsEmail());
            aux.setUs_cargo(usuario.getUsCargo());
            aux.setUs_area(usuario.getUsArea());
            aux.setUs_cargo(usuario.getUsCargo());
            aux.setUs_nombre(usuario.getUsNombre().toUpperCase());
            aux.setUs_password(usuario.getUsPassword());
            aux.setUs_estado(usuario.getUsEstado());
            aux.setUs_rol(usuario.getUsRol().getRoCodigo());
            aux.setUs_id(usuario.getUsId());
            aux.setUs_tipo_id(usuario.getUsTipoId());
            aux.setUs_login(usuario.getUsLogin());
            aux.setUs_cod_usuario(usuario.getUsCodUsuario());
            usuariosComponente.add(aux);
        }
        return usuariosComponente;
    }
    
}
