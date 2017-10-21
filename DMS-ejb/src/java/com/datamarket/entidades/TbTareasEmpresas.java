/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "tb_tareas_empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTareasEmpresas.findAll", query = "SELECT t FROM TbTareasEmpresas t"),
    @NamedQuery(name = "TbTareasEmpresas.findByTeSecTarea", query = "SELECT t FROM TbTareasEmpresas t WHERE t.teSecTarea = :teSecTarea"),
    @NamedQuery(name = "TbTareasEmpresas.findByTeEvento", query = "SELECT t FROM TbTareasEmpresas t WHERE t.teEvento = :teEvento"),
    @NamedQuery(name = "TbTareasEmpresas.findByTeFechaInicial", query = "SELECT t FROM TbTareasEmpresas t WHERE t.teFechaInicial = :teFechaInicial"),
    @NamedQuery(name = "TbTareasEmpresas.findByTeEstado", query = "SELECT t FROM TbTareasEmpresas t WHERE t.teEstado = :teEstado"),
    @NamedQuery(name = "TbTareasEmpresas.findByTeFechaFin", query = "SELECT t FROM TbTareasEmpresas t WHERE t.teFechaFin = :teFechaFin"),
    @NamedQuery(name = "TbTareasEmpresas.findByTeDescripcion", query = "SELECT t FROM TbTareasEmpresas t WHERE t.teDescripcion = :teDescripcion"),
    @NamedQuery(name = "TbTareasEmpresas.filtrarPorFin", query = "SELECT t FROM TbTareasEmpresas t WHERE t.teFechaFin BETWEEN :fechaInicial AND :fechaFinal"),
    @NamedQuery(name = "TbTareasEmpresas.filtrarPorInicio", query = "SELECT t FROM TbTareasEmpresas t WHERE t.teFechaInicial BETWEEN :fechaInicial AND :fechaFinal"),
    @NamedQuery(name = "TbTareasEmpresas.findByTeResponsable", query = "SELECT t FROM TbTareasEmpresas t WHERE t.teResponsable = :teResponsable")})
public class TbTareasEmpresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "te_sec_tarea")
    private Integer teSecTarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "te_evento")
    private String teEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "te_fecha_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date teFechaInicial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "te_estado")
    private String teEstado;
    @Column(name = "te_fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date teFechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "te_descripcion")
    private String teDescripcion;
    @Column(name = "te_responsable")
    private Integer teResponsable;
    @JoinColumn(name = "te_caso", referencedColumnName = "ce_sec_caso")
    @ManyToOne(optional = false)
    private TbCasosEmpresas teCaso;

    public TbTareasEmpresas() {
    }

    public TbTareasEmpresas(Integer teSecTarea) {
        this.teSecTarea = teSecTarea;
    }

    public TbTareasEmpresas(Integer teSecTarea, String teEvento, Date teFechaInicial, String teEstado, String teDescripcion) {
        this.teSecTarea = teSecTarea;
        this.teEvento = teEvento;
        this.teFechaInicial = teFechaInicial;
        this.teEstado = teEstado;
        this.teDescripcion = teDescripcion;
    }

    public Integer getTeSecTarea() {
        return teSecTarea;
    }

    public void setTeSecTarea(Integer teSecTarea) {
        this.teSecTarea = teSecTarea;
    }

    public String getTeEvento() {
        return teEvento;
    }

    public void setTeEvento(String teEvento) {
        this.teEvento = teEvento;
    }

    public Date getTeFechaInicial() {
        return teFechaInicial;
    }

    public void setTeFechaInicial(Date teFechaInicial) {
        this.teFechaInicial = teFechaInicial;
    }

    public String getTeEstado() {
        return teEstado;
    }

    public void setTeEstado(String teEstado) {
        this.teEstado = teEstado;
    }

    public Date getTeFechaFin() {
        return teFechaFin;
    }

    public void setTeFechaFin(Date teFechaFin) {
        this.teFechaFin = teFechaFin;
    }

    public String getTeDescripcion() {
        return teDescripcion;
    }

    public void setTeDescripcion(String teDescripcion) {
        this.teDescripcion = teDescripcion;
    }

    public Integer getTeResponsable() {
        return teResponsable;
    }

    public void setTeResponsable(Integer teResponsable) {
        this.teResponsable = teResponsable;
    }

    public TbCasosEmpresas getTeCaso() {
        return teCaso;
    }

    public void setTeCaso(TbCasosEmpresas teCaso) {
        this.teCaso = teCaso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teSecTarea != null ? teSecTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTareasEmpresas)) {
            return false;
        }
        TbTareasEmpresas other = (TbTareasEmpresas) object;
        if ((this.teSecTarea == null && other.teSecTarea != null) || (this.teSecTarea != null && !this.teSecTarea.equals(other.teSecTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datamarket.entidades.TbTareasEmpresas[ teSecTarea=" + teSecTarea + " ]";
    }

}
