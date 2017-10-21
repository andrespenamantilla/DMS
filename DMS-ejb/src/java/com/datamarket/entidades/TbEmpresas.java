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
 * @author Andrés
 */
@Entity
@Table(name = "tb_empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEmpresas.findAll", query = "SELECT t FROM TbEmpresas t")
    , @NamedQuery(name = "TbEmpresas.findByEmIdEmpresas", query = "SELECT t FROM TbEmpresas t WHERE t.emIdEmpresas = :emIdEmpresas")
    , @NamedQuery(name = "TbEmpresas.findByEmNit", query = "SELECT t FROM TbEmpresas t WHERE t.emNit = :emNit")
    , @NamedQuery(name = "TbEmpresas.findByEmDv", query = "SELECT t FROM TbEmpresas t WHERE t.emDv = :emDv")
    , @NamedQuery(name = "TbEmpresas.findByEmNombre", query = "SELECT t FROM TbEmpresas t WHERE t.emNombre = :emNombre")
    , @NamedQuery(name = "TbEmpresas.findByEmSector", query = "SELECT t FROM TbEmpresas t WHERE t.emSector = :emSector")
    , @NamedQuery(name = "TbEmpresas.findByEmSubsector", query = "SELECT t FROM TbEmpresas t WHERE t.emSubsector = :emSubsector")
    , @NamedQuery(name = "TbEmpresas.findByEmPais", query = "SELECT t FROM TbEmpresas t WHERE t.emPais = :emPais")
    , @NamedQuery(name = "TbEmpresas.findByEmDepto", query = "SELECT t FROM TbEmpresas t WHERE t.emDepto = :emDepto")
    , @NamedQuery(name = "TbEmpresas.findByEmCiudad", query = "SELECT t FROM TbEmpresas t WHERE t.emCiudad = :emCiudad")
    , @NamedQuery(name = "TbEmpresas.findByEmTelefono1", query = "SELECT t FROM TbEmpresas t WHERE t.emTelefono1 = :emTelefono1")
    , @NamedQuery(name = "TbEmpresas.findByEmTelefono2", query = "SELECT t FROM TbEmpresas t WHERE t.emTelefono2 = :emTelefono2")
    , @NamedQuery(name = "TbEmpresas.findByEmDireccion", query = "SELECT t FROM TbEmpresas t WHERE t.emDireccion = :emDireccion")
    , @NamedQuery(name = "TbEmpresas.findByEmTelefono3", query = "SELECT t FROM TbEmpresas t WHERE t.emTelefono3 = :emTelefono3")
    , @NamedQuery(name = "TbEmpresas.findByEmFax", query = "SELECT t FROM TbEmpresas t WHERE t.emFax = :emFax")
    , @NamedQuery(name = "TbEmpresas.findByEmWeb", query = "SELECT t FROM TbEmpresas t WHERE t.emWeb = :emWeb")
    , @NamedQuery(name = "TbEmpresas.findByEmAnioFundacion", query = "SELECT t FROM TbEmpresas t WHERE t.emAnioFundacion = :emAnioFundacion")
    , @NamedQuery(name = "TbEmpresas.findByEmFechaCreacion", query = "SELECT t FROM TbEmpresas t WHERE t.emFechaCreacion = :emFechaCreacion")
    , @NamedQuery(name = "TbEmpresas.findByEmEmail", query = "SELECT t FROM TbEmpresas t WHERE t.emEmail = :emEmail")
    , @NamedQuery(name = "TbEmpresas.findByEmActividadPrinc", query = "SELECT t FROM TbEmpresas t WHERE t.emActividadPrinc = :emActividadPrinc")
    , @NamedQuery(name = "TbEmpresas.findByEmCiiu1", query = "SELECT t FROM TbEmpresas t WHERE t.emCiiu1 = :emCiiu1")
    , @NamedQuery(name = "TbEmpresas.findByEmCiiu2", query = "SELECT t FROM TbEmpresas t WHERE t.emCiiu2 = :emCiiu2")
    , @NamedQuery(name = "TbEmpresas.findByEmCiiu3", query = "SELECT t FROM TbEmpresas t WHERE t.emCiiu3 = :emCiiu3")
    , @NamedQuery(name = "TbEmpresas.findByEmNumEmpleados", query = "SELECT t FROM TbEmpresas t WHERE t.emNumEmpleados = :emNumEmpleados")
    , @NamedQuery(name = "TbEmpresas.findByEmCelular", query = "SELECT t FROM TbEmpresas t WHERE t.emCelular = :emCelular")
    , @NamedQuery(name = "TbEmpresas.findByEmNroComp", query = "SELECT t FROM TbEmpresas t WHERE t.emNroComp = :emNroComp")
    , @NamedQuery(name = "TbEmpresas.findByEmObservaciones", query = "SELECT t FROM TbEmpresas t WHERE t.emObservaciones = :emObservaciones")
    , @NamedQuery(name = "TbEmpresas.findByEmOrigen", query = "SELECT t FROM TbEmpresas t WHERE t.emOrigen = :emOrigen")
    , @NamedQuery(name = "TbEmpresas.findByEmFechaUltMod", query = "SELECT t FROM TbEmpresas t WHERE t.emFechaUltMod = :emFechaUltMod")
    , @NamedQuery(name = "TbEmpresas.findByEmTipoPer", query = "SELECT t FROM TbEmpresas t WHERE t.emTipoPer = :emTipoPer")
    , @NamedQuery(name = "TbEmpresas.findByEmEstado", query = "SELECT t FROM TbEmpresas t WHERE t.emEstado = :emEstado")})
public class TbEmpresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "em_id_empresas")
    private Integer emIdEmpresas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "em_nit")
    private String emNit;
    @Size(max = 1)
    @Column(name = "em_dv")
    private String emDv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "em_nombre")
    private String emNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "em_sector")
    private int emSector;
    @Column(name = "em_subsector")
    private Integer emSubsector;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "em_pais")
    private String emPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "em_depto")
    private String emDepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "em_ciudad")
    private String emCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "em_telefono1")
    private String emTelefono1;
    @Size(max = 25)
    @Column(name = "em_telefono2")
    private String emTelefono2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "em_direccion")
    private String emDireccion;
    @Size(max = 25)
    @Column(name = "em_telefono3")
    private String emTelefono3;
    @Column(name = "em_fax")
    private Integer emFax;
    @Size(max = 50)
    @Column(name = "em_web")
    private String emWeb;
    @Column(name = "em_anio_fundacion")
    private Integer emAnioFundacion;
    @Column(name = "em_fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emFechaCreacion;
    @Size(max = 100)
    @Column(name = "em_email")
    private String emEmail;
    @Size(max = 200)
    @Column(name = "em_actividad_princ")
    private String emActividadPrinc;
    @Size(max = 10)
    @Column(name = "em_ciiu1")
    private String emCiiu1;
    @Size(max = 10)
    @Column(name = "em_ciiu2")
    private String emCiiu2;
    @Size(max = 10)
    @Column(name = "em_ciiu3")
    private String emCiiu3;
    @Column(name = "em_num_empleados")
    private Integer emNumEmpleados;
    @Size(max = 15)
    @Column(name = "em_celular")
    private String emCelular;
    @Column(name = "em_nro_comp")
    private Integer emNroComp;
    @Size(max = 200)
    @Column(name = "em_observaciones")
    private String emObservaciones;
    @Size(max = 20)
    @Column(name = "em_origen")
    private String emOrigen;
    @Column(name = "em_fecha_ult_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emFechaUltMod;
    @Column(name = "em_tipo_per")
    private Character emTipoPer;
    @Column(name = "em_estado")
    private Character emEstado;

    public TbEmpresas() {
    }

    public TbEmpresas(Integer emIdEmpresas) {
        this.emIdEmpresas = emIdEmpresas;
    }

    public TbEmpresas(Integer emIdEmpresas, String emNit, String emNombre, int emSector, String emPais, String emDepto, String emCiudad, String emTelefono1, String emDireccion) {
        this.emIdEmpresas = emIdEmpresas;
        this.emNit = emNit;
        this.emNombre = emNombre;
        this.emSector = emSector;
        this.emPais = emPais;
        this.emDepto = emDepto;
        this.emCiudad = emCiudad;
        this.emTelefono1 = emTelefono1;
        this.emDireccion = emDireccion;
    }

    public Integer getEmIdEmpresas() {
        return emIdEmpresas;
    }

    public void setEmIdEmpresas(Integer emIdEmpresas) {
        this.emIdEmpresas = emIdEmpresas;
    }

    public String getEmNit() {
        return emNit;
    }

    public void setEmNit(String emNit) {
        this.emNit = emNit;
    }

    public String getEmDv() {
        return emDv;
    }

    public void setEmDv(String emDv) {
        this.emDv = emDv;
    }

    public String getEmNombre() {
        return emNombre;
    }

    public void setEmNombre(String emNombre) {
        this.emNombre = emNombre;
    }

    public int getEmSector() {
        return emSector;
    }

    public void setEmSector(int emSector) {
        this.emSector = emSector;
    }

    public Integer getEmSubsector() {
        return emSubsector;
    }

    public void setEmSubsector(Integer emSubsector) {
        this.emSubsector = emSubsector;
    }

    public String getEmPais() {
        return emPais;
    }

    public void setEmPais(String emPais) {
        this.emPais = emPais;
    }

    public String getEmDepto() {
        return emDepto;
    }

    public void setEmDepto(String emDepto) {
        this.emDepto = emDepto;
    }

    public String getEmCiudad() {
        return emCiudad;
    }

    public void setEmCiudad(String emCiudad) {
        this.emCiudad = emCiudad;
    }

    public String getEmTelefono1() {
        return emTelefono1;
    }

    public void setEmTelefono1(String emTelefono1) {
        this.emTelefono1 = emTelefono1;
    }

    public String getEmTelefono2() {
        return emTelefono2;
    }

    public void setEmTelefono2(String emTelefono2) {
        this.emTelefono2 = emTelefono2;
    }

    public String getEmDireccion() {
        return emDireccion;
    }

    public void setEmDireccion(String emDireccion) {
        this.emDireccion = emDireccion;
    }

    public String getEmTelefono3() {
        return emTelefono3;
    }

    public void setEmTelefono3(String emTelefono3) {
        this.emTelefono3 = emTelefono3;
    }

    public Integer getEmFax() {
        return emFax;
    }

    public void setEmFax(Integer emFax) {
        this.emFax = emFax;
    }

    public String getEmWeb() {
        return emWeb;
    }

    public void setEmWeb(String emWeb) {
        this.emWeb = emWeb;
    }

    public Integer getEmAnioFundacion() {
        return emAnioFundacion;
    }

    public void setEmAnioFundacion(Integer emAnioFundacion) {
        this.emAnioFundacion = emAnioFundacion;
    }

    public Date getEmFechaCreacion() {
        return emFechaCreacion;
    }

    public void setEmFechaCreacion(Date emFechaCreacion) {
        this.emFechaCreacion = emFechaCreacion;
    }

    public String getEmEmail() {
        return emEmail;
    }

    public void setEmEmail(String emEmail) {
        this.emEmail = emEmail;
    }

    public String getEmActividadPrinc() {
        return emActividadPrinc;
    }

    public void setEmActividadPrinc(String emActividadPrinc) {
        this.emActividadPrinc = emActividadPrinc;
    }

    public String getEmCiiu1() {
        return emCiiu1;
    }

    public void setEmCiiu1(String emCiiu1) {
        this.emCiiu1 = emCiiu1;
    }

    public String getEmCiiu2() {
        return emCiiu2;
    }

    public void setEmCiiu2(String emCiiu2) {
        this.emCiiu2 = emCiiu2;
    }

    public String getEmCiiu3() {
        return emCiiu3;
    }

    public void setEmCiiu3(String emCiiu3) {
        this.emCiiu3 = emCiiu3;
    }

    public Integer getEmNumEmpleados() {
        return emNumEmpleados;
    }

    public void setEmNumEmpleados(Integer emNumEmpleados) {
        this.emNumEmpleados = emNumEmpleados;
    }

    public String getEmCelular() {
        return emCelular;
    }

    public void setEmCelular(String emCelular) {
        this.emCelular = emCelular;
    }

    public Integer getEmNroComp() {
        return emNroComp;
    }

    public void setEmNroComp(Integer emNroComp) {
        this.emNroComp = emNroComp;
    }

    public String getEmObservaciones() {
        return emObservaciones;
    }

    public void setEmObservaciones(String emObservaciones) {
        this.emObservaciones = emObservaciones;
    }

    public String getEmOrigen() {
        return emOrigen;
    }

    public void setEmOrigen(String emOrigen) {
        this.emOrigen = emOrigen;
    }

    public Date getEmFechaUltMod() {
        return emFechaUltMod;
    }

    public void setEmFechaUltMod(Date emFechaUltMod) {
        this.emFechaUltMod = emFechaUltMod;
    }

    public Character getEmTipoPer() {
        return emTipoPer;
    }

    public void setEmTipoPer(Character emTipoPer) {
        this.emTipoPer = emTipoPer;
    }

    public Character getEmEstado() {
        return emEstado;
    }

    public void setEmEstado(Character emEstado) {
        this.emEstado = emEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emIdEmpresas != null ? emIdEmpresas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEmpresas)) {
            return false;
        }
        TbEmpresas other = (TbEmpresas) object;
        if ((this.emIdEmpresas == null && other.emIdEmpresas != null) || (this.emIdEmpresas != null && !this.emIdEmpresas.equals(other.emIdEmpresas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbEmpresas[ emIdEmpresas=" + emIdEmpresas + " ]";
    }
    
}
