/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.Ifacades.ITbDetalleCotizacionFacadeLocal;
import com.datamarket.Ifacades.ITbProductosFacadeLocal;
import com.datamarket.components.PonderadoTotalOpcion;
import com.datamarket.components.TbDetalleCotizacionComponente;
import com.datamarket.components.TbObservacionesComponente;
import com.datamarket.converter.TbDetalleCotizacionConverter;
import com.datamarket.converter.TbObservacionesConverter;
import com.datamarket.entidades.TbCotizaciones;
import com.datamarket.entidades.TbDetalleCotizacion;
import com.datamarket.entidades.TbDetalleCotizacionPK;
import com.datamarket.entidades.TbObservaciones;
import com.datamarket.entidades.TbProductos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author andres
 */
@ViewScoped
@Named
public class DetalleCotizacion implements Serializable {

    @Inject
    ObjetosSesion sesion;
    @Inject
    ITbDetalleCotizacionFacadeLocal detalleCotizacionFacade;
    @Inject
    TbDetalleCotizacionConverter detalleCotizacionConverter;
    @Inject
    ITbProductosFacadeLocal productoFacade;
    @Inject
    TbObservacionesConverter observacionesConverter;

    private TbDetalleCotizacionComponente detalleCotizacionComponenteSeleccionado;
    private TbDetalleCotizacion detalleCotizacionSeleccionado;
    private TbProductos productoDetalle;
    private TbCotizaciones cotizacion;
    private TbObservacionesComponente observacionComponente;


    /**/
    private List<TbDetalleCotizacion> detallesCatalogo;
    private List<TbDetalleCotizacion> opcionUno;
    private List<TbDetalleCotizacion> opcionDos;
    private List<TbDetalleCotizacion> opcionTres;
    private List<TbDetalleCotizacion> opcionCuatro;
    private List<TbDetalleCotizacion> opcionCinco;
    /**/
    private List<TbDetalleCotizacionComponente> opcionUnoComponente;
    private List<TbDetalleCotizacionComponente> opcionDosComponente;
    private List<TbDetalleCotizacionComponente> opcionTresComponente;
    private List<TbDetalleCotizacionComponente> opcionCuatroComponente;
    private List<TbDetalleCotizacionComponente> opcionCincoComponente;

    /**/
    private boolean productoCortesía;
    private boolean habilitarCampos;

    private boolean renderedOpcionUno;
    private boolean renderedOpcionDos;
    private boolean renderedOpcionTres;
    private boolean renderedOpcionCuatro;
    private boolean renderedOpcionCinco;
    private boolean verificarAccionDetalle;
    private boolean disabledAgregarDetalle;
    private boolean disabledGuardarCambios;
    private boolean verdadero;
    private boolean falso;

    private Integer dcCantidad;
    private Integer prCodigo;
    private boolean dcCortesia;
    private Float dcPorcDescto;
    private Short dcOpcion;

    /*Ponderados*/
    private PonderadoTotalOpcion ponderadoUno;
    private PonderadoTotalOpcion ponderadoDos;
    private PonderadoTotalOpcion ponderadoTres;
    private PonderadoTotalOpcion ponderadoCuatro;
    private PonderadoTotalOpcion ponderadoCinco;

    @PostConstruct
    public void init() {
        detallesCatalogo = detalleCotizacionFacade.buscarPorCodigoCotizacion(sesion.getCotizacion());
        cotizacion = sesion.getCotizacion();
        ordenarOpcionesDetallles();
        inicializarListaComponentes();
        converirListadosAListadosDeComponentes();
        detalleCotizacionSeleccionado = new TbDetalleCotizacion();
        verificarAccionDetalle = true;
        disabledGuardarCambios = false;
        disabledAgregarDetalle = true;
        habilitarCampos = true;
        verdadero = true;
        falso = false;
        precargarVizualizacionOpciones();
        observacionComponente = new TbObservacionesComponente();
        inicializarPonderadosOpciones();
        inicializarValoresPorOpcionDeCotizacion();

    }

    public void verificarTipoDeAccion() {
        System.out.println("Entró");
        if (verificarAccionDetalle == true) {
            disabledAgregarDetalle = true;
            disabledGuardarCambios = false;
        }

        if (verificarAccionDetalle == false) {
            disabledAgregarDetalle = false;
            disabledGuardarCambios = true;
        }

    }

    public void inicializarPonderadosOpciones() {
        ponderadoUno = new PonderadoTotalOpcion();
        ponderadoDos = new PonderadoTotalOpcion();
        ponderadoTres = new PonderadoTotalOpcion();
        ponderadoCuatro = new PonderadoTotalOpcion();
        ponderadoCinco = new PonderadoTotalOpcion();

    }

    public void precargarVizualizacionOpciones() {
        if (opcionUnoComponente.isEmpty()) {
            renderedOpcionUno = false;
        } else {
            renderedOpcionUno = true;
        }
        if (opcionDosComponente.isEmpty()) {
            renderedOpcionDos = false;
        } else {
            renderedOpcionDos = true;
        }
        if (opcionTresComponente.isEmpty()) {
            renderedOpcionTres = false;
        } else {
            renderedOpcionTres = true;
        }
        if (opcionCuatroComponente.isEmpty()) {
            renderedOpcionCuatro = false;
        } else {
            renderedOpcionCuatro = true;
        }
        if (opcionCincoComponente.isEmpty()) {
            renderedOpcionCinco = false;
        } else {
            renderedOpcionCinco = true;
        }
    }

    public void ordenarOpcionesDetallles() {
        opcionUno = new ArrayList<>();
        opcionDos = new ArrayList<>();
        opcionTres = new ArrayList<>();
        opcionCuatro = new ArrayList<>();
        opcionCinco = new ArrayList<>();

        for (TbDetalleCotizacion item : detallesCatalogo) {
            if (item.getDcOpcion() == 1) {
                opcionUno.add(item);
            }
            if (item.getDcOpcion() == 2) {
                opcionDos.add(item);
            }
            if (item.getDcOpcion() == 3) {
                opcionTres.add(item);
            }
            if (item.getDcOpcion() == 4) {
                opcionCuatro.add(item);
            }
            if (item.getDcOpcion() == 5) {
                opcionCinco.add(item);
            }

        }

    }

    public void buscarInformacionProducto() {
        productoDetalle = productoFacade.findById(prCodigo);
        FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "CORRECTO , La información del producto de cargada correctamente."));

    }

    public void guardarCambios() {

    }

    public void converirListadosAListadosDeComponentes() {
        if (opcionUno.size() > 0) {

            opcionUno.forEach((TbDetalleCotizacion item) -> {
                opcionUnoComponente.add(detalleCotizacionConverter.convertirEntidadAComponente(item));
            });
        }

        if (opcionDos.size() > 0) {
            for (TbDetalleCotizacion item : opcionDos) {
                opcionDosComponente.add(detalleCotizacionConverter.convertirEntidadAComponente(item));

            }
        }
        if (opcionTres.size() > 0) {
            for (TbDetalleCotizacion item : opcionTres) {
                opcionTresComponente.add(detalleCotizacionConverter.convertirEntidadAComponente(item));

            }
        }
        if (opcionCuatro.size() > 0) {
            for (TbDetalleCotizacion item : opcionCuatro) {
                opcionCuatroComponente.add(detalleCotizacionConverter.convertirEntidadAComponente(item));

            }
        }
        if (opcionCinco.size() > 0) {
            for (TbDetalleCotizacion item : opcionCinco) {
                opcionCincoComponente.add(detalleCotizacionConverter.convertirEntidadAComponente(item));

            }
        }

    }

    public void inicializarValoresPorOpcionDeCotizacion() {
        if (opcionUnoComponente.size() > 0) {
            ponderadoUno = calcularPonderadosPorOpcion(opcionUnoComponente);
        }

        if (opcionDosComponente.size() > 0) {
            ponderadoDos = calcularPonderadosPorOpcion(opcionDosComponente);
        }

        if (opcionTresComponente.size() > 0) {
            ponderadoTres = calcularPonderadosPorOpcion(opcionTresComponente);
        }

        if (opcionCuatroComponente.size() > 0) {
            ponderadoCuatro = calcularPonderadosPorOpcion(opcionCuatroComponente);
        }

        if (opcionCincoComponente.size() > 0) {
            ponderadoCinco = calcularPonderadosPorOpcion(opcionCincoComponente);
        }

    }

    public void inicializarListaComponentes() {
        opcionUnoComponente = new ArrayList<>();
        opcionDosComponente = new ArrayList<>();
        opcionTresComponente = new ArrayList<>();
        opcionCuatroComponente = new ArrayList<>();
        opcionCincoComponente = new ArrayList<>();

    }

    public void seleccionarElementoDetalle() {
        System.out.println("Usted Seleccionó un elemento de ");
        detalleCotizacionSeleccionado = detalleCotizacionConverter.convertirComponenteAEntidad(detalleCotizacionComponenteSeleccionado);
        observacionComponente = observacionesConverter.convertirEntidadAComponente(detalleCotizacionSeleccionado.getDcObservacion());
        productoDetalle = productoFacade.findById(detalleCotizacionSeleccionado.getDcIdProducto());
        prCodigo = productoDetalle.getPrCodigo();
        if (Objects.equals(detalleCotizacionSeleccionado.getDcCortesia(), "N")) {
            productoCortesía = false;
        } else {
            productoCortesía = true;
        }

    }

    public void habilitarCamposFormulario() {
        if (habilitarCampos == false) {
            habilitarCampos = true;
        } else if (habilitarCampos == true) {
            habilitarCampos = false;
        }
    }

    public void eliminarDetalleOpcionUno(TbDetalleCotizacionComponente detalleOpcionUno) {

        Integer size = opcionUnoComponente.size();

        if (size == 1 && (opcionDosComponente.size() > 0 || opcionTresComponente.size() > 0 || opcionCuatroComponente.size() > 0 || opcionCincoComponente.size() > 0)) {
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdUno", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "ERROR , No puede ofrecer opciones alternativas sin una opción primaria."));

        }

        if ((opcionDosComponente.isEmpty() && opcionTresComponente.isEmpty() && opcionCuatroComponente.isEmpty() && opcionCincoComponente.isEmpty())) {
            opcionUnoComponente.remove(detalleOpcionUno);
            ponderadoUno = calcularPonderadosPorOpcion(opcionUnoComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdUno", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la primera opción."));

        }

        if ((opcionDosComponente.isEmpty() && opcionTresComponente.isEmpty() && opcionCuatroComponente.isEmpty())) {
            opcionUnoComponente.remove(detalleOpcionUno);
            ponderadoUno = calcularPonderadosPorOpcion(opcionUnoComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdUno", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la primera opción."));

        }

        if ((opcionDosComponente.isEmpty() && opcionTresComponente.isEmpty())) {
            opcionUnoComponente.remove(detalleOpcionUno);
            ponderadoUno = calcularPonderadosPorOpcion(opcionUnoComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdUno", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la primera opción."));

        }

        if ((opcionDosComponente.isEmpty())) {
            opcionUnoComponente.remove(detalleOpcionUno);
            ponderadoUno = calcularPonderadosPorOpcion(opcionUnoComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdUno", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la primera opción."));

        }

        if (size > 1 && (opcionDosComponente.size() > 0 || opcionTresComponente.size() > 0 || opcionCuatroComponente.size() > 0 || opcionCincoComponente.size() > 0)) {
            opcionUnoComponente.remove(detalleOpcionUno);
            ponderadoUno = calcularPonderadosPorOpcion(opcionUnoComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdUno", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la primera opción."));
        }

        if (opcionUnoComponente.isEmpty()) {
            renderedOpcionUno = false;

        }

    }

    /*Este método calcula todos los valores acumulados de una opción de la cotización*/
    public PonderadoTotalOpcion calcularPonderadosPorOpcion(List<TbDetalleCotizacionComponente> opcionDetalleComponente) {

        Double totalPonderadoDescuento = 0.0;
        Double totalPonderadoNeto = 0.0;
        Double netoDescontado = 0.0;

        PonderadoTotalOpcion ponderadoTotal = new PonderadoTotalOpcion();

        for (TbDetalleCotizacionComponente aux : opcionDetalleComponente) {
            totalPonderadoDescuento = totalPonderadoDescuento + calcularPonderadoPorDetalleConDescuento(aux);
            totalPonderadoNeto = totalPonderadoNeto + calcularPonderadoPorDetalleSinDescuento(aux);
            netoDescontado = netoDescontado + calcularMontoDescuento(aux);
        }
        ponderadoTotal.setSinDescuento(totalPonderadoNeto.toString());
        ponderadoTotal.setDescuento(netoDescontado.toString());
        ponderadoTotal.setTotalAntesDeIva(totalPonderadoDescuento.toString());

        return ponderadoTotal;
    }

    /*Este  método calcula el valor a pagar  del neto descontando el porcentaje de descuento*/
    public Double calcularPonderadoPorDetalleConDescuento(TbDetalleCotizacionComponente opcionDetalleComponente) {
        Double porcentaje = 0.0;

        Integer cantidad = opcionDetalleComponente.getDc_cantidad_num();
        Double precioUnidad = opcionDetalleComponente.getDc_precio();
        Double total = 0.0;
        if (opcionDetalleComponente.getDc_porc_descto_num() == 0) {
            porcentaje = 1.0;
            total = porcentaje * cantidad * precioUnidad;
        }
        if (opcionDetalleComponente.getDc_porc_descto_num() > 0) {
            porcentaje = 1 - opcionDetalleComponente.getDc_descuento() / 100;
            total = porcentaje * cantidad * precioUnidad;
        }

        return total;
    }

    public Double calcularMontoDescuento(TbDetalleCotizacionComponente opcionDetalleComponente) {
        Double montoADescontar = null;
        if (opcionDetalleComponente.getDc_porc_descto_num() == 0) {

            montoADescontar = 0.0;

        }
        if (opcionDetalleComponente.getDc_porc_descto_num() > 0) {
            montoADescontar = (opcionDetalleComponente.getDc_porc_descto_num()/ 100) * opcionDetalleComponente.getDc_cantidad_num() * opcionDetalleComponente.getDc_precio();
            
        }
        return montoADescontar;
    }

    public Double calcularPonderadoPorDetalleSinDescuento(TbDetalleCotizacionComponente opcionDetalleComponente) {
        Integer cantidad = opcionDetalleComponente.getDc_cantidad_num();
        Double precioUnidad = opcionDetalleComponente.getDc_precio();

        Double total = cantidad * precioUnidad;
        return total;
    }

    public void agregarProductosAOpciones() {
        if (detalleCotizacionSeleccionado.getDcOpcion() == 1) {
            renderedOpcionUno = true;

            opcionUnoComponente.add(detalleCotizacionConverter.convertirEntidadAComponente(agregarProductoAlDetalle()));
            System.out.println(opcionUnoComponente.size());
            ponderadoUno = calcularPonderadosPorOpcion(opcionUnoComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "CORRECTO , El detalle fue adicionado a la primera opción."));

        }

        if (detalleCotizacionSeleccionado.getDcOpcion() == 2 && renderedOpcionUno == true && opcionUno.size() > 0) {

            renderedOpcionDos = true;
            opcionDosComponente.add(detalleCotizacionConverter.convertirEntidadAComponente(agregarProductoAlDetalle()));
            ponderadoDos = calcularPonderadosPorOpcion(opcionDosComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "CORRECTO , El detalle fue adicionado a la segunda opción."));

        }

        if (detalleCotizacionSeleccionado.getDcOpcion() == 2 && renderedOpcionUno == false) {

            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "ERROR , No puede crear una opción alternativa si no existe una opción primaria."));
        }

        if (detalleCotizacionSeleccionado.getDcOpcion() == 3 && renderedOpcionUno == true && renderedOpcionDos == true && opcionDos.size() > 0) {
            renderedOpcionTres = true;
            opcionTresComponente.add(detalleCotizacionConverter.convertirEntidadAComponente(agregarProductoAlDetalle()));
            ponderadoTres = calcularPonderadosPorOpcion(opcionTresComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "CORRECTO , El detalle fue adicionado a la tercera opción."));

        }

        if (detalleCotizacionSeleccionado.getDcOpcion() == 3 && renderedOpcionUno == true && renderedOpcionDos == false) {
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "ERROR , No puede crear una opción alternativa si no existe una opción primaria."));

        }

        if (detalleCotizacionSeleccionado.getDcOpcion() == 4 && renderedOpcionUno == true && renderedOpcionDos == true && renderedOpcionTres == true && opcionTres.size() > 0) {
            renderedOpcionCuatro = true;
            opcionCuatroComponente.add(detalleCotizacionConverter.convertirEntidadAComponente(agregarProductoAlDetalle()));
            ponderadoCuatro = calcularPonderadosPorOpcion(opcionCuatroComponente);

            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "CORRECTO , El detalle fue adicionado a la cuarta opción."));

        }

        if (detalleCotizacionSeleccionado.getDcOpcion() == 4 && renderedOpcionUno == true && renderedOpcionDos == true && renderedOpcionTres == false) {
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "ERROR , No puede crear una opción alternativa si no existe una opción primaria."));

        }

        if (detalleCotizacionSeleccionado.getDcOpcion() == 5 && renderedOpcionUno == true && renderedOpcionDos == true && renderedOpcionTres == true && renderedOpcionCuatro == true && opcionCuatro.size() > 0) {
            renderedOpcionCinco = true;
            opcionCincoComponente.add(detalleCotizacionConverter.convertirEntidadAComponente(agregarProductoAlDetalle()));
            ponderadoCinco = calcularPonderadosPorOpcion(opcionCincoComponente);

            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "CORRECTO , El detalle fue adicionado a la quinta opción."));

        }

        if (detalleCotizacionSeleccionado.getDcOpcion() == 5 && renderedOpcionUno == true && renderedOpcionDos == true && renderedOpcionTres == true && renderedOpcionCuatro == false) {
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "ERROR , No puede crear una opción alternativa si no existe una opción primaria."));

        }

    }

    public TbDetalleCotizacion agregarProductoAlDetalle() {

        TbDetalleCotizacion detalle = new TbDetalleCotizacion();
        TbDetalleCotizacionPK detallePK = new TbDetalleCotizacionPK();
        TbObservacionesComponente aux = new TbObservacionesComponente();
        aux.setDc_texto(observacionComponente.getDc_texto());
        aux.setDc_clase("1");

        TbObservaciones observaciones = observacionesConverter.convertirComponenteAEntidad(aux);
        observaciones.setDcClase("1");
        detallePK.setDcCotizacion(cotizacion.getCoCodCotiz());
        detalle.setTbDetalleCotizacionPK(detallePK);
        detalle.setDcCantidad(detalleCotizacionSeleccionado.getDcCantidad());
        detalle.setDcIdProducto(productoDetalle.getPrCodigo());
        detalle.setDcOpcion(detalleCotizacionSeleccionado.getDcOpcion());
        detalle.setDcObservacion(observaciones);

        if (dcCortesia == false) {
            detalle.setDcPrecio(productoDetalle.getPrPrecio());
            detalle.setDcCortesia("N".charAt(0));
        }

        if (dcCortesia == true) {
            detalle.setDcPrecio(0.0);
            detalle.setDcCortesia("S".charAt(0));
        }

        if (detalleCotizacionSeleccionado.getDcPorcDescto() == 0) {
            detalle.setDcPorcDescto(0);
        }

        if (detalleCotizacionSeleccionado.getDcPorcDescto() >0) {
            detalle.setDcPorcDescto(detalleCotizacionSeleccionado.getDcPorcDescto());
        }

        return detalle;

    }

    public void eliminarDetalleOpcionDos(TbDetalleCotizacionComponente detalleOpcionDos) {
        Integer size = opcionDosComponente.size();

        if (size == 1 && (opcionTresComponente.size() > 0 || opcionCuatroComponente.size() > 0 || opcionCincoComponente.size() > 0)) {
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdDos", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "ERROR , No puede ofrecer una tercera opción sin una segunda opción."));
        }

        if ((opcionTresComponente.isEmpty() && opcionCuatroComponente.isEmpty() && opcionCincoComponente.isEmpty())) {
            opcionDosComponente.remove(detalleOpcionDos);
            ponderadoDos = calcularPonderadosPorOpcion(opcionDosComponente);

            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdDos", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la segunda opción."));

        }

        if ((opcionTresComponente.isEmpty() && opcionCuatroComponente.isEmpty())) {
            opcionDosComponente.remove(detalleOpcionDos);
            ponderadoDos = calcularPonderadosPorOpcion(opcionDosComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdDos", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la segunda opción."));

        }

        if ((opcionTresComponente.isEmpty())) {
            opcionDosComponente.remove(detalleOpcionDos);
            ponderadoDos = calcularPonderadosPorOpcion(opcionDosComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdDos", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la segunda opción."));

        }

        if (size > 1 && (opcionTresComponente.size() > 0 || opcionCuatroComponente.size() > 0 || opcionCincoComponente.size() > 0)) {
            opcionDosComponente.remove(detalleOpcionDos);
            ponderadoDos = calcularPonderadosPorOpcion(opcionDosComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdDos", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la segunda opción."));
        }

        if (opcionDosComponente.isEmpty()) {
            renderedOpcionDos = false;
        }
    }

    public void eliminarDetalleOpcionTres(TbDetalleCotizacionComponente detalleOpcionTres) {
        Integer size = opcionTresComponente.size();

        if (size > 1 && (opcionCuatroComponente.size() > 0 || opcionCincoComponente.size() > 0)) {
            opcionTresComponente.remove(detalleOpcionTres);
            ponderadoTres = calcularPonderadosPorOpcion(opcionTresComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdTres", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la tercera opción."));
        }

        if (size == 1 && (opcionCuatroComponente.size() > 0 || opcionCincoComponente.size() > 0)) {
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdTres", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "ERROR , No puede ofrecer una cuarta opción sin una tercera opción."));
        }

        if ((opcionCuatroComponente.isEmpty() && opcionCincoComponente.isEmpty())) {
            opcionTresComponente.remove(detalleOpcionTres);
            ponderadoTres = calcularPonderadosPorOpcion(opcionTresComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdTres", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la tercera opción."));

        }

        if ((opcionCuatroComponente.isEmpty())) {
            opcionTresComponente.remove(detalleOpcionTres);
            ponderadoTres = calcularPonderadosPorOpcion(opcionTresComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdTres", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la tercera opción."));

        }

        if (opcionTresComponente.isEmpty()) {
            renderedOpcionTres = false;
        }
    }

    public void eliminarDetalleOpcionCuatro(TbDetalleCotizacionComponente detalleOpcionCuatro) {
        Integer size = opcionCuatroComponente.size();

        if (size > 1 && (opcionCinco.size() > 0)) {
            opcionCuatroComponente.remove(detalleOpcionCuatro);
            ponderadoCuatro = calcularPonderadosPorOpcion(opcionCuatroComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdCuatro", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la cuarta opción."));
        }

        if (size == 1 && (opcionCincoComponente.size() > 0)) {
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdCuatro", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "ERROR , No puede ofrecer una quinta opción sin una cuarta opción."));
        }

        if (opcionCincoComponente.isEmpty()) {
            opcionCuatroComponente.remove(detalleOpcionCuatro);
            ponderadoCuatro = calcularPonderadosPorOpcion(opcionCuatroComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdCuatro", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la cuarta opción."));

        }

        if (opcionCuatroComponente.isEmpty()) {
            renderedOpcionCuatro = false;
        }

    }

    public void eliminarDetalleOpcionCinco(TbDetalleCotizacionComponente detalleOpcionCinco) {
        Integer size = opcionCuatroComponente.size();

        if (size >= 1) {
            opcionCincoComponente.remove(detalleOpcionCinco);
            ponderadoCinco = calcularPonderadosPorOpcion(opcionCincoComponente);
            FacesContext.getCurrentInstance().addMessage("editarCotizacion:messageIdCinco", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "NOTIFICACIÓN , Su detalle fue eliminado de la quinta opción."));
        }

        if (opcionCincoComponente.isEmpty()) {
            renderedOpcionCinco = false;
        }

    }

    /*Getters & Setters*/
    public List<TbDetalleCotizacion> getOpcionUno() {
        return opcionUno;
    }

    public void setOpcionUno(List<TbDetalleCotizacion> opcionUno) {
        this.opcionUno = opcionUno;
    }

    public List<TbDetalleCotizacion> getOpcionDos() {
        return opcionDos;
    }

    public void setOpcionDos(List<TbDetalleCotizacion> opcionDos) {
        this.opcionDos = opcionDos;
    }

    public List<TbDetalleCotizacion> getOpcionTres() {
        return opcionTres;
    }

    public void setOpcionTres(List<TbDetalleCotizacion> opcionTres) {
        this.opcionTres = opcionTres;
    }

    public List<TbDetalleCotizacion> getOpcionCuatro() {
        return opcionCuatro;
    }

    public void setOpcionCuatro(List<TbDetalleCotizacion> opcionCuatro) {
        this.opcionCuatro = opcionCuatro;
    }

    public List<TbDetalleCotizacion> getOpcionCinco() {
        return opcionCinco;
    }

    public void setOpcionCinco(List<TbDetalleCotizacion> opcionCinco) {
        this.opcionCinco = opcionCinco;
    }

    public List<TbDetalleCotizacionComponente> getOpcionUnoComponente() {
        return opcionUnoComponente;
    }

    public void setOpcionUnoComponente(List<TbDetalleCotizacionComponente> opcionUnoComponente) {
        this.opcionUnoComponente = opcionUnoComponente;
    }

    public List<TbDetalleCotizacionComponente> getOpcionDosComponente() {
        return opcionDosComponente;
    }

    public void setOpcionDosComponente(List<TbDetalleCotizacionComponente> opcionDosComponente) {
        this.opcionDosComponente = opcionDosComponente;
    }

    public List<TbDetalleCotizacionComponente> getOpcionTresComponente() {
        return opcionTresComponente;
    }

    public void setOpcionTresComponente(List<TbDetalleCotizacionComponente> opcionTresComponente) {
        this.opcionTresComponente = opcionTresComponente;
    }

    public List<TbDetalleCotizacionComponente> getOpcionCuatroComponente() {
        return opcionCuatroComponente;
    }

    public void setOpcionCuatroComponente(List<TbDetalleCotizacionComponente> opcionCuatroComponente) {
        this.opcionCuatroComponente = opcionCuatroComponente;
    }

    public List<TbDetalleCotizacionComponente> getOpcionCincoComponente() {
        return opcionCincoComponente;
    }

    public void setOpcionCincoComponente(List<TbDetalleCotizacionComponente> opcionCincoComponente) {
        this.opcionCincoComponente = opcionCincoComponente;
    }

    public TbDetalleCotizacionComponente getDetalleCotizacionComponenteSeleccionado() {
        return detalleCotizacionComponenteSeleccionado;
    }

    public void setDetalleCotizacionComponenteSeleccionado(TbDetalleCotizacionComponente detalleCotizacionComponenteSeleccionado) {
        this.detalleCotizacionComponenteSeleccionado = detalleCotizacionComponenteSeleccionado;
    }

    public TbDetalleCotizacion getDetalleCotizacionSeleccionado() {
        return detalleCotizacionSeleccionado;
    }

    public void setDetalleCotizacionSeleccionado(TbDetalleCotizacion detalleCotizacionSeleccionado) {
        this.detalleCotizacionSeleccionado = detalleCotizacionSeleccionado;
    }

    public TbProductos getProductoDetalle() {
        return productoDetalle;
    }

    public void setProductoDetalle(TbProductos productoDetalle) {
        this.productoDetalle = productoDetalle;
    }

    public boolean isProductoCortesía() {
        return productoCortesía;
    }

    public void setProductoCortesía(boolean productoCortesía) {
        this.productoCortesía = productoCortesía;
    }

    public boolean isHabilitarCampos() {
        return habilitarCampos;
    }

    public void setHabilitarCampos(boolean habilitarCampos) {
        this.habilitarCampos = habilitarCampos;
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

    public Integer getDcCantidad() {
        return dcCantidad;
    }

    public void setDcCantidad(Integer dcCantidad) {
        this.dcCantidad = dcCantidad;
    }

    public Integer getPrCodigo() {
        return prCodigo;
    }

    public void setPrCodigo(Integer prCodigo) {
        this.prCodigo = prCodigo;
    }

    public boolean isVerificarAccionDetalle() {
        return verificarAccionDetalle;
    }

    public void setVerificarAccionDetalle(boolean verificarAccionDetalle) {
        this.verificarAccionDetalle = verificarAccionDetalle;
    }

    public boolean isDisabledAgregarDetalle() {
        return disabledAgregarDetalle;
    }

    public void setDisabledAgregarDetalle(boolean disabledAgregarDetalle) {
        this.disabledAgregarDetalle = disabledAgregarDetalle;
    }

    public boolean isDisabledGuardarCambios() {
        return disabledGuardarCambios;
    }

    public void setDisabledGuardarCambios(boolean disabledGuardarCambios) {
        this.disabledGuardarCambios = disabledGuardarCambios;
    }

    public boolean isVerdadero() {
        return verdadero;
    }

    public void setVerdadero(boolean verdadero) {
        this.verdadero = verdadero;
    }

    public boolean isFalso() {
        return falso;
    }

    public void setFalso(boolean falso) {
        this.falso = falso;
    }

    public TbObservacionesComponente getObservacionComponente() {
        return observacionComponente;
    }

    public void setObservacionComponente(TbObservacionesComponente observacionComponente) {
        this.observacionComponente = observacionComponente;
    }

    public PonderadoTotalOpcion getPonderadoUno() {
        return ponderadoUno;
    }

    public void setPonderadoUno(PonderadoTotalOpcion ponderadoUno) {
        this.ponderadoUno = ponderadoUno;
    }

    public PonderadoTotalOpcion getPonderadoDos() {
        return ponderadoDos;
    }

    public void setPonderadoDos(PonderadoTotalOpcion ponderadoDos) {
        this.ponderadoDos = ponderadoDos;
    }

    public PonderadoTotalOpcion getPonderadoTres() {
        return ponderadoTres;
    }

    public void setPonderadoTres(PonderadoTotalOpcion ponderadoTres) {
        this.ponderadoTres = ponderadoTres;
    }

    public PonderadoTotalOpcion getPonderadoCuatro() {
        return ponderadoCuatro;
    }

    public void setPonderadoCuatro(PonderadoTotalOpcion ponderadoCuatro) {
        this.ponderadoCuatro = ponderadoCuatro;
    }

    public PonderadoTotalOpcion getPonderadoCinco() {
        return ponderadoCinco;
    }

    public void setPonderadoCinco(PonderadoTotalOpcion ponderadoCinco) {
        this.ponderadoCinco = ponderadoCinco;
    }

}
