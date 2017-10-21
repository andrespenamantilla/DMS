/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.servicios;

import com.datamarket.entidades.TbCiudades;
import com.datamarket.entidades.TbDepartamentos;
import com.datamarket.entidades.TbPaises;
import com.datamarket.facades.TbCiudadesFacade;
import com.datamarket.facades.TbDepartamentosFacade;
import com.datamarket.facades.TbPaisesFacade;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andres
 */
@Stateless
public class TbPaisesServicio {

    @Inject
    TbPaisesFacade paisesFacade;
    @Inject
    TbDepartamentosFacade departamentosFacade;
    @Inject
    TbCiudadesFacade ciudadesFacade;
  
    /*Toma la lista de paises y los vuelve un HashMap*/
    public Map<String, String> getAllPaisesMap() {

        List<TbPaises> allPaises = paisesFacade.todosLosPaises();

        Map<String, String> paisesMap = new HashMap<>();
        for (TbPaises aux : allPaises) {
            paisesMap.put(aux.getPaNombre(), (aux.getPaCodigo()));
        }
        return paisesMap;
    }
    
     public Map<String, String> getAllDepartamentosMap(TbPaises pais) {

        List<TbDepartamentos> allDepartamentosPorPais = departamentosFacade.buscarDepartamentosPorPais(pais);

        Map<String, String> allDepartamentosPorPaisMap = new HashMap<>();
        for (TbDepartamentos aux : allDepartamentosPorPais) {
            allDepartamentosPorPaisMap.put(aux.getDeNombre(), (aux.getTbDepartamentosPK().getDeCodigo()));
        }
        return allDepartamentosPorPaisMap;
    }
     
     
     public Map<String, String> getAllCiudadesMap(TbDepartamentos departamento)
     {
     List<TbCiudades> allCiudadesPorDepartamento = ciudadesFacade.buscarCiudadesPorDepartamento(departamento);
     
     Map<String, String> allCiudadesPorDepartamentoMap = new HashMap<>();
        for (TbCiudades aux : allCiudadesPorDepartamento) {
            allCiudadesPorDepartamentoMap.put(aux.getCiNombre(), (aux.getTbCiudadesPK().getCiCiudad()));
        }
        return allCiudadesPorDepartamentoMap;
     }
    
     
     
}
