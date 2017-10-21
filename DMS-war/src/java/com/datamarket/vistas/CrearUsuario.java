/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TbAdmUsuariosComponente;
import com.datamarket.converter.TbAdmUsuariosConverter;
import com.datamarket.email.Email;
import com.datamarket.email.EmailBean;
import com.datamarket.entidades.TbAdmUsuarios;
import com.datamarket.entidades.TbEjecutivos;
import com.datamarket.facades.TbAdmRolesFacade;
import com.datamarket.facades.TbAdmUsuariosFacade;
import com.datamarket.facades.TbEjecutivosFacade;
import com.datamarket.facades.TbEmpresaComercialFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Andrés
 */
@Named
@ViewScoped
public class CrearUsuario implements Serializable {

    private TbAdmUsuariosComponente usuarioComponente;
    private TbAdmUsuariosComponente usuarioComponenteEliminar;
    private TbAdmUsuarios nuevoUsuario;
    private TbAdmUsuarios usuarioEliminar;
    private String confirmarPassword;
    private List<TbAdmUsuarios> usuariosExistentes;
    private List<TbAdmUsuariosComponente> usuariosExistentesComponente;
    private TbEjecutivos ejecutivo;

    @Inject
    TbAdmUsuariosFacade usuariosFacade;
    @Inject
    TbAdmUsuariosConverter usuariosConverter;
    @Inject
    TbAdmRolesFacade rolesFacade;
    @Inject
    TbEjecutivosFacade ejecutivosFacade;
    @Inject
    ObjetosSesion session;
    @Inject
    TbEmpresaComercialFacade empresaComercialFacade;
    @Inject
    EmailBean emailBean;

    @PostConstruct
    public void init() {

        usuarioComponente = new TbAdmUsuariosComponente();
        usuariosExistentes = usuariosFacade.getAllUsuarios();
        usuariosExistentesComponente = usuariosConverter.convertirEntidadAComponenteMostrar(usuariosExistentes);

    }

    public void crearNuevoUsuario() {
        Email e = new Email();
        String pass = null;
        nuevoUsuario = new TbAdmUsuarios();
        nuevoUsuario = usuariosConverter.convertirComponenteAEntidad(usuarioComponente);
        nuevoUsuario.setUsCodUsuario(usuariosFacade.obtenerIdUltimoRegistro());
        pass = DigestUtils.md5Hex(usuarioComponente.getUs_password());
        nuevoUsuario.setUsPassword(pass);
        usuariosFacade.guardarTbAdmUsuarios(nuevoUsuario);
        usuarioComponente = new TbAdmUsuariosComponente();
        usuariosExistentes = usuariosFacade.getAllUsuarios();
        usuariosExistentesComponente = usuariosConverter.convertirEntidadAComponenteMostrar(usuariosExistentes);

        if (nuevoUsuario.getUsRol().getRoDescripcion().equals("ADMIN_SISTEMA") || nuevoUsuario.getUsRol().getRoDescripcion().equals("EJECUTIVO_CUENTA")) {
            ejecutivo = new TbEjecutivos();
            ejecutivo.setEjCodigo(nuevoUsuario.getUsCodUsuario());
            ejecutivo.setEjEstado("1");
            ejecutivosFacade.guardarTbEjecutivos(ejecutivo);
        }
        FacesContext.getCurrentInstance().addMessage("formIdUsuarios:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "EL USUARIO SE HA AGREGADO CORRECTAMENTE"));

        e.setContrasenia("pbdugrcvsmnzrjaz");
        e.setUsuarioCorreo("andrespenamantilla@gmail.com");
        e.setAsunto("NUEVO USUARIO");
        e.setMensaje("USTED" + session.getUsuarioEnSesion().getUsNombre()
                + "COMO ADMINISTRADOR DEL SISTEMA HA CREADO EL USUARIO: " + nuevoUsuario.getUsNombre()
                + "CON EL LOGIN" + nuevoUsuario.getUsLogin() + " CON TIPO USUARIO :" + nuevoUsuario.getUsRol().getRoDescripcion());
        e.setDestino(session.getUsuarioEnSesion().getUsEmail());
        if (emailBean.enviarCorreo(e) == true) {
            System.out.println("OK");
        } else {
            System.out.println("SAD");
        }
    }

    public void asignarUsuarioEliminacion(TbAdmUsuariosComponente componente) {
        usuarioEliminar = usuariosFacade.findById(componente.getUs_cod_usuario());
        usuarioComponenteEliminar = componente;

    }

    public void eliminarUsuario() {
        if (ejecutivosFacade.buscarPorId(usuarioEliminar.getUsCodUsuario()) != null && empresaComercialFacade.validarExistenciaEmpresasComerciales(usuarioEliminar.getUsCodUsuario()) == true) {
            FacesContext.getCurrentInstance().addMessage("formIdUsuarios:messageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "INCORRECTO", "EL USUARIO TIENE ASIGNADA INFORMACIÓN DE EJECUTIVO, Y EMPRESAS A SU CARGO POR LO CUAL NO SE PUEDE ELIMINAR"));
        }

        if (ejecutivosFacade.buscarPorId(usuarioEliminar.getUsCodUsuario()) != null) {
            TbEjecutivos aux = new TbEjecutivos();
            aux = ejecutivosFacade.buscarPorId(usuarioComponenteEliminar.getUs_cod_usuario());
            usuariosExistentesComponente.remove(usuarioComponenteEliminar);
            usuariosFacade.eliminarTbAdmUsuarios(usuarioEliminar);
ejecutivosFacade.eliminar(aux);
            FacesContext.getCurrentInstance().addMessage("formIdUsuarios:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "EL USUARIO FUÉ ELIMINADO"));
        }

        if (usuarioEliminar.getUsRol().getRoDescripcion().equals("ADMIN_BD")) {
            usuariosExistentesComponente.remove(usuarioComponenteEliminar);
            usuariosFacade.eliminarTbAdmUsuarios(usuarioEliminar);
        }

    }

    public String irDetalleUsuario(TbAdmUsuariosComponente componente) {

        session.setUsuarioModificar(usuariosFacade.findById(componente.getUs_cod_usuario()));
        session.setUsuarioModificarComponente(componente);
        return "irDetalleUsuario";

    }

    /*Getters & Setters*/
    public TbAdmUsuariosComponente getUsuarioComponente() {
        return usuarioComponente;
    }

    public void setUsuarioComponente(TbAdmUsuariosComponente usuarioComponente) {
        this.usuarioComponente = usuarioComponente;
    }

    public TbAdmUsuarios getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(TbAdmUsuarios nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }

    public String getConfirmarPassword() {
        return confirmarPassword;
    }

    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }

    public List<TbAdmUsuarios> getUsuariosExistentes() {
        return usuariosExistentes;
    }

    public void setUsuariosExistentes(List<TbAdmUsuarios> usuariosExistentes) {
        this.usuariosExistentes = usuariosExistentes;
    }

    public List<TbAdmUsuariosComponente> getUsuariosExistentesComponente() {
        return usuariosExistentesComponente;
    }

    public void setUsuariosExistentesComponente(List<TbAdmUsuariosComponente> usuariosExistentesComponente) {
        this.usuariosExistentesComponente = usuariosExistentesComponente;
    }
}
