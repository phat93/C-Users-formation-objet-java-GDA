package fr.afcepf.al32.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.dao.IPersonneDao;
import fr.afcepf.al32.entity.Don;
import fr.afcepf.al32.entity.Donateur;
import fr.afcepf.al32.entity.Personne;

@Component //ou bien @Service qui herite de @Component
@Transactional
public class ServiceDonateur implements IServiceDonateur {
	
	@Autowired
	private IPersonneDao personneDao=null;
	
	//pour injection de dépendance xml:
	public void setpersonneDao(IPersonneDao personneDao) {
		this.personneDao = personneDao;
	}

	@Override
	public void ajouterModifierDonateur(Personne p) {
		 personneDao.save(p);
		
	}

	@Override
	public void supprimerDonateur(Long num) {
		personneDao.delete(num);
		
	}

	@Override
	public Personne rechercheDonateur(Long num) {
		Personne p = personneDao.findOne(num);
		if(p instanceof Donateur)
		{
			return p;
		}else return null;
		
	}

	@Override
	public Personne rechercherParConnexion(String login, String password) {
		return personneDao.findByConnexion(login, password);
	}


	
	

}
