/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.servicios;

import com.datamarket.entidades.TbEjecutivos;
import com.datamarket.facades.TbEjecutivosFacade;
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
public class TbEjecutivosServicio {

    @Inject
    TbEjecutivosFacade TbEF;
    
     public Map<String, Integer> getAllEjecutivosMap() {

        /*
         Crear una lista de tipo objeto 'TbAdmRoles' de nombre 'allRoles' la cual 
         es el retorno de la funcion 'getAllRoles' por através del objeto 'TbARF'
         de tipo objeto 'TbAdmRolesFacade'
         */
    List<TbEjecutivos> allEjecutivos = TbEF.getAllEjecutivos();

        Map<String, Integer> ejecutivosMap = new HashMap<>();

        /* 
         Mientras existan objetos de nombre 'aux' de tipo 'TbEjecutivos' en la lista
         'allEjecutivos'
         */
        for (TbEjecutivos aux : allEjecutivos) {

            /*
             En la variable de tipo 'Map' de nombre 'ejecutivosMap'
             asigne las variables del objeto 'aux' de tipo 'TbEjecutivos'
             haga igual el 
             String = aux.getTbAdmUsuarios().getUsLogin()
             Integer = aux.getEjCodigo()
             */
            ejecutivosMap.put(aux.getTbAdmUsuarios().getUsNombre(), aux.getEjCodigo());
        }
        return ejecutivosMap;
    }
}
