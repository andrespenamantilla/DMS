/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import com.datamarket.entidades.TbCasosEmpresas;
import com.datamarket.entidades.TbEmpresaComercial;
import com.datamarket.facades.TbCasosEmpresasFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrés
 */
@Named
@ViewScoped
public class ListarCasosEmpresasPorEmpresa implements Serializable {

    @Inject
    ObjetosSesion objetosSesion;
    @Inject
    TbCasosEmpresasFacade casosEmpresas;
    private List<TbCasosEmpresas> listaDeCasosPorEmpresa;
    private TbEmpresaComercial empresaComercial;

    @PostConstruct
    public void init() {
        empresaComercial = new TbEmpresaComercial();
        empresaComercial = objetosSesion.getEmpresaComercialSesion();

        listaDeCasosPorEmpresa = casosEmpresas.listarCasosEmpresasPorIdEmpresaComercial(empresaComercial);
    }
    
    /*Getters & Setters*/

    public List<TbCasosEmpresas> getListaDeCasosPorEmpresa() {
        return listaDeCasosPorEmpresa;
    }

    public void setListaDeCasosPorEmpresa(List<TbCasosEmpresas> listaDeCasosPorEmpresa) {
        this.listaDeCasosPorEmpresa = listaDeCasosPorEmpresa;
    }

    public TbEmpresaComercial getEmpresaComercial() {
        return empresaComercial;
    }

    public void setEmpresaComercial(TbEmpresaComercial empresaComercial) {
        this.empresaComercial = empresaComercial;
    }
}
