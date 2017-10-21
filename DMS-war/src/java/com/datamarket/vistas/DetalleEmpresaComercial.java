/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.componentes.TbEmpresaComercialComponente;
import com.datamarket.components.TbContactosEmpresaComponente;
import com.datamarket.components.TbEmpresaComercialComponenteVista;
import com.datamarket.components.TbEmpresaComponente;
import com.datamarket.converter.TbContactosEmpresasConverter;
import com.datamarket.converter.TbEmpresaComponenteConverter;
import com.datamarket.converter.TbEmpresasComercialConverter;
import com.datamarket.entidades.TbCasosEmpresas;
import com.datamarket.entidades.TbContactosEmpresas;
import com.datamarket.entidades.TbDepartamentosPK;
import com.datamarket.entidades.TbEmpresaComercial;
import com.datamarket.entidades.TbEmpresas;
import com.datamarket.entidades.TbTareasEmpresas;
import com.datamarket.facades.TbCasosEmpresasFacade;
import com.datamarket.facades.TbContactosEmpresasFacade;
import com.datamarket.facades.TbDepartamentosFacade;
import com.datamarket.facades.TbEjecutivosFacade;
import com.datamarket.facades.TbEmpresaComercialFacade;
import com.datamarket.facades.TbEmpresasFacade;
import com.datamarket.facades.TbPaisesFacade;
import com.datamarket.facades.TbTareasEmpresasFacade;
import com.datamarket.servicios.TbDetalleCatalogoServicio;
import com.datamarket.servicios.TbEjecutivosServicio;
import com.datamarket.servicios.TbPaisesServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andrés Peña mantilla
 *
 */
@Named
@ViewScoped
public class DetalleEmpresaComercial implements Serializable {

    @Inject
    ObjetosSesion session;
    @Inject
    TbEmpresaComercialFacade empresaComercialFacade;
    @Inject
    TbDetalleCatalogoServicio catalogoServicio;
    @Inject
    TbContactosEmpresasFacade contactosFacade;
    @Inject
    TbEmpresaComponenteConverter TbEmpresaComponenteConverter;
    @Inject
    TbContactosEmpresasConverter contactosEmpresasConverter;
    @Inject
    TbContactosEmpresasFacade contactosEmpresasFacade;
    @Inject
    TbEmpresasComercialConverter empresaComercialConverter;
    @Inject
    TbEjecutivosServicio ejecutivosServicio;
    @Inject
    TbEjecutivosFacade ejecutivosFacade;
    @Inject
    TbPaisesServicio paisesServicio;
    @Inject
    TbPaisesFacade paisesFacade;
    @Inject
    TbDepartamentosFacade departamentosFacade;
    @Inject
    TbCasosEmpresasFacade casosEmpresasFacade;
    @Inject
    TbEmpresasFacade empresasFacade;

    private TbEmpresas empresa;
    private final String estadoPendiente = "2";
    private TbEmpresaComercial empresaComercial;
    private List<TbContactosEmpresas> contactos;
    private TbEmpresaComercialComponente empresaComercialComponente;
    private TbEmpresaComponente empresaComponente;
    private TbContactosEmpresaComponente contactosEmpresaComponente;
    private List<TbContactosEmpresaComponente> contactosComponente;
    private TbEmpresaComercialComponenteVista empresaComercialComponenteVista;
    private Integer cargarFormularioEmpresaComercial;
    private Map<String, Integer> ejecutivos;
    private Integer ecEjecutivo;
    @NotNull(message = "La línea de Negocio es requerida")
    private String ecLineaNegocio;
    private String ecClasificacion;
    private String ecProvTecn;
    private boolean habilitarFuncion;
    private TbContactosEmpresas nuevoContacto;
    private TbContactosEmpresaComponente nuevoContactoComponente;
    private Map<String, String> paisesMap;
    private Map<String, String> departamentosMap;
    private Map<String, String> ciudadesMap;
    private String paisId;
    private String departamentoId;
    private String ciudadId;
    private boolean habilitarCampos;
    private List<TbTareasEmpresas> tareasDeEjecutivo;
    @Inject
    TbTareasEmpresasFacade tareasEmpresasFacade;
    private List<TbCasosEmpresas> casosEmpresas;

    @PostConstruct
    public void init() {

        paisesMap = paisesServicio.getAllPaisesMap();
        nuevoContactoComponente = new TbContactosEmpresaComponente();
        ejecutivos = ejecutivosServicio.getAllEjecutivosMap();
        habilitarFuncion = false;
        empresa = new TbEmpresas();
        empresa = session.getEmpresaSesion();

        empresaComponente = TbEmpresaComponenteConverter.convertirEntidadAComponente(empresa);
        empresaComercialComponenteVista = new TbEmpresaComercialComponenteVista();

        if (session.getEmpresaComercialSesion() == null) {
            empresaComercial = new TbEmpresaComercial();
            empresaComercialComponenteVista = empresaComercialConverter.convertirEntidadNulaAComponenteVista();
            session.setEmpresaComercialComponenteVista(empresaComercialComponenteVista);
            cargarFormularioEmpresaComercial = 1;
        } else {
            asignarInformacion();
        }

        contactos = contactosFacade.getAllTbContactosEmpresasByEmpresa(empresa);
        session.setContactosEmpresas(contactos);
        contactosComponente = contactosEmpresasConverter.convertirContactosEmpresasComponente(contactos);

        if (session.getUsuarioEnSesion().getTbEjecutivos().getTbAdmUsuarios().getUsRol().getRoDescripcion().equals("EJECUTIVO_CUENTA") && session.getEmpresaComercialSesion() == null) {
            habilitarFuncion = true;
            System.out.println("1" + habilitarFuncion);
        } else if (session.getUsuarioEnSesion().getTbEjecutivos().getTbAdmUsuarios().getUsRol().getRoDescripcion().equals("EJECUTIVO_CUENTA") && Objects.equals(session.getEmpresaComercialSesion().getEcEjecutivo().getEjCodigo(), session.getUsuarioEnSesion().getTbEjecutivos().getTbAdmUsuarios().getUsCodUsuario())) {
            habilitarFuncion = false;
            System.out.println("2" + habilitarFuncion);

        } else if (session.getUsuarioEnSesion().getTbEjecutivos().getTbAdmUsuarios().getUsRol().getRoDescripcion().equals("EJECUTIVO_CUENTA") && !Objects.equals(session.getEmpresaComercialSesion().getEcEjecutivo().getEjCodigo(), session.getUsuarioEnSesion().getTbEjecutivos().getTbAdmUsuarios().getUsCodUsuario())) {
            habilitarFuncion = true;
            System.out.println("3" + habilitarFuncion);
        } else if (session.getUsuarioEnSesion().getUsRol().getRoDescripcion().equals("ADMIN_BD")) {
            habilitarFuncion = false;

        } else if (session.getUsuarioEnSesion().getTbEjecutivos().getTbAdmUsuarios().getUsRol().getRoDescripcion().equals("ADMIN_SISTEMA")) {
            habilitarFuncion = false;

        }

        cargarInformacionLocalizacion();
        habilitarCampos = true;
        System.out.println(habilitarCampos);
        System.out.println(nuevoContactoComponente.getCe_apellidos());
        System.out.println("El proveedor es " + ecProvTecn);
    }

    public void asignarInformacion() {
        empresaComercial = empresaComercialFacade.buscarPorId(empresa.getEmIdEmpresas());
        empresaComercialComponente = new TbEmpresaComercialComponente();

        session.setEmpresaComercialSesion(empresaComercial);
        empresaComercialComponenteVista = empresaComercialConverter.convertirEntidadAComponenteVista(empresaComercial);
        empresaComercialComponente.setEc_prov_tecn(empresaComercial.getEcProvTecn());
        empresaComercialComponente.setEc_clasificacion(empresaComercial.getEcClasificacion());
        empresaComercialComponente.setEc_ejecutivo(empresaComercial.getEcEjecutivo().getEjCodigo());
        empresaComercialComponente.setEc_lineaNegocio(empresaComercial.getEcLineaNegocio());
        empresaComercialComponente.setEc_empresa(empresaComercial.getEcEmpresa());

    }

    public String irActualizarEmpresa() {

        if (session.getEmpresaComercialSesion() == null) {
            session.setEmpresaComercialSesion(null);
        } else {
            session.setEmpresaComercialSesion(empresaComercial);
            session.setEmpresaSesion(empresa);
            session.setEmpresaComercialComponenteVista(empresaComercialComponenteVista);
            session.setEmpresaComponente(empresaComponente);
        }
        return "irActualizarEmpresa";
    }

    public void guardarEmpresaComercial() {

        TbEmpresaComercial aux = new TbEmpresaComercial();
        aux.setTbEmpresas(empresa);
        aux.setEcEjecutivo(ejecutivosFacade.buscarPorId(empresaComercialComponente.getEc_ejecutivo()));
        aux.setEcLineaNegocio(empresaComercialComponente.getEc_lineaNegocio());
        aux.setEcProvTecn(empresaComercialComponente.getEc_prov_tecn());
        aux.setEcClasificacion(empresaComercialComponente.getEc_clasificacion());
        aux.setEcEmpresa(empresa.getEmIdEmpresas());
        empresaComercial = aux;

        empresaComercialFacade.actualizar(aux);
        cargarFormularioEmpresaComercial = 2;
        session.setEmpresaComercialSesion(empresaComercial);
        empresaComercialComponenteVista = empresaComercialConverter.convertirEntidadAComponenteVista(aux);
        session.setEmpresaComercialComponenteVista(empresaComercialComponenteVista);
    }

    public String agregarNuevoCasoEmpresa() {
        return "irNuevoCasoEmpresa";
    }

    public String irDetalleContactoEmpresa(TbContactosEmpresaComponente contactoActualizar) {
        session.setContactoEmpresa(contactosEmpresasFacade.findById(contactoActualizar.getCe_secuencial()));
        return "irDetalleContacto";
    }

    public void asignarContactoEliminar(TbContactosEmpresaComponente contactoEliminar) {
        nuevoContacto = contactosFacade.findById(contactoEliminar.getCe_secuencial());

    }

    public void guardarContacto() {
        Date date = new Date();
        TbContactosEmpresaComponente aux;
        nuevoContacto = new TbContactosEmpresas();
        nuevoContacto = contactosEmpresasConverter.convertirComponenteToEntidad(nuevoContactoComponente);
        nuevoContacto.setCeCodigoEmpresa(empresa);
        nuevoContacto.setCeFechaCrea(date);
        contactosFacade.guardarTbContactosEmpresas(nuevoContacto);
        contactos = contactosFacade.getAllTbContactosEmpresasByEmpresa(empresa);
        contactosComponente = contactosEmpresasConverter.convertirContactosEmpresasComponente(contactos);
        FacesContext.getCurrentInstance().addMessage("listaContactos:messageId3", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "SE REALIZÓ LA CREACIÓN DEL CONTACTO CORRECTAMENTE."));
        nuevoContactoComponente = new TbContactosEmpresaComponente();
    }

    public void buscarDepartamentosPorPais() {

        if (empresaComponente != null && nuevoContactoComponente.getCe_pais() == null) {
            departamentosMap = paisesServicio.getAllDepartamentosMap(paisesFacade.findById(empresaComponente.getEm_pais()));
            empresaComponente.setEm_depto(null);
            empresaComponente.setEm_ciudad(null);
            ciudadesMap = new HashMap<>();

        }

        if (empresaComponente != null && nuevoContactoComponente.getCe_pais() != null) {
            departamentosMap = paisesServicio.getAllDepartamentosMap(paisesFacade.findById(nuevoContactoComponente.getCe_pais()));
            ciudadesMap = new HashMap<>();

        }

    }

    public void buscarCiudadesPorDepartamento() {

        if (empresaComponente != null && nuevoContactoComponente.getCe_pais() == null) {

            departamentoId = empresaComponente.getEm_depto();
            paisId = empresaComponente.getEm_pais();
            TbDepartamentosPK pk = new TbDepartamentosPK();
            pk.setDeCodigo(departamentoId);
            pk.setDePais(paisId);
            ciudadesMap = paisesServicio.getAllCiudadesMap(departamentosFacade.findById(pk));
            empresaComponente.setEm_ciudad(null);
        }

        if (empresaComponente != null && nuevoContactoComponente.getCe_pais() != null) {

            departamentoId = nuevoContactoComponente.getCe_depto();
            paisId = nuevoContactoComponente.getCe_pais();
            TbDepartamentosPK pk = new TbDepartamentosPK();
            pk.setDeCodigo(departamentoId);
            pk.setDePais(paisId);
            ciudadesMap = paisesServicio.getAllCiudadesMap(departamentosFacade.findById(pk));
            empresaComponente.setEm_ciudad(null);
        }
    }

    public void eliminarContacto() {
        if (casosEmpresasFacade.listarCasosEmpresasPorCeContacto(nuevoContacto.getCeSecuencial()) == true) {
            FacesContext.getCurrentInstance().addMessage("listaContactos:messageId4", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "ERROR, ESE CONTACTO ESTA ASIGNADO A UN PROCESO COMERCIAL ABIERTO."));

        } else {
            contactosFacade.eliminarContactosEmpresas(nuevoContacto);
            contactos = contactosFacade.getAllTbContactosEmpresasByEmpresa(empresa);
            contactosComponente = contactosEmpresasConverter.convertirContactosEmpresasComponente(contactos);
            FacesContext.getCurrentInstance().addMessage("listaContactos:messageId4", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "CORRECTO, EL CONTACTO SE HA ELIMINADO."));

        }

    }

    public void actualizarEmpresa() {

        Date date = new Date();
        try {
            System.out.println("Entró");
            TbEmpresas empresaActualizar = new TbEmpresas();
            empresaActualizar.setEmIdEmpresas(empresa.getEmIdEmpresas());
            empresaActualizar.setEmNit(empresaComponente.getEm_nit());
            empresaActualizar.setEmDv(empresaComponente.getEm_dv());
            empresaActualizar.setEmNombre(empresaComponente.getEm_nombre());
            empresaActualizar.setEmSector(empresa.getEmSector());
            empresaActualizar.setEmSubsector(empresaComponente.getEm_subsector_index());
            empresaActualizar.setEmPais(empresaComponente.getEm_pais());
            empresaActualizar.setEmDepto(empresaComponente.getEm_depto());
            empresaActualizar.setEmDireccion(empresaComponente.getEm_direccion());
            empresaActualizar.setEmCiudad(empresaComponente.getEm_ciudad());
            empresaActualizar.setEmTelefono1(empresaComponente.getEm_telefono1());
            empresaActualizar.setEmTelefono2(empresaComponente.getEm_telefono2());
            empresaActualizar.setEmTelefono3(empresaComponente.getEm_telefono3());
            empresaActualizar.setEmFax(empresaComponente.getEm_fax());
            empresaActualizar.setEmWeb(empresaComponente.getEm_web());
            empresaActualizar.setEmAnioFundacion(empresaComponente.getEm_anio_fundacion());
            empresaActualizar.setEmFechaCreacion(empresa.getEmFechaCreacion());
            empresaActualizar.setEmEmail(empresaComponente.getEm_email());
            empresaActualizar.setEmActividadPrinc(empresaComponente.getEm_actividad_principal());
            empresaActualizar.setEmCiiu1(empresaComponente.getEm_ciiu1());
            empresaActualizar.setEmCiiu2(empresaComponente.getEm_ciiu2());
            empresaActualizar.setEmCiiu3(empresaComponente.getEm_ciiu3());
            empresaActualizar.setEmNumEmpleados(empresaComponente.getEm_num_empleados());
            empresaActualizar.setEmCelular(empresaComponente.getEm_celular());
            empresaActualizar.setEmNroComp(empresaComponente.getEm_nro_comp());
            empresaActualizar.setEmObservaciones(empresaComponente.getEm_observaciones());
            empresaActualizar.setEmFechaUltMod(date);
            empresaActualizar.setEmTipoPer(empresaComponente.getEm_tipo_per());
            empresaActualizar.setEmEstado(empresaComponente.getEm_estado());
            empresasFacade.actualizar(empresaActualizar);
            FacesContext.getCurrentInstance().addMessage("detalleEmpresa:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "CORRECTO, LOS DATOS GENERALES DE LA EMPRESA  SE  HAN ACTUALIZADO CORRECTAMENTE"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("detalleEmpresa:messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "INCORRECTO, LOS DATOS GENERALES DE LA EMPRESA NO SE  HAN ACTUALIZADO CORRECTAMENTE"));
        }

    }

    public void actualizarEmpresaComercial() {
        try {
            casosEmpresas = casosEmpresasFacade.listarCasosEmpresasPorIdEmpresaComercial(empresaComercial);
            tareasDeEjecutivo = new ArrayList<>();
            List<TbTareasEmpresas> tareasPorCaso;
            for (int i = 0; i < casosEmpresas.size(); i++) {
                tareasPorCaso = new ArrayList<>();
                tareasPorCaso = tareasEmpresasFacade.buscarTareasPorCaso(casosEmpresas.get(i));

                for (int j = 0; j < tareasPorCaso.size(); j++) {

                    if (tareasPorCaso.get(i).getTeEstado().equals(estadoPendiente)) {
                        tareasPorCaso.get(i).setTeResponsable(empresaComercialComponente.getEc_ejecutivo());
                        tareasDeEjecutivo.add(tareasPorCaso.get(i));

                    }
                }

            }

            for (int i = 0; i < tareasDeEjecutivo.size(); i++) {

                tareasEmpresasFacade.actualizar(tareasDeEjecutivo.get(i));
            }

            empresaComercial.setEcEjecutivo(ejecutivosFacade.buscarPorId(empresaComercialComponente.getEc_ejecutivo()));
            empresaComercial.setEcClasificacion(empresaComercialComponente.getEc_clasificacion());
            empresaComercial.setEcProvTecn(empresaComercialComponente.getEc_prov_tecn());
            empresaComercial.setEcLineaNegocio(empresaComercialComponente.getEc_lineaNegocio());
            empresaComercialFacade.actualizar(empresaComercial);
            FacesContext.getCurrentInstance().addMessage("detalleEmpresaComercial:messageId2", new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "LOS DATOS COMERCIALES DE LA EMPRESA  SE  HAN ACTUALIZADO CORRECTAMENTE"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("actualizarEmpresaComercial:messageId2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "LOS DATOS COMERCIALES DE LA EMPRESA NO SE  HAN ACTUALIZADO CORRECTAMENTE"));
        }

    }

    public void cargarInformacionLocalizacion() {
        TbDepartamentosPK pk = new TbDepartamentosPK();
        pk.setDeCodigo(empresaComponente.getEm_depto());
        pk.setDePais(empresaComponente.getEm_pais());
        paisesMap = paisesServicio.getAllPaisesMap();
        departamentosMap = paisesServicio.getAllDepartamentosMap(paisesFacade.buscarPaisPorId(empresaComponente.getEm_ciudad()));
        ciudadesMap = paisesServicio.getAllCiudadesMap(departamentosFacade.findById(pk));

    }

    public void habilitarCampos() {
        habilitarCampos = false;
    }

    public void deshabilitarCampos() {
        habilitarCampos = true;

    }

    public void limpiarDatosFormularioContacto() {
        nuevoContactoComponente.setCe_nombres("");
        nuevoContactoComponente.setCe_apellidos("");
        nuevoContactoComponente.setCe_cargo("");
        nuevoContactoComponente.setCe_area("");
        nuevoContactoComponente.setCe_descripcion_funcion("");
        nuevoContactoComponente.setCe_ext_tel("");
        nuevoContactoComponente.setCe_telefono("");
        nuevoContactoComponente.setCe_direccion("");
        nuevoContactoComponente.setCe_pais("");
        nuevoContactoComponente.setCe_depto("");
        nuevoContactoComponente.setCe_ciudad("");
        nuevoContactoComponente.setCe_email_corp("");
        nuevoContactoComponente.setCe_email_personal("");
        nuevoContactoComponente.setCe_estado(null);
        nuevoContactoComponente.setCe_celular("");
        
        

    }


    /*Getters & Setters*/
    public List<TbContactosEmpresas> getContactos() {
        return contactos;
    }

    public void setContactos(List<TbContactosEmpresas> contactos) {
        this.contactos = contactos;
    }

    public TbEmpresaComercialComponente getEmpresaComercialComponente() {
        return empresaComercialComponente;
    }

    public void setEmpresaComercialComponente(TbEmpresaComercialComponente empresaComercialComponente) {
        this.empresaComercialComponente = empresaComercialComponente;
    }

    public TbEmpresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(TbEmpresas empresa) {
        this.empresa = empresa;
    }

    public TbEmpresaComponente getEmpresaComponente() {
        return empresaComponente;
    }

    public void setEmpresaComponente(TbEmpresaComponente empresaComponente) {
        this.empresaComponente = empresaComponente;
    }

    public List<TbContactosEmpresaComponente> getContactosComponente() {
        return contactosComponente;
    }

    public void setContactosComponente(List<TbContactosEmpresaComponente> contactosComponente) {
        this.contactosComponente = contactosComponente;
    }

    public TbEmpresaComercialComponenteVista getEmpresaComercialComponenteVista() {
        return empresaComercialComponenteVista;
    }

    public void setEmpresaComercialComponenteVista(TbEmpresaComercialComponenteVista empresaComercialComponenteVista) {
        this.empresaComercialComponenteVista = empresaComercialComponenteVista;
    }

    public Integer getCargarFormularioEmpresaComercial() {
        return cargarFormularioEmpresaComercial;
    }

    public void setCargarFormularioEmpresaComercial(Integer cargarFormularioEmpresaComercial) {
        this.cargarFormularioEmpresaComercial = cargarFormularioEmpresaComercial;
    }

    public TbEmpresaComercial getEmpresaComercial() {
        return empresaComercial;
    }

    public void setEmpresaComercial(TbEmpresaComercial empresaComercial) {
        this.empresaComercial = empresaComercial;
    }

    public Map<String, Integer> getEjecutivos() {
        return ejecutivos;
    }

    public void setEjecutivos(Map<String, Integer> ejecutivos) {
        this.ejecutivos = ejecutivos;
    }

    public Integer getEcEjecutivo() {
        return ecEjecutivo;
    }

    public void setEcEjecutivo(Integer ecEjecutivo) {
        this.ecEjecutivo = ecEjecutivo;
    }

    public String getEcLineaNegocio() {
        return ecLineaNegocio;
    }

    public void setEcLineaNegocio(String ecLineaNegocio) {
        this.ecLineaNegocio = ecLineaNegocio;
    }

    public String getEcClasificacion() {
        return ecClasificacion;
    }

    public void setEcClasificacion(String ecClasificacion) {
        this.ecClasificacion = ecClasificacion;
    }

    public String getEcProvTecn() {
        return ecProvTecn;
    }

    public void setEcProvTecn(String ecProvTecn) {
        this.ecProvTecn = ecProvTecn;
    }

    public boolean isHabilitarFuncion() {
        return habilitarFuncion;
    }

    public void setHabilitarFuncion(boolean habilitarFuncion) {
        this.habilitarFuncion = habilitarFuncion;
    }

    public TbContactosEmpresaComponente getContactosEmpresaComponente() {
        return contactosEmpresaComponente;
    }

    public void setContactosEmpresaComponente(TbContactosEmpresaComponente contactosEmpresaComponente) {
        this.contactosEmpresaComponente = contactosEmpresaComponente;
    }

    public TbContactosEmpresas getNuevoContacto() {
        return nuevoContacto;
    }

    public void setNuevoContacto(TbContactosEmpresas nuevoContacto) {
        this.nuevoContacto = nuevoContacto;
    }

    public TbContactosEmpresaComponente getNuevoContactoComponente() {
        return nuevoContactoComponente;
    }

    public void setNuevoContactoComponente(TbContactosEmpresaComponente nuevoContactoComponente) {
        this.nuevoContactoComponente = nuevoContactoComponente;
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

    public String getPaisId() {
        return paisId;
    }

    public void setPaisId(String paisId) {
        this.paisId = paisId;
    }

    public String getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(String departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(String ciudadId) {
        this.ciudadId = ciudadId;
    }

    public boolean isHabilitarCampos() {
        return habilitarCampos;
    }

    public void setHabilitarCampos(boolean habilitarCampos) {
        this.habilitarCampos = habilitarCampos;
    }

    public void test() {
        System.out.println(ecProvTecn);
    }
}
