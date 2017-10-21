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
 * @author Andres
 */
@Entity
@Table(name = "tb_etapas_proceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEtapasProceso.findAll", query = "SELECT t FROM TbEtapasProceso t"),
    @NamedQuery(name = "TbEtapasProceso.findByEpEtapa", query = "SELECT t FROM TbEtapasProceso t WHERE t.tbEtapasProcesoPK.epEtapa = :epEtapa"),
    @NamedQuery(name = "TbEtapasProceso.findByEpSecEtapa", query = "SELECT t FROM TbEtapasProceso t WHERE t.tbEtapasProcesoPK.epSecEtapa = :epSecEtapa"),
    @NamedQuery(name = "TbEtapasProceso.findByEpDescEtapa", query = "SELECT t FROM TbEtapasProceso t WHERE t.epDescEtapa = :epDescEtapa"),
    @NamedQuery(name = "TbEtapasProceso.findByEpTipoProceso", query = "SELECT t FROM TbEtapasProceso t WHERE t.epTipoProceso = :epTipoProceso")})
public class TbEtapasProceso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbEtapasProcesoPK tbEtapasProcesoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ep_desc_etapa")
    private String epDescEtapa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ep_tipo_proceso")
    private String epTipoProceso;

    public TbEtapasProceso() {
    }

    public TbEtapasProceso(TbEtapasProcesoPK tbEtapasProcesoPK) {
        this.tbEtapasProcesoPK = tbEtapasProcesoPK;
    }

    public TbEtapasProceso(TbEtapasProcesoPK tbEtapasProcesoPK, String epDescEtapa, String epTipoProceso) {
        this.tbEtapasProcesoPK = tbEtapasProcesoPK;
        this.epDescEtapa = epDescEtapa;
        this.epTipoProceso = epTipoProceso;
    }

    public TbEtapasProceso(String epEtapa, int epSecEtapa) {
        this.tbEtapasProcesoPK = new TbEtapasProcesoPK(epEtapa, epSecEtapa);
    }

    public TbEtapasProcesoPK getTbEtapasProcesoPK() {
        return tbEtapasProcesoPK;
    }

    public void setTbEtapasProcesoPK(TbEtapasProcesoPK tbEtapasProcesoPK) {
        this.tbEtapasProcesoPK = tbEtapasProcesoPK;
    }

    public String getEpDescEtapa() {
        return epDescEtapa;
    }

    public void setEpDescEtapa(String epDescEtapa) {
        this.epDescEtapa = epDescEtapa;
    }

    public String getEpTipoProceso() {
        return epTipoProceso;
    }

    public void setEpTipoProceso(String epTipoProceso) {
        this.epTipoProceso = epTipoProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbEtapasProcesoPK != null ? tbEtapasProcesoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEtapasProceso)) {
            return false;
        }
        TbEtapasProceso other = (TbEtapasProceso) object;
        if ((this.tbEtapasProcesoPK == null && other.tbEtapasProcesoPK != null) || (this.tbEtapasProcesoPK != null && !this.tbEtapasProcesoPK.equals(other.tbEtapasProcesoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbEtapasProceso[ tbEtapasProcesoPK=" + tbEtapasProcesoPK + " ]";
    }
    
}
