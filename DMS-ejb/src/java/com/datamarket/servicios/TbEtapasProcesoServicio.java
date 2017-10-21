/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.servicios;

import com.datamarket.entidades.TbEtapasProceso;
import com.datamarket.facades.TbEtapasProcesoFacade;
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
public class TbEtapasProcesoServicio {

    @Inject
    TbEtapasProcesoFacade etapasProcesoFacade;
    private Map<String, Integer> etapasProcesoMap;
    private List<TbEtapasProceso> etapasProcesoList;

    public Map<String, Integer> getAllEtapasProcesoMap() {

        etapasProcesoList = etapasProcesoFacade.getAllEtapasProceso();
        etapasProcesoMap = new HashMap<>();
        for (TbEtapasProceso etapasProcesoList1 : etapasProcesoList) {
            etapasProcesoMap.put(etapasProcesoList1.getEpDescEtapa(), etapasProcesoList1.getTbEtapasProcesoPK().getEpSecEtapa());
        }

        return etapasProcesoMap;

    }

    /*
    
     for(int i = 0; i<etapasProcesoList.size(); i++)
     {
     etapasProcesoMap.put(etapasProcesoList.get(i).getTbEtapasProcesoPK().getEpSecEtapa(), etapasProcesoList.get(i).getEpTipoProceso());   
     }
     */
}
