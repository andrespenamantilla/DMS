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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "tb_cotizaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCotizaciones.findAll", query = "SELECT t FROM TbCotizaciones t")
    , @NamedQuery(name = "TbCotizaciones.findByCoCodCotiz", query = "SELECT t FROM TbCotizaciones t WHERE t.coCodCotiz = :coCodCotiz")
    , @NamedQuery(name = "TbCotizaciones.findByCoEmpresa", query = "SELECT t FROM TbCotizaciones t WHERE t.coEmpresa = :coEmpresa")
    , @NamedQuery(name = "TbCotizaciones.findByCoEjecutivo", query = "SELECT t FROM TbCotizaciones t WHERE t.coEjecutivo = :coEjecutivo")
    , @NamedQuery(name = "TbCotizaciones.findByCoFecha", query = "SELECT t FROM TbCotizaciones t WHERE t.coFecha = :coFecha")
    , @NamedQuery(name = "TbCotizaciones.findByCoCaso", query = "SELECT t FROM TbCotizaciones t WHERE t.coCaso = :coCaso")})
public class TbCotizaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "co_cod_cotiz")
    private Integer coCodCotiz;
    @Column(name = "co_empresa")
    private Integer coEmpresa;
    @Column(name = "co_ejecutivo")
    private Integer coEjecutivo;
    @Column(name = "co_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date coFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "co_caso")
    private int coCaso;

    public TbCotizaciones() {
    }

    public TbCotizaciones(Integer coCodCotiz) {
        this.coCodCotiz = coCodCotiz;
    }

    public TbCotizaciones(Integer coCodCotiz, int coCaso) {
        this.coCodCotiz = coCodCotiz;
        this.coCaso = coCaso;
    }

    public Integer getCoCodCotiz() {
        return coCodCotiz;
    }

    public void setCoCodCotiz(Integer coCodCotiz) {
        this.coCodCotiz = coCodCotiz;
    }

    public Integer getCoEmpresa() {
        return coEmpresa;
    }

    public void setCoEmpresa(Integer coEmpresa) {
        this.coEmpresa = coEmpresa;
    }

    public Integer getCoEjecutivo() {
        return coEjecutivo;
    }

    public void setCoEjecutivo(Integer coEjecutivo) {
        this.coEjecutivo = coEjecutivo;
    }

    public Date getCoFecha() {
        return coFecha;
    }

    public void setCoFecha(Date coFecha) {
        this.coFecha = coFecha;
    }

    public int getCoCaso() {
        return coCaso;
    }

    public void setCoCaso(int coCaso) {
        this.coCaso = coCaso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coCodCotiz != null ? coCodCotiz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCotizaciones)) {
            return false;
        }
        TbCotizaciones other = (TbCotizaciones) object;
        if ((this.coCodCotiz == null && other.coCodCotiz != null) || (this.coCodCotiz != null && !this.coCodCotiz.equals(other.coCodCotiz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbCotizaciones[ coCodCotiz=" + coCodCotiz + " ]";
    }
    
}
