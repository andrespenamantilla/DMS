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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "tb_casos_empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCasosEmpresas.findAll", query = "SELECT t FROM TbCasosEmpresas t"),
    @NamedQuery(name = "TbCasosEmpresas.findByCeSecCaso", query = "SELECT t FROM TbCasosEmpresas t WHERE t.ceSecCaso = :ceSecCaso"),
    @NamedQuery(name = "TbCasosEmpresas.findByCeDescripcion", query = "SELECT t FROM TbCasosEmpresas t WHERE t.ceDescripcion = :ceDescripcion"),
    @NamedQuery(name = "TbCasosEmpresas.findByCeEstado", query = "SELECT t FROM TbCasosEmpresas t WHERE t.ceEstado = :ceEstado"),
    @NamedQuery(name = "TbCasosEmpresas.findByCeLineaNegocio", query = "SELECT t FROM TbCasosEmpresas t WHERE t.ceLineaNegocio = :ceLineaNegocio"),
    @NamedQuery(name = "TbCasosEmpresas.findByCeEmpresa", query = "SELECT t FROM TbCasosEmpresas t WHERE t.ceEmpresa = :ceEmpresa"),
    @NamedQuery(name = "TbCasosEmpresas.findByCeContacto", query = "SELECT t FROM TbCasosEmpresas t WHERE t.ceContacto = :ceContacto"),
    @NamedQuery(name = "TbCasosEmpresas.findByCeCausal", query = "SELECT t FROM TbCasosEmpresas t WHERE t.ceCausal = :ceCausal"),
    @NamedQuery(name = "TbCasosEmpresas.findByCeTipoCont", query = "SELECT t FROM TbCasosEmpresas t WHERE t.ceTipoCont = :ceTipoCont"),
    @NamedQuery(name = "TbCasosEmpresas.findByCeEtapa", query = "SELECT t FROM TbCasosEmpresas t WHERE t.ceEtapa = :ceEtapa")})
public class TbCasosEmpresas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ce_sec_caso")
    private Integer ceSecCaso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ce_descripcion")
    private String ceDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ce_estado")
    private String ceEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ce_linea_negocio")
    private String ceLineaNegocio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ce_contacto")
    private int ceContacto;
    @Size(max = 2)
    @Column(name = "ce_causal")
    private String ceCausal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ce_tipo_cont")
    private String ceTipoCont;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ce_etapa")
    private int ceEtapa;
    @JoinColumn(name = "ce_empresa", referencedColumnName = "ec_empresa")
    @ManyToOne(optional = false)
    private TbEmpresaComercial ceEmpresa;

    public TbCasosEmpresas() {
    }

    public TbCasosEmpresas(Integer ceSecCaso) {
        this.ceSecCaso = ceSecCaso;
    }

    public TbCasosEmpresas(Integer ceSecCaso, String ceDescripcion, String ceEstado, String ceLineaNegocio, int ceContacto, String ceTipoCont, int ceEtapa) {
        this.ceSecCaso = ceSecCaso;
        this.ceDescripcion = ceDescripcion;
        this.ceEstado = ceEstado;
        this.ceLineaNegocio = ceLineaNegocio;
        this.ceContacto = ceContacto;
        this.ceTipoCont = ceTipoCont;
        this.ceEtapa = ceEtapa;
    }

    public Integer getCeSecCaso() {
        return ceSecCaso;
    }

    public void setCeSecCaso(Integer ceSecCaso) {
        this.ceSecCaso = ceSecCaso;
    }

    public String getCeDescripcion() {
        return ceDescripcion;
    }

    public void setCeDescripcion(String ceDescripcion) {
        this.ceDescripcion = ceDescripcion;
    }

    public String getCeEstado() {
        return ceEstado;
    }

    public void setCeEstado(String ceEstado) {
        this.ceEstado = ceEstado;
    }

    public String getCeLineaNegocio() {
        return ceLineaNegocio;
    }

    public void setCeLineaNegocio(String ceLineaNegocio) {
        this.ceLineaNegocio = ceLineaNegocio;
    }

    public int getCeContacto() {
        return ceContacto;
    }

    public void setCeContacto(int ceContacto) {
        this.ceContacto = ceContacto;
    }

    public String getCeCausal() {
        return ceCausal;
    }

    public void setCeCausal(String ceCausal) {
        this.ceCausal = ceCausal;
    }

    public String getCeTipoCont() {
        return ceTipoCont;
    }

    public void setCeTipoCont(String ceTipoCont) {
        this.ceTipoCont = ceTipoCont;
    }

    public int getCeEtapa() {
        return ceEtapa;
    }

    public void setCeEtapa(int ceEtapa) {
        this.ceEtapa = ceEtapa;
    }

    public TbEmpresaComercial getCeEmpresa() {
        return ceEmpresa;
    }

    public void setCeEmpresa(TbEmpresaComercial ceEmpresa) {
        this.ceEmpresa = ceEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ceSecCaso != null ? ceSecCaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCasosEmpresas)) {
            return false;
        }
        TbCasosEmpresas other = (TbCasosEmpresas) object;
        if ((this.ceSecCaso == null && other.ceSecCaso != null) || (this.ceSecCaso != null && !this.ceSecCaso.equals(other.ceSecCaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbCasosEmpresas[ ceSecCaso=" + ceSecCaso + " ]";
    }
    
}
