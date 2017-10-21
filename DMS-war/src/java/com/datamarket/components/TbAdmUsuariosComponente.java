/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.components;

import javax.validation.constraints.Pattern;

/**
 *
 * @author Andrés
 */
public class TbAdmUsuariosComponente {

    private Integer us_cod_usuario;
    private String us_login;
    private String us_password;
    private String us_tipo_id;
    private String us_tipo_id_descripcion;
    private Character us_estado;
    private String us_estado_descripcion;
    private String us_id;
    private String us_area;
    private String us_area_descripcion;
    private String us_cargo;
    private String us_cargo_descripcion;
    private String us_nombre;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*"
            + "@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Ingrese un e-mail válido")
    private String us_email;
    private Integer us_rol;

    /*Getters & Setters*/
    public Integer getUs_cod_usuario() {
        return us_cod_usuario;
    }

    public void setUs_cod_usuario(Integer us_cod_usuario) {
        this.us_cod_usuario = us_cod_usuario;
    }

    public String getUs_login() {
        return us_login;
    }

    public void setUs_login(String us_login) {
        this.us_login = us_login;
    }

    public String getUs_password() {
        return us_password;
    }

    public void setUs_password(String us_password) {
        this.us_password = us_password;
    }

    public String getUs_tipo_id() {
        return us_tipo_id;
    }

    public void setUs_tipo_id(String us_tipo_id) {
        this.us_tipo_id = us_tipo_id;
    }

    public String getUs_tipo_id_descripcion() {
        return us_tipo_id_descripcion;
    }

    public void setUs_tipo_id_descripcion(String us_tipo_id_descripcion) {
        this.us_tipo_id_descripcion = us_tipo_id_descripcion;
    }

    public Character getUs_estado() {
        return us_estado;
    }

    public void setUs_estado(Character us_estado) {
        this.us_estado = us_estado;
    }

    public String getUs_estado_descripcion() {
        return us_estado_descripcion;
    }

    public void setUs_estado_descripcion(String us_estado_descripcion) {
        this.us_estado_descripcion = us_estado_descripcion;
    }

    public String getUs_id() {
        return us_id;
    }

    public void setUs_id(String us_id) {
        this.us_id = us_id;
    }

    public String getUs_area() {
        return us_area;
    }

    public void setUs_area(String us_area) {
        this.us_area = us_area;
    }

    public String getUs_area_descripcion() {
        return us_area_descripcion;
    }

    public void setUs_area_descripcion(String us_area_descripcion) {
        this.us_area_descripcion = us_area_descripcion;
    }

    public String getUs_cargo() {
        return us_cargo;
    }

    public void setUs_cargo(String us_cargo) {
        this.us_cargo = us_cargo;
    }

    public String getUs_cargo_descripcion() {
        return us_cargo_descripcion;
    }

    public void setUs_cargo_descripcion(String us_cargo_descripcion) {
        this.us_cargo_descripcion = us_cargo_descripcion;
    }

    public String getUs_nombre() {
        return us_nombre;
    }

    public void setUs_nombre(String us_nombre) {
        this.us_nombre = us_nombre;
    }

    public String getUs_email() {
        return us_email;
    }

    public void setUs_email(String us_email) {
        this.us_email = us_email;
    }

    public Integer getUs_rol() {
        return us_rol;
    }

    public void setUs_rol(Integer us_rol) {
        this.us_rol = us_rol;
    }

}
