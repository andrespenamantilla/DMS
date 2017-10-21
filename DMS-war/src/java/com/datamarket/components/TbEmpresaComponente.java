/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.components;

import javax.validation.constraints.Pattern;

/**
 *
 * @author andre
 */
public class TbEmpresaComponente {

    private Integer em_id_empresas;
    private String em_nit;
    private String em_nombre;
    private String em_sector;
    private String em_dv;
    private String em_subsector;
    private String em_pais;
    private String em_depto;
    private String em_ciudad;
    @Pattern(regexp = "(?<=\\s|^)\\d+(?=\\s|$)", message = "Ingrese números para el teléfono")
    private String em_telefono1;
    @Pattern(regexp = "(?<=\\s|^)\\d+(?=\\s|$)", message = "Ingrese números para el teléfono")
    private String em_telefono2;
    private String em_direccion;
    @Pattern(regexp = "(?<=\\s|^)\\d+(?=\\s|$)", message = "Ingrese números para el teléfono")
    private String em_telefono3;
    private Integer em_fax;
    private String em_web;
    private Integer em_anio_fundacion;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*"
            + "@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Ingrese un e-mail válido")
    private String em_email;
    private String em_actividad_principal;
    private String em_ciiu1;
    private String em_ciiu2;
    private String em_ciiu3;
    private Integer em_num_empleados;
    private Character em_tipo_per;
    private String em_origen;
    private String em_celular;
    private Integer em_nro_comp;
    private String em_observaciones;
    private Character em_estado;
    private Integer em_sector_index;
    private Integer em_subsector_index;
    private Integer em_sector_list;

    /*Getters ^ Setters*/
    public Integer getEm_id_empresas() {
        return em_id_empresas;
    }

    public void setEm_id_empresas(Integer em_id_empresas) {
        this.em_id_empresas = em_id_empresas;
    }

    public String getEm_nit() {
        return em_nit;
    }

    public void setEm_nit(String em_nit) {
        this.em_nit = em_nit;
    }

    public String getEm_nombre() {
        return em_nombre;
    }

    public void setEm_nombre(String em_nombre) {
        this.em_nombre = em_nombre;
    }

    public String getEm_sector() {
        return em_sector;
    }

    public void setEm_sector(String em_sector) {
        this.em_sector = em_sector;
    }

    public String getEm_dv() {
        return em_dv;
    }

    public void setEm_dv(String em_dv) {
        this.em_dv = em_dv;
    }

    public String getEm_subsector() {
        return em_subsector;
    }

    public void setEm_subsector(String em_subsector) {
        this.em_subsector = em_subsector;
    }

    public String getEm_pais() {
        return em_pais;
    }

    public void setEm_pais(String em_pais) {
        this.em_pais = em_pais;
    }

    public String getEm_depto() {
        return em_depto;
    }

    public void setEm_depto(String em_depto) {
        this.em_depto = em_depto;
    }

    public String getEm_ciudad() {
        return em_ciudad;
    }

    public void setEm_ciudad(String em_ciudad) {
        this.em_ciudad = em_ciudad;
    }

    public String getEm_telefono1() {
        return em_telefono1;
    }

    public void setEm_telefono1(String em_telefono1) {
        this.em_telefono1 = em_telefono1;
    }

    public String getEm_telefono2() {
        return em_telefono2;
    }

    public void setEm_telefono2(String em_telefono2) {
        this.em_telefono2 = em_telefono2;
    }

    public String getEm_direccion() {
        return em_direccion;
    }

    public void setEm_direccion(String em_direccion) {
        this.em_direccion = em_direccion;
    }

    public String getEm_telefono3() {
        return em_telefono3;
    }

    public void setEm_telefono3(String em_telefono3) {
        this.em_telefono3 = em_telefono3;
    }

    public Integer getEm_fax() {
        return em_fax;
    }

    public void setEm_fax(Integer em_fax) {
        this.em_fax = em_fax;
    }

    public String getEm_web() {
        return em_web;
    }

    public void setEm_web(String em_web) {
        this.em_web = em_web;
    }

    public Integer getEm_anio_fundacion() {
        return em_anio_fundacion;
    }

    public void setEm_anio_fundacion(Integer em_anio_fundacion) {
        this.em_anio_fundacion = em_anio_fundacion;
    }

    public String getEm_email() {
        return em_email;
    }

    public void setEm_email(String em_email) {
        this.em_email = em_email;
    }

    public String getEm_actividad_principal() {
        return em_actividad_principal;
    }

    public void setEm_actividad_principal(String em_actividad_principal) {
        this.em_actividad_principal = em_actividad_principal;
    }

    public String getEm_ciiu1() {
        return em_ciiu1;
    }

    public void setEm_ciiu1(String em_ciiu1) {
        this.em_ciiu1 = em_ciiu1;
    }

    public String getEm_ciiu2() {
        return em_ciiu2;
    }

    public void setEm_ciiu2(String em_ciiu2) {
        this.em_ciiu2 = em_ciiu2;
    }

    public String getEm_ciiu3() {
        return em_ciiu3;
    }

    public void setEm_ciiu3(String em_ciiu3) {
        this.em_ciiu3 = em_ciiu3;
    }

    public Integer getEm_num_empleados() {
        return em_num_empleados;
    }

    public void setEm_num_empleados(Integer em_num_empleados) {
        this.em_num_empleados = em_num_empleados;
    }

    public Character getEm_tipo_per() {
        return em_tipo_per;
    }

    public void setEm_tipo_per(Character em_tipo_per) {
        this.em_tipo_per = em_tipo_per;
    }

    public String getEm_origen() {
        return em_origen;
    }

    public void setEm_origen(String em_origen) {
        this.em_origen = em_origen;
    }

    public String getEm_celular() {
        return em_celular;
    }

    public void setEm_celular(String em_celular) {
        this.em_celular = em_celular;
    }

    public Integer getEm_nro_comp() {
        return em_nro_comp;
    }

    public void setEm_nro_comp(Integer em_nro_comp) {
        this.em_nro_comp = em_nro_comp;
    }

    public String getEm_observaciones() {
        return em_observaciones;
    }

    public void setEm_observaciones(String em_observaciones) {
        this.em_observaciones = em_observaciones;
    }

    public Character getEm_estado() {
        return em_estado;
    }

    public void setEm_estado(Character em_estado) {
        this.em_estado = em_estado;
    }

    public Integer getEm_sector_index() {
        return em_sector_index;
    }

    public void setEm_sector_index(Integer em_sector_index) {
        this.em_sector_index = em_sector_index;
    }

    public Integer getEm_subsector_index() {
        return em_subsector_index;
    }

    public void setEm_subsector_index(Integer em_subsector_index) {
        this.em_subsector_index = em_subsector_index;
    }

    public Integer getEm_sector_list() {
        return em_sector_list;
    }

    public void setEm_sector_list(Integer em_sector_list) {
        this.em_sector_list = em_sector_list;
    }

}
