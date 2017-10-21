/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.entidades.TbAdmRoles;
import com.datamarket.facades.TbAdmRolesFacade;
import com.datamarket.facades.TbAdmUsuariosFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
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
public class TbAdmRolesVista implements Serializable {

    /*
     Declaracion de un objeto de nombre 'rolEliminar' de tipo 'TbAdmRoles' 
     el cual es el objeto que se elimina directamente contra la base de datos 
     */
    private TbAdmRoles rolEliminar;

    /*
     Declaracion de un objeto de nombre 'rolSeleccionado' de tipo 'TbAdmRoles' 
     el cual es el objeto que se elimina directamente contra la lista de objetos 'listaTbAdmRoles'
     */
    private TbAdmRoles rolSeleccionado;

    /*
     Declaracion de un objeto de nombre 'rolSesion' de tipo 'TbAdmRoles' que almacenara la informacion del registro 
     en sesión para ser modificado
     */
    private TbAdmRoles rolSesion;

    /*
     Declaración de una lista de tipo 'TbAdmRoles' que contendrá todos los registros de la tabla 'Tb_adm_roles'
     */
    protected List<TbAdmRoles> listaTbAdmRoles;

    /*
     Declaración de una variable de nombre 'nuevoRol' de tipo 'TbAdmRoles' que será el objeto el cual almacenará
     la información de un nuevo registro en la tabla 'Tb_adm_roles' en la base de datos.
     */
    private TbAdmRoles nuevoRol;

    /*
     Declaración de una variable  de tipo entero de nombre 'ro_codigo_vista' que contiene 
     la información a insertar en el campo 'ro_codigo' de la tabla 'Tb_Adm_roles' 
     */
    private Integer ro_codigo_vista;

    /*
     Declaración de una variable  de tipo String de nombre 'ro_descripcion_vista' que contiene 
     la información a insertar en el campo 'ro_descripcion' de la tabla 'Tb_Adm_roles' 
     */
    private String ro_descripcion_vista;

    /*
     Declaracion de una variable de nombre 'TbARF'  de tipo 'TbAdmRolesFacade' y que es un 'EJB'
     */
    @Inject
    TbAdmRolesFacade TbARF;
    @Inject
    TbAdmUsuariosFacade TbAUF;
    /*
     Declaracion de una variable de nombre 'objetosSesion'  de tipo 'ObjetosSesion' de tipo 'Inject'
     es de anotación 'SessionScoped'
     */
    @Inject
    protected ObjetosSesion objetosSesion;

    /*
     Funcion de tipo 'PostConstruct que ese carga siempre que se solicita una vista
     y antes de inicializar variables'
     Esta función carga en memoria  todos los roles en la lista 'listaTbAdmRoles' y 
     inicializa el objeto 'nuevoRol'
     */
    @PostConstruct
    public void init() {
        /*
         Se carga en la vista 'Tb_Adm_Roles_C.xhtml' la informacion del registro a modificar
         */
        cargarSesionInformacionRegistroTbAdmRolesVista();

        /*
         Se cargan los registros de la tabla 'Tb_Adm_Roles' en una lista en el sistema
         */
        listaTbAdmRoles = obtenerAllTbAdmRoles();

        nuevoRol = new TbAdmRoles();

    }

    public void TbAdmRolesVista() {

    }

    /*
     Este método retorna toda la lista de los registros de la tabla 'Tb_Adm_Roles' por medio del objeto 'TbARF' de tipo 'TbAdmRolesFacade'
     */
    private List<TbAdmRoles> obtenerAllTbAdmRoles() {
        return TbARF.getAllRoles();
    }

    /*
     GETTERS Y SETTERS DE LAS VARIABLES DECLARADAS
    
     Lista: --> 'listaTbAdmRoles'
     Entero: --> 'ro_codigo_vista'
     Cadena de caracteres: --> 'ro_descripcion_vista'
     TbAdmRol: --> 'nuevoRol'
     TbAdmRol: --> 'rolSeleccionado'
     TbAdmRol: --> 'rolSesion'

     */
    public List<TbAdmRoles> getListaTbAdmRoles() {
        return listaTbAdmRoles;
    }

    public void setListaTbAdmRoles(List<TbAdmRoles> listaTbAdmRoles) {
        this.listaTbAdmRoles = listaTbAdmRoles;
    }

    public Integer getRo_codigo_vista() {
        return ro_codigo_vista;
    }

    public void setRo_codigo_vista(Integer ro_codigo_vista) {
        this.ro_codigo_vista = ro_codigo_vista;
    }

    public String getRo_descripcion_vista() {
        return ro_descripcion_vista;
    }

    public void setRo_descripcion_vista(String ro_descripcion_vista) {
        this.ro_descripcion_vista = ro_descripcion_vista;
    }

    public TbAdmRoles getNuevoRol() {
        return nuevoRol;
    }

    public void setNuevoRol(TbAdmRoles nuevoRol) {
        this.nuevoRol = nuevoRol;
    }

    public TbAdmRoles getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(TbAdmRoles rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public TbAdmRoles getRolSesion() {
        return rolSesion;
    }

    public void setRolSesion(TbAdmRoles rolSesion) {
        this.rolSesion = rolSesion;
    }

    /*FUNCION INSERTAR UN ROL EN LA BASE DE DATOS*/
    public void insertarTbAdmRolesVista() {
        try {
            /*Se setea el parametro  'ro_codigo_vista' al objeto 'nuevoRol' */
            nuevoRol.setRoCodigo(ro_codigo_vista);

            /*Se setea el parametro  'ro_descripcion_vista' al objeto 'nuevoRol' */
            nuevoRol.setRoDescripcion(ro_descripcion_vista);

            /*Se setea envía el objeto 'nuevoRol' ya llenado por a la funcion 'persistir' del EJB 'TbARF' */
            TbARF.guardarTbAdmRoles(nuevoRol);

            /*
             Se vacía el objeto 'nuevoRol' para no usar el mismo objeto muchas veces
             */
            nuevoRol = new TbAdmRoles();

            /*
             Se vacía la  variable 'ro_codigo_vista
             */
            ro_codigo_vista = null;

            /*
             Se vacía la variable 'ro_descripcion_vista'
             */
            ro_descripcion_vista = "";

            FacesContext.getCurrentInstance().addMessage("formIdRoles:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se agrego un rol"));
        } catch (Exception e) {
        }
    }

    /*
     FUNCION ELIMINAR UN ROL EN LA BASE DE DATOS
     */
    public void eliminarTbAdmRolesVista() {
        try {
            /*
             Indica que el objeto ´rolEliminar´ de  tipo 'TbAdmRoles' es igual a la búsqueda del 'ro_codigo'
             del objeto 'rolSeleccionado' que contiene la informacion del registro seleccionado del dataTable
             'tablaRolesId' de la vista 'Tb_Adm_Roles'
             */
            rolEliminar = TbARF.buscarPorId(rolSeleccionado.getRoCodigo());

            /*
             Cuando el 'rolEliminar'  fue encontrado se elimina de la base de datos 
             por medio del objeto 'TbARF' de tipo 'TbAdmRolesFacade'
             */
            if (TbAUF.validarExistenciaUsuariosPorRol(rolSeleccionado.getRoCodigo()) == true) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Eliminar", "Usted  eliminó el rol del sistema."));
            } else {
                TbARF.eliminarTbAdmRoles(rolEliminar);

                /*
                 Se elimina de la lista 'listaTbAdmRoles' que se cargó en memoria el objeto 
                 'rolSeleccionado' que corresponde al del registro seleccionado del dataTable
                 'tablaRolesId' de la vista 'Tb_Adm_Roles', para que posteriormente se refresque
                 sólo el dataTable
                 */
                listaTbAdmRoles.remove(rolSeleccionado);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Eliminar", "Usted  eliminó el rol del sistema."));
            }
        } catch (Exception e) {
        }
    }

    /*
     FUNCION MODIFICAR UN ROL EN LA BASE DE DATOS
     */
    public void modificarTbAdmRolesVista() {
        try {
            /*
             Creación de un nuevo objeto de nombre 'rolActualizar' de tipo 'TbAdmRoles'
             que contendrá la información del
             */
            TbAdmRoles rolActualizar = new TbAdmRoles();

            /*
             Se setea el parámetro 'ro_codigo_vista' al objeto 'rolActualizar'
             */
            rolActualizar.setRoCodigo(ro_codigo_vista);

            /*
             Se setea el parámetro 'ro_descripcion_vista' al objeto 'rolActualizar'
             */
            rolActualizar.setRoDescripcion(ro_descripcion_vista);

            /*
             Por medio del objeto 'TbARF' de tipo 'TbmAdmRolesFacade' se envía el objeto 'rolActualizar' como
             parámetro a la función 'modificarTbAdmRoles'
        
             */
            TbARF.modificarTbAdmRoles(rolActualizar);

            rolActualizar = new TbAdmRoles();
            FacesContext.getCurrentInstance().addMessage("formIdRoles:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se Modificó el Rol"));
        } catch (Exception e) {
        }

    }

    /*FUNCION ROL NO ELIMINADO DE LA BASE DE DATOS*/
    public void noEliminadoTbAdmRolesVista() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar", "Usted no eliminó el rol del sistema."));
    }

    /*
     Función que carga en el registro del rol seleccionado desde la vista
     */
    public void asignarInformacionRegistroTbAdmRolesVista() {
        try {
            /*
             Asigna el 'rolSeleccionado' que viene desde el dataTable 'tablaRolesId'
             al 'objetoSesion' de tipo 'ObjetosSesion' por medio del método 'setRolSesion'
             */
            objetosSesion.setRolSesion(rolSeleccionado);
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.getExternalContext().redirect("rolM.xhtml");
        } catch (IOException ex) {
        }
    }

    public void cargarSesionInformacionRegistroTbAdmRolesVista() {
        HttpServletRequest oriRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        /*
         Si la request a la que hace la peticion termina con el nombre 'Tb_Adm_Roles_M.xhtml' entonces:
         */
        if (oriRequest.getPathInfo().endsWith("rolM.xhtml")) {

            /*
             Si  objeto de nombre 'objetosSesion' y de tipo 'ObjetosSesion' no es nulo entonces:
             */
            if (objetosSesion.getRolSesion() != null) {

                /*
                 Al 'ro_codigo_vista' asignele la informacion que contiene el'objetosSesion' 
                 del rol que contenga y del ro_codigo que contenga
                 */
                this.ro_codigo_vista = objetosSesion.getRolSesion().getRoCodigo();

                /*
                 Al 'ro_descripcion_vista' asignele la informacion que contiene el'objetosSesion' 
                 del rol que contenga y del ro_descripcion que contenga
                 */
                this.ro_descripcion_vista = objetosSesion.getRolSesion().getRoDescripcion();
                /*
                 Vuelva nulo el 'objetosSesion' por medio de la funcion 'revome'
                 */
                objetosSesion.remove();
            } else {
                try {
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ctx.getExternalContext().redirect("rolM.xhtml");
                } catch (IOException ex) {
                }
            }
        }
    }

}
