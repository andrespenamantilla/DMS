/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TbEmpresaProspectoComponente;
import com.datamarket.entidades.TbDepartamentos;
import com.datamarket.entidades.TbDepartamentosPK;
import com.datamarket.entidades.TbEmpresasProspecto;
import com.datamarket.entidades.TbPaises;
import com.datamarket.facades.TbDepartamentosFacade;
import com.datamarket.facades.TbEmpresasProspectoFacade;
import com.datamarket.facades.TbPaisesFacade;
import com.datamarket.servicios.TbDetalleCatalogoServicio;
import com.datamarket.servicios.TbPaisesServicio;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrés
 */
@ViewScoped
@Named
public class ProspectarEmpresa implements Serializable {

    @Inject
    TbPaisesServicio paisServicio;
    @Inject
    TbPaisesFacade paisFacade;
    @Inject
    TbDepartamentosFacade departamentosFacade;
    @Inject
    TbDetalleCatalogoServicio catalogoServicio;
    @Inject
    TbEmpresasProspectoFacade empresaProspectoFacade;
    @Inject
    ObjetosSesion session;
    private Map<String, String> paisesSistemaMap;
    private Map<String, String> departamentosSistemaMap;
    private Map<String, String> ciudadesSistemaMap;
    private Map<String, String> referenciaProspecto;
    private Map<String, String> areasCatalogo;
    private Map<String, String> cargosCatalogo;
    private Map<String, String> sectorCatalogo;

    private String paisId;
    private TbPaises paisSeleccionado;
    private TbDepartamentos departamentoSeleccionado;
    private TbEmpresaProspectoComponente empresaProspectoComponente;
    private TbEmpresasProspecto empresaProspectoNueva;

    @PostConstruct
    public void init() {
        paisesSistemaMap = paisServicio.getAllPaisesMap();
        empresaProspectoComponente = new TbEmpresaProspectoComponente();
        referenciaProspecto = catalogoServicio.getAllReferidoProspectoEmpresa();
        areasCatalogo = catalogoServicio.getAllAreasMap();
        cargosCatalogo = catalogoServicio.getAllCargosMap();
        sectorCatalogo = catalogoServicio.getAllSector();

    }

    /*Busca una lista de Map de departamentos por un país*/
    public void buscarDepartamentosPorPais() {

        paisId = empresaProspectoComponente.getPe_pais();
        empresaProspectoComponente.setPe_pais(paisId);
        paisSeleccionado = paisFacade.findById(paisId);
        departamentosSistemaMap = paisServicio.getAllDepartamentosMap(paisSeleccionado);
    }

    public void buscarCiudadesPorDepartamento() {
        departamentoSeleccionado = new TbDepartamentos();
        TbDepartamentosPK departamentoSeleccionadoPK = new TbDepartamentosPK();
        departamentoSeleccionadoPK.setDeCodigo(empresaProspectoComponente.getPe_departamento());
        departamentoSeleccionadoPK.setDePais(paisSeleccionado.getPaCodigo());
        departamentoSeleccionado = departamentosFacade.findById(departamentoSeleccionadoPK);
        ciudadesSistemaMap = paisServicio.getAllCiudadesMap(departamentoSeleccionado);
    }

    public void insertarEmpresaProspecto() {

        Date date = new Date();
        empresaProspectoNueva = new TbEmpresasProspecto();
        empresaProspectoNueva.setPeCargo(empresaProspectoComponente.getPe_cargo());
        empresaProspectoNueva.setPeArea(empresaProspectoComponente.getPe_area());
        empresaProspectoNueva.setPeEmpresa(empresaProspectoComponente.getPe_empresa());
        empresaProspectoNueva.setPeNombre(empresaProspectoComponente.getPe_nombre());
        empresaProspectoNueva.setPeNumeroId(empresaProspectoComponente.getPe_numero_id());
        empresaProspectoNueva.setPeDv(empresaProspectoComponente.getPe_dv());
        empresaProspectoNueva.setPeDireccion(empresaProspectoComponente.getPe_direccion());
        empresaProspectoNueva.setPeDepartamento(empresaProspectoComponente.getPe_departamento());
        empresaProspectoNueva.setPeCiudad(empresaProspectoComponente.getPe_ciudad());
        empresaProspectoNueva.setPeTelefono(empresaProspectoComponente.getPe_telefono());
        empresaProspectoNueva.setPeEmail(empresaProspectoComponente.getPe_email());
        empresaProspectoNueva.setPeSitioWeb(empresaProspectoComponente.getPe_sitio_web());
        empresaProspectoNueva.setPeSector(empresaProspectoComponente.getPe_sector());
        empresaProspectoNueva.setPeProductos(empresaProspectoComponente.getPe_productos());
        empresaProspectoNueva.setPeReferencia(empresaProspectoComponente.getPe_referencia());
        empresaProspectoNueva.setPeNombreContacto(empresaProspectoComponente.getPe_nombre_contacto());
        empresaProspectoNueva.setPeApellidoContacto(empresaProspectoComponente.getPe_apellido_contacto());
        empresaProspectoNueva.setPeDescripcionFuncion(empresaProspectoComponente.getPe_descripcion_funcion());
        empresaProspectoNueva.setPeFechaCreacion(date);
        empresaProspectoNueva.setPePais(paisId);
        empresaProspectoNueva.setPeEjecutivo(session.getUsuarioEnSesion().getUsCodUsuario());

        try {
            empresaProspectoComponente = new TbEmpresaProspectoComponente();
            empresaProspectoFacade.guardarTbEmpresasProspecto(empresaProspectoNueva);
            empresaProspectoNueva = new TbEmpresasProspecto();
            FacesContext.getCurrentInstance().addMessage("nuevaEmpresaProspectoId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "SU SOLICITUD FUE CREADA"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("nuevaEmpresaProspectoId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "NO SE PUDO CREAR SU SOLICITUD"));
        }

    }

    public void validarKey(FacesContext ctx, UIComponent component, Object value) {
        String key = value.toString();
        if (empresaProspectoFacade.validarExistencia(key) == true) {
            FacesMessage msg = new FacesMessage("ERROR", "Escoja otra, esa llave ya existe.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }

    public void validaKey() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
        FacesContext.getCurrentInstance().addMessage(":nuevaEmpresaProspectoId:panelNuevoProspectoId:messageIdx", new FacesMessage(FacesMessage.SEVERITY_ERROR, "CORRECTO", "SU SOLICITUD FUE CREADA"));

    }

    public void validarNit(FacesContext ctx, UIComponent component, Object value) {
        String nit = value.toString();
        if (empresaProspectoFacade.validarNitExistente(nit) == false) {
            FacesMessage msg = new FacesMessage("ERROR", "Escoja otro nombre, esa empresa ya existe.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }

    public void validarNombreEmpresa(FacesContext ctx, UIComponent component, Object value) {
        String nombre = value.toString();
        if (empresaProspectoFacade.validarNombreExistente(nombre) == false) {
            FacesMessage msg = new FacesMessage("ERROR", "Escoja otro nombre, esa empresa ya existe.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }

    /*Getters & Setters*/
    public Map<String, String> getPaisesSistemaMap() {
        return paisesSistemaMap;
    }

    public void setPaisesSistemaMap(Map<String, String> paisesSistemaMap) {
        this.paisesSistemaMap = paisesSistemaMap;
    }

    public String getPaisId() {
        return paisId;
    }

    public void setPaisId(String paisId) {
        this.paisId = paisId;
    }

    public Map<String, String> getDepartamentosSistemaMap() {
        return departamentosSistemaMap;
    }

    public void setDepartamentosSistemaMap(Map<String, String> departamentosSistemaMap) {
        this.departamentosSistemaMap = departamentosSistemaMap;
    }

    public Map<String, String> getCiudadesSistemaMap() {
        return ciudadesSistemaMap;
    }

    public void setCiudadesSistemaMap(Map<String, String> ciudadesSistemaMap) {
        this.ciudadesSistemaMap = ciudadesSistemaMap;
    }

    public TbEmpresaProspectoComponente getEmpresaProspectoComponente() {
        return empresaProspectoComponente;
    }

    public void setEmpresaProspectoComponente(TbEmpresaProspectoComponente empresaProspectoComponente) {
        this.empresaProspectoComponente = empresaProspectoComponente;
    }

    public Map<String, String> getReferenciaProspecto() {
        return referenciaProspecto;
    }

    public void setReferenciaProspecto(Map<String, String> referenciaProstecto) {
        this.referenciaProspecto = referenciaProstecto;
    }

    public Map<String, String> getAreasCatalogo() {
        return areasCatalogo;
    }

    public void setAreasCatalogo(Map<String, String> areasCatalogo) {
        this.areasCatalogo = areasCatalogo;
    }

    public Map<String, String> getCargosCatalogo() {
        return cargosCatalogo;
    }

    public void setCargosCatalogo(Map<String, String> cargosCatalogo) {
        this.cargosCatalogo = cargosCatalogo;
    }

    public Map<String, String> getSectorCatalogo() {
        return sectorCatalogo;
    }

    public void setSectorCatalogo(Map<String, String> sectorCatalogo) {
        this.sectorCatalogo = sectorCatalogo;
    }

}
