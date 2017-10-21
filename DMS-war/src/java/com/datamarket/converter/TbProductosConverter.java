/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import com.datamarket.components.TbProductoComponente;
import com.datamarket.entidades.TbProductos;
import javax.ejb.Stateless;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbProductosConverter {
    
    public TbProductos convertirComponenteAEntidad(TbProductoComponente productoComponente) {
        TbProductos aux = new TbProductos();
        aux.setPrNombre(productoComponente.getPr_nombre());
        aux.setPrStock(productoComponente.getPr_stock());
        aux.setPrPrecio(Double.parseDouble(productoComponente.getPr_precio()));
        aux.setPrCategoria(productoComponente.getPr_categoria());
        
        return aux;
    }
    
    public TbProductoComponente convertirEntidadAComponente(TbProductos producto) {
        TbProductoComponente aux = new TbProductoComponente();
        
        aux.setPr_categoria(producto.getPrCategoria());
        aux.setPr_nombre(producto.getPrNombre());
        aux.setPr_precio(producto.getPrPrecio().toString());
        aux.setPr_stock(producto.getPrStock());
        aux.setPr_codigo(producto.getPrCodigo());
        
        return aux;
    }
    
}
