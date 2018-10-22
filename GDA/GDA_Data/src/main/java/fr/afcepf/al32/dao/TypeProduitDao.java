package fr.afcepf.al32.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al32.entity.TypeProduit;

@Component
@Transactional
public class TypeProduitDao implements ITypeProduitDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public TypeProduit findOne(Long numero) {
		return entityManager.find(TypeProduit.class, numero);
	}

	@Override
	public void save(TypeProduit p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TypeProduit> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
