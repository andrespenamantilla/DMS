/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "tb_historial_casos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbHistorialCasos.findAll", query = "SELECT t FROM TbHistorialCasos t"),
    @NamedQuery(name = "TbHistorialCasos.findByHcSecHistorial", query = "SELECT t FROM TbHistorialCasos t WHERE t.hcSecHistorial = :hcSecHistorial"),
    @NamedQuery(name = "TbHistorialCasos.findByHcSecCaso", query = "SELECT t FROM TbHistorialCasos t WHERE t.hcSecCaso = :hcSecCaso"),
    @NamedQuery(name = "TbHistorialCasos.findByHcCodEmpresa", query = "SELECT t FROM TbHistorialCasos t WHERE t.hcCodEmpresa = :hcCodEmpresa"),
    @NamedQuery(name = "TbHistorialCasos.findByHCodContacto", query = "SELECT t FROM TbHistorialCasos t WHERE t.hCodContacto = :hCodContacto"),
    @NamedQuery(name = "TbHistorialCasos.findByHcCodEtapa", query = "SELECT t FROM TbHistorialCasos t WHERE t.hcCodEtapa = :hcCodEtapa"),
    @NamedQuery(name = "TbHistorialCasos.findByHcEstadoCaso", query = "SELECT t FROM TbHistorialCasos t WHERE t.hcEstadoCaso = :hcEstadoCaso"),
    @NamedQuery(name = "TbHistorialCasos.findByHcEvento", query = "SELECT t FROM TbHistorialCasos t WHERE t.hcEvento = :hcEvento"),
    @NamedQuery(name = "TbHistorialCasos.findByHcCodTarea", query = "SELECT t FROM TbHistorialCasos t WHERE t.hcCodTarea = :hcCodTarea"),
    @NamedQuery(name = "TbHistorialCasos.findByHcEstadoTarea", query = "SELECT t FROM TbHistorialCasos t WHERE t.hcEstadoTarea = :hcEstadoTarea"),
    @NamedQuery(name = "TbHistorialCasos.findByHcAnotacion", query = "SELECT t FROM TbHistorialCasos t WHERE t.hcAnotacion = :hcAnotacion"),
    @NamedQuery(name = "TbHistorialCasos.findByHcFecha", query = "SELECT t FROM TbHistorialCasos t WHERE t.hcFecha = :hcFecha"),
    @NamedQuery(name = "TbHistorialCasos.findByHcUsuario", query = "SELECT t FROM TbHistorialCasos t WHERE t.hcUsuario = :hcUsuario")})
public class TbHistorialCasos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hc_sec_historial")
    private Integer hcSecHistorial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hc_sec_caso")
    private int hcSecCaso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hc_cod_empresa")
    private int hcCodEmpresa;
    @Column(name = "h_cod_contacto")
    private Integer hCodContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "hc_cod_etapa")
    private String hcCodEtapa;
    @Size(max = 2)
    @Column(name = "hc_estado_caso")
    private String hcEstadoCaso;
    @Size(max = 2)
    @Column(name = "hc_evento")
    private String hcEvento;
    @Column(name = "hc_cod_tarea")
    private Integer hcCodTarea;
    @Size(max = 3)
    @Column(name = "hc_estado_tarea")
    private String hcEstadoTarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "hc_anotacion")
    private String hcAnotacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hc_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hcFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hc_usuario")
    private int hcUsuario;

    public TbHistorialCasos() {
    }

    public TbHistorialCasos(Integer hcSecHistorial) {
        this.hcSecHistorial = hcSecHistorial;
    }

    public TbHistorialCasos(Integer hcSecHistorial, int hcSecCaso, int hcCodEmpresa, String hcCodEtapa, String hcAnotacion, Date hcFecha, int hcUsuario) {
        this.hcSecHistorial = hcSecHistorial;
        this.hcSecCaso = hcSecCaso;
        this.hcCodEmpresa = hcCodEmpresa;
        this.hcCodEtapa = hcCodEtapa;
        this.hcAnotacion = hcAnotacion;
        this.hcFecha = hcFecha;
        this.hcUsuario = hcUsuario;
    }

    public Integer getHcSecHistorial() {
        return hcSecHistorial;
    }

    public void setHcSecHistorial(Integer hcSecHistorial) {
        this.hcSecHistorial = hcSecHistorial;
    }

    public int getHcSecCaso() {
        return hcSecCaso;
    }

    public void setHcSecCaso(int hcSecCaso) {
        this.hcSecCaso = hcSecCaso;
    }

    public int getHcCodEmpresa() {
        return hcCodEmpresa;
    }

    public void setHcCodEmpresa(int hcCodEmpresa) {
        this.hcCodEmpresa = hcCodEmpresa;
    }

    public Integer getHCodContacto() {
        return hCodContacto;
    }

    public void setHCodContacto(Integer hCodContacto) {
        this.hCodContacto = hCodContacto;
    }

    public String getHcCodEtapa() {
        return hcCodEtapa;
    }

    public void setHcCodEtapa(String hcCodEtapa) {
        this.hcCodEtapa = hcCodEtapa;
    }

    public String getHcEstadoCaso() {
        return hcEstadoCaso;
    }

    public void setHcEstadoCaso(String hcEstadoCaso) {
        this.hcEstadoCaso = hcEstadoCaso;
    }

    public String getHcEvento() {
        return hcEvento;
    }

    public void setHcEvento(String hcEvento) {
        this.hcEvento = hcEvento;
    }

    public Integer getHcCodTarea() {
        return hcCodTarea;
    }

    public void setHcCodTarea(Integer hcCodTarea) {
        this.hcCodTarea = hcCodTarea;
    }

    public String getHcEstadoTarea() {
        return hcEstadoTarea;
    }

    public void setHcEstadoTarea(String hcEstadoTarea) {
        this.hcEstadoTarea = hcEstadoTarea;
    }

    public String getHcAnotacion() {
        return hcAnotacion;
    }

    public void setHcAnotacion(String hcAnotacion) {
        this.hcAnotacion = hcAnotacion;
    }

    public Date getHcFecha() {
        return hcFecha;
    }

    public void setHcFecha(Date hcFecha) {
        this.hcFecha = hcFecha;
    }

    public int getHcUsuario() {
        return hcUsuario;
    }

    public void setHcUsuario(int hcUsuario) {
        this.hcUsuario = hcUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hcSecHistorial != null ? hcSecHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbHistorialCasos)) {
            return false;
        }
        TbHistorialCasos other = (TbHistorialCasos) object;
        if ((this.hcSecHistorial == null && other.hcSecHistorial != null) || (this.hcSecHistorial != null && !this.hcSecHistorial.equals(other.hcSecHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbHistorialCasos[ hcSecHistorial=" + hcSecHistorial + " ]";
    }

}
