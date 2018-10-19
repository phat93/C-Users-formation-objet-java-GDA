package fr.afcepf.al32.service;

import java.util.List;

import fr.afcepf.al32.entity.Don;
import fr.afcepf.al32.entity.Pack;

public interface IServiceDon {
	void ajouterModifierDon(Don d);
	void supprimerDon(Long num);
	Don rechercherDonParNumero(Long num);
	List<Don> listDonDonateur(Long num);
}
