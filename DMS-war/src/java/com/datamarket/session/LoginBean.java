/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.session;

import com.datamarket.entidades.TbAdmUsuarios;
import com.datamarket.facades.TbAdmUsuariosFacade;
import com.datamarket.vistas.ObjetosSesion;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.PermitAll;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Andres
 */
@Named
@SessionScoped
@PermitAll
public class LoginBean implements Serializable {

    @Inject
    TbAdmUsuariosFacade TbAUF;
    @Inject
    ObjetosSesion objetosSesion;
//usuario de tipo 'TbAdmUsuarios' que estará en sesión
    private TbAdmUsuarios usuarioEnSesion;

    //Campo referencia a nombre de usuario
    String userName;
    //Campo referencia a contraseña del usuario
    String password;
    /*Entero para la validación de Permisos*/
    Integer tipoDeUsuario;
    String rolUsuario;

    /*GETTERS Y SETTERS METHODS*/
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(Integer tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public TbAdmUsuarios getUsuarioEnSesion() {
        return usuarioEnSesion;
    }

    public void setUsuarioEnSesion(TbAdmUsuarios usuarioEnSesion) {
        this.usuarioEnSesion = usuarioEnSesion;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    /*Método que incia una sesión en el sistema*/
    public String loginSesion() throws IOException {

        System.out.println("Entró");
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            /*Busca el usuario en sesión por los parametros 'userName' y 'password' para tenerlo en memoria*/
            usuarioEnSesion = TbAUF.buscarUsuarioPorLoginAndPassword(userName, password);
            objetosSesion.setUsuarioEnSesion(usuarioEnSesion);
            if (usuarioEnSesion == null) {
            } else {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidadVista", usuarioEnSesion);

                /*Pide una petición de logueo con los parametros 'userName' y 'password'*/
                request.login(userName, password);

                /*Si el usuario existe y es de tipo ADMIN_SISTEMA redireccione a su menú principal*/
                if (request.isUserInRole("ADMIN_SISTEMA")) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/DMS-war/faces/privado/admin.xhtml");
                    tipoDeUsuario = 1;
                    rolUsuario = "ADMINISTRADOR DEL SISTEMA";
                    return "SUCESS";
                } /*Si el usuario existe y es de tipo ADMIN_BD redireccione a su menú principal*/ else if (request.isUserInRole("ADMIN_BD")) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/DMS-war/faces/adminbd/adminbd.xhtml");
                    tipoDeUsuario = 2;
                    rolUsuario = "ADMINISTRADOR DE LA BASE DE DATOS";
                } /*Si el usuario existe y es de tipo EJECUTIVO_CUENTA redireccione a su menú principal*/ else if (request.isUserInRole("EJECUTIVO_CUENTA")) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/DMS-war/faces/comercial/ejecutivo.xhtml");
                    tipoDeUsuario = 3;
                    rolUsuario = "EJECUTIVO DE CUENTA";

                }
            }
        } catch (ServletException | IOException ex) {
            /*Si el usuario no existe o se genera un error redireccione a la página de error*/

            // Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/EnterpriseApplicationDMS-war/faces/error.xhtml");

        }
        return "ERROR";
    }

    /*Este método cierra la sesión en memoria*/
    public void logout() throws IOException {

        /*Vuelve nulo el usuario en sesión*/
        this.usuarioEnSesion = null;
        this.userName = null;
        this.password = null;
        this.tipoDeUsuario = null;
        this.rolUsuario = null;
        objetosSesion.remove();
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/EnterpriseApplicationDMS-war/faces/loginF.xhtml");

        } catch (ServletException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
