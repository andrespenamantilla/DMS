/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.Ifacades.ITbProductosFacadeLocal;
import com.datamarket.entidades.TbProductos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbProductosFacade extends ManejadorPersistencia<TbProductos> implements ITbProductosFacadeLocal {

    @Override
    public void persistirProducto(TbProductos producto) {
        em.merge(producto);

    }

    @Override
    public TbProductos findById(Integer id) {
        return em.find(TbProductos.class, id);

    }

    @Override
    public void eliminarProducto(TbProductos producto) {
        em.remove(producto);
    }

    @Override
    public void actualizarProducto(TbProductos producto) {
        em.merge(producto);
    }

    public TbProductosFacade() {
        super();
    }

    public List<TbProductos> listarTodosLosProductos() {
        Query q = em.createNamedQuery("TbProductos.findAll");
        return q.getResultList();
    }

    @Override
    public List<String> buscarProductoPorNombre(String prNombre) {

        List<String> nombresProductos = new ArrayList<>();
        List<TbProductos> productosHallados = new ArrayList<>();
        Query q = em.createQuery("SELECT t FROM TbProductos t WHERE t.prNombre LIKE :prNombre");
        q.setParameter("prNombre", "%" + prNombre + "%");
        q.setFirstResult(0);
        q.setMaxResults(50);
        productosHallados = q.getResultList();
        String aux;
        for (int i = 0; i < productosHallados.size(); i++) {

            aux = productosHallados.get(i).getPrNombre();
            nombresProductos.add(aux);
            aux = null;

        }

        return nombresProductos;
    }

    @Override
    public List<TbProductos> buscarProductosPorParametrosDeBusqueda(
            String prNombre,
            Integer prCodigo,
            Double prPrecio,
            String prCategoria,
            Integer prStock
    ) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT t ");
        query.append("FROM TbProductos t  ");
        query.append("WHERE ");

        List<String> criteria = new ArrayList<String>();
        if (prNombre != null) {
            criteria.add("t.prNombre LIKE :prNombre");
        }
        if (prCodigo != null) {
            criteria.add("t.prCodigo = :prCodigo");
        }
        if (prPrecio != null) {
            criteria.add("t.prPrecio = :prPrecio");
        }

        if (prCategoria != null) {
            criteria.add("t.prCategoria = :prCategoria");
        }

        if (prStock != null) {
            criteria.add("t.prStock = :prStock");
        }

        for (int i = 0; i < criteria.size(); i++) {
            if (i > 0) {
                query.append(" AND ");
            }
            query.append(criteria.get(i));
        }

        Query q = em.createQuery(query.toString());
        if (prNombre != null) {
            q.setParameter("prNombre", "%" + prNombre + "%");
        }
        if (prCodigo != null) {
            q.setParameter("prCodigo", prCodigo);
        }
        if (prPrecio != null) {
            q.setParameter("prPrecio", prPrecio);
        }

        if (prCategoria != null) {
            q.setParameter("prCategoria", prCategoria);
        }

        if (prStock != null) {
            q.setParameter("prStock", prStock);
        }
        return (q.getResultList());
    }
}
