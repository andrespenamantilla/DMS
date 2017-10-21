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
@Table(name = "tb_ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCiudades.findAll", query = "SELECT t FROM TbCiudades t"),
    @NamedQuery(name = "TbCiudades.findByCiPais", query = "SELECT t FROM TbCiudades t WHERE t.tbCiudadesPK.ciPais = :ciPais"),
    @NamedQuery(name = "TbCiudades.findByCiDepto", query = "SELECT t FROM TbCiudades t WHERE t.tbCiudadesPK.ciDepto = :ciDepto"),
    @NamedQuery(name = "TbCiudades.findByCiCiudad", query = "SELECT t FROM TbCiudades t WHERE t.tbCiudadesPK.ciCiudad = :ciCiudad"),
    @NamedQuery(name = "TbCiudades.findByCiNombre", query = "SELECT t FROM TbCiudades t WHERE t.ciNombre = :ciNombre")})
public class TbCiudades implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbCiudadesPK tbCiudadesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ci_nombre")
    private String ciNombre;

    public TbCiudades() {
    }

    public TbCiudades(TbCiudadesPK tbCiudadesPK) {
        this.tbCiudadesPK = tbCiudadesPK;
    }

    public TbCiudades(TbCiudadesPK tbCiudadesPK, String ciNombre) {
        this.tbCiudadesPK = tbCiudadesPK;
        this.ciNombre = ciNombre;
    }

    public TbCiudades(String ciPais, String ciDepto, String ciCiudad) {
        this.tbCiudadesPK = new TbCiudadesPK(ciPais, ciDepto, ciCiudad);
    }

    public TbCiudadesPK getTbCiudadesPK() {
        return tbCiudadesPK;
    }

    public void setTbCiudadesPK(TbCiudadesPK tbCiudadesPK) {
        this.tbCiudadesPK = tbCiudadesPK;
    }

    public String getCiNombre() {
        return ciNombre;
    }

    public void setCiNombre(String ciNombre) {
        this.ciNombre = ciNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbCiudadesPK != null ? tbCiudadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCiudades)) {
            return false;
        }
        TbCiudades other = (TbCiudades) object;
        if ((this.tbCiudadesPK == null && other.tbCiudadesPK != null) || (this.tbCiudadesPK != null && !this.tbCiudadesPK.equals(other.tbCiudadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbCiudades[ tbCiudadesPK=" + tbCiudadesPK + " ]";
    }
    
}
