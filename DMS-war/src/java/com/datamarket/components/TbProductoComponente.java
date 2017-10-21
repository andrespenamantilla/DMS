/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.components;

import java.lang.annotation.Documented;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Andrés
 */
public class TbProductoComponente {

    @NotNull(message = "El nombre del Producto es requerido")
    private String pr_nombre;
    @NotNull(message = "El nombre del precio delProducto es requerido")
    private String pr_precio;
    @NotNull(message = "La cantidad en stock es requerida")
    private Integer pr_stock;
    @NotNull(message = "La categoria es requerida")
    private String pr_categoria;
    private Integer pr_codigo;

    /*Getters & Setters*/
    public String getPr_nombre() {
        return pr_nombre;
    }

    public void setPr_nombre(String pr_nombre) {
        this.pr_nombre = pr_nombre;
    }

    public String getPr_precio() {
        return pr_precio;
    }

    public void setPr_precio(String pr_precio) {
        this.pr_precio = pr_precio;
    }

    public Integer getPr_stock() {
        return pr_stock;
    }

    public void setPr_stock(Integer pr_stock) {
        this.pr_stock = pr_stock;
    }

    public String getPr_categoria() {
        return pr_categoria;
    }

    public void setPr_categoria(String pr_categoria) {
        this.pr_categoria = pr_categoria;
    }

    public Integer getPr_codigo() {
        return pr_codigo;
    }

    public void setPr_codigo(Integer pr_codigo) {
        this.pr_codigo = pr_codigo;
    }

}
