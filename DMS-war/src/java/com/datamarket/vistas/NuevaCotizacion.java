/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.IServicios.ITbCotizacionesServiciosLocal;
import com.datamarket.IServicios.ITbProductosServiciosLocal;
import com.datamarket.Ifacades.ITbCotizacionesFacadeLocal;
import com.datamarket.Ifacades.ITbDetalleCotizacionFacadeLocal;
import com.datamarket.Ifacades.ITbObservacionesFacadeLocal;
import com.datamarket.Ifacades.ITbProductosFacadeLocal;
import com.datamarket.components.TbDetalleCotizacionComponente;
import com.datamarket.components.TbObservacionesComponente;
import com.datamarket.converter.TbDetalleCotizacionConverter;
import com.datamarket.converter.TbObservacionesConverter;
import com.datamarket.entidades.TbCasosEmpresas;
import com.datamarket.entidades.TbCotizaciones;
import com.datamarket.entidades.TbDetalleCotizacion;
import com.datamarket.entidades.TbDetalleCotizacionPK;
import com.datamarket.entidades.TbObservaciones;
import com.datamarket.entidades.TbProductos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrés
 */
@ViewScoped
@Named
public class NuevaCotizacion implements Serializable {

    @Inject
    ObjetosSesion sesion;
    @Inject
    ITbProductosFacadeLocal productoFacade;
    @Inject
    ITbCotizacionesFacadeLocal cotizacionesFacade;
    @Inject
    ITbDetalleCotizacionFacadeLocal detalleCotizacionFacade;
    @Inject
    ITbProductosServiciosLocal productosServicio;
    @Inject
    TbObservacionesConverter observacionesConverter;
    @Inject
    TbDetalleCotizacionConverter detalleCotizacionConverter;
    @Inject
    ITbObservacionesFacadeLocal observacionesFacade;
    @Inject
    ITbCotizacionesServiciosLocal cotizacionesServicio;

    private String nombreEmpresa;
    private TbCasosEmpresas casoCotizacion;
    private List<TbProductos> productosDisponibles;
    private HashSet<TbProductos> productosDetalle;
    private HashMap<String, Integer> productosMap;
    private Double montoCotizacion;
    private Integer codCotizacion;
    private Integer dcNumDetalle;
    private Integer dcCotizacion;
    private Integer coCaso;
    private Integer coEjecutivo;
    private TbProductos productoInformacion;
    private Integer dcCantidad;
    private List<TbDetalleCotizacionComponente> opcionUno;
    private List<TbDetalleCotizacionComponente> opcionDos;
    private List<TbDetalleCotizacionComponente> opcionTres;
    private List<TbDetalleCotizacionComponente> opcionCuatro;
    private List<TbDetalleCotizacionComponente> opcionCinco;

    private TbObservacionesComponente observacionComponente;
    private Float dcPorcDescto;
    private Short dcOpcion;
    private Short[] opcionesSeleccionadas = new Short[5];
    private boolean renderedOpcionUno;
    private boolean renderedOpcionDos;
    private boolean renderedOpcionTres;
    private boolean renderedOpcionCuatro;
    private boolean renderedOpcionCinco;
    private Double precioCalculado;
    private List<TbDetalleCotizacionComponente> detallesComponente;
    private boolean renderedDetalles;
    private Integer dcCodigoObservacion;

    private TbCotizaciones cotizacionNueva;
    private Integer prCodigo;
    private boolean dcCortesia;

    @PostConstruct
    public void init() {
        casoCotizacion = sesion.getCasoEmpresaSesion();
        productosDisponibles = productoFacade.listarTodosLosProductos();
        cotizacionNueva = new TbCotizaciones();
        productosDetalle = new HashSet<>();
        nombreEmpresa = casoCotizacion.getCeEmpresa().getTbEmpresas().getEmNombre();
        montoCotizacion = 0.0;
        detallesComponente = new ArrayList<>();
        dcCodigoObservacion = observacionesFacade.retornarDcCodigo();
        /**
         *
         */
        coCaso = sesion.getCasoEmpresaSesion().getCeSecCaso();
        coEjecutivo = sesion.getCasoEmpresaSesion().getCeEmpresa().getEcEjecutivo().getEjCodigo();
        codCotizacion = cotizacionesFacade.retornarCodCotizacion();
        dcNumDetalle = detalleCotizacionFacade.retornarDcNumDetalle();
        dcCotizacion = detalleCotizacionFacade.retornarDcCotizacion();

        /**/
        calcularCodCotizacion();
        calcularDcCotizacion();

        Arrays.fill(opcionesSeleccionadas, null);
        dcCortesia = false;
        renderedDetalles = false;
        renderedOpcionUno = false;
        renderedOpcionDos = false;
        renderedOpcionTres = false;
        renderedOpcionCuatro = false;
        renderedOpcionCinco = false;

        opcionUno = new ArrayList<>();
        opcionDos = new ArrayList<>();
        opcionTres = new ArrayList<>();
        opcionCuatro = new ArrayList<>();
        opcionCinco = new ArrayList<>();

        productoInformacion = new TbProductos();
        observacionComponente = new TbObservacionesComponente();
        prCodigo = null;
        dcCantidad = null;
        dcOpcion = null;
        dcPorcDescto = null;
        observacionComponente = new TbObservacionesComponente();

    }

    public void buscarInformacionProducto() {
        productoInformacion = productoFacade.findById(prCodigo);
        FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "CORRECTO , La información del producto de cargada correctamente."));

    }

    public Integer calcularDcCodigoObservacion() {
        Integer nuevoDcCodigoObservacion;

        nuevoDcCodigoObservacion = dcCodigoObservacion = dcCodigoObservacion + 1;
        return nuevoDcCodigoObservacion;
    }

    public TbDetalleCotizacion agregarProductoAlDetalle() {

        calcularDcNumDetalle();

        TbDetalleCotizacion detalle = new TbDetalleCotizacion();
        TbDetalleCotizacionPK detallePK = new TbDetalleCotizacionPK();
        TbObservaciones observaciones = observacionesConverter.convertirComponenteAEntidad(observacionComponente);
        observaciones.setDcClase("1");
        detallePK.setDcNumDetalle(dcNumDetalle);
        detallePK.setDcCotizacion(codCotizacion);
        detalle.setTbDetalleCotizacionPK(detallePK);
        detalle.setDcCantidad(dcCantidad);
        detalle.setDcIdProducto(productoInformacion.getPrCodigo());
        detalle.setDcOpcion(dcOpcion);
        detalle.setDcObservacion(observaciones);

        if (dcCortesia == false) {
            detalle.setDcPrecio(productoInformacion.getPrPrecio());
            detalle.setDcCortesia("N".charAt(0));
        }

        if (dcCortesia == true) {
            detalle.setDcPrecio(0.0);
            detalle.setDcCortesia("S".charAt(0));
        }

        if (dcPorcDescto == null) {
            detalle.setDcPorcDescto(0);
        }

        if (dcPorcDescto != null) {
            detalle.setDcPorcDescto(dcPorcDescto);
        }

        return detalle;

    }

    public Double calculaCostoPorDetalle(TbDetalleCotizacion detalleCotizacion) {
        Double valor;

        valor = (detalleCotizacion.getDcPrecio() * detalleCotizacion.getDcCantidad() * (100.0 - detalleCotizacion.getDcPorcDescto())) / 100;

        return valor;
    }

    public void agregarProductosAOpciones() {
        if (dcOpcion == 1) {
            renderedOpcionUno = true;
            System.out.println(opcionUno.size());
            opcionUno.add(detalleCotizacionConverter.convertirEntidadAComponente(agregarProductoAlDetalle()));
            System.out.println(opcionUno.size());
            renderedDetalles = true;
            System.out.println(renderedDetalles);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageId2", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "CORRECTO , El detalle fue adicionado a la primera opción."));

        }

        if (dcOpcion == 2 && renderedOpcionUno == true && opcionUno.size() > 0) {

            renderedOpcionDos = true;
            opcionDos.add(detalleCotizacionConverter.convertirEntidadAComponente(agregarProductoAlDetalle()));
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageId2", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "CORRECTO , El detalle fue adicionado a la segunda opción."));

        }

        if (dcOpcion == 2 && renderedOpcionUno == false) {

            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageId2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "ERROR , No puede crear una opción alternativa si no existe una opción primaria."));
        }

        if (dcOpcion == 3 && renderedOpcionUno == true && renderedOpcionDos == true && opcionDos.size() > 0) {
            renderedOpcionTres = true;
            opcionTres.add(detalleCotizacionConverter.convertirEntidadAComponente(agregarProductoAlDetalle()));
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageId2", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "CORRECTO , El detalle fue adicionado a la tercera opción."));

        }

        if (dcOpcion == 3 && renderedOpcionUno == true && renderedOpcionDos == false) {
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageId2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "ERROR , No puede crear una opción alternativa si no existe una opción primaria."));

        }

        if (dcOpcion == 4 && renderedOpcionUno == true && renderedOpcionDos == true && renderedOpcionTres == true && opcionTres.size() > 0) {
            renderedOpcionCuatro = true;
            opcionCuatro.add(detalleCotizacionConverter.convertirEntidadAComponente(agregarProductoAlDetalle()));
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageId2", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "CORRECTO , El detalle fue adicionado a la cuarta opción."));

        }

        if (dcOpcion == 4 && renderedOpcionUno == true && renderedOpcionDos == true && renderedOpcionTres == false) {
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageId2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "ERROR , No puede crear una opción alternativa si no existe una opción primaria."));

        }

        if (dcOpcion == 5 && renderedOpcionUno == true && renderedOpcionDos == true && renderedOpcionTres == true && renderedOpcionCuatro == true && opcionCuatro.size() > 0) {
            renderedOpcionCinco = true;
            opcionCinco.add(detalleCotizacionConverter.convertirEntidadAComponente(agregarProductoAlDetalle()));
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageId2", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "CORRECTO , El detalle fue adicionado a la quinta opción."));

        }

        if (dcOpcion == 5 && renderedOpcionUno == true && renderedOpcionDos == true && renderedOpcionTres == true && renderedOpcionCuatro == false) {
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageId2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "ERROR , No puede crear una opción alternativa si no existe una opción primaria."));

        }

    }

    public void calcularDcNumDetalle() {
        dcNumDetalle = dcNumDetalle + 1;
    }

    public void calcularCodCotizacion() {
        codCotizacion = codCotizacion + 1;
    }

    public void calcularDcCotizacion() {
        dcCotizacion = dcCotizacion + 1;
    }

    public void calcularMontoCotizacion() {

        if (productosDetalle.isEmpty()) {
            montoCotizacion = 0.0;
        }

        if (productosDetalle.size() > 0) {

            for (TbProductos aux : productosDetalle) {

                montoCotizacion = montoCotizacion + aux.getPrPrecio();
            }
        }
    }

    public void guardarCotizacion() {
        Date date = new Date();
        cotizacionNueva.setCoCaso(coCaso);
        cotizacionNueva.setCoEjecutivo(coEjecutivo);
        cotizacionNueva.setCoEmpresa(sesion.getCasoEmpresaSesion().getCeEmpresa().getEcEmpresa());
        cotizacionNueva.setCoCodCotiz(codCotizacion);
        cotizacionNueva.setCoFecha(date);

        List<TbDetalleCotizacion> detalles = new ArrayList<>();

        if (opcionUno.size() > 0) {
            for (int i = 0; i < opcionUno.size(); i++) {
                TbDetalleCotizacion aux;
                aux = detalleCotizacionConverter.convertirComponenteAEntidad(opcionUno.get(i));
                aux.getDcObservacion().setDcCodigo(calcularDcCodigoObservacion());
                detalles.add(aux);

            }
        }

        if (opcionDos.size() > 0) {
            for (int i = 0; i < opcionDos.size(); i++) {
                TbDetalleCotizacion aux;
                aux = detalleCotizacionConverter.convertirComponenteAEntidad(opcionDos.get(i));
                aux.getDcObservacion().setDcCodigo(calcularDcCodigoObservacion());
                detalles.add(aux);

            }
        }

        if (opcionTres.size() > 0) {
            for (int i = 0; i < opcionTres.size(); i++) {
                TbDetalleCotizacion aux;
                aux = detalleCotizacionConverter.convertirComponenteAEntidad(opcionTres.get(i));
                aux.getDcObservacion().setDcCodigo(calcularDcCodigoObservacion());
                detalles.add(aux);

            }
        }

        if (opcionCuatro.size() > 0) {
            for (int i = 0; i < opcionCuatro.size(); i++) {
                TbDetalleCotizacion aux;
                aux = detalleCotizacionConverter.convertirComponenteAEntidad(opcionCuatro.get(i));
                aux.getDcObservacion().setDcCodigo(calcularDcCodigoObservacion());
                detalles.add(aux);

            }
        }

        if (opcionCinco.size() > 0) {
            for (int i = 0; i < opcionCinco.size(); i++) {
                TbDetalleCotizacion aux;
                aux = detalleCotizacionConverter.convertirComponenteAEntidad(opcionCinco.get(i));
                aux.getDcObservacion().setDcCodigo(calcularDcCodigoObservacion());
                detalles.add(aux);

            }
        }

        cotizacionesServicio.persistirCotizacion(detalles, cotizacionNueva);
        init();

        codCotizacion = cotizacionesFacade.retornarCodCotizacion();
        dcNumDetalle = detalleCotizacionFacade.retornarDcNumDetalle();
        dcCotizacion = detalleCotizacionFacade.retornarDcCotizacion();

        System.out.println(codCotizacion);
        System.out.println(dcCotizacion);
        System.out.println(dcNumDetalle);
        
        
        calcularCodCotizacion();
        calcularDcCotizacion();
    }

    public void eliminarDetalleOpcionUno(TbDetalleCotizacionComponente detalleOpcionUno) {

        Integer size = opcionUno.size();

        if (size == 1 && (opcionDos.size() > 0 || opcionTres.size() > 0 || opcionCuatro.size() > 0 || opcionCinco.size() > 0)) {
            System.out.println("El tamaño es " + opcionUno.size());
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdUno", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "ERROR , No puede ofrecer opciones alternativas sin una opción primaria."));
        }

        if ((opcionDos.isEmpty() && opcionTres.isEmpty() && opcionCuatro.isEmpty() && opcionCinco.isEmpty())) {
            opcionUno.remove(detalleOpcionUno);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdUno", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la primera opción."));

        }

        if ((opcionDos.isEmpty() && opcionTres.isEmpty() && opcionCuatro.isEmpty())) {
            opcionUno.remove(detalleOpcionUno);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdUno", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la primera opción."));

        }

        if ((opcionDos.isEmpty() && opcionTres.isEmpty())) {
            opcionUno.remove(detalleOpcionUno);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdUno", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la primera opción."));

        }

        if ((opcionDos.isEmpty())) {
            opcionUno.remove(detalleOpcionUno);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdUno", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la primera opción."));

        }

        if (size > 1 && (opcionDos.size() > 0 || opcionTres.size() > 0 || opcionCuatro.size() > 0 || opcionCinco.size() > 0)) {
            opcionUno.remove(detalleOpcionUno);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdUno", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la primera opción."));
        }

        if (opcionUno.isEmpty()) {
            renderedOpcionUno = false;
            renderedDetalles = false;
        }

        System.out.println("El tamaño de la lista es" + opcionUno.size());

    }

    public void eliminarDetalleOpcionDos(TbDetalleCotizacionComponente detalleOpcionDos) {
        Integer size = opcionDos.size();

        if (size == 1 && (opcionTres.size() > 0 || opcionCuatro.size() > 0 || opcionCinco.size() > 0)) {
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdDos", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "ERROR , No puede ofrecer una tercera opción sin una segunda opción."));
        }

        if ((opcionTres.isEmpty() && opcionCuatro.isEmpty() && opcionCinco.isEmpty())) {
            opcionDos.remove(detalleOpcionDos);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdDos", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la segunda opción."));

        }

        if ((opcionTres.isEmpty() && opcionCuatro.isEmpty())) {
            opcionDos.remove(detalleOpcionDos);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdDos", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la segunda opción."));

        }

        if ((opcionTres.isEmpty())) {
            opcionDos.remove(detalleOpcionDos);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdDos", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la segunda opción."));

        }

        if (size > 1 && (opcionTres.size() > 0 || opcionCuatro.size() > 0 || opcionCinco.size() > 0)) {
            opcionDos.remove(detalleOpcionDos);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdDos", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la segunda opción."));
        }

        if (opcionDos.isEmpty()) {
            renderedOpcionDos = false;
        }

        System.out.println("El tamaño de la lista es" + opcionUno.size());

    }

    public void eliminarDetalleOpcionTres(TbDetalleCotizacionComponente detalleOpcionTres) {
        Integer size = opcionTres.size();

        if (size > 1 && (opcionCuatro.size() > 0 || opcionCinco.size() > 0)) {
            opcionTres.remove(detalleOpcionTres);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdTres", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la tercera opción."));
        }

        if (size == 1 && (opcionCuatro.size() > 0 || opcionCinco.size() > 0)) {
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdTres", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "ERROR , No puede ofrecer una cuarta opción sin una tercera opción."));
        }

        if ((opcionCuatro.isEmpty() && opcionCinco.isEmpty())) {
            opcionTres.remove(detalleOpcionTres);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdTres", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la tercera opción."));

        }

        if ((opcionCuatro.isEmpty())) {
            opcionTres.remove(detalleOpcionTres);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdTres", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la tercera opción."));

        }

        if (opcionTres.isEmpty()) {
            renderedOpcionTres = false;
        }
    }

    public void eliminarDetalleOpcionCuatro(TbDetalleCotizacionComponente detalleOpcionCuatro) {
        Integer size = opcionCuatro.size();

        if (size > 1 && (opcionCinco.size() > 0)) {
            opcionCuatro.remove(detalleOpcionCuatro);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdCuatro", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la cuarta opción."));
        }

        if (size == 1 && (opcionCinco.size() > 0)) {
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdCuatro", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "ERROR , No puede ofrecer una quinta opción sin una cuarta opción."));
        }

        if (opcionCinco.isEmpty()) {
            opcionCuatro.remove(detalleOpcionCuatro);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdCuatro", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la cuarta opción."));

        }

        if (opcionCuatro.isEmpty()) {
            renderedOpcionCuatro = false;
        }

    }

    public void eliminarDetalleOpcionCinco(TbDetalleCotizacionComponente detalleOpcionCinco) {
        Integer size = opcionCuatro.size();

        if (size >= 1) {
            opcionCinco.remove(detalleOpcionCinco);
            FacesContext.getCurrentInstance().addMessage("nuevaCotizacion:messageIdCinco", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la quinta opción."));
        }

        if (opcionCinco.isEmpty()) {
            renderedOpcionCinco = false;
        }

    }

    /*Getters & Setters*/
    public List<TbProductos> getProductosDisponibles() {
        return productosDisponibles;
    }

    public void setProductosDisponibles(List<TbProductos> productosDisponibles) {
        this.productosDisponibles = productosDisponibles;
    }

    public HashSet<TbProductos> getProductosDetalle() {
        return productosDetalle;
    }

    public void setProductosDetalle(HashSet<TbProductos> productosDetalle) {
        this.productosDetalle = productosDetalle;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Double getMontoCotizacion() {
        return montoCotizacion;
    }

    public void setMontoCotizacion(Double montoCotizacion) {
        this.montoCotizacion = montoCotizacion;
    }

    public HashMap<String, Integer> getProductosMap() {
        return productosMap;
    }

    public void setProductosMap(HashMap<String, Integer> productosMap) {
        this.productosMap = productosMap;
    }

    public Integer getPrCodigo() {
        return prCodigo;
    }

    public void setPrCodigo(Integer prCodigo) {
        this.prCodigo = prCodigo;
    }

    public TbProductos getProductoInformacion() {
        return productoInformacion;
    }

    public void setProductoInformacion(TbProductos productoInformacion) {
        this.productoInformacion = productoInformacion;
    }

    public TbObservacionesComponente getObservacionComponente() {
        return observacionComponente;
    }

    public void setObservacionComponente(TbObservacionesComponente observacionComponente) {
        this.observacionComponente = observacionComponente;
    }

    public List<TbDetalleCotizacionComponente> getOpcionUno() {
        return opcionUno;
    }

    public void setOpcionUno(List<TbDetalleCotizacionComponente> opcionUno) {
        this.opcionUno = opcionUno;
    }

    public List<TbDetalleCotizacionComponente> getOpcionDos() {
        return opcionDos;
    }

    public void setOpcionDos(List<TbDetalleCotizacionComponente> opcionDos) {
        this.opcionDos = opcionDos;
    }

    public List<TbDetalleCotizacionComponente> getOpcionTres() {
        return opcionTres;
    }

    public void setOpcionTres(List<TbDetalleCotizacionComponente> opcionTres) {
        this.opcionTres = opcionTres;
    }

    public List<TbDetalleCotizacionComponente> getOpcionCuatro() {
        return opcionCuatro;
    }

    public void setOpcionCuatro(List<TbDetalleCotizacionComponente> opcionCuatro) {
        this.opcionCuatro = opcionCuatro;
    }

    public List<TbDetalleCotizacionComponente> getOpcionCinco() {
        return opcionCinco;
    }

    public void setOpcionCinco(List<TbDetalleCotizacionComponente> opcionCinco) {
        this.opcionCinco = opcionCinco;
    }

    public Float getDcPorcDescto() {
        return dcPorcDescto;
    }

    public void setDcPorcDescto(Float dcPorcDescto) {
        this.dcPorcDescto = dcPorcDescto;
    }

    public Short getDcOpcion() {
        return dcOpcion;
    }

    public void setDcOpcion(Short dcOpcion) {
        this.dcOpcion = dcOpcion;
    }

    public boolean isDcCortesia() {
        return dcCortesia;
    }

    public void setDcCortesia(boolean dcCortesia) {
        this.dcCortesia = dcCortesia;
    }

    public boolean isRenderedOpcionUno() {
        return renderedOpcionUno;
    }

    public void setRenderedOpcionUno(boolean renderedOpcionUno) {
        this.renderedOpcionUno = renderedOpcionUno;
    }

    public boolean isRenderedOpcionDos() {
        return renderedOpcionDos;
    }

    public void setRenderedOpcionDos(boolean renderedOpcionDos) {
        this.renderedOpcionDos = renderedOpcionDos;
    }

    public boolean isRenderedOpcionTres() {
        return renderedOpcionTres;
    }

    public void setRenderedOpcionTres(boolean renderedOpcionTres) {
        this.renderedOpcionTres = renderedOpcionTres;
    }

    public boolean isRenderedOpcionCuatro() {
        return renderedOpcionCuatro;
    }

    public void setRenderedOpcionCuatro(boolean renderedOpcionCuatro) {
        this.renderedOpcionCuatro = renderedOpcionCuatro;
    }

    public boolean isRenderedOpcionCinco() {
        return renderedOpcionCinco;
    }

    public void setRenderedOpcionCinco(boolean renderedOpcionCinco) {
        this.renderedOpcionCinco = renderedOpcionCinco;
    }

    public Integer getDcNumDetalle() {
        return dcNumDetalle;
    }

    public void setDcNumDetalle(Integer dcNumDetalle) {
        this.dcNumDetalle = dcNumDetalle;
    }

    public Integer getDcCotizacion() {
        return dcCotizacion;
    }

    public void setDcCotizacion(Integer dcCotizacion) {
        this.dcCotizacion = dcCotizacion;
    }

    public Integer getDcCantidad() {
        return dcCantidad;
    }

    public void setDcCantidad(Integer dcCantidad) {
        this.dcCantidad = dcCantidad;
    }

    public boolean isRenderedDetalles() {
        return renderedDetalles;
    }

    public void setRenderedDetalles(boolean renderedDetalles) {
        this.renderedDetalles = renderedDetalles;
    }

}
