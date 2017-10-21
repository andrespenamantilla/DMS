/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import com.datamarket.Ifacades.ITbProductosFacadeLocal;
import com.datamarket.components.TbDetalleCotizacionComponente;
import com.datamarket.entidades.TbDetalleCotizacion;
import com.datamarket.entidades.TbDetalleCotizacionPK;
import com.datamarket.entidades.TbObservaciones;
import java.text.DecimalFormat;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbDetalleCotizacionConverter {
    
    @Inject
    ITbProductosFacadeLocal productoFacade;
    
    public TbDetalleCotizacionComponente convertirEntidadAComponente(TbDetalleCotizacion detalleCotizacion) {
        
        
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        TbDetalleCotizacionComponente detalleCotizacionComponente = new TbDetalleCotizacionComponente();
        
        detalleCotizacionComponente.setDc_num_detalle(detalleCotizacion.getTbDetalleCotizacionPK().getDcNumDetalle());
        detalleCotizacionComponente.setDc_cortesia_char(detalleCotizacion.getDcCortesia());
        detalleCotizacionComponente.setDc_cotizacion(detalleCotizacion.getTbDetalleCotizacionPK().getDcCotizacion());
        
        if (detalleCotizacion.getDcCantidad() == null) {
            detalleCotizacionComponente.setDc_cantidad(null);
            detalleCotizacionComponente.setDc_cantidad_num(0);
        }
        if (detalleCotizacion.getDcCantidad() != null) {
            detalleCotizacionComponente.setDc_cantidad(detalleCotizacion.getDcCantidad() + " unidades");
            detalleCotizacionComponente.setDc_cantidad_num(detalleCotizacion.getDcCantidad());
        }
        
        detalleCotizacionComponente.setDc_id_producto(detalleCotizacion.getDcIdProducto());
        
        if ("S".equals(detalleCotizacion.getDcCortesia().toString())) {
            
            detalleCotizacionComponente.setDc_cortesia("Si");
        }
        
        if ("N".equals(detalleCotizacion.getDcCortesia().toString())) {
            
            detalleCotizacionComponente.setDc_cortesia("No");
        }
        
        detalleCotizacionComponente.setDc_porc_descto(detalleCotizacion.getDcPorcDescto() + "% de descuento");
        detalleCotizacionComponente.setDc_porc_descto_num(detalleCotizacion.getDcPorcDescto());
        
        detalleCotizacionComponente.setDc_opcion(detalleCotizacion.getDcOpcion());
        
        detalleCotizacionComponente.setDc_observacion(detalleCotizacion.getDcObservacion().getDcTexto());
        detalleCotizacionComponente.setDc_precio(detalleCotizacion.getDcPrecio());
        detalleCotizacionComponente.setPr_nombre(productoFacade.findById(detalleCotizacion.getDcIdProducto()).getPrNombre());
        
        if (detalleCotizacion.getDcPorcDescto() == 0) {
            detalleCotizacionComponente.setDc_neto(((detalleCotizacion.getDcPrecio() * detalleCotizacion.getDcCantidad())));
            detalleCotizacionComponente.setDc_descuento(((detalleCotizacion.getDcPrecio() * detalleCotizacion.getDcCantidad())));
        }
        
        if (detalleCotizacion.getDcPorcDescto() > 0) {
            detalleCotizacionComponente.setDc_neto((detalleCotizacion.getDcPrecio() * detalleCotizacion.getDcCantidad()));
            detalleCotizacionComponente.setDc_descuento(((detalleCotizacion.getDcCantidad() * detalleCotizacion.getDcPrecio()) - ((detalleCotizacion.getDcPrecio() * detalleCotizacion.getDcCantidad() * detalleCotizacion.getDcPorcDescto()) / 100)));
        }
        return detalleCotizacionComponente;
    }
    
    public TbDetalleCotizacion convertirComponenteAEntidad(TbDetalleCotizacionComponente detalleCotizacionComponente) {
        
        /*Creación de la observación*/
        TbObservaciones observacion = new TbObservaciones();
        observacion.setDcTexto(detalleCotizacionComponente.getDc_observacion());
        observacion.setDcClase("1");
        
        TbDetalleCotizacion detalle = new TbDetalleCotizacion();
        TbDetalleCotizacionPK detallePK = new TbDetalleCotizacionPK();
        
        detallePK.setDcCotizacion(detalleCotizacionComponente.getDc_cotizacion());
        detallePK.setDcNumDetalle(detalleCotizacionComponente.getDc_num_detalle());
        
        detalle.setDcCantidad(detalleCotizacionComponente.getDc_cantidad_num());
        detalle.setDcPorcDescto(detalleCotizacionComponente.getDc_porc_descto_num());
        detalle.setDcPrecio(detalleCotizacionComponente.getDc_precio());
        detalle.setDcIdProducto(detalleCotizacionComponente.getDc_id_producto());
        detalle.setDcOpcion(detalleCotizacionComponente.getDc_opcion());
        detalle.setDcObservacion(observacion);
        detalle.setTbDetalleCotizacionPK(detallePK);
        detalle.setDcCortesia(detalleCotizacionComponente.getDc_cortesia_char());
        
        
        if (detalleCotizacionComponente.getDc_cortesia().equals("Si")) {
            detalle.setDcCortesia("S".charAt(0));
        }
        
        if (detalleCotizacionComponente.getDc_cortesia().equals("No")) {
            detalle.setDcCortesia("N".charAt(0));
        }
        
        return detalle;
    }
    
}
