/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.Ifacades.ITbProductosFacadeLocal;
import com.datamarket.components.TbProductoComponente;
import com.datamarket.converter.TbProductosConverter;
import com.datamarket.entidades.TbProductos;
import java.io.Serializable;
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
public class ProductoNuevo implements Serializable {

    @Inject
    private ITbProductosFacadeLocal productosFacade;
    @Inject
    TbProductosConverter productosConverter;

    private TbProductos productoNuevo;
    private TbProductoComponente productoComponenteNuevo;
    private boolean habilitarCampos;

    @PostConstruct
    public void init() {
        productoNuevo = new TbProductos();
        productoComponenteNuevo = new TbProductoComponente();
        habilitarCampos = true;
    }

    public void insertarProducto() {
        try {
            productoNuevo = productosConverter.convertirComponenteAEntidad(productoComponenteNuevo);
            productosFacade.persistirProducto(productoNuevo);
            productoComponenteNuevo = new TbProductoComponente();
            FacesContext.getCurrentInstance().addMessage("nuevoProducto:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "EL PRODUCTO FUE AGREGADO SATISFACTORIAMENTE"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("nuevoProducto:messageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "EL PRODUCTO NO HA PODIDO SER AGREGADO"));

        }
    }

    public void habilitarCamposFormulario() {
        habilitarCampos = false;

    }

    public void deshabilitarCamposFormulario() {
        habilitarCampos = true;
    }

    public String irBusquedaListaProductos() {

        return "irBusquedaListaProductos";
    }

    /*Getters & Setters*/
    public TbProductos getProductoNuevo() {
        return productoNuevo;
    }

    public void setProductoNuevo(TbProductos productoNuevo) {
        this.productoNuevo = productoNuevo;
    }

    public TbProductoComponente getProductoComponenteNuevo() {
        return productoComponenteNuevo;
    }

    public void setProductoComponenteNuevo(TbProductoComponente productoComponenteNuevo) {
        this.productoComponenteNuevo = productoComponenteNuevo;
    }

    public boolean isHabilitarCampos() {
        return habilitarCampos;
    }

    public void setHabilitarCampos(boolean habilitarCampos) {
        this.habilitarCampos = habilitarCampos;
    }

}
