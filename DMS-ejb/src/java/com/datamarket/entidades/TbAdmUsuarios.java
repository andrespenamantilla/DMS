/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "tb_adm_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAdmUsuarios.findAll", query = "SELECT t FROM TbAdmUsuarios t"),
    @NamedQuery(name = "TbAdmUsuarios.findByUsCodUsuario", query = "SELECT t FROM TbAdmUsuarios t WHERE t.usCodUsuario = :usCodUsuario"),
    @NamedQuery(name = "TbAdmUsuarios.findByUsLogin", query = "SELECT t FROM TbAdmUsuarios t WHERE t.usLogin = :usLogin"),
    @NamedQuery(name = "TbAdmUsuarios.findByUsPassword", query = "SELECT t FROM TbAdmUsuarios t WHERE t.usPassword = :usPassword"),
    @NamedQuery(name = "TbAdmUsuarios.findByUsTipoId", query = "SELECT t FROM TbAdmUsuarios t WHERE t.usTipoId = :usTipoId"),
    @NamedQuery(name = "TbAdmUsuarios.findByUsEstado", query = "SELECT t FROM TbAdmUsuarios t WHERE t.usEstado = :usEstado"),
    @NamedQuery(name = "TbAdmUsuarios.findByUsId", query = "SELECT t FROM TbAdmUsuarios t WHERE t.usId = :usId"),
    @NamedQuery(name = "TbAdmUsuarios.findByUsArea", query = "SELECT t FROM TbAdmUsuarios t WHERE t.usArea = :usArea"),
    @NamedQuery(name = "TbAdmUsuarios.findByLoginAndPassword", query = "SELECT t FROM TbAdmUsuarios t WHERE t.usLogin = :usLogin AND t.usPassword = :usPassword"),
    @NamedQuery(name = "TbAdmUsuarios.findByUsCargo", query = "SELECT t FROM TbAdmUsuarios t WHERE t.usCargo = :usCargo"),
    @NamedQuery(name = "TbAdmUsuarios.findByUsRol", query = "SELECT t FROM TbAdmUsuarios t WHERE t.usRol.roCodigo = :usRol"),
    @NamedQuery(name = "TbAdmUsuarios.findByUsNombre", query = "SELECT t FROM TbAdmUsuarios t WHERE t.usNombre = :usNombre")})

public class TbAdmUsuarios implements Serializable {

    @Size(max = 100)
    @Column(name = "us_email")
    private String usEmail;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "us_cod_usuario")
    private Integer usCodUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "us_login")
    private String usLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "us_password")
    private String usPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "us_tipo_id")
    private String usTipoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "us_estado")
    private Character usEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "us_id")
    private String usId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "us_area")
    private String usArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "us_cargo")
    private String usCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "us_nombre")
    private String usNombre;
    @JoinColumn(name = "us_rol", referencedColumnName = "ro_codigo")
    @ManyToOne(optional = false)
    private TbAdmRoles usRol;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbAdmUsuarios")
    private TbEjecutivos tbEjecutivos;

    public TbAdmUsuarios() {
    }

    public TbAdmUsuarios(Integer usCodUsuario) {
        this.usCodUsuario = usCodUsuario;
    }

    public TbAdmUsuarios(Integer usCodUsuario, String usLogin, String usPassword, String usTipoId, Character usEstado, String usId, String usArea, String usCargo, String usNombre) {
        this.usCodUsuario = usCodUsuario;
        this.usLogin = usLogin;
        this.usPassword = usPassword;
        this.usTipoId = usTipoId;
        this.usEstado = usEstado;
        this.usId = usId;
        this.usArea = usArea;
        this.usCargo = usCargo;
        this.usNombre = usNombre;
    }

    public Integer getUsCodUsuario() {
        return usCodUsuario;
    }

    public void setUsCodUsuario(Integer usCodUsuario) {
        this.usCodUsuario = usCodUsuario;
    }

    public String getUsLogin() {
        return usLogin;
    }

    public void setUsLogin(String usLogin) {
        this.usLogin = usLogin;
    }

    public String getUsPassword() {
        return usPassword;
    }

    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword;
    }

    public String getUsTipoId() {
        return usTipoId;
    }

    public void setUsTipoId(String usTipoId) {
        this.usTipoId = usTipoId;
    }

    public Character getUsEstado() {
        return usEstado;
    }

    public void setUsEstado(Character usEstado) {
        this.usEstado = usEstado;
    }

    public String getUsId() {
        return usId;
    }

    public void setUsId(String usId) {
        this.usId = usId;
    }

    public String getUsArea() {
        return usArea;
    }

    public void setUsArea(String usArea) {
        this.usArea = usArea;
    }

    public String getUsCargo() {
        return usCargo;
    }

    public void setUsCargo(String usCargo) {
        this.usCargo = usCargo;
    }

    public String getUsNombre() {
        return usNombre;
    }

    public void setUsNombre(String usNombre) {
        this.usNombre = usNombre;
    }

    public TbAdmRoles getUsRol() {
        return usRol;
    }

    public void setUsRol(TbAdmRoles usRol) {
        this.usRol = usRol;
    }

    public TbEjecutivos getTbEjecutivos() {
        return tbEjecutivos;
    }

    public void setTbEjecutivos(TbEjecutivos tbEjecutivos) {
        this.tbEjecutivos = tbEjecutivos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usCodUsuario != null ? usCodUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAdmUsuarios)) {
            return false;
        }
        TbAdmUsuarios other = (TbAdmUsuarios) object;
        if ((this.usCodUsuario == null && other.usCodUsuario != null) || (this.usCodUsuario != null && !this.usCodUsuario.equals(other.usCodUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbAdmUsuarios[ usCodUsuario=" + usCodUsuario + " ]";
    }

    public String getUsEmail() {
        return usEmail;
    }

    public void setUsEmail(String usEmail) {
        this.usEmail = usEmail;
    }
    
}
