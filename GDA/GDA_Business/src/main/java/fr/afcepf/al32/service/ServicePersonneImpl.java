package fr.afcepf.al32.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.dao.IPersonneDao;
import fr.afcepf.al32.entity.Personne;

@Component 
@Transactional
public class ServicePersonneImpl implements IServicePersonne {}
