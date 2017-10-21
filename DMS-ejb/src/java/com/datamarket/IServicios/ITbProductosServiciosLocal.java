/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.IServicios;



import java.util.HashMap;
import javax.ejb.Local;


/**
 *
 * @author Andrés
 */
@Local
public interface ITbProductosServiciosLocal {

   HashMap<String, Integer> productosMap();
}
