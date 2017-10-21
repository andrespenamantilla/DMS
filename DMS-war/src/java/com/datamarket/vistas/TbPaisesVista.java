/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.entidades.TbCiudades;
import com.datamarket.entidades.TbCiudadesPK;
import com.datamarket.entidades.TbDepartamentos;
import com.datamarket.entidades.TbDepartamentosPK;
import com.datamarket.entidades.TbPaises;
import com.datamarket.facades.TbCiudadesFacade;
import com.datamarket.facades.TbDepartamentosFacade;
import com.datamarket.facades.TbPaisesFacade;
import com.datamarket.servicios.TbPaisesServicio;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.datamarket.validaciones.Caracter;
import com.datamarket.validaciones.Numeros;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andrés
 */
@Named
@SessionScoped
public class TbPaisesVista implements Serializable {

    private Map<String, String> listaPaisesSistemaMap;
    private Map<String, String> listaDepartamentosPorPaisMap;
    private Map<String, String> listaCiudadesPorDepartamentoMap;

    @Inject
    TbPaisesFacade paisesFacade;
    @Inject
    TbPaisesServicio paisesServicio;
    @Inject
    TbDepartamentosFacade departamentoFacade;
    @Inject
    TbCiudadesFacade ciudadFacade;

    TbPaises nuevoPais;
    TbDepartamentos nuevoDepartamento;
    TbCiudades nuevaCiudad;
    TbPaises selectedPais;
    TbDepartamentos selectedDepartamento;

    private String paisSeleccionado;
    private Integer departamentoSeleccionado;
    private String codigo_departamento;
    private String codigo_ciudad;

    @PostConstruct
    public void init() {
        nuevoPais = new TbPaises();
        nuevoDepartamento = new TbDepartamentos();
        nuevaCiudad = new TbCiudades();

        // todosLosPaisesVista();
        listaPaisesSistemaMap = paisesServicio.getAllPaisesMap();
    }
    @Numeros
    String pa_codigo_vista;

    @Caracter
    @NotNull(message = "El nombre del País no puede estar vacío.")
    String pa_nombre_vista;

    @Caracter
    String de_nombre_vista;

    @Caracter
    String ci_nombre_vista;

    /*Getters & Setters*/
    public String getPa_codigo_vista() {
        return pa_codigo_vista;
    }

    public void setPa_codigo_vista(String pa_codigo_vista) {
        this.pa_codigo_vista = pa_codigo_vista;
    }

    public String getPa_nombre_vista() {
        return pa_nombre_vista;
    }

    public void setPa_nombre_vista(String pa_nombre_vista) {
        this.pa_nombre_vista = pa_nombre_vista;
    }

    public TbPaises getNuevoPais() {
        return nuevoPais;
    }

    public void setNuevoPais(TbPaises nuevoPais) {
        this.nuevoPais = nuevoPais;
    }

    public Map<String, String> getListaPaisesSistemaMap() {
        return listaPaisesSistemaMap;
    }

    public void setListaPaisesSistemaMap(Map<String, String> listaPaisesSistemaMap) {
        this.listaPaisesSistemaMap = listaPaisesSistemaMap;
    }

    public String getDe_nombre_vista() {
        return de_nombre_vista;
    }

    public void setDe_nombre_vista(String de_nombre_vista) {
        this.de_nombre_vista = de_nombre_vista;
    }

    public String getPaisSeleccionado() {
        return paisSeleccionado;
    }

    public void setPaisSeleccionado(String paisSeleccionado) {
        this.paisSeleccionado = paisSeleccionado;
    }

    public String getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(String codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    public Map<String, String> getListaDepartamentosPorPaisMap() {
        return listaDepartamentosPorPaisMap;
    }

    public void setListaDepartamentosPorPaisMap(Map<String, String> listaDepartamentosPorPaisMap) {
        this.listaDepartamentosPorPaisMap = listaDepartamentosPorPaisMap;
    }

    public Integer getDepartamentoSeleccionado() {
        return departamentoSeleccionado;
    }

    public void setDepartamentoSeleccionado(Integer departamentoSeleccionado) {
        this.departamentoSeleccionado = departamentoSeleccionado;
    }

    public Map<String, String> getListaCiudadesPorDepartamentoMap() {
        return listaCiudadesPorDepartamentoMap;
    }

    public void setListaCiudadesPorDepartamentoMap(Map<String, String> listaCiudadesPorDepartamentoMap) {
        this.listaCiudadesPorDepartamentoMap = listaCiudadesPorDepartamentoMap;
    }

    public String getCodigo_ciudad() {
        return codigo_ciudad;
    }

    public void setCodigo_ciudad(String codigo_ciudad) {
        this.codigo_ciudad = codigo_ciudad;
    }

    public String getCi_nombre_vista() {
        return ci_nombre_vista;
    }

    public void setCi_nombre_vista(String ci_nombre_vista) {
        this.ci_nombre_vista = ci_nombre_vista;
    }

    /*Esta Función Inserta un país en la base de datos*/
    public void insertarPaisVista() {
        if (paisesFacade.validarExistenciaPaisPorNombre(pa_nombre_vista) == true) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR","El país ya existe."));

        } else {
            nuevoPais.setPaCodigo(pa_codigo_vista);
            nuevoPais.setPaNombre(pa_nombre_vista);
            paisesFacade.guardarTbPaises(nuevoPais);
            listaPaisesSistemaMap.put(nuevoPais.getPaNombre(), (nuevoPais.getPaCodigo()));
            this.pa_codigo_vista = "";
            this.pa_nombre_vista = "";
            nuevoPais = new TbPaises();
            //FacesContext.getCurrentInstance().addMessage("formCrearPaisId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "PAÍS CREADO", "PAÍS CREADO"));
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO","El país ya existe."));

        }
    }

    public void guardarDepartamentoVista() {
        TbPaises paisDepartamento;
        TbDepartamentosPK llaveDepartamento;
        llaveDepartamento = new TbDepartamentosPK();
        llaveDepartamento.setDeCodigo(codigo_departamento);
        llaveDepartamento.setDePais(paisSeleccionado.toString());

        paisDepartamento = paisesFacade.buscarPaisPorId(paisSeleccionado);

        nuevoDepartamento.setDeNombre(de_nombre_vista);
        nuevoDepartamento.setTbPaises(paisDepartamento);
        nuevoDepartamento.setTbDepartamentosPK(llaveDepartamento);

        departamentoFacade.guardarTbDepartamento(nuevoDepartamento);
        listaDepartamentosPorPaisMap.put(nuevoDepartamento.getDeNombre(), (nuevoDepartamento.getTbDepartamentosPK().getDeCodigo()));

        this.de_nombre_vista = "";
        this.codigo_departamento = "";
        //this.paisSeleccionado = null;
        nuevoDepartamento = new TbDepartamentos();
        FacesContext.getCurrentInstance().addMessage("formCrearPaisId:messageId2", new FacesMessage(FacesMessage.SEVERITY_INFO, "DEPARTAMENTO CREADO", "DEPARTAMENTO CREADO"));

    }

    public void buscarDepartamentosPorPais(Integer idPais) {

        /**/
        selectedPais = new TbPaises();
        selectedPais = paisesFacade.findById(paisSeleccionado.toString());
        this.listaDepartamentosPorPaisMap = paisesServicio.getAllDepartamentosMap(selectedPais);

    }

    public void buscarCiudadesPorDepartamento() {

        selectedDepartamento = new TbDepartamentos();
        TbDepartamentosPK selectedDepartamentoPK = new TbDepartamentosPK();
        selectedDepartamentoPK.setDePais(selectedPais.getPaCodigo());
        selectedDepartamentoPK.setDeCodigo(departamentoSeleccionado.toString());
        selectedDepartamento = departamentoFacade.findById(selectedDepartamentoPK);
        listaCiudadesPorDepartamentoMap = paisesServicio.getAllCiudadesMap(selectedDepartamento);
    }

    public void guardarCiudadVista() {
        try {
            nuevaCiudad = new TbCiudades();
            TbCiudadesPK ciudadPk = new TbCiudadesPK();
            ciudadPk.setCiPais(selectedDepartamento.getTbDepartamentosPK().getDePais());
            ciudadPk.setCiDepto(selectedDepartamento.getTbDepartamentosPK().getDeCodigo());
            ciudadPk.setCiCiudad(codigo_ciudad.toString());
            nuevaCiudad.setCiNombre(ci_nombre_vista);
            nuevaCiudad.setTbCiudadesPK(ciudadPk);

            ciudadFacade.guardarTbCiudades(nuevaCiudad);
            listaCiudadesPorDepartamentoMap.put(ci_nombre_vista, codigo_ciudad);
            this.ci_nombre_vista = "";
            this.codigo_ciudad = null;
            nuevaCiudad = new TbCiudades();
            FacesContext.getCurrentInstance().addMessage("formCrearPaisId:messageId3", new FacesMessage(FacesMessage.SEVERITY_INFO, "DEPARTAMENTO CREADO", "CIUDAD CREADA"));
        } catch (Exception e) {
        }

    }

    public void validarNombrePaisExistente(FacesContext ctx, UIComponent component, Object value) {
        String paisNombreValidar = value.toString();
        if (paisesFacade.validarExistenciaPaisPorNombre(paisNombreValidar) == true) {
            FacesMessage msg = new FacesMessage("ERROR", "ESCOJA OTRO NOMBRE ESE PAIS YA EXISTE.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }

}
