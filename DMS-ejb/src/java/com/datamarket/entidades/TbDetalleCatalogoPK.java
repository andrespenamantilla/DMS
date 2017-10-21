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
public class TbDetalleCatalogoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "dc_catalogo")
    private String dcCatalogo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "dc_codigo")
    private String dcCodigo;

    public TbDetalleCatalogoPK() {
    }

    public TbDetalleCatalogoPK(String dcCatalogo, String dcCodigo) {
        this.dcCatalogo = dcCatalogo;
        this.dcCodigo = dcCodigo;
    }

    public String getDcCatalogo() {
        return dcCatalogo;
    }

    public void setDcCatalogo(String dcCatalogo) {
        this.dcCatalogo = dcCatalogo;
    }

    public String getDcCodigo() {
        return dcCodigo;
    }

    public void setDcCodigo(String dcCodigo) {
        this.dcCodigo = dcCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dcCatalogo != null ? dcCatalogo.hashCode() : 0);
        hash += (dcCodigo != null ? dcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDetalleCatalogoPK)) {
            return false;
        }
        TbDetalleCatalogoPK other = (TbDetalleCatalogoPK) object;
        if ((this.dcCatalogo == null && other.dcCatalogo != null) || (this.dcCatalogo != null && !this.dcCatalogo.equals(other.dcCatalogo))) {
            return false;
        }
        if ((this.dcCodigo == null && other.dcCodigo != null) || (this.dcCodigo != null && !this.dcCodigo.equals(other.dcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbDetalleCatalogoPK[ dcCatalogo=" + dcCatalogo + ", dcCodigo=" + dcCodigo + " ]";
    }
    
}
