/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "tb_observaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbObservaciones.findAll", query = "SELECT t FROM TbObservaciones t")
    , @NamedQuery(name = "TbObservaciones.findByDcCodigo", query = "SELECT t FROM TbObservaciones t WHERE t.dcCodigo = :dcCodigo")
    , @NamedQuery(name = "TbObservaciones.findByDcClase", query = "SELECT t FROM TbObservaciones t WHERE t.dcClase = :dcClase")
    , @NamedQuery(name = "TbObservaciones.findByDcTexto", query = "SELECT t FROM TbObservaciones t WHERE t.dcTexto = :dcTexto")})
public class TbObservaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dc_codigo")
    private Integer dcCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "dc_clase")
    private String dcClase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "dc_texto")
    private String dcTexto;

    public TbObservaciones() {
    }

    public TbObservaciones(Integer dcCodigo) {
        this.dcCodigo = dcCodigo;
    }

    public TbObservaciones(Integer dcCodigo, String dcClase, String dcTexto) {
        this.dcCodigo = dcCodigo;
        this.dcClase = dcClase;
        this.dcTexto = dcTexto;
    }

    public Integer getDcCodigo() {
        return dcCodigo;
    }

    public void setDcCodigo(Integer dcCodigo) {
        this.dcCodigo = dcCodigo;
    }

    public String getDcClase() {
        return dcClase;
    }

    public void setDcClase(String dcClase) {
        this.dcClase = dcClase;
    }

    public String getDcTexto() {
        return dcTexto;
    }

    public void setDcTexto(String dcTexto) {
        this.dcTexto = dcTexto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dcCodigo != null ? dcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbObservaciones)) {
            return false;
        }
        TbObservaciones other = (TbObservaciones) object;
        if ((this.dcCodigo == null && other.dcCodigo != null) || (this.dcCodigo != null && !this.dcCodigo.equals(other.dcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbObservaciones[ dcCodigo=" + dcCodigo + " ]";
    }
    
}
