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
@Table(name = "tb_adm_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAdmRoles.findAll", query = "SELECT t FROM TbAdmRoles t"),
    @NamedQuery(name = "TbAdmRoles.findByRoCodigo", query = "SELECT t FROM TbAdmRoles t WHERE t.roCodigo = :roCodigo"),
    @NamedQuery(name = "TbAdmRoles.findByRoDescripcion", query = "SELECT t FROM TbAdmRoles t WHERE t.roDescripcion = :roDescripcion")})
public class TbAdmRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ro_codigo")
    private Integer roCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ro_descripcion")
    private String roDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usRol")
    private Collection<TbAdmUsuarios> tbAdmUsuariosCollection;

    public TbAdmRoles() {
    }

    public TbAdmRoles(Integer roCodigo) {
        this.roCodigo = roCodigo;
    }

    public TbAdmRoles(Integer roCodigo, String roDescripcion) {
        this.roCodigo = roCodigo;
        this.roDescripcion = roDescripcion;
    }

    public Integer getRoCodigo() {
        return roCodigo;
    }

    public void setRoCodigo(Integer roCodigo) {
        this.roCodigo = roCodigo;
    }

    public String getRoDescripcion() {
        return roDescripcion;
    }

    public void setRoDescripcion(String roDescripcion) {
        this.roDescripcion = roDescripcion;
    }

    @XmlTransient
    public Collection<TbAdmUsuarios> getTbAdmUsuariosCollection() {
        return tbAdmUsuariosCollection;
    }

    public void setTbAdmUsuariosCollection(Collection<TbAdmUsuarios> tbAdmUsuariosCollection) {
        this.tbAdmUsuariosCollection = tbAdmUsuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roCodigo != null ? roCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAdmRoles)) {
            return false;
        }
        TbAdmRoles other = (TbAdmRoles) object;
        if ((this.roCodigo == null && other.roCodigo != null) || (this.roCodigo != null && !this.roCodigo.equals(other.roCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbAdmRoles[ roCodigo=" + roCodigo + " ]";
    }
    
}
