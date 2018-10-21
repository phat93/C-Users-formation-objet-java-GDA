package fr.afcepf.al32.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al32.entity.Don;
import fr.afcepf.al32.entity.PackAssociation;
import fr.afcepf.al32.entity.Personne;

@Component
@Transactional 
public class DonDao implements IDonDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Don findOne(Long numero) {
	
		return entityManager.find(Don.class, numero);
	}

	@Override
	public void save(Don p) {
		if(p.getId()==null)
			entityManager.persist(p);//INSERT INTO ...
		else 
			entityManager.merge(p); //UPDATE SQL
		
	}

	@Override
	public void delete(Long numero) {
		Don d = entityManager.find(Don.class, numero);
		entityManager.remove(d);
		
	}

	@Override
	public List<Don> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Don> findAllByParam(String hql, String param, Long valParam) {
		return entityManager.createNamedQuery(hql, Don.class)
				.setParameter(param, valParam)
	            .getResultList();
	}
	
	
	@Override
	public List<Don> findAll(String hql) {
		return entityManager.createNamedQuery(hql, Don.class)
	            .getResultList();
	}
	/*public List<Don> list(Long valParam) {
		return entityManager.createNamedQuery("ListeDonDonateur", Don.class)
				.setParameter("idDonateur", valParam)
	            .getResultList();
	}*/

	

}
