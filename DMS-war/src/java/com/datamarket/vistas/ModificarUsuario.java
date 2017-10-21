/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TbAdmUsuariosComponente;
import com.datamarket.converter.TbAdmUsuariosConverter;
import com.datamarket.entidades.TbAdmUsuarios;
import com.datamarket.entidades.TbEjecutivos;
import com.datamarket.facades.TbAdmUsuariosFacade;
import com.datamarket.facades.TbEjecutivosFacade;
import java.io.Serializable;
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
@ViewScoped
@Named
public class ModificarUsuario implements Serializable {

    @Inject
    ObjetosSesion session;
    @Inject
    TbAdmUsuariosConverter usuariosConverter;
    @Inject
    TbAdmUsuariosFacade usuariosFacade;
    @Inject
    TbEjecutivosFacade ejecutivosFacade;

    private boolean modificarPassword;
    private boolean ocultarPanel;

    TbAdmUsuarios usuarioModificar;
    private TbAdmUsuariosComponente usuarioModificarComponente;
    private String password;
    private String confirmar;
    private String passwordAlmacenado;
    private TbEjecutivos ejecutivoModificar;
    private boolean ocultarEjecutivoInformacion;

    @PostConstruct
    public void init() {
        usuarioModificarComponente = session.getUsuarioModificarComponente();
        usuarioModificar = usuariosFacade.buscarPorId(usuarioModificarComponente.getUs_cod_usuario());
        modificarPassword = false;
        ocultarPanel = true;
        passwordAlmacenado = usuarioModificarComponente.getUs_password();
        ocultarEjecutivoInformacion = true;

        if (usuarioModificar.getUsRol().getRoDescripcion().equals("ADMIN_SISTEMA") || usuarioModificar.getUsRol().getRoDescripcion().equals("EJECUTIVO_CUENTA")) {
            ejecutivoModificar = ejecutivosFacade.buscarPorId(usuarioModificarComponente.getUs_cod_usuario());
            ocultarEjecutivoInformacion = false;

        }
    }

    public void cambiarEstadoFormulario() {
        modificarPassword = true;
        ocultarPanel = false;
        usuarioModificarComponente.setUs_password(null);

    }

    public void cambiarEstadoFormularioPassword() {
        modificarPassword = false;
        ocultarPanel = true;

    }

    public void modificarUsuario() {

        if (modificarPassword == false && ocultarPanel == true) {

            usuarioModificar = new TbAdmUsuarios();
            usuarioModificar = usuariosConverter.convertirComponenteAEntidad(usuarioModificarComponente);
            usuarioModificar.setUsPassword(passwordAlmacenado);
            usuariosFacade.actualizar(usuarioModificar);
            if (usuarioModificar.getUsRol().getRoDescripcion().equals("ADMIN_SISTEMA") || usuarioModificar.getUsRol().getRoDescripcion().equals("EJECUTIVO_CUENTA")) {
                ejecutivosFacade.actualizar(ejecutivoModificar);
            }
            FacesContext.getCurrentInstance().addMessage("formIdUsuarios:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "EL USUARIO SE HA SIDO ACTUALIZADO CORRECTAMENTE"));
            modificarPassword = false;
            ocultarPanel = true;

        } else {

            if (!password.equals(confirmar)) {
                FacesContext.getCurrentInstance().addMessage("formIdUsuarios:messageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "INCORRECTO", "LAS CLAVES NO SON IGUALES"));
            } else {
                usuarioModificar = new TbAdmUsuarios();
                usuarioModificar = usuariosConverter.convertirComponenteAEntidad(usuarioModificarComponente);
                usuarioModificar.setUsPassword(DigestUtils.md5Hex(password));
                passwordAlmacenado = DigestUtils.md5Hex(password);
                usuariosFacade.actualizar(usuarioModificar);
                if (usuarioModificar.getUsRol().getRoDescripcion().equals("ADMIN_SISTEMA") || usuarioModificar.getUsRol().getRoDescripcion().equals("EJECUTIVO_CUENTA")) {
                    ejecutivosFacade.actualizar(ejecutivoModificar);
                }
                FacesContext.getCurrentInstance().addMessage("formIdUsuarios:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "EL USUARIO SE HA SIDO ACTUALIZADO CORRECTAMENTE"));
                modificarPassword = false;
                ocultarPanel = true;
            }
        }
    }

    /*Getters & Setters*/
    public TbAdmUsuariosComponente getUsuarioModificarComponente() {
        return usuarioModificarComponente;
    }

    public void setUsuarioModificarComponente(TbAdmUsuariosComponente usuarioModificarComponente) {
        this.usuarioModificarComponente = usuarioModificarComponente;
    }

    public boolean isModificarPassword() {
        return modificarPassword;
    }

    public void setModificarPassword(boolean modificarPassword) {
        this.modificarPassword = modificarPassword;
    }

    public boolean isOcultarPanel() {
        return ocultarPanel;
    }

    public void setOcultarPanel(boolean ocultarPanel) {
        this.ocultarPanel = ocultarPanel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmar() {
        return confirmar;
    }

    public void setConfirmar(String confirmar) {
        this.confirmar = confirmar;
    }

    public TbEjecutivos getEjecutivoModificar() {
        return ejecutivoModificar;
    }

    public void setEjecutivoModificar(TbEjecutivos ejecutivoModificar) {
        this.ejecutivoModificar = ejecutivoModificar;
    }

    public boolean isOcultarEjecutivoInformacion() {
        return ocultarEjecutivoInformacion;
    }

    public void setOcultarEjecutivoInformacion(boolean ocultarEjecutivoInformacion) {
        this.ocultarEjecutivoInformacion = ocultarEjecutivoInformacion;
    }

}
