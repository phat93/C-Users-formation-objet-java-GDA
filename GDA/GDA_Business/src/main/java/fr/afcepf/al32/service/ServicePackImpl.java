package fr.afcepf.al32.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.dao.IPackDao;
import fr.afcepf.al32.entity.Association;
import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.PackAssociation;
import fr.afcepf.al32.entity.Personne;


@Component 
@Transactional
public class ServicePackImpl implements IServicePack {
	
	@Autowired 
	private IPackDao packDao=null;	

//	public void setPackDao(IPackDao packDao) {
//		this.packDao = packDao;
//	}
	
	@Override
	public void ajouterPack(Pack p) {
		packDao.save(p);
	}	
	

	@Override
	public Pack rechercherPackParNumero(Long num) {		
		
		Pack p = packDao.findOne(num);
		if(p instanceof PackAssociation)
		{
			return p;
		}else return null;
	}
		
	@Override  
	public List<PackAssociation> rechercherPackAssociation() {		
		return packDao.findAllPackAssociation();		
	}


	@Override
	public List<PackAssociation> rechercherPackAssociationParType(Long idType) {
		return packDao.findAllPackAssociationByType(idType);
	}


	@Override
	public List<PackAssociation> rechercherPackAssociationParAssociation(Long id) {
		return packDao.findAllPackAssociationByAssociation(id);
	}


	@Override
	public List<PackAssociation> rechercherPackAssociationParAssociationEtType(Long id, Long idType) {
		return packDao.findAllPackAssociationByAssociationAndType(id, idType);
	}


	@Override
	public void desactiverPack(PackAssociation p) {
		Timestamp dtefin = new Timestamp( System.currentTimeMillis() );
		p.setDateRetrait(dtefin);
		packDao.save(p);
	}


}
