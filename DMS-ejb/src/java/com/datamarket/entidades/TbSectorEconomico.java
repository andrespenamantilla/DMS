/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "tb_sector_economico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSectorEconomico.findAll", query = "SELECT t FROM TbSectorEconomico t")
    , @NamedQuery(name = "TbSectorEconomico.findBySeCodigo", query = "SELECT t FROM TbSectorEconomico t WHERE t.seCodigo = :seCodigo")
    , @NamedQuery(name = "TbSectorEconomico.findBySeDescripcion", query = "SELECT t FROM TbSectorEconomico t WHERE t.seDescripcion = :seDescripcion")})
public class TbSectorEconomico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "se_codigo")
    private Integer seCodigo;
    @Size(max = 150)
    @Column(name = "se_descripcion")
    private String seDescripcion;

    public TbSectorEconomico() {
    }

    public TbSectorEconomico(Integer seCodigo) {
        this.seCodigo = seCodigo;
    }

    public Integer getSeCodigo() {
        return seCodigo;
    }

    public void setSeCodigo(Integer seCodigo) {
        this.seCodigo = seCodigo;
    }

    public String getSeDescripcion() {
        return seDescripcion;
    }

    public void setSeDescripcion(String seDescripcion) {
        this.seDescripcion = seDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seCodigo != null ? seCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbSectorEconomico)) {
            return false;
        }
        TbSectorEconomico other = (TbSectorEconomico) object;
        if ((this.seCodigo == null && other.seCodigo != null) || (this.seCodigo != null && !this.seCodigo.equals(other.seCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbSectorEconomico[ seCodigo=" + seCodigo + " ]";
    }
    
}
