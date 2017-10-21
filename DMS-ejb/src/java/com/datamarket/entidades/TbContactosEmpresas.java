/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "tb_contactos_empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbContactosEmpresas.findAll", query = "SELECT t FROM TbContactosEmpresas t"),
    @NamedQuery(name = "TbContactosEmpresas.findByCeSecuencial", query = "SELECT t FROM TbContactosEmpresas t WHERE t.ceSecuencial = :ceSecuencial"),
    @NamedQuery(name = "TbContactosEmpresas.findByCeNombres", query = "SELECT t FROM TbContactosEmpresas t WHERE t.ceNombres = :ceNombres"),
    @NamedQuery(name = "TbContactosEmpresas.findByCeApellidos", query = "SELECT t FROM TbContactosEmpresas t WHERE t.ceApellidos = :ceApellidos"),
    @NamedQuery(name = "TbContactosEmpresas.findByCeCargo", query = "SELECT t FROM TbContactosEmpresas t WHERE t.ceCargo = :ceCargo"),
    @NamedQuery(name = "TbContactosEmpresas.findByCeArea", query = "SELECT t FROM TbContactosEmpresas t WHERE t.ceArea = :ceArea"),
    @NamedQuery(name = "TbContactosEmpresas.findByCeCodigoEmpresa", query = "SELECT t FROM TbContactosEmpresas t WHERE t.ceCodigoEmpresa = :ceCodigoEmpresa")
})
public class TbContactosEmpresas implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ce_descripcion_funcion")
    private String ceDescripcionFuncion;
    @Size(max = 50)
    @Column(name = "ce_telefono")
    private String ceTelefono;
    @Column(name = "ce_ext_tel")
    private Integer ceExtTel;
    @Size(max = 100)
    @Column(name = "ce_direccion")
    private String ceDireccion;
    @Size(max = 3)
    @Column(name = "ce_pais")
    private String cePais;
    @Size(max = 2)
    @Column(name = "ce_depto")
    private String ceDepto;
    @Size(max = 5)
    @Column(name = "ce_ciudad")
    private String ceCiudad;
    @Size(max = 100)
    @Column(name = "ce_email_corp")
    private String ceEmailCorp;
    @Size(max = 100)
    @Column(name = "ce_email_personal")
    private String ceEmailPersonal;
    @Column(name = "ce_estado")
    private Character ceEstado;
    @Size(max = 15)
    @Column(name = "ce_celular")
    private String ceCelular;
    @Column(name = "ce_sw_contacto")
    private Character ceSwContacto;
    @Column(name = "ce_fecha_crea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ceFechaCrea;
    @Column(name = "ce_fecha_ult_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ceFechaUltMod;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ce_secuencial")
    private Integer ceSecuencial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "ce_nombres")
    private String ceNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "ce_apellidos")
    private String ceApellidos;
    @Size(max = 15)
    @Column(name = "ce_cargo")
    private String ceCargo;
    @Size(max = 15)
    @Column(name = "ce_area")
    private String ceArea;
    @JoinColumn(name = "ce_codigo_empresa", referencedColumnName = "em_id_empresas")
    @ManyToOne(optional = false)
    private TbEmpresas ceCodigoEmpresa;

    public TbContactosEmpresas() {
    }

    public TbContactosEmpresas(Integer ceSecuencial) {
        this.ceSecuencial = ceSecuencial;
    }

    public TbContactosEmpresas(Integer ceSecuencial, String ceNombres, String ceApellidos) {
        this.ceSecuencial = ceSecuencial;
        this.ceNombres = ceNombres;
        this.ceApellidos = ceApellidos;
    }

    public Integer getCeSecuencial() {
        return ceSecuencial;
    }

    public void setCeSecuencial(Integer ceSecuencial) {
        this.ceSecuencial = ceSecuencial;
    }

    public String getCeNombres() {
        return ceNombres;
    }

    public void setCeNombres(String ceNombres) {
        this.ceNombres = ceNombres;
    }

    public String getCeApellidos() {
        return ceApellidos;
    }

    public void setCeApellidos(String ceApellidos) {
        this.ceApellidos = ceApellidos;
    }

    public String getCeCargo() {
        return ceCargo;
    }

    public void setCeCargo(String ceCargo) {
        this.ceCargo = ceCargo;
    }

    public String getCeArea() {
        return ceArea;
    }

    public void setCeArea(String ceArea) {
        this.ceArea = ceArea;
    }

    public TbEmpresas getCeCodigoEmpresa() {
        return ceCodigoEmpresa;
    }

    public void setCeCodigoEmpresa(TbEmpresas ceCodigoEmpresa) {
        this.ceCodigoEmpresa = ceCodigoEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ceSecuencial != null ? ceSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbContactosEmpresas)) {
            return false;
        }
        TbContactosEmpresas other = (TbContactosEmpresas) object;
        if ((this.ceSecuencial == null && other.ceSecuencial != null) || (this.ceSecuencial != null && !this.ceSecuencial.equals(other.ceSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbContactosEmpresas[ ceSecuencial=" + ceSecuencial + " ]";
    }

    public String getCeDescripcionFuncion() {
        return ceDescripcionFuncion;
    }

    public void setCeDescripcionFuncion(String ceDescripcionFuncion) {
        this.ceDescripcionFuncion = ceDescripcionFuncion;
    }

    public String getCeTelefono() {
        return ceTelefono;
    }

    public void setCeTelefono(String ceTelefono) {
        this.ceTelefono = ceTelefono;
    }

    public Integer getCeExtTel() {
        return ceExtTel;
    }

    public void setCeExtTel(Integer ceExtTel) {
        this.ceExtTel = ceExtTel;
    }

    public String getCeDireccion() {
        return ceDireccion;
    }

    public void setCeDireccion(String ceDireccion) {
        this.ceDireccion = ceDireccion;
    }

    public String getCePais() {
        return cePais;
    }

    public void setCePais(String cePais) {
        this.cePais = cePais;
    }

    public String getCeDepto() {
        return ceDepto;
    }

    public void setCeDepto(String ceDepto) {
        this.ceDepto = ceDepto;
    }

    public String getCeCiudad() {
        return ceCiudad;
    }

    public void setCeCiudad(String ceCiudad) {
        this.ceCiudad = ceCiudad;
    }

    public String getCeEmailCorp() {
        return ceEmailCorp;
    }

    public void setCeEmailCorp(String ceEmailCorp) {
        this.ceEmailCorp = ceEmailCorp;
    }

    public String getCeEmailPersonal() {
        return ceEmailPersonal;
    }

    public void setCeEmailPersonal(String ceEmailPersonal) {
        this.ceEmailPersonal = ceEmailPersonal;
    }

    public Character getCeEstado() {
        return ceEstado;
    }

    public void setCeEstado(Character ceEstado) {
        this.ceEstado = ceEstado;
    }

    public String getCeCelular() {
        return ceCelular;
    }

    public void setCeCelular(String ceCelular) {
        this.ceCelular = ceCelular;
    }

    public Character getCeSwContacto() {
        return ceSwContacto;
    }

    public void setCeSwContacto(Character ceSwContacto) {
        this.ceSwContacto = ceSwContacto;
    }

    public Date getCeFechaCrea() {
        return ceFechaCrea;
    }

    public void setCeFechaCrea(Date ceFechaCrea) {
        this.ceFechaCrea = ceFechaCrea;
    }

    public Date getCeFechaUltMod() {
        return ceFechaUltMod;
    }

    public void setCeFechaUltMod(Date ceFechaUltMod) {
        this.ceFechaUltMod = ceFechaUltMod;
    }  
}
