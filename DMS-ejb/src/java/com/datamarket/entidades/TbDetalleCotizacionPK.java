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

/**
 *
 * @author Andrés
 */
@Embeddable
public class TbDetalleCotizacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "dc_num_detalle")
    private int dcNumDetalle;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dc_cotizacion")
    private int dcCotizacion;

    public TbDetalleCotizacionPK() {
    }

    public TbDetalleCotizacionPK(int dcNumDetalle, int dcCotizacion) {
        this.dcNumDetalle = dcNumDetalle;
        this.dcCotizacion = dcCotizacion;
    }

    public int getDcNumDetalle() {
        return dcNumDetalle;
    }

    public void setDcNumDetalle(int dcNumDetalle) {
        this.dcNumDetalle = dcNumDetalle;
    }

    public int getDcCotizacion() {
        return dcCotizacion;
    }

    public void setDcCotizacion(int dcCotizacion) {
        this.dcCotizacion = dcCotizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dcNumDetalle;
        hash += (int) dcCotizacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDetalleCotizacionPK)) {
            return false;
        }
        TbDetalleCotizacionPK other = (TbDetalleCotizacionPK) object;
        if (this.dcNumDetalle != other.dcNumDetalle) {
            return false;
        }
        if (this.dcCotizacion != other.dcCotizacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbDetalleCotizacionPK[ dcNumDetalle=" + dcNumDetalle + ", dcCotizacion=" + dcCotizacion + " ]";
    }
    
}
