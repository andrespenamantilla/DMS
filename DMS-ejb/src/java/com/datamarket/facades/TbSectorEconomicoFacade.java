/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbSectorEconomico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author andre
 */
@Stateless
public class TbSectorEconomicoFacade extends ManejadorPersistencia<TbSectorEconomico> {

    public String buscarNombreSector(Integer se_codigo) {
        TbSectorEconomico aux;

        Query q = em.createQuery("SELECT t FROM TbSectorEconomico t WHERE t.seCodigo = :seCodigo");
        q.setParameter("seCodigo", se_codigo);

        aux = (TbSectorEconomico) q.getSingleResult();

        return aux.getSeDescripcion().toUpperCase();
    }

    public List buscarTodosLosSectores() {
        Query q = em.createNamedQuery("TbSectorEconomico.findAll");
        return q.getResultList();

    }
}
