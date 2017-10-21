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
public class TbDepartamentosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "de_pais")
    private String dePais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "de_codigo")
    private String deCodigo;

    public TbDepartamentosPK() {
    }

    public TbDepartamentosPK(String dePais, String deCodigo) {
        this.dePais = dePais;
        this.deCodigo = deCodigo;
    }

    public String getDePais() {
        return dePais;
    }

    public void setDePais(String dePais) {
        this.dePais = dePais;
    }

    public String getDeCodigo() {
        return deCodigo;
    }

    public void setDeCodigo(String deCodigo) {
        this.deCodigo = deCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dePais != null ? dePais.hashCode() : 0);
        hash += (deCodigo != null ? deCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDepartamentosPK)) {
            return false;
        }
        TbDepartamentosPK other = (TbDepartamentosPK) object;
        if ((this.dePais == null && other.dePais != null) || (this.dePais != null && !this.dePais.equals(other.dePais))) {
            return false;
        }
        if ((this.deCodigo == null && other.deCodigo != null) || (this.deCodigo != null && !this.deCodigo.equals(other.deCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbDepartamentosPK[ dePais=" + dePais + ", deCodigo=" + deCodigo + " ]";
    }
    
}
