package fr.afcepf.al32.dao;

import java.util.List;

import fr.afcepf.al32.entity.Personne;

/*
 * DAO = Data Access Object (objet spécialisé dans l'accès aux données)
 * couche logicielle "persistance" ou "accès aux données"
 * avec méthodes "CRUD" 
 * C: Create (insert into)
 * R: Recherche
 * U: Update
 * D: Delete
 */

public interface IPersonneDao extends IGenericDao<Personne>{

	Personne findByConnexion(String login, String password);
	List<Personne> findAllByParam(String hql, String param, Long valParam);
	List<Personne> findAllByMoreParam(String hql, String param, double valParam, String param1, double valParam1);
	public List<Personne> findAll(String hql) ;
}
