/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.servicios;

import com.datamarket.entidades.TbSectorEconomico;
import com.datamarket.facades.TbSectorEconomicoFacade;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés
 */
@Stateless
public class TbSectorEconomicoServicio {

    @Inject
    TbSectorEconomicoFacade sectorEconomicoFacade;
    
    
         public Map<String, Integer> getAllSectores() {

        List<TbSectorEconomico> catalogosByProveedor = sectorEconomicoFacade.buscarTodosLosSectores();
        Map<String, Integer> catalogosByNivelEjecutivoMap = new HashMap<>();
        for (TbSectorEconomico aux : catalogosByProveedor) {
            catalogosByNivelEjecutivoMap.put(aux.getSeDescripcion(), aux.getSeCodigo());
        }
        return catalogosByNivelEjecutivoMap;
    }
     
}
