package fr.afcepf.al32.service;

import java.util.List;

import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.PackAssociation;


public interface IServicePack {		
	void ajouterPack(Pack p);		
	Pack rechercherPackParNumero(Long num);
	List<PackAssociation> rechercherPackAssociation();	
	List<PackAssociation> rechercherPackAssociationParType(Long idType);
	List<PackAssociation> rechercherPackAssociationParAssociation(Long id);
	List<PackAssociation> rechercherPackAssociationParAssociationEtType(Long id, Long idType);
	void desactiverPack(Long num);
	

}
