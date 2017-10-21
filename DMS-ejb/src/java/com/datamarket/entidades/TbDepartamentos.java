/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author Andrés
 */
@Entity
@Table(name = "tb_departamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDepartamentos.findAll", query = "SELECT t FROM TbDepartamentos t"),
    @NamedQuery(name = "TbDepartamentos.findByDePais", query = "SELECT t FROM TbDepartamentos t WHERE t.tbDepartamentosPK.dePais = :dePais"),
    @NamedQuery(name = "TbDepartamentos.findByDeCodigo", query = "SELECT t FROM TbDepartamentos t WHERE t.tbDepartamentosPK.deCodigo = :deCodigo"),
    @NamedQuery(name = "TbDepartamentos.findByDeNombre", query = "SELECT t FROM TbDepartamentos t WHERE t.deNombre = :deNombre")})
public class TbDepartamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbDepartamentosPK tbDepartamentosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "de_nombre")
    private String deNombre;
    @JoinColumn(name = "de_pais", referencedColumnName = "pa_codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbPaises tbPaises;

    public TbDepartamentos() {
    }

    public TbDepartamentos(TbDepartamentosPK tbDepartamentosPK) {
        this.tbDepartamentosPK = tbDepartamentosPK;
    }

    public TbDepartamentos(TbDepartamentosPK tbDepartamentosPK, String deNombre) {
        this.tbDepartamentosPK = tbDepartamentosPK;
        this.deNombre = deNombre;
    }

    public TbDepartamentos(String dePais, String deCodigo) {
        this.tbDepartamentosPK = new TbDepartamentosPK(dePais, deCodigo);
    }

    public TbDepartamentosPK getTbDepartamentosPK() {
        return tbDepartamentosPK;
    }

    public void setTbDepartamentosPK(TbDepartamentosPK tbDepartamentosPK) {
        this.tbDepartamentosPK = tbDepartamentosPK;
    }

    public String getDeNombre() {
        return deNombre;
    }

    public void setDeNombre(String deNombre) {
        this.deNombre = deNombre;
    }

    public TbPaises getTbPaises() {
        return tbPaises;
    }

    public void setTbPaises(TbPaises tbPaises) {
        this.tbPaises = tbPaises;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbDepartamentosPK != null ? tbDepartamentosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDepartamentos)) {
            return false;
        }
        TbDepartamentos other = (TbDepartamentos) object;
        if ((this.tbDepartamentosPK == null && other.tbDepartamentosPK != null) || (this.tbDepartamentosPK != null && !this.tbDepartamentosPK.equals(other.tbDepartamentosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbDepartamentos[ tbDepartamentosPK=" + tbDepartamentosPK + " ]";
    }
    
}
