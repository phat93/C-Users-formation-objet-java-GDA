package fr.afcepf.al32.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.dao.IPersonneDao;
import fr.afcepf.al32.entity.Association;
import fr.afcepf.al32.entity.Personne;


@Component //ou bien @Service qui herite de @Component
@Transactional
public class ServiceAssociation implements IServiceAssociation {
	
	@Autowired
	private IPersonneDao personneDao=null;

	@Override
	public List<Personne> rechercheAssociationTypePt( Long param) {
		
		return personneDao.findAllByParam("AssociationParType", "id",param);
	}

	@Override
	public List<Personne> rechercheAssociationTypePays(Long param) {
		return personneDao.findAllByParam("AssociationParPays","idPaysAide", param);
		}

	@Override
	public void ajouterModifierAssociation(Personne p) {
		 personneDao.save(p);
	}

	@Override
	public void supprimerAssociation(Long num) {
		personneDao.delete(num);
	}

	@Override
	public List<Personne> rechercheAssociationNouvelle() {
		return personneDao.findAll("AssociationNouvelle");
	}
	@Override
	public List<Personne> rechercheAssociationPxPack(double valParam, double valParam1)
	{
		return personneDao.findAllByMoreParam("AssociationParPxPack", "minPx",  valParam, "maxPx",valParam1);
	}
	@Override
	public Personne rechercherParConnexion(String login, String password) {
		return personneDao.findByConnexion(login, password);
	}

	@Override
	public Personne rechercheAssociation(Long num) {
	
		Personne p = personneDao.findOne(num);
		if(p instanceof Association)
		{
			return p;
		}else return null;
		
	}

	@Override
	public void accepterAssociation(Long num, Date dateAcc ) {
		Association a = (Association) personneDao.findOne(num);
		a.setDateAcceptation(dateAcc);
		 personneDao.save(a);
	}

	@Override
	public void refuserAssociation(Long num, Date dateFin) {
		Association a = (Association) personneDao.findOne(num);
		a.setDateFin(dateFin);
		 personneDao.save(a);
		
	}	
	
	@Override
	public List<Personne> rechercheAssociationValidee() {
		return personneDao.findAll("AssociationValidee");
	}

}
