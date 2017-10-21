/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.Ifacades.ITbProductosFacadeLocal;
import com.datamarket.entidades.TbProductos;
import java.io.Serializable;
import java.util.List;
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
public class BuscarProductos implements Serializable {

    @Inject
    ITbProductosFacadeLocal productoFacade;

    private List<TbProductos> productos;

    private List<String> productosHallados;
    private String prNombre;
    private Integer prCodigo;
    private Double prPrecio;
    private Integer prStock;
    private String prCategoria;
    private TbProductos productoEliminar;

    @PostConstruct
    public void init() {

    }

    public List buscarProductosPorNombre() {
        return productosHallados = productoFacade.buscarProductoPorNombre(prNombre);

    }

    public void limpiarCampos() {
        prNombre = null;
        prPrecio = null;
        prCodigo = null;
        prCategoria = null;
        prStock = null;

    }

    public void buscarProductosPorParametros() {
        try {

            if (prNombre == null && prPrecio == null && prCodigo == null && prCategoria == null && prStock == null) {
                FacesContext.getCurrentInstance().addMessage("buscarProducto:messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "ERROR, NO HA SELECCIONADO/INGRESADO NINGÚN PARÁMETRO DE BÚSQUEDA"));

            }

            productos = productoFacade.buscarProductosPorParametrosDeBusqueda(prNombre, prCodigo, prPrecio, prCategoria, prStock);

            if (productos.size() > 0) {
                FacesContext.getCurrentInstance().addMessage("buscarProducto:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "BUSQUEDA SATISFACTORIA", "BUSQUEDA SATISFACTORIA, SE HAN ENCONTRADO " + productos.size() + " PRODUCTO(S) QUE COINCIDEN CON SU BÚSQUEDA"));
            } else {
                FacesContext.getCurrentInstance().addMessage("buscarProducto:messageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "BUSQUEDA INSATOSFACTORIA", "BUSQUEDA INSATOSFACTORIA, NO SE HAN ENCONTRADO PRODUCTOS QUE COINCIDAN CON SU BÚSQUEDA"));

            }
        } catch (Exception e) {

        }

    }

    public void asignarProductoAEliminar(TbProductos productoRow) {
        productoEliminar = productoRow;

    }


    /*Getters & Setters*/
    public String getPrNombre() {
        return prNombre;
    }

    public void setPrNombre(String prNombre) {
        this.prNombre = prNombre;
    }

    public List<String> getProductosHallados() {
        return productosHallados;
    }

    public void setProductosHallados(List<String> productosHallados) {
        this.productosHallados = productosHallados;
    }

    public Integer getPrCodigo() {
        return prCodigo;
    }

    public void setPrCodigo(Integer prCodigo) {
        this.prCodigo = prCodigo;
    }

    public Double getPrPrecio() {
        return prPrecio;
    }

    public void setPrPrecio(Double prPrecio) {
        this.prPrecio = prPrecio;
    }

    public Integer getPrStock() {
        return prStock;
    }

    public void setPrStock(Integer prStock) {
        this.prStock = prStock;
    }

    public String getPrCategoria() {
        return prCategoria;
    }

    public void setPrCategoria(String prCategoria) {
        this.prCategoria = prCategoria;
    }

    public List<TbProductos> getProductos() {
        return productos;
    }

    public void setProductos(List<TbProductos> productos) {
        this.productos = productos;
    }

}
