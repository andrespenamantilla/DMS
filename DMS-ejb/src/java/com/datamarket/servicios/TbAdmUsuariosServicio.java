/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.servicios;

import com.datamarket.entidades.TbAdmUsuarios;
import com.datamarket.facades.TbAdmUsuariosFacade;
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
public class TbAdmUsuariosServicio {
  @Inject
  
  TbAdmUsuariosFacade usuariosFacade;
  
  
   public Map<String, Integer> getAllUsuariosMap() {

        /*
         Crear una lista de tipo objeto 'TbAdmRoles' de nombre 'allRoles' la cual 
         es el retorno de la funcion 'getAllRoles' por através del objeto 'TbARF'
         de tipo objeto 'TbAdmRolesFacade'
         */
        List<TbAdmUsuarios> allUsuarios = usuariosFacade.getAllUsuarios();

        Map<String, Integer> ejecutivosMap = new HashMap<>();

        for (TbAdmUsuarios aux : allUsuarios) {

            ejecutivosMap.put(aux.getUsNombre(), aux.getUsCodUsuario());
        }
        return ejecutivosMap;
    }
  
  
}
