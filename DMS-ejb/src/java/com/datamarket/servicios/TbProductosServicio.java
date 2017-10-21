/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.servicios;

import com.datamarket.IServicios.ITbProductosServiciosLocal;
import com.datamarket.Ifacades.ITbProductosFacadeLocal;
import com.datamarket.entidades.TbProductos;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbProductosServicio implements ITbProductosServiciosLocal {

    @Inject
    ITbProductosFacadeLocal productosFacade;

    @Override
    public HashMap<String, Integer> productosMap() {
        List<TbProductos> productos = productosFacade.listarTodosLosProductos();
        HashMap<String, Integer> productosMap = new HashMap<>();

        for (TbProductos producto : productos) {
            productosMap.put(producto.getPrNombre(), producto.getPrCodigo());

        }
        return productosMap;
    }

}
