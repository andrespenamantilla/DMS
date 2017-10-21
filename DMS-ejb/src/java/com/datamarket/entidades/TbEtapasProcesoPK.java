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
 * @author Andres
 */
@Embeddable
public class TbEtapasProcesoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ep_etapa")
    private String epEtapa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ep_sec_etapa")
    private int epSecEtapa;

    public TbEtapasProcesoPK() {
    }

    public TbEtapasProcesoPK(String epEtapa, int epSecEtapa) {
        this.epEtapa = epEtapa;
        this.epSecEtapa = epSecEtapa;
    }

    public String getEpEtapa() {
        return epEtapa;
    }

    public void setEpEtapa(String epEtapa) {
        this.epEtapa = epEtapa;
    }

    public int getEpSecEtapa() {
        return epSecEtapa;
    }

    public void setEpSecEtapa(int epSecEtapa) {
        this.epSecEtapa = epSecEtapa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (epEtapa != null ? epEtapa.hashCode() : 0);
        hash += (int) epSecEtapa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEtapasProcesoPK)) {
            return false;
        }
        TbEtapasProcesoPK other = (TbEtapasProcesoPK) object;
        if ((this.epEtapa == null && other.epEtapa != null) || (this.epEtapa != null && !this.epEtapa.equals(other.epEtapa))) {
            return false;
        }
        if (this.epSecEtapa != other.epSecEtapa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbEtapasProcesoPK[ epEtapa=" + epEtapa + ", epSecEtapa=" + epSecEtapa + " ]";
    }
    
}
