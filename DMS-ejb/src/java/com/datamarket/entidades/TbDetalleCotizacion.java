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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "tb_detalle_cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDetalleCotizacion.findAll", query = "SELECT t FROM TbDetalleCotizacion t")
    , @NamedQuery(name = "TbDetalleCotizacion.findByDcNumDetalle", query = "SELECT t FROM TbDetalleCotizacion t WHERE t.tbDetalleCotizacionPK.dcNumDetalle = :dcNumDetalle")
    , @NamedQuery(name = "TbDetalleCotizacion.findByDcCantidad", query = "SELECT t FROM TbDetalleCotizacion t WHERE t.dcCantidad = :dcCantidad")
    , @NamedQuery(name = "TbDetalleCotizacion.findByDcPrecio", query = "SELECT t FROM TbDetalleCotizacion t WHERE t.dcPrecio = :dcPrecio")
    , @NamedQuery(name = "TbDetalleCotizacion.findByDcCotizacion", query = "SELECT t FROM TbDetalleCotizacion t WHERE t.tbDetalleCotizacionPK.dcCotizacion = :dcCotizacion")
    , @NamedQuery(name = "TbDetalleCotizacion.findByDcIdProducto", query = "SELECT t FROM TbDetalleCotizacion t WHERE t.dcIdProducto = :dcIdProducto")
    , @NamedQuery(name = "TbDetalleCotizacion.findByDcCortesia", query = "SELECT t FROM TbDetalleCotizacion t WHERE t.dcCortesia = :dcCortesia")
    , @NamedQuery(name = "TbDetalleCotizacion.findByCcPorcDescto", query = "SELECT t FROM TbDetalleCotizacion t WHERE t.dcPorcDesscto = :dcPorcDescto")
    , @NamedQuery(name = "TbDetalleCotizacion.findByDcOpcion", query = "SELECT t FROM TbDetalleCotizacion t WHERE t.dcOpcion = :dcOpcion")})
public class TbDetalleCotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbDetalleCotizacionPK tbDetalleCotizacionPK;
    @Column(name = "dc_cantidad")
    private Integer dcCantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dc_precio")
    private Double dcPrecio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dc_id_producto")
    private int dcIdProducto;
    @Column(name = "dc_cortesia")
    private Character dcCortesia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dc_porc_descto")
    private float dcPorcDesscto;
    @Column(name = "dc_opcion")
    private Short dcOpcion;
    @OneToOne
    @JoinColumn(name = "dc_observacion", referencedColumnName = "dc_codigo")
    private TbObservaciones dcObservacion;

    public TbDetalleCotizacion() {
    }

    public TbDetalleCotizacion(TbDetalleCotizacionPK tbDetalleCotizacionPK) {
        this.tbDetalleCotizacionPK = tbDetalleCotizacionPK;
    }

    public TbDetalleCotizacion(TbDetalleCotizacionPK tbDetalleCotizacionPK, int dcIdProducto, float ccPorcDesscto) {
        this.tbDetalleCotizacionPK = tbDetalleCotizacionPK;
        this.dcIdProducto = dcIdProducto;
        this.dcPorcDesscto = ccPorcDesscto;
    }

    public TbDetalleCotizacion(int dcNumDetalle, int dcCotizacion) {
        this.tbDetalleCotizacionPK = new TbDetalleCotizacionPK(dcNumDetalle, dcCotizacion);
    }

    public TbDetalleCotizacionPK getTbDetalleCotizacionPK() {
        return tbDetalleCotizacionPK;
    }

    public void setTbDetalleCotizacionPK(TbDetalleCotizacionPK tbDetalleCotizacionPK) {
        this.tbDetalleCotizacionPK = tbDetalleCotizacionPK;
    }

    public Integer getDcCantidad() {
        return dcCantidad;
    }

    public void setDcCantidad(Integer dcCantidad) {
        this.dcCantidad = dcCantidad;
    }

    public Double getDcPrecio() {
        return dcPrecio;
    }

    public void setDcPrecio(Double dcPrecio) {
        this.dcPrecio = dcPrecio;
    }

    public int getDcIdProducto() {
        return dcIdProducto;
    }

    public void setDcIdProducto(int dcIdProducto) {
        this.dcIdProducto = dcIdProducto;
    }

    public Character getDcCortesia() {
        return dcCortesia;
    }

    public void setDcCortesia(Character dcCortesia) {
        this.dcCortesia = dcCortesia;
    }

    public float getDcPorcDescto() {
        return dcPorcDesscto;
    }

    public void setDcPorcDescto(float dcPorcDesscto) {
        this.dcPorcDesscto = dcPorcDesscto;
    }

    public Short getDcOpcion() {
        return dcOpcion;
    }

    public void setDcOpcion(Short dcOpcion) {
        this.dcOpcion = dcOpcion;
    }

    public TbObservaciones getDcObservacion() {
        return dcObservacion;
    }

    public void setDcObservacion(TbObservaciones dcObservacion) {
        this.dcObservacion = dcObservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbDetalleCotizacionPK != null ? tbDetalleCotizacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDetalleCotizacion)) {
            return false;
        }
        TbDetalleCotizacion other = (TbDetalleCotizacion) object;
        if ((this.tbDetalleCotizacionPK == null && other.tbDetalleCotizacionPK != null) || (this.tbDetalleCotizacionPK != null && !this.tbDetalleCotizacionPK.equals(other.tbDetalleCotizacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbDetalleCotizacion[ tbDetalleCotizacionPK=" + tbDetalleCotizacionPK + " ]";
    }

}
