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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "tb_ejecutivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEjecutivos.findAll", query = "SELECT t FROM TbEjecutivos t"),
    @NamedQuery(name = "TbEjecutivos.findByEjEstado", query = "SELECT t FROM TbEjecutivos t WHERE t.ejEstado = :ejEstado"),
    @NamedQuery(name = "TbEjecutivos.findByEjCodigo", query = "SELECT t FROM TbEjecutivos t WHERE t.ejCodigo = :ejCodigo")})
public class TbEjecutivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ej_estado")
    private String ejEstado;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ej_codigo")
    private Integer ejCodigo;
    @JoinColumn(name = "ej_codigo", referencedColumnName = "us_cod_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TbAdmUsuarios tbAdmUsuarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ecEjecutivo")
    private Collection<TbEmpresaComercial> tbEmpresaComercialCollection;

    public TbEjecutivos() {
    }

    public TbEjecutivos(Integer ejCodigo) {
        this.ejCodigo = ejCodigo;
    }

    public TbEjecutivos(Integer ejCodigo, String ejEstado) {
        this.ejCodigo = ejCodigo;
        this.ejEstado = ejEstado;
    }

    public String getEjEstado() {
        return ejEstado;
    }

    public void setEjEstado(String ejEstado) {
        this.ejEstado = ejEstado;
    }

    public Integer getEjCodigo() {
        return ejCodigo;
    }

    public void setEjCodigo(Integer ejCodigo) {
        this.ejCodigo = ejCodigo;
    }

    public TbAdmUsuarios getTbAdmUsuarios() {
        return tbAdmUsuarios;
    }

    public void setTbAdmUsuarios(TbAdmUsuarios tbAdmUsuarios) {
        this.tbAdmUsuarios = tbAdmUsuarios;
    }

    @XmlTransient
    public Collection<TbEmpresaComercial> getTbEmpresaComercialCollection() {
        return tbEmpresaComercialCollection;
    }

    public void setTbEmpresaComercialCollection(Collection<TbEmpresaComercial> tbEmpresaComercialCollection) {
        this.tbEmpresaComercialCollection = tbEmpresaComercialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ejCodigo != null ? ejCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEjecutivos)) {
            return false;
        }
        TbEjecutivos other = (TbEjecutivos) object;
        if ((this.ejCodigo == null && other.ejCodigo != null) || (this.ejCodigo != null && !this.ejCodigo.equals(other.ejCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbEjecutivos[ ejCodigo=" + ejCodigo + " ]";
    }
    
}
