/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.components.TbEmpresasProspectoComponente;
import com.datamarket.converter.TbEmpresasProspectoConverter;
import com.datamarket.entidades.TbDepartamentosPK;
import com.datamarket.entidades.TbEmpresasProspecto;
import com.datamarket.facades.TbCiudadesFacade;
import com.datamarket.facades.TbDepartamentosFacade;
import com.datamarket.facades.TbEmpresasProspectoFacade;
import com.datamarket.facades.TbPaisesFacade;
import com.datamarket.servicios.TbPaisesServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrés
 */
@Named
@ViewScoped
public class EditarEmpresaProspectada implements Serializable {

    @Inject
    ObjetosSesion session;
    @Inject
    TbEmpresasProspectoConverter empresaProspectoConverter;
    @Inject
    TbPaisesServicio paisesServicio;
    @Inject
    TbPaisesFacade paisFacade;
    @Inject
    TbDepartamentosFacade departamentosFacade;
    @Inject
    TbCiudadesFacade ciudadesFacade;
    @Inject
    TbEmpresasProspectoFacade empresasProspectoFacade;

    private TbEmpresasProspecto empresaProsectoEditar;
    private TbEmpresasProspectoComponente empresasProspectoEditarComponente;
    private List<TbEmpresasProspecto> converterList;
    private Map<String, String> paisesMap;
    private Map<String, String> departamentosMap;
    private Map<String, String> ciudadesMap;
    private String paisId;
    private String departamentoId;

    @PostConstruct
    public void init() {
        empresaProsectoEditar = session.getEmpresaProspectoSesion();
        converterList = new ArrayList<>();
        converterList.add(empresaProsectoEditar);
        empresasProspectoEditarComponente = (empresaProspectoConverter.convertirTbEmpresasProspectoToEmpresasProspectoComponente(converterList)).get(0);
        cargarInformacionLocalizacionEmpresa();
    }

    public void buscarDepartamentosPorPais() {

        paisId = empresasProspectoEditarComponente.getPe_pais();
        departamentosMap = paisesServicio.getAllDepartamentosMap(paisFacade.buscarPaisPorId(paisId));
        ciudadesMap = new HashMap<>();
        departamentoId = "";
        empresasProspectoEditarComponente.setPe_departamento(departamentoId);
        empresasProspectoEditarComponente.setPe_ciudad("");

    }

    public void buscarCiudadesPorDepartamento() {

        departamentoId = empresasProspectoEditarComponente.getPe_departamento();
        TbDepartamentosPK pk = new TbDepartamentosPK();
        pk.setDeCodigo(departamentoId);
        pk.setDePais(paisId);
        ciudadesMap = paisesServicio.getAllCiudadesMap(departamentosFacade.findById(pk));
    }

    public void cargarInformacionLocalizacionEmpresa() {
        TbDepartamentosPK pk = new TbDepartamentosPK();
        pk.setDeCodigo(empresasProspectoEditarComponente.getPe_departamento());
        pk.setDePais(empresasProspectoEditarComponente.getPe_pais());
        paisesMap = paisesServicio.getAllPaisesMap();
        departamentosMap = paisesServicio.getAllDepartamentosMap(paisFacade.buscarPaisPorId(empresasProspectoEditarComponente.getPe_pais()));
        ciudadesMap = paisesServicio.getAllCiudadesMap(departamentosFacade.findById(pk));
    }

    public void actualizarEmpresaProspectada() {
        TbEmpresasProspecto empresaProspectoNueva = new TbEmpresasProspecto();
        
        empresaProspectoNueva.setPeCargo(empresasProspectoEditarComponente.getPe_cargo());
        empresaProspectoNueva.setPeArea(empresasProspectoEditarComponente.getPe_area());
        empresaProspectoNueva.setPeEmpresa(empresasProspectoEditarComponente.getPe_empresa());
        empresaProspectoNueva.setPeNombre(empresasProspectoEditarComponente.getPe_nombre());
        empresaProspectoNueva.setPeNumeroId(empresasProspectoEditarComponente.getPe_numero_id());
        empresaProspectoNueva.setPeDv(empresasProspectoEditarComponente.getPe_dv());
        empresaProspectoNueva.setPeDireccion(empresasProspectoEditarComponente.getPe_direccion());
        empresaProspectoNueva.setPeDepartamento(empresasProspectoEditarComponente.getPe_departamento());
        empresaProspectoNueva.setPeCiudad(empresasProspectoEditarComponente.getPe_ciudad());
        empresaProspectoNueva.setPeTelefono(empresasProspectoEditarComponente.getPe_telefono());
        empresaProspectoNueva.setPeEmail(empresasProspectoEditarComponente.getPe_email());
        empresaProspectoNueva.setPeSitioWeb(empresasProspectoEditarComponente.getPe_sitio_web());
        empresaProspectoNueva.setPeSector(empresasProspectoEditarComponente.getPe_sector());
        empresaProspectoNueva.setPeProductos(empresasProspectoEditarComponente.getPe_productos());
        empresaProspectoNueva.setPeReferencia(empresasProspectoEditarComponente.getPe_referencia());
        empresaProspectoNueva.setPeNombreContacto(empresasProspectoEditarComponente.getPe_nombre_contacto());
        empresaProspectoNueva.setPeApellidoContacto(empresasProspectoEditarComponente.getPe_apellido_contacto());
        empresaProspectoNueva.setPeDescripcionFuncion(empresasProspectoEditarComponente.getPe_descripcion_funcion());
        empresaProspectoNueva.setPePais(empresasProspectoEditarComponente.getPe_pais());
        empresaProspectoNueva.setPeEjecutivo(session.getUsuarioEnSesion().getUsCodUsuario());
        empresaProspectoNueva.setPeFechaCreacion(empresasProspectoEditarComponente.getPe_fecha_creacion());
        

        try {

            empresasProspectoFacade.actualizarEmpresaProspecto(empresaProspectoNueva);
            empresaProspectoNueva = new TbEmpresasProspecto();
            FacesContext.getCurrentInstance().addMessage("nuevaEmpresaProspectoId:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "SU SOLICITUD FUE CREADA"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("nuevaEmpresaProspectoId:messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "NO SE PUDO CREAR SU SOLICITUD"));
        }

    }

    /*Getters & Setters*/
    public TbEmpresasProspectoComponente getEmpresasProspectoEditarComponente() {
        return empresasProspectoEditarComponente;
    }

    public void setEmpresasProspectoEditarComponente(TbEmpresasProspectoComponente empresasProspectoEditarComponente) {
        this.empresasProspectoEditarComponente = empresasProspectoEditarComponente;
    }

    public Map<String, String> getPaisesMap() {
        return paisesMap;
    }

    public void setPaisesMap(Map<String, String> paisesMap) {
        this.paisesMap = paisesMap;
    }

    public Map<String, String> getDepartamentosMap() {
        return departamentosMap;
    }

    public void setDepartamentosMap(Map<String, String> departamentosMap) {
        this.departamentosMap = departamentosMap;
    }

    public Map<String, String> getCiudadesMap() {
        return ciudadesMap;
    }

    public void setCiudadesMap(Map<String, String> ciudadesMap) {
        this.ciudadesMap = ciudadesMap;
    }

}
