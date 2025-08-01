package com.fss.services;

import java.util.List;

import com.fss.entities.CompteBancaire;

public interface CompteBancaireService {
	
	CompteBancaire creer(CompteBancaire compteBancaire) ;
	CompteBancaire consulter(Long id) ;
	List<CompteBancaire> consulterComptes();
	void modifier(CompteBancaire compteBancaire) ;
	void supprimer(Long id) ;

}
