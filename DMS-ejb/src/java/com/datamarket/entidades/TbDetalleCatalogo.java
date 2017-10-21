/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "tb_detalle_catalogo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDetalleCatalogo.findAll", query = "SELECT t FROM TbDetalleCatalogo t"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCatalogo", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCodigo", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCodigo = :dcCodigo"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCatalogoCargoAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCatalogoNivelAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCatalogoAreasAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCatalogoClasifacionClienteAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCatalogoEstadoProcesoAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCatalogoEstadoTareaAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCatalogoEstadoUsuarioAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCatalogoEventosAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCatalogoSectorAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCatalogoLineaNegocioAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcTipoContactoAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCambioEstadoProcesoAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCatalogoProcesosEmpresaAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcCatalogoRefereridoProspectoEmpresaAndDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.tbDetalleCatalogoPK.dcCatalogo = :dcCatalogo AND t.dcEstado = :dcEstado"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcEstadoTarea", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.dcDescripcion = :dcDescripcion"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcDescripcion", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.dcDescripcion = :dcDescripcion"),
    @NamedQuery(name = "TbDetalleCatalogo.findByDcEstado", query = "SELECT t FROM TbDetalleCatalogo t WHERE t.dcEstado = :dcEstado")})

public class TbDetalleCatalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbDetalleCatalogoPK tbDetalleCatalogoPK;
    @Size(max = 100)
    @Column(name = "dc_descripcion")
    private String dcDescripcion;
    @Size(max = 1)
    @Column(name = "dc_estado")
    private String dcEstado;

    public TbDetalleCatalogo() {
    }

    public TbDetalleCatalogo(TbDetalleCatalogoPK tbDetalleCatalogoPK) {
        this.tbDetalleCatalogoPK = tbDetalleCatalogoPK;
    }

    public TbDetalleCatalogo(String dcCatalogo, String dcCodigo) {
        this.tbDetalleCatalogoPK = new TbDetalleCatalogoPK(dcCatalogo, dcCodigo);
    }

    public TbDetalleCatalogoPK getTbDetalleCatalogoPK() {
        return tbDetalleCatalogoPK;
    }

    public void setTbDetalleCatalogoPK(TbDetalleCatalogoPK tbDetalleCatalogoPK) {
        this.tbDetalleCatalogoPK = tbDetalleCatalogoPK;
    }

    public String getDcDescripcion() {
        return dcDescripcion;
    }

    public void setDcDescripcion(String dcDescripcion) {
        this.dcDescripcion = dcDescripcion;
    }

    public String getDcEstado() {
        return dcEstado;
    }

    public void setDcEstado(String dcEstado) {
        this.dcEstado = dcEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbDetalleCatalogoPK != null ? tbDetalleCatalogoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDetalleCatalogo)) {
            return false;
        }
        TbDetalleCatalogo other = (TbDetalleCatalogo) object;
        if ((this.tbDetalleCatalogoPK == null && other.tbDetalleCatalogoPK != null) || (this.tbDetalleCatalogoPK != null && !this.tbDetalleCatalogoPK.equals(other.tbDetalleCatalogoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbDetalleCatalogo[ tbDetalleCatalogoPK=" + tbDetalleCatalogoPK + " ]";
    }

}
