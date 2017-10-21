/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.facades;

import com.datamarket.entidades.TbEmpresas;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andres Peña Mantilla
 */
@Stateless
public class TbEmpresasFacade extends ManejadorPersistencia<TbEmpresas> {

    /*
     Funcion que ejecuta el  query 
     "Buscar por 'em_id_empresas' en la tabla 'Tb_Empresas'
     */
    public TbEmpresas buscarPorId(Integer idEmpresas) {
        Query query = em.createNamedQuery("TbEmpresas.findByEmIdEmpresas", TbEmpresas.class).setParameter("emIdEmpresas", idEmpresas);
        TbEmpresas empresaById = (TbEmpresas) (query.getResultList().get(0));
        if (empresaById == null) {
            return null;
        } else {
            return empresaById;
        }
    }

    /*
     Funcion que ejecuta el  query 
     "Seleccionar  todos los registros de la tabla 'Tb_Empresas'
     */
    public List getAllEmpresas() {
        Query q = em.createNamedQuery("TbEmpresas.findAll", TbEmpresas.class);
        List<TbEmpresas> empresas = q.getResultList();
        return empresas;
    }

    /*
     Funcion que persiste en la base de datos una entidad de tipo TbEmpresas a la tabla 'Tb_Empresas'
     */
    public void guardarTbEmpresas(TbEmpresas empresa) {
        em.persist(empresa);
    }

    /*
     Funcion que elimina en la base de datos una entidad de tipo TbEmpresas a la tabla 'Tb_Empresas'
     */
    public void eliminarTbEmpresa(TbEmpresas empresa) {
        Query q = em.createNamedQuery("TbEmpresas.findByEmIdEmpresas", TbEmpresas.class).setParameter("emIdEmpresas", empresa.getEmIdEmpresas());
        TbEmpresas empresaEliminar = (TbEmpresas) q.getSingleResult();
        eliminar(empresaEliminar);
    }

    /*
     Funcion que modifica  en la base de datos una entidad de tipo Tb_Empresas a la tabla 'Tb_Empresas'
     */
    public void modificarTbEmpresa(TbEmpresas empresa) {
        em.merge(empresa);
    }

    public TbEmpresas buscarPorNombre(String emNombre) {
        Query q = em.createNamedQuery("TbEmpresas.findByEmNombre", TbEmpresas.class).setParameter("emNombre", emNombre);
        return (TbEmpresas) q.getSingleResult();

    }

    public TbEmpresas buscarPorNit(String emNit) {
        Query q = em.createNamedQuery("TbEmpresas.findByEmNit", TbEmpresas.class).setParameter("emNit", emNit);
        return (TbEmpresas) q.getSingleResult();

    }

    public List<TbEmpresas> buscarEmpresas(String textoBusqueda, int startAt, int maxPerPage) {
        Query q = em.createNamedQuery("TbEmpresas.findByNombreAndNit", TbEmpresas.class).setParameter("txtBusqueda", textoBusqueda);
        q.setFirstResult(startAt);
        q.setMaxResults(maxPerPage);
        return q.getResultList();
    }

    public List<TbEmpresas> buscarEmpresasPorFiltro(String textoBusqueda, int startAt, int maxPerPage) {
        Query q = em.createQuery("SELECT t FROM TbEmpresas t WHERE t.emNombre LIKE :txtBusqueda OR t.emNit LIKE :txtBusqueda");
        q.setParameter("txtBusqueda", "%" + textoBusqueda + "%");
        q.setFirstResult(startAt);
        q.setMaxResults(maxPerPage);
        return q.getResultList();
    }

    public List<TbEmpresas> buscarEmpresas(String textoBusqueda) {
        Query q = em.createQuery("SELECT t FROM TbEmpresas t WHERE t.emNombre LIKE :txtBusqueda OR t.emNit LIKE :txtBusqueda");
        q.setParameter("txtBusqueda", "%" + textoBusqueda + "%");
        return q.getResultList();
    }

    public TbEmpresas findById(Integer empresaId) {
        TbEmpresas empresa;
        empresa = em.find(TbEmpresas.class, empresaId);
        return empresa;
    }

    public List<String> buscarEmpresaPorNombre(String emNombre) {

        List<String> nombresEmpresas = new ArrayList<>();
        List<TbEmpresas> empresasHalladas = new ArrayList<>();
        Query q = em.createQuery("SELECT t FROM TbEmpresas t WHERE t.emNombre LIKE :emNombre");
        q.setParameter("emNombre", "%" + emNombre + "%");
        q.setFirstResult(0);
        q.setMaxResults(50);
        empresasHalladas = q.getResultList();
        String aux;
        for (int i = 0; i < empresasHalladas.size(); i++) {

            aux = empresasHalladas.get(i).getEmNombre();
            nombresEmpresas.add(aux);
            aux = null;

        }

        return nombresEmpresas;
    }

    public List<String> buscarEmpresaPorNit(String emNit) {

        List<String> nitEmpresas = new ArrayList<>();
        List<TbEmpresas> empresasHalladas;
        Query q = em.createQuery("SELECT t FROM TbEmpresas t WHERE t.emNit LIKE :emNit");
        q.setParameter("emNit", "" + emNit + "%");
        q.setFirstResult(0);
        q.setMaxResults(50);
        empresasHalladas = q.getResultList();
        String aux;
        for (int i = 0; i < empresasHalladas.size(); i++) {

            aux = empresasHalladas.get(i).getEmNit();
            nitEmpresas.add(aux);
            aux = null;

        }

        return nitEmpresas;
    }

    public List<TbEmpresas> buscarEmpresasPorParametrosDeBusqueda(
            String emNombre,
            String emNit,
            Integer emSector,
            String emPais,
            String emDepto,
            String emCiudad,
            String emTelefono1,
            String emTelefono2
    ) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT t ");
        query.append("FROM TbEmpresas t  ");
        query.append("WHERE ");

        List<String> criteria = new ArrayList<String>();
        if (emNombre != null) {
            criteria.add("t.emNombre LIKE :emNombre");
        }
        if (emNit != null) {
            criteria.add("t.emNit = :emNit");
        }
        if (emSector != null) {
            criteria.add("t.emSector = :emSector");
        }

        if (emPais != null) {
            criteria.add("t.emPais = :emPais");
        }

        if (emDepto != null) {
            criteria.add("t.emDepto = :emDepto");
        }

        if (emCiudad != null) {
            criteria.add("t.emCiudad = :emCiudad");
        }
        if (emTelefono1 != null) {
            criteria.add("t.emTelefono1 = :emTelefono1");
        }

        if (emTelefono2 != null) {
            criteria.add("t.emTelefono2 = :emTelefono2");
        }

        if (criteria.size() == 0) {
            //throw new RuntimeException("no criteria");

            return null;

        }

        for (int i = 0; i < criteria.size(); i++) {
            if (i > 0) {
                query.append(" AND ");
            }
            query.append(criteria.get(i));
        }

        Query q = em.createQuery(query.toString());
        if (emNombre != null) {
            q.setParameter("emNombre","%"+emNombre+"%");
        }
        if (emNit != null) {
            q.setParameter("emNit", emNit);
        }
        if (emCiudad != null) {
            q.setParameter("emCiudad", emCiudad);
        }

        if (emPais != null) {
            q.setParameter("emPais", emPais);
        }

        if (emDepto != null) {
            q.setParameter("emDepto", emDepto);
        }

        if (emSector != null) {
            q.setParameter("emSector", emSector);
        }

        if (emTelefono1 != null) {
            q.setParameter("emTelefono1", emTelefono1);
        }

        if (emTelefono2 != null) {
            q.setParameter("emTelefono2", emTelefono2);
        }

        return (q.getResultList());
    }

    public Integer obtenerIdUltimoRegistro() {
        List<TbEmpresas> empresasHalladas;
        Query q = em.createNamedQuery("TbEmpresas.findAll", TbEmpresas.class);
        empresasHalladas = q.getResultList();

        return empresasHalladas.get(empresasHalladas.size() -1 ).getEmIdEmpresas() + 1;
    }

     public void eliminarEmpresas(TbEmpresas empresa) {
        Query q = em.createQuery("DELETE FROM TbEmpresas t WHERE t.emIdEmpresas =:emIdEmpresas");
        q.setParameter("emIdEmpresas", empresa.getEmIdEmpresas());
        q.executeUpdate();
    }
    
    
    
}
