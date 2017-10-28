/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.servicios;

import com.datamarket.IServicios.ITbContactosEmpresasServicioLocal;
import com.datamarket.entidades.TbContactosEmpresas;
import com.datamarket.entidades.TbEmpresas;
import com.datamarket.facades.TbContactosEmpresasFacade;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author andre
 */
@Stateless
public class TbContactosEmpresasServicio implements ITbContactosEmpresasServicioLocal{

    @Inject
    TbContactosEmpresasFacade TbcontactosEmpresasFacade;

    public Map<String, Integer> retornarListaDeContactos(TbEmpresas empresa) {
        List<TbContactosEmpresas> contactos = TbcontactosEmpresasFacade.getAllTbContactosEmpresasByEmpresa(empresa);

        Map<String, Integer> contactosMap = new HashMap<String, Integer>();

        for (TbContactosEmpresas aux : contactos) {
            contactosMap.put(aux.getCeNombres() + " " + aux.getCeApellidos(), aux.getCeSecuencial());
        }

        return contactosMap;
    }

}
