/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.components;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Andrés
 */
public class TbEmpresaProspectoComponente {

    private Integer pe_empresa;

    private String pe_nombre;

    private String pe_numero_id;

    private String pe_dv;

    @NotNull(message = "La dirección de la empresa es requerida.")
    private String pe_direccion;

    @NotNull(message = "Por favor seleccione un departamento.")
    private String pe_departamento;

    @NotNull(message = "Por favor seleccione una ciudad.")
    private String pe_ciudad;

    @NotNull(message = "Por favor escriba un teléfono.")
    private String pe_telefono;

    @Pattern(regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message = "Ingrese un e-mail válido.")
    private String pe_email;

    @Pattern(regexp = "(http[s]?://|ftp://)?(www\\.)?[a-zA-Z0-9-\\.]+\\.([a-zA-Z]{2,5})$", message = "Ingrese una dirección válida.")
    private String pe_sitio_web;

    @NotNull(message = "Por favor seleccione un sector.")
    private Integer pe_sector;

    @NotNull(message = "Por favor escriba los productos de la empresa.")
    private String pe_productos;

    @NotNull(message = "Por favor seleccione una referencia.")
    private String pe_referencia;

    @Pattern(regexp = "([a-zA-ZñÑáéíóúÁÉÍÓÚ ]+)$", message = "Ingrese una nombre válido.")
    private String pe_nombre_contacto;

    @Pattern(regexp = "([a-zA-ZñÑáéíóúÁÉÍÓÚ ]+)$", message = "Ingrese una apellido válido.")
    private String pe_apellido_contacto;

    private String pe_descripcion_funcion;

    private Date fecha_creacion;

    @NotNull(message = "Por favor seleccione el país.")
    private String pe_pais;

    private String pe_cargo;

    private String pe_area;

    /*Getters & Setters*/
    public Integer getPe_empresa() {
        return pe_empresa;
    }

    public void setPe_empresa(Integer pe_empresa) {
        this.pe_empresa = pe_empresa;
    }

    public String getPe_nombre() {
        return pe_nombre;
    }

    public void setPe_nombre(String pe_nombre) {
        this.pe_nombre = pe_nombre;
    }

    public String getPe_numero_id() {
        return pe_numero_id;
    }

    public void setPe_numero_id(String pe_numero_id) {
        this.pe_numero_id = pe_numero_id;
    }

    public String getPe_dv() {
        return pe_dv;
    }

    public void setPe_dv(String pe_dv) {
        this.pe_dv = pe_dv;
    }

    public String getPe_direccion() {
        return pe_direccion;
    }

    public void setPe_direccion(String pe_direccion) {
        this.pe_direccion = pe_direccion;
    }

    public String getPe_departamento() {
        return pe_departamento;
    }

    public void setPe_departamento(String pe_departamento) {
        this.pe_departamento = pe_departamento;
    }

    public String getPe_ciudad() {
        return pe_ciudad;
    }

    public void setPe_ciudad(String pe_ciudad) {
        this.pe_ciudad = pe_ciudad;
    }

    public String getPe_telefono() {
        return pe_telefono;
    }

    public void setPe_telefono(String pe_telefono) {
        this.pe_telefono = pe_telefono;
    }

    public String getPe_email() {
        return pe_email;
    }

    public void setPe_email(String pe_email) {
        this.pe_email = pe_email;
    }

    public String getPe_sitio_web() {
        return pe_sitio_web;
    }

    public void setPe_sitio_web(String pe_sitio_web) {
        this.pe_sitio_web = pe_sitio_web;
    }

    public Integer getPe_sector() {
        return pe_sector;
    }

    public void setPe_sector(Integer pe_sector) {
        this.pe_sector = pe_sector;
    }

    public String getPe_productos() {
        return pe_productos;
    }

    public void setPe_productos(String pe_productos) {
        this.pe_productos = pe_productos;
    }

    public String getPe_referencia() {
        return pe_referencia;
    }

    public void setPe_referencia(String pe_referencia) {
        this.pe_referencia = pe_referencia;
    }

    public String getPe_nombre_contacto() {
        return pe_nombre_contacto;
    }

    public void setPe_nombre_contacto(String pe_nombre_contacto) {
        this.pe_nombre_contacto = pe_nombre_contacto;
    }

    public String getPe_apellido_contacto() {
        return pe_apellido_contacto;
    }

    public void setPe_apellido_contacto(String pe_apellido_contacto) {
        this.pe_apellido_contacto = pe_apellido_contacto;
    }

    public String getPe_descripcion_funcion() {
        return pe_descripcion_funcion;
    }

    public void setPe_descripcion_funcion(String pe_descripcion_funcion) {
        this.pe_descripcion_funcion = pe_descripcion_funcion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getPe_pais() {
        return pe_pais;
    }

    public void setPe_pais(String pe_pais) {
        this.pe_pais = pe_pais;
    }

    public String getPe_cargo() {
        return pe_cargo;
    }

    public void setPe_cargo(String pe_cargo) {
        this.pe_cargo = pe_cargo;
    }

    public String getPe_area() {
        return pe_area;
    }

    public void setPe_area(String pe_area) {
        this.pe_area = pe_area;
    }
}
