/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.entidades.TbAdmUsuarios;
import com.datamarket.entidades.TbDetalleCatalogo;
import com.datamarket.entidades.TbEmpresasProspecto;
import com.datamarket.entidades.TbPaises;
import com.datamarket.facades.TbDetalleCatalogoFacade;
import com.datamarket.facades.TbEmpresasProspectoFacade;
import com.datamarket.facades.TbPaisesFacade;
import com.datamarket.servicios.TbDetalleCatalogoServicio;
import com.datamarket.servicios.TbPaisesServicio;
import com.datamarket.validaciones.Caracter;
import com.datamarket.validaciones.Email;
import com.datamarket.validaciones.Numeros;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Andres
 */
@Named
@SessionScoped
public class TbEmpresasProspectoVista implements Serializable {

    @Inject
    TbEmpresasProspectoFacade TbEPF;
    @Inject
    TbDetalleCatalogoServicio TbDCS;
    @Inject
    TbDetalleCatalogoFacade TbDCF;
    private TbEmpresasProspecto empresaProspectoNueva;
    @Inject
    ObjetosSesion objetosSesion;
    @Inject
    TbPaisesFacade paisesFacade;
    @Inject
    TbPaisesServicio paisesServicio;

    private TbAdmUsuarios usuarioEnSesion;
    private Map<String, String> listaPaisesSistemaMap;
    private Map<String, String> listaDepartamentosPorPaisMap;
    private Map<String, String> listaCiudadesPorDepartamentoMap;
    private TbPaises selectedPais;

    @PostConstruct
    public void init() {

        empresaProspectoNueva = new TbEmpresasProspecto();
        catalogosTodosCargos();
        categoriasCargos = TbDCS.getAllCargosMap();
        listaPaisesSistemaMap = paisesServicio.getAllPaisesMap();

    }
    protected List<TbDetalleCatalogo> catalogosPorCargo;
    protected Map<String, String> categoriasCargos;
    /* 
 
     */
    @NotNull(message = "El código de la empresa a prospectar es requerido")
    Integer pe_empresa_vista;
    /* 
 
     */
    @NotNull(message = "El nombre de la Empresa a prospectar  es requerido")
    @Caracter(message = "Escriba por favor una palabra válida")
    String pe_nombre_vista;
    /* 
 
     */
    @NotNull(message = "El número de la empresa es requerido")
    @Numeros(message = "El campo tiene que ser numérico")
    String pe_numero_id_vista;

    /* 
     Dígito de verificación
     */
    String pe_dv_vista;
    /* 
 
     */
    @NotNull(message = "La direccion de la empresa a prospectar es requerido")
    String pe_direccion_vista;
    /* 
 
     */
    @NotNull(message = "El país de la empresa a prospectar es requerido")
    @Caracter(message = "Escriba una palabra válida")
    String pe_pais_vista;
    /* 
 
     */
    @NotNull(message = "El departamento de la empresa a prospectar es requerido")
    @Caracter(message = "Escriba una palabra válida")
    String pe_departamento_vista;
    /* 
 
     */
    @NotNull(message = "La ciudad de la empresa a prospectar es requerido")
    @Caracter(message = "Escriba una palabra válida")
    String pe_ciudad_vista;
    /* 
 
     */
    @NotNull(message = "El teléfono de la empresa a prospectar es requerido")
    String pe_telefono_vista;
    /* 
 
     */
    @Email(message = "Escriba una dirección de direccion de correo electrónico válida")
    String pe_email_vista;
    /* 
 
     */

    String pe_sitio_web_vista = "";
    /* 
 
     */
    @NotNull(message = "El sector económico de le empresa a prospectar es requerido")
    Integer pe_sector_vista;
    /* 
 
     */
    @NotNull(message = "Los productos de la empresa a prospectar son requeridos")
    @Caracter(message = "Escriba una palabra válida")
    String pe_productos_vista;
    /* 
 
     */
    Integer pe_ejecutivo_vista;
    /* 
 
     */
    @NotNull(message = "La referencia de prospecto de la empresa es requerida")
    String pe_referencia_vista;
    /* 
 
     */
    @Caracter(message = "Ingrese una palabrá válida")
    private String pe_nombre_contacto_vista = null;

    public TbEmpresasProspectoVista() {
    }
    /* 
 
     */

    @Caracter(message = "Ingrese una palabra válida")
    String pe_apellido_contacto_vista;
    /* 
 
     */
    String pe_cargo_vista;
    /* 
 
     */
    String pe_area_vista;
    /* 
 
     */
    String pe_descripcion_funcion_vista;
    /* 
 
     */
    Date pe_fecha_creacion_vista;

    public TbEmpresasProspectoFacade getTbEPF() {
        return TbEPF;
    }

    public void setTbEPF(TbEmpresasProspectoFacade TbEPF) {
        this.TbEPF = TbEPF;
    }

    public Integer getPe_empresa_vista() {
        return pe_empresa_vista;
    }

    public void setPe_empresa_vista(Integer pe_empresa_vista) {
        this.pe_empresa_vista = pe_empresa_vista;
    }

    public String getPe_nombre_vista() {
        return pe_nombre_vista;
    }

    public void setPe_nombre_vista(String pe_nombre_vista) {
        this.pe_nombre_vista = pe_nombre_vista;
    }

    public String getPe_numero_id_vista() {
        return pe_numero_id_vista;
    }

    public void setPe_numero_id_vista(String pe_numero_id_vista) {
        this.pe_numero_id_vista = pe_numero_id_vista;
    }

    public String getPe_dv_vista() {
        return pe_dv_vista;
    }

    public void setPe_dv_vista(String pe_dv_vista) {
        this.pe_dv_vista = pe_dv_vista;
    }

    public String getPe_direccion_vista() {
        return pe_direccion_vista;
    }

    public void setPe_direccion_vista(String pe_direccion_vista) {
        this.pe_direccion_vista = pe_direccion_vista;
    }

    public String getPe_pais_vista() {
        return pe_pais_vista;
    }

    public void setPe_pais_vista(String pe_pais_vista) {
        this.pe_pais_vista = pe_pais_vista;
    }

    public String getPe_departamento_vista() {
        return pe_departamento_vista;
    }

    public void setPe_departamento_vista(String pe_departamento_vista) {
        this.pe_departamento_vista = pe_departamento_vista;
    }

    public String getPe_ciudad_vista() {
        return pe_ciudad_vista;
    }

    public void setPe_ciudad_vista(String pe_ciudad_vista) {
        this.pe_ciudad_vista = pe_ciudad_vista;
    }

    public String getPe_telefono_vista() {
        return pe_telefono_vista;
    }

    public void setPe_telefono_vista(String pe_telefono_vista) {
        this.pe_telefono_vista = pe_telefono_vista;
    }

    public String getPe_email_vista() {
        return pe_email_vista;
    }

    public void setPe_email_vista(String pe_email_vista) {
        this.pe_email_vista = pe_email_vista;
    }

    public String getPe_sitio_web_vista() {
        return pe_sitio_web_vista;
    }

    public void setPe_sitio_web_vista(String pe_sitio_web_vista) {
        this.pe_sitio_web_vista = pe_sitio_web_vista;
    }

    public Integer getPe_sector_vista() {
        return pe_sector_vista;
    }

    public void setPe_sector_vista(Integer pe_sector_vista) {
        this.pe_sector_vista = pe_sector_vista;
    }

    public Integer getPe_ejecutivo_vista() {
        return pe_ejecutivo_vista;
    }

    public void setPe_ejecutivo_vista(Integer pe_ejecutivo_vista) {
        this.pe_ejecutivo_vista = pe_ejecutivo_vista;
    }

    public String getPe_referencia_vista() {
        return pe_referencia_vista;
    }

    public void setPe_referencia_vista(String pe_referencia_vista) {
        this.pe_referencia_vista = pe_referencia_vista;
    }

    public String getPe_nombre_contacto_vista() {
        return pe_nombre_contacto_vista;
    }

    public void setPe_nombre_contacto_vista(String pe_nombre_contacto_vista) {
        this.pe_nombre_contacto_vista = pe_nombre_contacto_vista;
    }

    public String getPe_apellido_contacto_vista() {
        return pe_apellido_contacto_vista;
    }

    public void setPe_apellido_contacto_vista(String pe_apellido_contacto_vista) {
        this.pe_apellido_contacto_vista = pe_apellido_contacto_vista;
    }

    public String getPe_cargo_vista() {
        return pe_cargo_vista;
    }

    public void setPe_cargo_vista(String pe_cargo_vista) {
        this.pe_cargo_vista = pe_cargo_vista;
    }

    public String getPe_area_vista() {
        return pe_area_vista;
    }

    public void setPe_area_vista(String pe_area_vista) {
        this.pe_area_vista = pe_area_vista;
    }

    public String getPe_descripcion_funcion_vista() {
        return pe_descripcion_funcion_vista;
    }

    public void setPe_descripcion_funcion_vista(String pe_descripcion_funcion_vista) {
        this.pe_descripcion_funcion_vista = pe_descripcion_funcion_vista;
    }

    public Date getPe_fecha_creacion_vista() {
        return pe_fecha_creacion_vista;
    }

    public void setPe_fecha_creacion_vista(Date pe_fecha_creacion_vista) {
        this.pe_fecha_creacion_vista = pe_fecha_creacion_vista;
    }

    public String getPe_productos_vista() {
        return pe_productos_vista;
    }

    public void setPe_productos_vista(String pe_productos_vista) {
        this.pe_productos_vista = pe_productos_vista;
    }

    public Map<String, String> getCategoriasCargos() {
        return categoriasCargos;
    }

    public void setCategoriasCargos(Map<String, String> categoriasCargos) {
        this.categoriasCargos = categoriasCargos;
    }

    public List<TbDetalleCatalogo> getCatalogosPorCargo() {
        return catalogosPorCargo;
    }

    public void setCatalogosPorCargo(List<TbDetalleCatalogo> catalogosPorCargo) {
        this.catalogosPorCargo = catalogosPorCargo;
    }

    public List catalogosTodosCargos() {
        return TbDCF.getCatalogosByCargo();
    }

    public TbAdmUsuarios getUsuarioEnSesion() {
        return usuarioEnSesion;
    }

    public void setUsuarioEnSesion(TbAdmUsuarios usuarioEnSesion) {
        this.usuarioEnSesion = usuarioEnSesion;
    }

    public Map<String, String> getListaPaisesSistemaMap() {
        return listaPaisesSistemaMap;
    }

    public void setListaPaisesSistemaMap(Map<String, String> listaPaisesSistemaMap) {
        this.listaPaisesSistemaMap = listaPaisesSistemaMap;
    }

    public Map<String, String> getListaDepartamentosPorPaisMap() {
        return listaDepartamentosPorPaisMap;
    }

    public void setListaDepartamentosPorPaisMap(Map<String, String> listaDepartamentosPorPaisMap) {
        this.listaDepartamentosPorPaisMap = listaDepartamentosPorPaisMap;
    }

    public Map<String, String> getListaCiudadesPorDepartamentoMap() {
        return listaCiudadesPorDepartamentoMap;
    }

    public void setListaCiudadesPorDepartamentoMap(Map<String, String> listaCiudadesPorDepartamentoMap) {
        this.listaCiudadesPorDepartamentoMap = listaCiudadesPorDepartamentoMap;
    }

    public void insertarTbEmpresasProspectoVista() {

        try {

            usuarioEnSesion = objetosSesion.getUsuarioEnSesion();
            pe_fecha_creacion_vista = new Date();
            empresaProspectoNueva.setPeEmpresa(pe_empresa_vista);
            empresaProspectoNueva.setPeNombre(pe_nombre_vista);
            empresaProspectoNueva.setPeNumeroId(pe_numero_id_vista);
            empresaProspectoNueva.setPeDv(pe_dv_vista);
            empresaProspectoNueva.setPeDireccion(pe_direccion_vista);
            empresaProspectoNueva.setPePais(pe_pais_vista);
            empresaProspectoNueva.setPeDepartamento(pe_departamento_vista);
            empresaProspectoNueva.setPeCiudad(pe_ciudad_vista);
            empresaProspectoNueva.setPeTelefono(pe_telefono_vista);
            empresaProspectoNueva.setPeEmail(pe_email_vista);
            empresaProspectoNueva.setPeSitioWeb(pe_sitio_web_vista);
            empresaProspectoNueva.setPeSector(pe_sector_vista);
            empresaProspectoNueva.setPeProductos(pe_productos_vista);
            empresaProspectoNueva.setPeEjecutivo(usuarioEnSesion.getUsCodUsuario());
            empresaProspectoNueva.setPeReferencia(pe_referencia_vista);
            empresaProspectoNueva.setPeNombreContacto(pe_nombre_contacto_vista);
            empresaProspectoNueva.setPeApellidoContacto(pe_apellido_contacto_vista);
            empresaProspectoNueva.setPeCargo(pe_cargo_vista);
            empresaProspectoNueva.setPeArea(pe_area_vista);
            empresaProspectoNueva.setPeDescripcionFuncion(pe_descripcion_funcion_vista);
            empresaProspectoNueva.setPeFechaCreacion(pe_fecha_creacion_vista);
            TbEPF.guardarTbEmpresasProspecto(empresaProspectoNueva);
        } catch (Exception e) {
        }

    }

    public void buscarDepartamentosPorPais() {
        /**/
        selectedPais = new TbPaises();
        selectedPais = paisesFacade.findById(pe_pais_vista);
        this.listaDepartamentosPorPaisMap = paisesServicio.getAllDepartamentosMap(selectedPais);
    }

    public void hola() {


    }

}
