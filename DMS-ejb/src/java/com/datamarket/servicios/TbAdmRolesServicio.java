/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.servicios;

import com.datamarket.entidades.TbAdmRoles;
import com.datamarket.facades.TbAdmRolesFacade;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Andres
 */
@Stateless
public class TbAdmRolesServicio {

    /*     
     Creación de una variable de nombre 'TbARF' de tipo objeto 'TbAdmRolesFacade'
     */
    @EJB
    TbAdmRolesFacade TbARF;

    public Map<String, Integer> getAllRolesMap() {

        /*
         Crear una lista de tipo objeto 'TbAdmRoles' de nombre 'allRoles' la cual 
         es el retorno de la funcion 'getAllRoles' por através del objeto 'TbARF'
         de tipo objeto 'TbAdmRolesFacade'
         */
        List<TbAdmRoles> allRoles = TbARF.getAllRoles();

        Map<String, Integer> rolesMap = new HashMap<>();

        /* 
         Mientras existan objetos de nombre 'aux' de tipo 'TbAdmRoles' en la lista
         'allRoles'
         */
        for (TbAdmRoles aux : allRoles) {

            /*
             En la variable de tipo 'Map' de nombre 'rolesMap'
             asigne las variables del objeto 'aux' de tipo 'TbAdmRoles'
             haga igual el 
             String = aux.getRoDescripcion()
             Integer = aux.getRoCodigo()
             */
            if (aux.getRoDescripcion().equals("ADMIN_SISTEMA")) {
                rolesMap.put("ADMINISTRADOR", aux.getRoCodigo());

            }
            if (aux.getRoDescripcion().equals("ADMIN_BD")) {
                rolesMap.put("BASE DE DATOS", aux.getRoCodigo());

            }
            if (aux.getRoDescripcion().equals("EJECUTIVO_CUENTA")) {
                rolesMap.put("EJECUTIVO DE CUENTA", aux.getRoCodigo());

            }
        }
        return rolesMap;
    }

}
