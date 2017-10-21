/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbAdmUsuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.apache.commons.codec.digest.DigestUtils;
import org.ocpsoft.common.util.Strings;


/**
 *
 * @author Andres
 */
@Stateless
public class TbAdmUsuariosFacade extends ManejadorPersistencia<TbAdmUsuarios> {

    /*
     Funcion que ejecuta el  query 
     "Buscar por 'us_cod_usuario' en la tabla 'Tb_Adm_usuarios'
     */
    public TbAdmUsuarios buscarPorId(Integer usCodUsuario) {
        Query query = em.createNamedQuery("TbAdmUsuarios.findByUsCodUsuario", TbAdmUsuarios.class).setParameter("usCodUsuario", usCodUsuario);
        TbAdmUsuarios usuarioByCodUsuario = (TbAdmUsuarios) (query.getResultList().get(0));
        if (usuarioByCodUsuario == null) {
            return null;
        } else {
            return usuarioByCodUsuario;
        }
    }

    /*
     Funcion que ejecuta el  query 
     "Seleccionar  todos los registros de la tabla 'Tb_Adm_usuarios'
     */
    public List getAllUsuarios() {
        Query q = em.createNamedQuery("TbAdmUsuarios.findAll", TbAdmUsuarios.class);
        List<TbAdmUsuarios> usuarios = q.getResultList();
        return usuarios;
    }

    /*
     Funcion que persiste en la base de datos una entidad de tipo TbAdmUsuarios a la tabla 'Tb_Adm_usuarios'
     */
    public void guardarTbAdmUsuarios(TbAdmUsuarios usuario) {
        em.persist(usuario);
    }

    /*
     Funcion que elimina en la base de datos una entidad de tipo TbAdmUsuarios la tabla 'Tb_Adm_usuarios'
     */
    public void eliminarTbAdmUsuarios(TbAdmUsuarios usuario) {
        Query q = em.createNamedQuery("TbAdmUsuarios.findByUsCodUsuario", TbAdmUsuarios.class).setParameter("usCodUsuario", usuario.getUsCodUsuario());
        TbAdmUsuarios usuarioEliminar = (TbAdmUsuarios) q.getSingleResult();
        em.remove(usuarioEliminar);
    }

    /*
     Funcion que modifica  en la base de datos una entidad de tipo TbAdmUsuarios a la tabla 'Tb_Adm_usuarios'
     */

    public void modificarTbAdmUsuarios(TbAdmUsuarios usuario) {
        em.merge(usuario);
    }

    /*Función que ejecuta el query 'TbAdmUsuarios.findByLoginAndPassword' y busca un usuario por 'us_login' y 'us_password'
     de la tabla 'Tb_Adm_usuarios'
     */
    public TbAdmUsuarios buscarUsuarioPorLoginAndPassword(String userName, String password) {
        Query q = em.createNamedQuery("TbAdmUsuarios.findByLoginAndPassword", TbAdmUsuarios.class).setParameter("usLogin", userName).setParameter("usPassword", DigestUtils.md5Hex(password));
        TbAdmUsuarios usuarioHallado = (TbAdmUsuarios) q.getSingleResult();

        return usuarioHallado;
    }

    /*
     valida si Existen usuarios asosiados a un rol
     */
    public boolean validarExistenciaUsuariosPorRol(Integer rolUsuarios) {
        Query q = em.createNamedQuery("TbAdmUsuarios.findByUsRol", TbAdmUsuarios.class).setParameter("usRol", rolUsuarios);
        List<TbAdmUsuarios> listaUsuarios = q.getResultList();
        /*Si el tamaño de la lista es mayor a cero*/
        if (listaUsuarios.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public TbAdmUsuarios findById(Integer usuarioId) {
        TbAdmUsuarios usuarioHallado;
        usuarioHallado = em.find(TbAdmUsuarios.class, usuarioId);
        return usuarioHallado;
        }
    
    
     public String findNombreById(Integer usuarioId) {
        TbAdmUsuarios usuarioHallado;
        usuarioHallado = em.find(TbAdmUsuarios.class, usuarioId);
        
        
        return Strings.capitalize(usuarioHallado.getUsNombre());
        }
     
       public Integer obtenerIdUltimoRegistro() {
        List<TbAdmUsuarios> usuarios;
        Query q = em.createNamedQuery("TbAdmUsuarios.findAll", TbAdmUsuarios.class);
        usuarios = q.getResultList();

        return usuarios.get(usuarios.size() -1 ).getUsCodUsuario()+ 1;
    }
    
     
     
}

