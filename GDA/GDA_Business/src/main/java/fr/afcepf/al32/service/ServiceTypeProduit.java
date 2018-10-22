package fr.afcepf.al32.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.dao.ITypeProduitDao;
import fr.afcepf.al32.entity.TypeProduit;

@Component 
@Transactional
public class ServiceTypeProduit implements IServiceTypeProduit {
	
	@Autowired
	private ITypeProduitDao typeProduitDao;
	
	@Override
	public TypeProduit rechercherTypeProduit(Long id) {
		return typeProduitDao.findOne(id);
	}

}
