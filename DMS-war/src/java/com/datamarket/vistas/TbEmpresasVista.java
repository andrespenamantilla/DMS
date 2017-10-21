/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.entidades.TbContactosEmpresas;
import com.datamarket.entidades.TbEmpresas;
import com.datamarket.facades.TbContactosEmpresasFacade;
import com.datamarket.facades.TbEmpresasFacade;
import com.datamarket.servicios.TbDetalleCatalogoServicio;
import com.datamarket.validaciones.Caracter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Andres
 */
@Named
@ViewScoped
public class TbEmpresasVista implements Serializable {

    @Inject
    TbEmpresasFacade TbEF;
    @Inject
    ObjetosSesion objetosSesion;
    @Inject
    TbContactosEmpresasFacade TbCEF;
    @Inject
    TbDetalleCatalogoServicio TbDCS;

    private TbEmpresas empresaEliminar;
    private TbEmpresas empresaModificar;
    private TbEmpresas empresaNueva;
    private TbContactosEmpresas contactoEmpresa;
    private TbContactosEmpresas contactoEliminar;
    private TbContactosEmpresas contactoModificar;
    private TbContactosEmpresas nuevoContactoEmpresa;
    private List<TbContactosEmpresas> contactosPorEmpresa;
    private LazyDataModel<TbEmpresas> empresasEncontradasLazyModel;
    private List<TbEmpresas> empresasEncontradasPorNitAndNombre;
    protected Map<String, String> allCargos;
    protected Map<String, String> allAreas;

    Integer em_id_empresas_vista;
    String em_nit_vista;
    String em_dv_vista;
    String em_nombre_vista;
    Integer em_sector_vista;
    Integer em_subsector_vista;
    String em_pais_vista;
    String em_depto_vista;
    String em_ciudad_vista;
    String em_telefono1_vista;
    String em_telefono2_vista;
    String em_direccion_vista;
    Integer IdEmpresaBuscarVista;

    Integer contactos_ce_secuencial_vista;
    @Caracter(message = "El nombre del contacto no puede se nulo")
    @NotNull(message = "El nombre del contacto no puede se nulo")
    String contactos_ce_nombres_vista;
    @Caracter
    @NotNull(message = "El/Los Apellidos del contacto no pueden ser nulos")
    String contactos_ce_apellidos_vista;

    @NotNull(message = "Debe seleccionar un cargo para el contacto")
    String contactos_ce_cargo_vista;
    @NotNull(message = "Debe seleccionar un área para el contacto")
    String contactos_ce_area_vista;

    private TbEmpresas empresaHallada;
    private TbEmpresas empresaConsulta;
    private String textoBusquedaEmpresa;

    private boolean habilitarBoton = true;

    @PostConstruct
    public void init() {

        allCargos = TbDCS.getAllCargosMap();
        allAreas = TbDCS.getAllAreasMap();
        cargarInformacionEmpresaHallada();
        empresaNueva = new TbEmpresas();
        contactoEmpresa = new TbContactosEmpresas();

        empresasEncontradasLazyModel = new LazyDataModel<TbEmpresas>() {
            @Override
            public List<TbEmpresas> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

                empresasEncontradasPorNitAndNombre = TbEF.buscarEmpresas(textoBusquedaEmpresa, first, pageSize);
                setRowCount(empresasEncontradasPorNitAndNombre.size());
                return empresasEncontradasPorNitAndNombre;
            }
        };
    }


    /*GETTERS Y SETTERS*/
    public Integer getEm_id_empresas_vista() {
        return em_id_empresas_vista;
    }

    public void setEm_id_empresas_vista(Integer em_id_empresas_vista) {
        this.em_id_empresas_vista = em_id_empresas_vista;
    }

    public String getEm_nit_vista() {
        return em_nit_vista;
    }

    public void setEm_nit_vista(String em_nit_vista) {
        this.em_nit_vista = em_nit_vista;
    }

    public String getEm_dv_vista() {
        return em_dv_vista;
    }

    public void setEm_dv_vista(String em_dv_vista) {
        this.em_dv_vista = em_dv_vista;
    }

    public String getEm_nombre_vista() {
        return em_nombre_vista;
    }

    public void setEm_nombre_vista(String em_nombre_vista) {
        this.em_nombre_vista = em_nombre_vista;
    }

    public Integer getEm_sector_vista() {
        return em_sector_vista;
    }

    public void setEm_sector_vista(Integer em_sector_vista) {
        this.em_sector_vista = em_sector_vista;
    }

    public Integer getEm_subsector_vista() {
        return em_subsector_vista;
    }

    public void setEm_subsector_vista(Integer em_subsector_vista) {
        this.em_subsector_vista = em_subsector_vista;
    }

    public String getEm_pais_vista() {
        return em_pais_vista;
    }

    public void setEm_pais_vista(String em_pais_vista) {
        this.em_pais_vista = em_pais_vista;
    }

    public String getEm_depto_vista() {
        return em_depto_vista;
    }

    public void setEm_depto_vista(String em_depto_vista) {
        this.em_depto_vista = em_depto_vista;
    }

    public String getEm_ciudad_vista() {
        return em_ciudad_vista;
    }

    public void setEm_ciudad_vista(String em_ciudad_vista) {
        this.em_ciudad_vista = em_ciudad_vista;
    }

    public String getEm_telefono1_vista() {
        return em_telefono1_vista;
    }

    public void setEm_telefono1_vista(String em_telefono1_vista) {
        this.em_telefono1_vista = em_telefono1_vista;
    }

    public String getEm_telefono2_vista() {
        return em_telefono2_vista;
    }

    public void setEm_telefono2_vista(String em_telefono2_vista) {
        this.em_telefono2_vista = em_telefono2_vista;
    }

    public String getEm_direccion_vista() {
        return em_direccion_vista;
    }

    public void setEm_direccion_vista(String em_direccion_vista) {
        this.em_direccion_vista = em_direccion_vista;
    }

    public TbEmpresas getEmpresaHallada() {
        return empresaHallada;
    }

    public void setEmpresaHallada(TbEmpresas empresaHallada) {
        this.empresaHallada = empresaHallada;
    }

    public TbEmpresas getEmpresaConsulta() {
        return empresaConsulta;
    }

    public void setEmpresaConsulta(TbEmpresas empresaConsulta) {
        this.empresaConsulta = empresaConsulta;
    }

    public List<TbContactosEmpresas> getContactosPorEmpresa() {
        return contactosPorEmpresa;
    }

    public void setContactosPorEmpresa(List<TbContactosEmpresas> contactosPorEmpresa) {
        this.contactosPorEmpresa = contactosPorEmpresa;
    }

    public void prueba() {

    }

    public void habilitarCamposTbEmpresasDetalleVista() {
        habilitarBoton = false;
    }

    public void guardar() {
        habilitarBoton = true;
    }

    public boolean isHabilitarBoton() {
        return habilitarBoton;
    }

    public void setHabilitarBoton(boolean habilitarBoton) {
        this.habilitarBoton = habilitarBoton;
    }

    public Map<String, String> getAllCargos() {
        return allCargos;
    }

    public void setAllCargos(Map<String, String> allCargos) {
        this.allCargos = allCargos;
    }

    public Map<String, String> getAllAreas() {
        return allAreas;
    }

    public void setAllAreas(Map<String, String> allAreas) {
        this.allAreas = allAreas;
    }

    public Integer getContactos_ce_secuencial_vista() {
        return contactos_ce_secuencial_vista;
    }

    public void setContactos_ce_secuencial_vista(Integer contactos_ce_secuencial_vista) {
        this.contactos_ce_secuencial_vista = contactos_ce_secuencial_vista;
    }

    public String getContactos_ce_nombres_vista() {
        return contactos_ce_nombres_vista;
    }

    public void setContactos_ce_nombres_vista(String contactos_ce_nombres_vista) {
        this.contactos_ce_nombres_vista = contactos_ce_nombres_vista;
    }

    public String getContactos_ce_apellidos_vista() {
        return contactos_ce_apellidos_vista;
    }

    public void setContactos_ce_apellidos_vista(String contactos_ce_apellidos_vista) {
        this.contactos_ce_apellidos_vista = contactos_ce_apellidos_vista;
    }

    public String getContactos_ce_cargo_vista() {
        return contactos_ce_cargo_vista;
    }

    public void setContactos_ce_cargo_vista(String contactos_ce_cargo_vista) {
        this.contactos_ce_cargo_vista = contactos_ce_cargo_vista;
    }

    public String getContactos_ce_area_vista() {
        return contactos_ce_area_vista;
    }

    public void setContactos_ce_area_vista(String contactos_ce_area_vista) {
        this.contactos_ce_area_vista = contactos_ce_area_vista;
    }

    public Integer getIdEmpresaBuscarVista() {
        return IdEmpresaBuscarVista;
    }

    public void setIdEmpresaBuscarVista(Integer IdEmpresaBuscarVista) {
        this.IdEmpresaBuscarVista = IdEmpresaBuscarVista;
    }

    public TbContactosEmpresas getContactoEliminar() {
        return contactoEliminar;
    }

    public void setContactoEliminar(TbContactosEmpresas contactoEliminar) {
        this.contactoEliminar = contactoEliminar;
    }

    public TbContactosEmpresas getContactoModificar() {
        return contactoModificar;
    }

    public void setContactoModificar(TbContactosEmpresas contactoModificar) {
        this.contactoModificar = contactoModificar;
    }

    public List<TbEmpresas> getEmpresasEncontradasPorNitAndNombre() {
        return empresasEncontradasPorNitAndNombre;
    }

    public void setEmpresasEncontradasPorNitAndNombre(List<TbEmpresas> empresasEncontradasPorNitAndNombre) {
        this.empresasEncontradasPorNitAndNombre = empresasEncontradasPorNitAndNombre;
    }

    public String getTextoBusquedaEmpresa() {
        return textoBusquedaEmpresa;
    }

    public void setTextoBusquedaEmpresa(String textoBusquedaEmpresa) {
        this.textoBusquedaEmpresa = textoBusquedaEmpresa;
    }

    public void buscar() {
        init();

    }

    public void insertarTbEmpresasVista() {
        try {

            empresaNueva.setEmIdEmpresas(em_id_empresas_vista);
            empresaNueva.setEmNit(em_nit_vista);
            empresaNueva.setEmDv(em_dv_vista);
            empresaNueva.setEmNombre(em_nombre_vista);
            empresaNueva.setEmSector(em_sector_vista);
            empresaNueva.setEmSubsector(em_subsector_vista);
            empresaNueva.setEmPais(em_pais_vista);
            empresaNueva.setEmDepto(em_depto_vista);
            empresaNueva.setEmCiudad(em_ciudad_vista);
            empresaNueva.setEmTelefono1(em_telefono1_vista);
            empresaNueva.setEmTelefono2(em_telefono2_vista);
            empresaNueva.setEmDireccion(em_direccion_vista);
            TbEF.guardarTbEmpresas(empresaNueva);

            empresaNueva = new TbEmpresas();

            em_id_empresas_vista = null;
            em_nit_vista = "";
            em_dv_vista = "";
            em_nombre_vista = "";
            em_sector_vista = null;
            em_subsector_vista = null;
            em_pais_vista = "";
            em_depto_vista = "";
            em_ciudad_vista = "";
            em_telefono1_vista = "";
            em_telefono2_vista = "";
            em_direccion_vista = "";


        } catch (Exception e) {
        }
    }

    public void buscarEmpresaPorID() {
        try {
            if (TbEF.buscarPorId(IdEmpresaBuscarVista) != null) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "La Empresa Existe."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Información", "La Empresa no existe."));
            }

        } catch (Exception e) {
        }

    }

    public void cargarInformacionEmpresa() {
        empresaHallada = TbEF.buscarPorId(IdEmpresaBuscarVista);
        contactosPorEmpresa = TbCEF.getAllTbContactosEmpresasByEmpresa(empresaHallada);
        objetosSesion.setEmpresaSesion(empresaHallada);
        objetosSesion.setContactosEmpresas(contactosPorEmpresa);
        //objetosSesion.setContactoEmpresa(contactoModificar);
        try {
            if (empresaHallada != null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("empD.xhtml");
            } else {
            }
        } catch (Exception e) {
        }

    }

    public void asignacionInformacionRegistroComercialVista() {

        try {

            objetosSesion.setContactoEmpresa(contactoModificar);
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.getExternalContext().redirect("conMod.xhtml");
        } catch (IOException ex) {
        }
    }

    public void cargarInformacionEmpresaHallada() {
        HttpServletRequest oriRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if (oriRequest.getPathInfo().endsWith("empD.xhtml")) {
            if (objetosSesion.getEmpresaSesion() != null) {
                this.empresaConsulta = objetosSesion.getEmpresaSesion();
                this.contactosPorEmpresa = objetosSesion.getContactosEmpresas();
                this.contactoModificar = objetosSesion.getContactoEmpresa();
                //objetosSesion.remove();
            } else {
                try {
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ctx.getExternalContext().redirect("empD.xhtml");
                    FacesContext ctx2 = FacesContext.getCurrentInstance();
                    ctx2.getExternalContext().redirect("conMod.xhtml");

                } catch (IOException ex) {
                    Logger.getLogger(TbEmpresas.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void insertarEmpleadoPorEmpresa() {

        contactoEmpresa.setCeCodigoEmpresa(empresaConsulta);
        contactoEmpresa.setCeSecuencial(contactos_ce_secuencial_vista);
        contactoEmpresa.setCeArea(contactos_ce_area_vista);
        contactoEmpresa.setCeCargo(contactos_ce_cargo_vista);
        contactoEmpresa.setCeApellidos(contactos_ce_apellidos_vista);
        contactoEmpresa.setCeNombres(contactos_ce_nombres_vista);
        TbCEF.guardarTbContactosEmpresas(contactoEmpresa);
        contactosPorEmpresa.add(contactoEmpresa);
        this.contactos_ce_secuencial_vista = null;
        this.contactos_ce_apellidos_vista = "";
        this.contactos_ce_nombres_vista = "";
        this.contactos_ce_cargo_vista = "";
        this.contactos_ce_area_vista = "";
        contactoEmpresa = new TbContactosEmpresas();
        FacesContext.getCurrentInstance().addMessage(":dialogEmpleadoId:dialogFormAgregarContactoId:messageContactoId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se agrego un contacto"));

    }

    public void eliminarContactoEmpresa() {
        try {
            TbCEF.eliminarTbContactosEmpresas(contactoEliminar.getCeSecuencial());
            contactosPorEmpresa.remove(contactoEliminar);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Eliminar", "Usted  eliminó el contacto del sistema."));

        } catch (Exception e) {
        }

    }

    public void noEliminarContactoEmpresa() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Eliminar", "Usted NO eliminó el contacto del sistema."));

    }

    public void modificarContactoEmpresa() {

    }

    public void pruebaMensaje() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Eliminar", "Usted NO eliminó el contacto del sistema."));

    }

}
