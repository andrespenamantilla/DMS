/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.Ifacades;

import com.datamarket.entidades.TbProductos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andrés
 */
@Local
public interface ITbProductosFacadeLocal {

    void persistirProducto(TbProductos producto);

    void eliminarProducto(TbProductos producto);

    void actualizarProducto(TbProductos producto);

    TbProductos findById(Integer id);

    List<TbProductos> listarTodosLosProductos();

    List<String> buscarProductoPorNombre(String prNombre);

    List<TbProductos> buscarProductosPorParametrosDeBusqueda(String prNombre, Integer prCodigo, Double prPrecio, String prCategoria, Integer prStock);

}
