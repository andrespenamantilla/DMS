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
import javax.persistence.Id;
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
@Table(name = "tb_empresas_prospecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEmpresasProspecto.findAll", query = "SELECT t FROM TbEmpresasProspecto t"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeEmpresa", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peEmpresa = :peEmpresa"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeNombre", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peNombre = :peNombre"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeNumeroId", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peNumeroId = :peNumeroId"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeDv", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peDv = :peDv"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeDireccion", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peDireccion = :peDireccion"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeDepartamento", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peDepartamento = :peDepartamento"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeCiudad", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peCiudad = :peCiudad"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeTelefono", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peTelefono = :peTelefono"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeEmail", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peEmail = :peEmail"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeSitioWeb", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peSitioWeb = :peSitioWeb"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeSector", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peSector = :peSector"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeProductos", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peProductos = :peProductos"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeReferencia", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peReferencia = :peReferencia"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeNombreContacto", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peNombreContacto = :peNombreContacto"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeApellidoContacto", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peApellidoContacto = :peApellidoContacto"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeDescripcionFuncion", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peDescripcionFuncion = :peDescripcionFuncion"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeFechaCreacion", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peFechaCreacion = :peFechaCreacion"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPePais", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.pePais = :pePais"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeEjecutivo", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peEjecutivo = :peEjecutivo"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeCargo", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peCargo = :peCargo"),
    @NamedQuery(name = "TbEmpresasProspecto.findByPeArea", query = "SELECT t FROM TbEmpresasProspecto t WHERE t.peArea = :peArea")})
public class TbEmpresasProspecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pe_empresa")
    private Integer peEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pe_nombre")
    private String peNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pe_numero_id")
    private String peNumeroId;
    @Size(max = 1)
    @Column(name = "pe_dv")
    private String peDv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "pe_direccion")
    private String peDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "pe_departamento")
    private String peDepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "pe_ciudad")
    private String peCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "pe_telefono")
    private String peTelefono;
    @Size(max = 100)
    @Column(name = "pe_email")
    private String peEmail;
    @Size(max = 50)
    @Column(name = "pe_sitio_web")
    private String peSitioWeb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pe_sector")
    private int peSector;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pe_productos")
    private String peProductos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "pe_referencia")
    private String peReferencia;
    @Size(max = 60)
    @Column(name = "pe_nombre_contacto")
    private String peNombreContacto;
    @Size(max = 60)
    @Column(name = "pe_apellido_contacto")
    private String peApellidoContacto;
    @Size(max = 255)
    @Column(name = "pe_descripcion_funcion")
    private String peDescripcionFuncion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pe_fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date peFechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "pe_pais")
    private String pePais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pe_ejecutivo")
    private int peEjecutivo;
    @Size(max = 15)
    @Column(name = "pe_cargo")
    private String peCargo;
    @Size(max = 15)
    @Column(name = "pe_area")
    private String peArea;

    public TbEmpresasProspecto() {
    }

    public TbEmpresasProspecto(Integer peEmpresa) {
        this.peEmpresa = peEmpresa;
    }

    public TbEmpresasProspecto(Integer peEmpresa, String peNombre, String peNumeroId, String peDireccion, String peDepartamento, String peCiudad, String peTelefono, int peSector, String peProductos, String peReferencia, Date peFechaCreacion, String pePais, int peEjecutivo) {
        this.peEmpresa = peEmpresa;
        this.peNombre = peNombre;
        this.peNumeroId = peNumeroId;
        this.peDireccion = peDireccion;
        this.peDepartamento = peDepartamento;
        this.peCiudad = peCiudad;
        this.peTelefono = peTelefono;
        this.peSector = peSector;
        this.peProductos = peProductos;
        this.peReferencia = peReferencia;
        this.peFechaCreacion = peFechaCreacion;
        this.pePais = pePais;
        this.peEjecutivo = peEjecutivo;
    }

    public Integer getPeEmpresa() {
        return peEmpresa;
    }

    public void setPeEmpresa(Integer peEmpresa) {
        this.peEmpresa = peEmpresa;
    }

    public String getPeNombre() {
        return peNombre;
    }

    public void setPeNombre(String peNombre) {
        this.peNombre = peNombre;
    }

    public String getPeNumeroId() {
        return peNumeroId;
    }

    public void setPeNumeroId(String peNumeroId) {
        this.peNumeroId = peNumeroId;
    }

    public String getPeDv() {
        return peDv;
    }

    public void setPeDv(String peDv) {
        this.peDv = peDv;
    }

    public String getPeDireccion() {
        return peDireccion;
    }

    public void setPeDireccion(String peDireccion) {
        this.peDireccion = peDireccion;
    }

    public String getPeDepartamento() {
        return peDepartamento;
    }

    public void setPeDepartamento(String peDepartamento) {
        this.peDepartamento = peDepartamento;
    }

    public String getPeCiudad() {
        return peCiudad;
    }

    public void setPeCiudad(String peCiudad) {
        this.peCiudad = peCiudad;
    }

    public String getPeTelefono() {
        return peTelefono;
    }

    public void setPeTelefono(String peTelefono) {
        this.peTelefono = peTelefono;
    }

    public String getPeEmail() {
        return peEmail;
    }

    public void setPeEmail(String peEmail) {
        this.peEmail = peEmail;
    }

    public String getPeSitioWeb() {
        return peSitioWeb;
    }

    public void setPeSitioWeb(String peSitioWeb) {
        this.peSitioWeb = peSitioWeb;
    }

    public int getPeSector() {
        return peSector;
    }

    public void setPeSector(int peSector) {
        this.peSector = peSector;
    }

    public String getPeProductos() {
        return peProductos;
    }

    public void setPeProductos(String peProductos) {
        this.peProductos = peProductos;
    }

    public String getPeReferencia() {
        return peReferencia;
    }

    public void setPeReferencia(String peReferencia) {
        this.peReferencia = peReferencia;
    }

    public String getPeNombreContacto() {
        return peNombreContacto;
    }

    public void setPeNombreContacto(String peNombreContacto) {
        this.peNombreContacto = peNombreContacto;
    }

    public String getPeApellidoContacto() {
        return peApellidoContacto;
    }

    public void setPeApellidoContacto(String peApellidoContacto) {
        this.peApellidoContacto = peApellidoContacto;
    }

    public String getPeDescripcionFuncion() {
        return peDescripcionFuncion;
    }

    public void setPeDescripcionFuncion(String peDescripcionFuncion) {
        this.peDescripcionFuncion = peDescripcionFuncion;
    }

    public Date getPeFechaCreacion() {
        return peFechaCreacion;
    }

    public void setPeFechaCreacion(Date peFechaCreacion) {
        this.peFechaCreacion = peFechaCreacion;
    }

    public String getPePais() {
        return pePais;
    }

    public void setPePais(String pePais) {
        this.pePais = pePais;
    }

    public int getPeEjecutivo() {
        return peEjecutivo;
    }

    public void setPeEjecutivo(int peEjecutivo) {
        this.peEjecutivo = peEjecutivo;
    }

    public String getPeCargo() {
        return peCargo;
    }

    public void setPeCargo(String peCargo) {
        this.peCargo = peCargo;
    }

    public String getPeArea() {
        return peArea;
    }

    public void setPeArea(String peArea) {
        this.peArea = peArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peEmpresa != null ? peEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEmpresasProspecto)) {
            return false;
        }
        TbEmpresasProspecto other = (TbEmpresasProspecto) object;
        if ((this.peEmpresa == null && other.peEmpresa != null) || (this.peEmpresa != null && !this.peEmpresa.equals(other.peEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbEmpresasProspecto[ peEmpresa=" + peEmpresa + " ]";
    }
    
}
