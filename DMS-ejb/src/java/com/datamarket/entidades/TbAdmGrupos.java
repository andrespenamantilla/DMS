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
 * @author Andres
 */
@Entity
@Table(name = "tb_adm_grupos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAdmGrupos.findAll", query = "SELECT t FROM TbAdmGrupos t"),
    @NamedQuery(name = "TbAdmGrupos.findByGrNombreGrupo", query = "SELECT t FROM TbAdmGrupos t WHERE t.grNombreGrupo = :grNombreGrupo"),
    @NamedQuery(name = "TbAdmGrupos.findByGrUsuLogin", query = "SELECT t FROM TbAdmGrupos t WHERE t.grUsuLogin = :grUsuLogin")})
public class TbAdmGrupos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gr_nombre_grupo")
    private String grNombreGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gr_usu_login")
    private String grUsuLogin;

    public TbAdmGrupos() {
    }

    public TbAdmGrupos(String grNombreGrupo) {
        this.grNombreGrupo = grNombreGrupo;
    }

    public TbAdmGrupos(String grNombreGrupo, String grUsuLogin) {
        this.grNombreGrupo = grNombreGrupo;
        this.grUsuLogin = grUsuLogin;
    }

    public String getGrNombreGrupo() {
        return grNombreGrupo;
    }

    public void setGrNombreGrupo(String grNombreGrupo) {
        this.grNombreGrupo = grNombreGrupo;
    }

    public String getGrUsuLogin() {
        return grUsuLogin;
    }

    public void setGrUsuLogin(String grUsuLogin) {
        this.grUsuLogin = grUsuLogin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grNombreGrupo != null ? grNombreGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAdmGrupos)) {
            return false;
        }
        TbAdmGrupos other = (TbAdmGrupos) object;
        if ((this.grNombreGrupo == null && other.grNombreGrupo != null) || (this.grNombreGrupo != null && !this.grNombreGrupo.equals(other.grNombreGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbAdmGrupos[ grNombreGrupo=" + grNombreGrupo + " ]";
    }
    
}
