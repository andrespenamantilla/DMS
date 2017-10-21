/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbAdmRoles;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
@Stateless
public class TbAdmRolesFacade extends ManejadorPersistencia<TbAdmRoles> {

    /*
     Funcion que ejecuta el  query 
     "Buscar por 'ro_codigo' en la tabla 'Tb_Adm_roles'
     */
    public TbAdmRoles buscarPorId(Integer roCodigo) {
        Query query = em.createNamedQuery("TbAdmRoles.findByRoCodigo", TbAdmRoles.class).setParameter("roCodigo", roCodigo);
        TbAdmRoles rolByCodigo = (TbAdmRoles) (query.getResultList().get(0));
        if (rolByCodigo == null) {
            return null;
        } else {
            return rolByCodigo;
        }
    }

    /*
     Funcion que ejecuta el  query 
     "Seleccionar  todos los registros de la tabla 'Tb_Adm_roles'
     */
    public List getAllRoles() {
        Query q = em.createNamedQuery("TbAdmRoles.findAll", TbAdmRoles.class);
        List<TbAdmRoles> roles = q.getResultList();
        return roles;
    }

    /*
     Funcion que persiste en la base de datos una entidad de tipo TbAdmRoles a la tabla 'Tb_Adm_roles'
     */
    public void guardarTbAdmRoles(TbAdmRoles rol) {
        persistir(rol);
    }

    /*
     Funcion que elimina en la base de datos una entidad de tipo TbAdmRoles a la tabla 'Tb_Adm_roles'
     */
    public void eliminarTbAdmRoles(TbAdmRoles rol) {
        Query q = em.createNamedQuery("TbAdmRoles.findByRoCodigo", TbAdmRoles.class).setParameter("roCodigo", rol.getRoCodigo());
        TbAdmRoles rolEliminar = (TbAdmRoles) q.getSingleResult();
        eliminar(rolEliminar);
    }

    /*
     Funcion que modifica  en la base de datos una entidad de tipo TbAdmRoles a la tabla 'Tb_Adm_roles'
     */
    public void modificarTbAdmRoles(TbAdmRoles rol) {
        em.merge(rol);

    }

    public TbAdmRoles finById(Integer roCodigo) {
        return em.find(TbAdmRoles.class, roCodigo);

    }
}
