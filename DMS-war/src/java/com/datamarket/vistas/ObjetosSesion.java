/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

/**
 *
 * @author Andres
 */
import com.datamarket.components.TbAdmUsuariosComponente;
import com.datamarket.components.TbCotizacionesComponente;
import com.datamarket.components.TbDetalleCotizacionComponente;
import com.datamarket.components.TbEmpresaComercialComponenteVista;
import com.datamarket.components.TbEmpresaComponente;
import com.datamarket.entidades.TbAdmRoles;
import com.datamarket.entidades.TbAdmUsuarios;
import com.datamarket.entidades.TbCasosEmpresas;
import com.datamarket.entidades.TbContactosEmpresas;
import com.datamarket.entidades.TbCotizaciones;
import com.datamarket.entidades.TbDetalleCotizacion;
import com.datamarket.entidades.TbEjecutivos;
import com.datamarket.entidades.TbEmpresaComercial;
import com.datamarket.entidades.TbEmpresas;
import com.datamarket.entidades.TbEmpresasProspecto;
import com.datamarket.entidades.TbHistorialCasos;
import com.datamarket.entidades.TbTareasEmpresas;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named("sessionUtils")
@SessionScoped

public class ObjetosSesion implements Serializable {

    private TbAdmRoles rolSesion;
    private TbAdmUsuarios usuarioSesion;
    private TbEjecutivos ejecutivoSesion;
    private TbEmpresas empresaSesion;
    private TbEmpresasProspecto empresaProspectoSesion;
    private TbEmpresaComercial empresaComercialSesion;
    private Integer booleano;
    private List<TbContactosEmpresas> contactosEmpresas;
    private TbAdmUsuarios usuarioEnSesion;
    private TbContactosEmpresas contactoEmpresa;
    private TbCasosEmpresas casoEmpresaSesion;
    private TbTareasEmpresas tareaEmpresaSesion;
    private TbHistorialCasos historialCaso;
    private TbEmpresaComercialComponenteVista empresaComercialComponenteVista;
    private TbEmpresaComponente empresaComponente;
    private TbAdmUsuarios usuarioModificar;
    private TbAdmUsuariosComponente usuarioModificarComponente;
    private TbCotizaciones cotizacion;
    private TbDetalleCotizacion detalleCotizaciones;
    private TbDetalleCotizacionComponente detalleCotizacionesComponente;
    private TbCotizacionesComponente cotizacionComponente;
    

    /*
     GETTERS Y SETTERS
     */
    public TbAdmRoles getRolSesion() {
        return rolSesion;
    }

    public void setRolSesion(TbAdmRoles rolSesion) {
        this.rolSesion = rolSesion;
    }

    public TbAdmUsuarios getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(TbAdmUsuarios usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }

    public TbEjecutivos getEjecutivoSesion() {
        return ejecutivoSesion;
    }

    public void setEjecutivoSesion(TbEjecutivos ejecutivoSesion) {
        this.ejecutivoSesion = ejecutivoSesion;
    }

    public TbEmpresas getEmpresaSesion() {
        return empresaSesion;
    }

    public void setEmpresaSesion(TbEmpresas empresaSesion) {
        this.empresaSesion = empresaSesion;
    }

    public TbEmpresasProspecto getEmpresaProspectoSesion() {
        return empresaProspectoSesion;
    }

    public void setEmpresaProspectoSesion(TbEmpresasProspecto empresaProspectoSesion) {
        this.empresaProspectoSesion = empresaProspectoSesion;
    }

    public TbEmpresaComercial getEmpresaComercialSesion() {
        return empresaComercialSesion;
    }

    public void setEmpresaComercialSesion(TbEmpresaComercial empresaComercialSesion) {
        this.empresaComercialSesion = empresaComercialSesion;
    }

    public Integer getBooleano() {
        return booleano;
    }

    public void setBooleano(Integer booleano) {
        this.booleano = booleano;
    }

    public List<TbContactosEmpresas> getContactosEmpresas() {
        return contactosEmpresas;
    }

    public void setContactosEmpresas(List<TbContactosEmpresas> contactosEmpresas) {
        this.contactosEmpresas = contactosEmpresas;
    }

    public TbContactosEmpresas getContactoEmpresa() {
        return contactoEmpresa;
    }

    public void setContactoEmpresa(TbContactosEmpresas contactoEmpresa) {
        this.contactoEmpresa = contactoEmpresa;
    }

    public TbAdmUsuarios getUsuarioEnSesion() {
        return usuarioEnSesion;
    }

    public void setUsuarioEnSesion(TbAdmUsuarios usuarioEnSesion) {
        this.usuarioEnSesion = usuarioEnSesion;
    }

    public TbCasosEmpresas getCasoEmpresaSesion() {
        return casoEmpresaSesion;
    }

    public void setCasoEmpresaSesion(TbCasosEmpresas casoEmpresaSesion) {
        this.casoEmpresaSesion = casoEmpresaSesion;
    }

    public TbTareasEmpresas getTareaEmpresaSesion() {
        return tareaEmpresaSesion;
    }

    public void setTareaEmpresaSesion(TbTareasEmpresas tareaEmpresaSesion) {
        this.tareaEmpresaSesion = tareaEmpresaSesion;
    }

    public TbHistorialCasos getHistorialCaso() {
        return historialCaso;
    }

    public void setHistorialCaso(TbHistorialCasos historialCaso) {
        this.historialCaso = historialCaso;
    }

    public TbEmpresaComercialComponenteVista getEmpresaComercialComponenteVista() {
        return empresaComercialComponenteVista;
    }

    public void setEmpresaComercialComponenteVista(TbEmpresaComercialComponenteVista empresaComercialComponenteVista) {
        this.empresaComercialComponenteVista = empresaComercialComponenteVista;
    }

    public TbEmpresaComponente getEmpresaComponente() {
        return empresaComponente;
    }

    public void setEmpresaComponente(TbEmpresaComponente empresaComponente) {
        this.empresaComponente = empresaComponente;
    }

    public TbAdmUsuarios getUsuarioModificar() {
        return usuarioModificar;
    }

    public void setUsuarioModificar(TbAdmUsuarios usuarioModificar) {
        this.usuarioModificar = usuarioModificar;
    }

    public TbAdmUsuariosComponente getUsuarioModificarComponente() {
        return usuarioModificarComponente;
    }

    public void setUsuarioModificarComponente(TbAdmUsuariosComponente usuarioModificarComponente) {
        this.usuarioModificarComponente = usuarioModificarComponente;
    }

    public TbCotizaciones getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(TbCotizaciones cotizacion) {
        this.cotizacion = cotizacion;
    }

    public TbDetalleCotizacion getDetalleCotizaciones() {
        return detalleCotizaciones;
    }

    public void setDetalleCotizaciones(TbDetalleCotizacion detalleCotizaciones) {
        this.detalleCotizaciones = detalleCotizaciones;
    }

    public TbDetalleCotizacionComponente getDetalleCotizacionesComponente() {
        return detalleCotizacionesComponente;
    }

    public void setDetalleCotizacionesComponente(TbDetalleCotizacionComponente detalleCotizacionesComponente) {
        this.detalleCotizacionesComponente = detalleCotizacionesComponente;
    }

    public TbCotizacionesComponente getCotizacionComponente() {
        return cotizacionComponente;
    }

    public void setCotizacionComponente(TbCotizacionesComponente cotizacionComponente) {
        this.cotizacionComponente = cotizacionComponente;
    }

    public void remove() {
        this.rolSesion = null;
        this.usuarioSesion = null;
        this.ejecutivoSesion = null;
        this.empresaSesion = null;
        this.empresaProspectoSesion = null;
        this.empresaComercialSesion = null;
        this.booleano = null;
        this.contactosEmpresas = null;
        this.usuarioEnSesion = null;
        this.contactoEmpresa = null;
        this.casoEmpresaSesion = null;
        this.tareaEmpresaSesion = null;
        this.historialCaso = null;
        this.empresaComercialComponenteVista = null;
        this.empresaComponente = null;
        this.usuarioModificar = null;
        this.cotizacion = null;
        this.detalleCotizaciones = null;
        this.detalleCotizacionesComponente = null;

    }
}
