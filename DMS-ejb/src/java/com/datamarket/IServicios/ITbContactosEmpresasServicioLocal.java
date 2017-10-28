/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.IServicios;

import com.datamarket.entidades.TbEmpresas;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author andre
 */
@Local
public interface ITbContactosEmpresasServicioLocal {
    Map<String, Integer> retornarListaDeContactos(TbEmpresas empresa);
}
