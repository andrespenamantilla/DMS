/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.entidades.TbEjecutivos;
import com.datamarket.facades.TbEjecutivosFacade;
import com.datamarket.servicios.TbAdmUsuariosServicio;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Andres
 */
@Named
@ViewScoped
public class TbEjecutivoVista implements Serializable {

    @Inject
    TbEjecutivosFacade TbEF;

    @Inject
    TbAdmUsuariosServicio usuariosServicio;
    @Inject
    ObjetosSesion objetoSesion;

    /*Campo de tipo String  que hace referencia al 'ej_estado' en la tabla 'Tb_ejecutivos'*/
    private String ej_estado_vista;
    /*Campo de tipo String  que hace referencia al 'ej_codigo' en la tabla 'Tb_ejecutivos'*/
    private Integer ej_codigo_vista;
    /*Objeto de tipo 'TbEjecutivos' de nombre 'nuevoEjecutivo' el cual es el objeto que se persiste en la BD*/
    private TbEjecutivos nuevoEjecutivo;
    /*Objeto de tipo 'TbEjecutivos' de nombre 'modificarEjecutivo' el cual es el objeto que se modifica en la BD*/
    private TbEjecutivos modificarEjecutivo;
    /*Lista de tipo 'TbEjecutivos' de nombre 'allEjecutivos' que contiene todos los registros de la tabla 'Tb_ejecutivos'*/
    protected List<TbEjecutivos> allEjecutivos;
    protected Map<String, Integer> allUsuarios;


    /*Objeto tipo 'TbEjecutivos' de nombre 'ejecutivoSeleccionado' que contiene la 
     información de la selección de un row del dataTable de la vista*/
    private TbEjecutivos ejecutivoSeleccionado;

    /*Este método se ejecuta al momento de cargar una vista en la cual es llamada*/
    @PostConstruct
    public void init() {
        nuevoEjecutivo = new TbEjecutivos();
        allEjecutivos = TbEF.getAllEjecutivos();
        allUsuarios = usuariosServicio.getAllUsuariosMap();
    }

    /* GETTERS Y SETTERS*/
    public String getEj_estado_vista() {
        return ej_estado_vista;
    }

    public void setEj_estado_vista(String ej_estado_vista) {
        this.ej_estado_vista = ej_estado_vista;
    }

    public Integer getEj_codigo_vista() {
        return ej_codigo_vista;
    }

    public void setEj_codigo_vista(Integer ej_codigo_vista) {
        this.ej_codigo_vista = ej_codigo_vista;
    }

    public List<TbEjecutivos> getAllEjecutivos() {
        return allEjecutivos;
    }

    public void setAllEjecutivos(List<TbEjecutivos> allEjecutivos) {
        this.allEjecutivos = allEjecutivos;
    }

    public TbEjecutivos getModificarEjecutivo() {
        return modificarEjecutivo;
    }

    public void setModificarEjecutivo(TbEjecutivos modificarEjecutivo) {
        this.modificarEjecutivo = modificarEjecutivo;
    }

    public TbEjecutivos getEjecutivoSeleccionado() {
        return ejecutivoSeleccionado;
    }

    public void setEjecutivoSeleccionado(TbEjecutivos ejecutivoSeleccionado) {
        this.ejecutivoSeleccionado = ejecutivoSeleccionado;
    }

    public Map<String, Integer> getAllUsuarios() {
        return allUsuarios;
    }

    public void setAllUsuarios(Map<String, Integer> allUsuarios) {
        this.allUsuarios = allUsuarios;
    }

    
    
    
    /*Funcion insertar un nueva entidad 'TbEjecutivos' en la base de datos en la tabla 'Tb_Ejecutivos' */
    public void insertarTbEjecutivosVista() {
        try {

            /*recibe  los parametos  desde la vista al objeto 'nuevoEjecutivo'*/
            nuevoEjecutivo.setEjCodigo(ej_codigo_vista);
            nuevoEjecutivo.setEjEstado(ej_estado_vista);
            TbEF.guardarTbEjecutivos(nuevoEjecutivo);
            ej_codigo_vista = null;

            FacesContext.getCurrentInstance().addMessage("formIdEjecutivo:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se agrego un rol"));

        } catch (Exception e) {
        }

    }

    /*Método que retorna todos los  registros de la tabla 'Tb_Ejecutivos'*/
    public List<TbEjecutivos> obtenerAllEjecutivos() {
        return TbEF.getAllEjecutivos();

    }

    /*Método que modifica un registro en la base de datos por medio del objeto 'modificarEjecutivo'*/
    public void modificarTbEjecutivoVista() {

    }

    /*Método que elimina un registro de la base de datos por medio del objeto''*/
    public void eliminarTbEjecutivoVista() {

    }

    /*
     Función que carga en el registro del ejecutivo seleccionado desde la vista
     */
    public void asignarInformacionRegistroTbAdmEjecutivoVista() {
        try {
            /*
             Asigna el 'ejecutivoSeleccionado' que viene desde el dataTable 'tablaEjecutivosId'
             al 'objetoSesion' de tipo 'ObjetosSesion' por medio del método 'setEjecutivoSesion'
             */
            objetoSesion.setEjecutivoSesion(ejecutivoSeleccionado);
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.getExternalContext().redirect("ejeM.xhtml");
        } catch (IOException ex) {
        }
    }

    /**/
    public void cargarSesionInformacionRegistroTbEjecutivosVista() {
        HttpServletRequest oriRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        /*
         Si la request a la que hace la peticion termina con el nombre 'Tb_Adm_Roles_M.xhtml' entonces:
         */
        if (oriRequest.getPathInfo().endsWith("ejeM.xhtml")) {

            /*
             Si  objeto de nombre 'objetosSesion' y de tipo 'ObjetosSesion' no es nulo entonces:
             */
            if (objetoSesion.getEjecutivoSesion() != null) {

                /*
                 Al 'ro_codigo_vista' asignele la informacion que contiene el'objetosSesion' 
                 del rol que contenga y del ro_codigo que contenga
                 */
                this.ej_codigo_vista = objetoSesion.getEjecutivoSesion().getEjCodigo();


                /*
                 Al 'ro_descripcion_vista' asignele la informacion que contiene el'objetosSesion' 
                 del rol que contenga y del ro_descripcion que contenga
                 */
                this.ej_estado_vista = objetoSesion.getEjecutivoSesion().getEjEstado();
                /*
                 Vuelva nulo el 'objetosSesion' por medio de la funcion 'revome'
                 */
                objetoSesion.remove();
            } else {
                try {
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ctx.getExternalContext().redirect("ejeM.xhtml");
                } catch (IOException ex) {
                }
            }
        }
    }
    /**/

    public void noEliminadoTbEjecutivos() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar", "Usted no eliminó el ejecutivo del sistema."));
    }
}
