/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "tb_paises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPaises.findAll", query = "SELECT t FROM TbPaises t ORDER BY t.paNombre ASC"),
    @NamedQuery(name = "TbPaises.findByPaCodigo", query = "SELECT t FROM TbPaises t WHERE t.paCodigo = :paCodigo"),
    @NamedQuery(name = "TbPaises.findByPaNombre", query = "SELECT t FROM TbPaises t WHERE t.paNombre = :paNombre")})
public class TbPaises implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "pa_codigo")
    private String paCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pa_nombre")
    private String paNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbPaises")
    private Collection<TbDepartamentos> tbDepartamentosCollection;

    public TbPaises() {
    }

    public TbPaises(String paCodigo) {
        this.paCodigo = paCodigo;
    }

    public TbPaises(String paCodigo, String paNombre) {
        this.paCodigo = paCodigo;
        this.paNombre = paNombre;
    }

    public String getPaCodigo() {
        return paCodigo;
    }

    public void setPaCodigo(String paCodigo) {
        this.paCodigo = paCodigo;
    }

    public String getPaNombre() {
        return paNombre;
    }

    public void setPaNombre(String paNombre) {
        this.paNombre = paNombre;
    }

    @XmlTransient
    public Collection<TbDepartamentos> getTbDepartamentosCollection() {
        return tbDepartamentosCollection;
    }

    public void setTbDepartamentosCollection(Collection<TbDepartamentos> tbDepartamentosCollection) {
        this.tbDepartamentosCollection = tbDepartamentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paCodigo != null ? paCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPaises)) {
            return false;
        }
        TbPaises other = (TbPaises) object;
        if ((this.paCodigo == null && other.paCodigo != null) || (this.paCodigo != null && !this.paCodigo.equals(other.paCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbPaises[ paCodigo=" + paCodigo + " ]";
    }
    
}
