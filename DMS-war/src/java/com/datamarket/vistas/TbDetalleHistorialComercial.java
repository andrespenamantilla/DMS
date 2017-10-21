/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.vistas;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author andre
 */
@ViewScoped
@Named
public class TbDetalleHistorialComercial implements Serializable{
    
    @Inject
    ObjetosSesion sesion;
    
    @PostConstruct
    public void init()
    {
    
    
    
    }
    
}
