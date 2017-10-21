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
import javax.persistence.ManyToOne;
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
@Table(name = "tb_empresa_comercial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEmpresaComercial.findAll", query = "SELECT t FROM TbEmpresaComercial t"),
    @NamedQuery(name = "TbEmpresaComercial.findByEcEmpresa", query = "SELECT t FROM TbEmpresaComercial t WHERE t.ecEmpresa = :ecEmpresa"),
    @NamedQuery(name = "TbEmpresaComercial.findByEcLineaNegocio", query = "SELECT t FROM TbEmpresaComercial t WHERE t.ecLineaNegocio = :ecLineaNegocio"),
    @NamedQuery(name = "TbEmpresaComercial.finbByEcEjecutivo", query = "SELECT t FROM TbEmpresaComercial t WHERE t.ecEjecutivo =:ecEjecutivo"),
    @NamedQuery(name = "TbEmpresaComercial.findByEcClasificacion", query = "SELECT t FROM TbEmpresaComercial t WHERE t.ecClasificacion = :ecClasificacion"),
    @NamedQuery(name = "TbEmpresaComercial.findByEcProvTecn", query = "SELECT t FROM TbEmpresaComercial t WHERE t.ecProvTecn = :ecProvTecn")})
public class TbEmpresaComercial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ec_empresa")
    private Integer ecEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ec_linea_negocio")
    private String ecLineaNegocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ec_clasificacion")
    private String ecClasificacion;
    @Size(max = 1)
    @Column(name = "ec_prov_tecn")
    private String ecProvTecn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ceEmpresa")
    private Collection<TbCasosEmpresas> tbCasosEmpresasCollection;
    @JoinColumn(name = "ec_ejecutivo", referencedColumnName = "ej_codigo")
    @ManyToOne(optional = false)
    private TbEjecutivos ecEjecutivo;
    @JoinColumn(name = "ec_empresa", referencedColumnName = "em_id_empresas", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TbEmpresas tbEmpresas;

    public TbEmpresaComercial() {
    }

    public TbEmpresaComercial(Integer ecEmpresa) {
        this.ecEmpresa = ecEmpresa;
    }

    public TbEmpresaComercial(Integer ecEmpresa, String ecLineaNegocio, String ecClasificacion) {
        this.ecEmpresa = ecEmpresa;
        this.ecLineaNegocio = ecLineaNegocio;
        this.ecClasificacion = ecClasificacion;
    }

    public Integer getEcEmpresa() {
        return ecEmpresa;
    }

    public void setEcEmpresa(Integer ecEmpresa) {
        this.ecEmpresa = ecEmpresa;
    }

    public String getEcLineaNegocio() {
        return ecLineaNegocio;
    }

    public void setEcLineaNegocio(String ecLineaNegocio) {
        this.ecLineaNegocio = ecLineaNegocio;
    }

    public String getEcClasificacion() {
        return ecClasificacion;
    }

    public void setEcClasificacion(String ecClasificacion) {
        this.ecClasificacion = ecClasificacion;
    }

    public String getEcProvTecn() {
        return ecProvTecn;
    }

    public void setEcProvTecn(String ecProvTecn) {
        this.ecProvTecn = ecProvTecn;
    }

    @XmlTransient
    public Collection<TbCasosEmpresas> getTbCasosEmpresasCollection() {
        return tbCasosEmpresasCollection;
    }

    public void setTbCasosEmpresasCollection(Collection<TbCasosEmpresas> tbCasosEmpresasCollection) {
        this.tbCasosEmpresasCollection = tbCasosEmpresasCollection;
    }

    public TbEjecutivos getEcEjecutivo() {
        return ecEjecutivo;
    }

    public void setEcEjecutivo(TbEjecutivos ecEjecutivo) {
        this.ecEjecutivo = ecEjecutivo;
    }

    public TbEmpresas getTbEmpresas() {
        return tbEmpresas;
    }

    public void setTbEmpresas(TbEmpresas tbEmpresas) {
        this.tbEmpresas = tbEmpresas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ecEmpresa != null ? ecEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEmpresaComercial)) {
            return false;
        }
        TbEmpresaComercial other = (TbEmpresaComercial) object;
        if ((this.ecEmpresa == null && other.ecEmpresa != null) || (this.ecEmpresa != null && !this.ecEmpresa.equals(other.ecEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbEmpresaComercial[ ecEmpresa=" + ecEmpresa + " ]";
    }
    
}
