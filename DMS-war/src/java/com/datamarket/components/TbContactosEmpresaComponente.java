/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.components;

import java.util.Date;
import javax.validation.constraints.Pattern;

/**
 *
 * @author andre
 */
public class TbContactosEmpresaComponente {

    private Integer ce_secuencial;
    private Integer ce_codigo_empresa;
    private String ce_nombres;
    private String ce_apellidos;
    private String ce_cargo;
    private String ce_area;
    private String nombre_empresa;
    private String ce_descripcion_funcion;
    @Pattern(regexp = "(?<=\\s|^)\\d+(?=\\s|$)", message = "Ingrese números para el teléfono")
    private String ce_telefono;
    @Pattern(regexp = "(?<=\\s|^)\\d+(?=\\s|$)", message = "Ingrese números para la extensión")
    private String ce_ext_tel;
    private String ce_direccion;
    private String ce_pais;
    private String ce_depto;
    private String ce_ciudad;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*"
            + "@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Ingrese un e-mail válido")
    private String ce_email_corp;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*"
            + "@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Ingrese un e-mail válido")

    private String ce_email_personal;
    private Character ce_estado;
    @Pattern(regexp = "(?<=\\s|^)\\d+(?=\\s|$)", message = "Ingrese números para el celular")
    private String ce_celular;
    private Character ce_sw_contacto;
    private Date ce_fecha_crea;
    private Date ce_fecha_ult_mod;

    /*Getters & Setters*/
    public Integer getCe_secuencial() {
        return ce_secuencial;
    }

    public void setCe_secuencial(Integer ce_secuencial) {
        this.ce_secuencial = ce_secuencial;
    }

    public Integer getCe_codigo_empresa() {
        return ce_codigo_empresa;
    }

    public void setCe_codigo_empresa(Integer ce_codigo_empresa) {
        this.ce_codigo_empresa = ce_codigo_empresa;
    }

    public String getCe_nombres() {
        return ce_nombres;
    }

    public void setCe_nombres(String ce_nombres) {
        this.ce_nombres = ce_nombres;
    }

    public String getCe_apellidos() {
        return ce_apellidos;
    }

    public void setCe_apellidos(String ce_apellidos) {
        this.ce_apellidos = ce_apellidos;
    }

    public String getCe_cargo() {
        return ce_cargo;
    }

    public void setCe_cargo(String ce_cargo) {
        this.ce_cargo = ce_cargo;
    }

    public String getCe_area() {
        return ce_area;
    }

    public void setCe_area(String ce_area) {
        this.ce_area = ce_area;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getCe_descripcion_funcion() {
        return ce_descripcion_funcion;
    }

    public void setCe_descripcion_funcion(String ce_descripcion_funcion) {
        this.ce_descripcion_funcion = ce_descripcion_funcion;
    }

    public String getCe_telefono() {
        return ce_telefono;
    }

    public void setCe_telefono(String ce_telefono) {
        this.ce_telefono = ce_telefono;
    }

    public String getCe_ext_tel() {
        return ce_ext_tel;
    }

    public void setCe_ext_tel(String ce_ext_tel) {
        this.ce_ext_tel = ce_ext_tel;
    }

    public String getCe_direccion() {
        return ce_direccion;
    }

    public void setCe_direccion(String ce_direccion) {
        this.ce_direccion = ce_direccion;
    }

    public String getCe_pais() {
        return ce_pais;
    }

    public void setCe_pais(String ce_pais) {
        this.ce_pais = ce_pais;
    }

    public String getCe_depto() {
        return ce_depto;
    }

    public void setCe_depto(String ce_depto) {
        this.ce_depto = ce_depto;
    }

    public String getCe_ciudad() {
        return ce_ciudad;
    }

    public void setCe_ciudad(String ce_ciudad) {
        this.ce_ciudad = ce_ciudad;
    }

    public String getCe_email_corp() {
        return ce_email_corp;
    }

    public void setCe_email_corp(String ce_email_corp) {
        this.ce_email_corp = ce_email_corp;
    }

    public String getCe_email_personal() {
        return ce_email_personal;
    }

    public void setCe_email_personal(String ce_email_personal) {
        this.ce_email_personal = ce_email_personal;
    }

    public Character getCe_estado() {
        return ce_estado;
    }

    public void setCe_estado(Character ce_estado) {
        this.ce_estado = ce_estado;
    }

    public String getCe_celular() {
        return ce_celular;
    }

    public void setCe_celular(String ce_celular) {
        this.ce_celular = ce_celular;
    }

    public Character getCe_sw_contacto() {
        return ce_sw_contacto;
    }

    public void setCe_sw_contacto(Character ce_sw_contacto) {
        this.ce_sw_contacto = ce_sw_contacto;
    }

    public Date getCe_fecha_crea() {
        return ce_fecha_crea;
    }

    public void setCe_fecha_crea(Date ce_fecha_crea) {
        this.ce_fecha_crea = ce_fecha_crea;
    }

    public Date getCe_fecha_ult_mod() {
        return ce_fecha_ult_mod;
    }

    public void setCe_fecha_ult_mod(Date ce_fecha_ult_mod) {
        this.ce_fecha_ult_mod = ce_fecha_ult_mod;
    }
}
