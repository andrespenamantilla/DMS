/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.utils;

import com.datamarket.entidades.TbContactosEmpresas;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author Andrés
 */
@Stateless
public class ConverterTbContactosEmpresas {

    public Map<String, Integer> converterContactosEmpresasToHashMap(List<TbContactosEmpresas> contactos) 
    {

        Map<String, Integer> contactosMap = new HashMap<>();

        for (TbContactosEmpresas aux : contactos) {

            contactosMap.put(aux.getCeNombres()+" "+aux.getCeApellidos(), aux.getCeSecuencial());
        }
        return contactosMap;
    }
}