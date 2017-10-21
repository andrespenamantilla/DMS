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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "tb_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProductos.findAll", query = "SELECT t FROM TbProductos t")
    , @NamedQuery(name = "TbProductos.findByPrCodigo", query = "SELECT t FROM TbProductos t WHERE t.prCodigo = :prCodigo")
    , @NamedQuery(name = "TbProductos.findByPrNombre", query = "SELECT t FROM TbProductos t WHERE t.prNombre = :prNombre")
    , @NamedQuery(name = "TbProductos.findByPrPrecio", query = "SELECT t FROM TbProductos t WHERE t.prPrecio = :prPrecio")
    , @NamedQuery(name = "TbProductos.findByPrStock", query = "SELECT t FROM TbProductos t WHERE t.prStock = :prStock")
    , @NamedQuery(name = "TbProductos.findByPrCategoria", query = "SELECT t FROM TbProductos t WHERE t.prCategoria = :prCategoria")})
public class TbProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pr_codigo")
    private Integer prCodigo;
    @Size(max = 100)
    @Column(name = "pr_nombre")
    private String prNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pr_precio")
    private Double prPrecio;
    @Column(name = "pr_stock")
    private Integer prStock;
    @Size(max = 3)
    @Column(name = "pr_categoria")
    private String prCategoria;

    public TbProductos() {
    }

    public TbProductos(Integer prCodigo) {
        this.prCodigo = prCodigo;
    }

    public Integer getPrCodigo() {
        return prCodigo;
    }

    public void setPrCodigo(Integer prCodigo) {
        this.prCodigo = prCodigo;
    }

    public String getPrNombre() {
        return prNombre;
    }

    public void setPrNombre(String prNombre) {
        this.prNombre = prNombre;
    }

    public Double getPrPrecio() {
        return prPrecio;
    }

    public void setPrPrecio(Double prPrecio) {
        this.prPrecio = prPrecio;
    }

    public Integer getPrStock() {
        return prStock;
    }

    public void setPrStock(Integer prStock) {
        this.prStock = prStock;
    }

    public String getPrCategoria() {
        return prCategoria;
    }

    public void setPrCategoria(String prCategoria) {
        this.prCategoria = prCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prCodigo != null ? prCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProductos)) {
            return false;
        }
        TbProductos other = (TbProductos) object;
        if ((this.prCodigo == null && other.prCodigo != null) || (this.prCodigo != null && !this.prCodigo.equals(other.prCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbProductos[ prCodigo=" + prCodigo + " ]";
    }
    
}
