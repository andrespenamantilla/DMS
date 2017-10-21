/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andrés
 */
@Embeddable
public class TbCiudadesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CI_PAIS")
    private String ciPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CI_DEPTO")
    private String ciDepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CI_CIUDAD")
    private String ciCiudad;

    public TbCiudadesPK() {
    }

    public TbCiudadesPK(String ciPais, String ciDepto, String ciCiudad) {
        this.ciPais = ciPais;
        this.ciDepto = ciDepto;
        this.ciCiudad = ciCiudad;
    }

    public String getCiPais() {
        return ciPais;
    }

    public void setCiPais(String ciPais) {
        this.ciPais = ciPais;
    }

    public String getCiDepto() {
        return ciDepto;
    }

    public void setCiDepto(String ciDepto) {
        this.ciDepto = ciDepto;
    }

    public String getCiCiudad() {
        return ciCiudad;
    }

    public void setCiCiudad(String ciCiudad) {
        this.ciCiudad = ciCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciPais != null ? ciPais.hashCode() : 0);
        hash += (ciDepto != null ? ciDepto.hashCode() : 0);
        hash += (ciCiudad != null ? ciCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCiudadesPK)) {
            return false;
        }
        TbCiudadesPK other = (TbCiudadesPK) object;
        if ((this.ciPais == null && other.ciPais != null) || (this.ciPais != null && !this.ciPais.equals(other.ciPais))) {
            return false;
        }
        if ((this.ciDepto == null && other.ciDepto != null) || (this.ciDepto != null && !this.ciDepto.equals(other.ciDepto))) {
            return false;
        }
        if ((this.ciCiudad == null && other.ciCiudad != null) || (this.ciCiudad != null && !this.ciCiudad.equals(other.ciCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbCiudadesPK[ ciPais=" + ciPais + ", ciDepto=" + ciDepto + ", ciCiudad=" + ciCiudad + " ]";
    }
    
}
