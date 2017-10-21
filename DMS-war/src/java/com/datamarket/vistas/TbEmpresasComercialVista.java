/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.componentes.TbEmpresaComercialComponente;
import com.datamarket.components.TbEmpresaComponente;
import com.datamarket.converter.TbEmpresaComponenteConverter;
import com.datamarket.entidades.TbContactosEmpresas;
import com.datamarket.entidades.TbEjecutivos;
import com.datamarket.entidades.TbEmpresaComercial;
import com.datamarket.entidades.TbEmpresas;
import com.datamarket.facades.TbContactosEmpresasFacade;
import com.datamarket.facades.TbEjecutivosFacade;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;
import com.datamarket.facades.TbEmpresaComercialFacade;
import com.datamarket.facades.TbEmpresasFacade;
import com.datamarket.servicios.TbDetalleCatalogoServicio;
import com.datamarket.servicios.TbEjecutivosServicio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Andres
 */
@Named
@ViewScoped
public class TbEmpresasComercialVista implements Serializable {

    @Inject
    TbEmpresaComercialFacade TbECF;
    @Inject
    TbEjecutivosFacade TbEjF;
    @Inject
    TbEmpresasFacade TbEmF;
    @Inject
    TbEjecutivosServicio TbES;
    @Inject
    private ObjetosSesion objetosSesion;
    @Inject
    TbDetalleCatalogoServicio catalogoServicio;
    @Inject
    TbEjecutivosFacade ejecutivosFacade;
    @Inject
    TbEmpresaComponenteConverter empresaComponenteConverter;
    @Inject
    TbContactosEmpresasFacade contactosFacade;
    @Inject
    TbEmpresaComercialFacade empresaComercialFacade;
    
    
    private List<TbContactosEmpresas> contactos;
    private TbEmpresaComercial empresaComercialNueva;
    protected List<TbEmpresaComercial> empresasPorComecial;
    private Integer comercialIdVista;
    protected Map<String, Integer> allEjecutivos;
    protected Map<String, String> catalalogoLineaNegocioVista;
    protected Map<String, String> catalalogoClasificacionClienteVista;
    private TbEmpresaComercial empresaSeleccionada;
    private TbEmpresas empresaDetalle;
    private List<TbEmpresaComercial> empresasPorComercialSesion;
    private TbEjecutivos ejecutivoSesion;
    private List<TbEmpresaComponente> empresasComercialComponente;
    private List<TbEmpresaComponente> empresasSeleccionadasDelComercial;
    private TbEmpresaComponente empresaConsultar;


    @PostConstruct
    public void init() {
        empresaSeleccionada = new TbEmpresaComercial();
        empresaComercialNueva = new TbEmpresaComercial();
        allEjecutivos = TbES.getAllEjecutivosMap();
        cargarSesionInformacionRegistroTbEmpresasComercialVista();
        catalalogoLineaNegocioVista = catalogoServicio.getAllLineaNegocio();
        catalalogoClasificacionClienteVista = catalogoServicio.getAllClasificacionClientes();
        ejecutivoSesion = ejecutivosFacade.buscarPorId(objetosSesion.getUsuarioEnSesion().getUsCodUsuario());
        empresasPorComercialSesion = TbECF.buscarTbEmpresaComercialPorejecutivo(ejecutivoSesion);
        empresasComercialComponente = empresaComponenteConverter.convertirAEmpresasComponente(empresasPorComercialSesion);

    }

    String prueba;
    /**/
    Integer ec_empresa_vista;

    /**/
    String ec_linea_negocio_vista;

    /**/
    String ec_clasificacion_vista;

    /**/
    String ec_prov_tecn_vista;

    /**/
    Integer ec_ejecutivo_vista;

    /**/
    public Integer getEc_empresa_vista() {
        return ec_empresa_vista;
    }

    public void setEc_empresa_vista(Integer ec_empresa_vista) {
        this.ec_empresa_vista = ec_empresa_vista;
    }

    public String getEc_linea_negocio_vista() {
        return ec_linea_negocio_vista;
    }

    public void setEc_linea_negocio_vista(String ec_linea_negocio_vista) {
        this.ec_linea_negocio_vista = ec_linea_negocio_vista;
    }

    public String getEc_clasificacion_vista() {
        return ec_clasificacion_vista;
    }

    public void setEc_clasificacion_vista(String ec_clasificacion_vista) {
        this.ec_clasificacion_vista = ec_clasificacion_vista;
    }

    public String getEc_prov_tecn_vista() {
        return ec_prov_tecn_vista;
    }

    public void setEc_prov_tecn_vista(String ec_prov_tecn_vista) {
        this.ec_prov_tecn_vista = ec_prov_tecn_vista;
    }

    public Integer getEc_ejecutivo_vista() {
        return ec_ejecutivo_vista;
    }

    public void setEc_ejecutivo_vista(Integer ec_ejecutivo_vista) {
        this.ec_ejecutivo_vista = ec_ejecutivo_vista;
    }

    public List<TbEmpresaComercial> getEmpresasPorComecial() {
        return empresasPorComecial;
    }

    public void setEmpresasPorComecial(List<TbEmpresaComercial> empresasPorComecial) {
        this.empresasPorComecial = empresasPorComecial;
    }

    public Integer getComercialIdVista() {
        return comercialIdVista;
    }

    public void setComercialIdVista(Integer comercialIdVista) {
        this.comercialIdVista = comercialIdVista;
    }

    public Map<String, Integer> getAllEjecutivos() {
        return allEjecutivos;
    }

    public void setAllEjecutivos(Map<String, Integer> allEjecutivos) {
        this.allEjecutivos = allEjecutivos;
    }

    public TbEmpresaComercial getEmpresaSeleccionada() {
        return empresaSeleccionada;
    }

    public void setEmpresaSeleccionada(TbEmpresaComercial empresaSeleccionada) {
        this.empresaSeleccionada = empresaSeleccionada;
    }

    public ObjetosSesion getObjetosSesion() {
        return objetosSesion;
    }

    public void setObjetosSesion(ObjetosSesion objetosSesion) {
        this.objetosSesion = objetosSesion;
    }

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    public TbEmpresas getEmpresaDetalle() {
        return empresaDetalle;
    }

    public void setEmpresaDetalle(TbEmpresas empresaDetalle) {
        this.empresaDetalle = empresaDetalle;
    }

    public Map<String, String> getCatalalogoLineaNegocioVista() {
        return catalalogoLineaNegocioVista;
    }

    public void setCatalalogoLineaNegocioVista(Map<String, String> catalalogoLineaNegocioVista) {
        this.catalalogoLineaNegocioVista = catalalogoLineaNegocioVista;
    }

    public Map<String, String> getCatalalogoClasificacionClienteVista() {
        return catalalogoClasificacionClienteVista;
    }

    public void setCatalalogoClasificacionClienteVista(Map<String, String> catalalogoClasificacionClienteVista) {
        this.catalalogoClasificacionClienteVista = catalalogoClasificacionClienteVista;
    }

    public List<TbEmpresaComercial> getEmpresasPorComercialSesion() {
        return empresasPorComercialSesion;
    }

    public void setEmpresasPorComercialSesion(List<TbEmpresaComercial> empresasPorComercialSesion) {
        this.empresasPorComercialSesion = empresasPorComercialSesion;
    }

    public void obtenerEjecutivoEnSesionVista() {
        ejecutivoSesion = ejecutivosFacade.buscarPorId(objetosSesion.getUsuarioEnSesion().getUsCodUsuario());
        // return ejecutivoSesion;
    }

    public List<TbEmpresaComponente> getEmpresasComercialComponente() {
        return empresasComercialComponente;
    }

    public void setEmpresasComercialComponente(List<TbEmpresaComponente> empresasComercialComponente) {
        this.empresasComercialComponente = empresasComercialComponente;
    }

    public TbEmpresaComponente getEmpresaConsultar() {
        return empresaConsultar;
    }

    public void setEmpresaConsultar(TbEmpresaComponente empresaConsultar) {
        this.empresaConsultar = empresaConsultar;
    }

    
    
    
    
    public void insertarTbEmpresaComercialVista() {
        try {


            empresaComercialNueva.setEcEmpresa(ec_empresa_vista);
            empresaComercialNueva.setEcLineaNegocio(ec_linea_negocio_vista);
            empresaComercialNueva.setEcClasificacion(ec_clasificacion_vista);
            empresaComercialNueva.setEcProvTecn(ec_prov_tecn_vista);
            empresaComercialNueva.setEcEjecutivo(TbEjF.buscarPorId(ec_ejecutivo_vista));
            empresaComercialNueva.setTbEmpresas(TbEmF.buscarPorId(ec_empresa_vista));
            TbECF.guardarTbEmpresaComercial(empresaComercialNueva);

            ec_empresa_vista = null;
            ec_linea_negocio_vista = "";
            ec_clasificacion_vista = "";
            ec_ejecutivo_vista = null;

        } catch (Exception e) {

        }

    }

    public void buscarEmpresasPorComercialVista() {


        empresasPorComecial = TbECF.buscarTbEmpresaComercialPorejecutivo(TbEjF.buscarPorId(comercialIdVista));
        empresasSeleccionadasDelComercial = new ArrayList<>();
        empresasSeleccionadasDelComercial = empresaComponenteConverter.convertirAEmpresasComponente(empresasPorComecial);

    }

    public void buscarInformacionRegistroEmpresaVista() {

    }

    public void asignarInformacionRegistroTbEmpresaComercialVista() {
        objetosSesion.setEmpresaComercialSesion(empresaSeleccionada);
        prueba = objetosSesion.getEmpresaComercialSesion().getTbEmpresas().getEmNombre();

    }

    public void asignacionInforacionRegistroEmpresaComercialVista() {

        try {

            objetosSesion.setEmpresaComercialSesion(empresaSeleccionada);
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.getExternalContext().redirect("empDetalle.xhtml");
        } catch (IOException ex) {
        }
    }

    public void cargarSesionInformacionRegistroTbEmpresasComercialVista() {
        HttpServletRequest oriRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        /*
         Si la request a la que hace la peticion termina con el nombre 'Tb_Adm_Roles_M.xhtml' entonces:
         */
        if (oriRequest.getPathInfo().endsWith("empDetalle.xhtml")) {

            /*
             Si  objeto de nombre 'objetosSesion' y de tipo 'ObjetosSesion' no es nulo entonces:
             */
            if (objetosSesion.getEmpresaComercialSesion() != null) {
                this.empresaDetalle = TbEmF.buscarPorId(objetosSesion.getEmpresaComercialSesion().getTbEmpresas().getEmIdEmpresas());

                objetosSesion.remove();
            } else {
                try {
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ctx.getExternalContext().redirect("empDetalle.xhtml");
                } catch (IOException ex) {
                }
            }
        }
    }

    public String verDetalleEmpresaComercial(TbEmpresaComponente empresaComercialComponente) {
        TbEmpresas empresa;
        empresa = TbEmF.buscarPorId(empresaComercialComponente.getEm_id_empresas());

        objetosSesion.setEmpresaSesion(empresa);
        objetosSesion.setEmpresaComercialSesion(empresaComercialFacade.buscarPorId(empresa.getEmIdEmpresas()));
        return "irDetalleComercial";
    }

    public String irListaDeCasosEmpresa() {
        TbEmpresas empresa;
        TbEmpresaComercial empresaComercial;
        empresa = TbEmF.buscarPorId(empresaConsultar.getEm_id_empresas());
        contactos = contactosFacade.getAllTbContactosEmpresasByEmpresa(empresa);
        objetosSesion.setEmpresaSesion(empresa);
        objetosSesion.setEmpresaComercialSesion(TbECF.buscarPorId(empresaConsultar.getEm_id_empresas()));
        objetosSesion.setContactosEmpresas(contactos);
        
        return "irDetalleCasosEmpresa";

    }

}
