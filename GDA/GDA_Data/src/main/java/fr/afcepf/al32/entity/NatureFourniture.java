package fr.afcepf.al32.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class NatureFourniture {

	@Id
	private Long id;
	private String nature;
	
	@OneToMany(mappedBy="natureFourniture")
	private List<FournitureScolaire> fournituresScolaires;
}
