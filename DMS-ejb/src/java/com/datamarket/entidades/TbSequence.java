/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "tb_sequence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSequence.findAll", query = "SELECT t FROM TbSequence t")
    , @NamedQuery(name = "TbSequence.findBySeqDcNumDetalle", query = "SELECT t FROM TbSequence t WHERE t.seqDcNumDetalle = :seqDcNumDetalle")
    , @NamedQuery(name = "TbSequence.findBySeqDcCotizacion", query = "SELECT t FROM TbSequence t WHERE t.seqDcCotizacion = :seqDcCotizacion")
    , @NamedQuery(name = "TbSequence.findBySeqKey", query = "SELECT t FROM TbSequence t WHERE t.seqKey = :seqKey")})
public class TbSequence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "seq_dc_num_detalle")
    private BigInteger seqDcNumDetalle;
    @Column(name = "seq_dc_cotizacion")
    private BigInteger seqDcCotizacion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seq_key")
    private Long seqKey;

    public TbSequence() {
    }

    public TbSequence(Long seqKey) {
        this.seqKey = seqKey;
    }

    public BigInteger getSeqDcNumDetalle() {
        return seqDcNumDetalle;
    }

    public void setSeqDcNumDetalle(BigInteger seqDcNumDetalle) {
        this.seqDcNumDetalle = seqDcNumDetalle;
    }

    public BigInteger getSeqDcCotizacion() {
        return seqDcCotizacion;
    }

    public void setSeqDcCotizacion(BigInteger seqDcCotizacion) {
        this.seqDcCotizacion = seqDcCotizacion;
    }

    public Long getSeqKey() {
        return seqKey;
    }

    public void setSeqKey(Long seqKey) {
        this.seqKey = seqKey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqKey != null ? seqKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbSequence)) {
            return false;
        }
        TbSequence other = (TbSequence) object;
        if ((this.seqKey == null && other.seqKey != null) || (this.seqKey != null && !this.seqKey.equals(other.seqKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbSequence[ seqKey=" + seqKey + " ]";
    }
    
}
