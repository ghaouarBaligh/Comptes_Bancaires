package com.fss.services;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.repositories.CompteBancaireRepository;
import com.fss.entities.Client;
import com.fss.entities.CompteBancaire;

@Service
public class CompteBancaireServiceImp implements CompteBancaireService {

	@Autowired
	CompteBancaireRepository compteBancaireRepository;
	@Override
	public CompteBancaire creer(CompteBancaire compteBancaire) {
		compteBancaireRepository.save(compteBancaire);
		System.out.println("Enregistrement du Compte Bancaire avec succés");
		return compteBancaire;
	}
	@Override
	public CompteBancaire consulter(Long id) {
		return compteBancaireRepository.findById(id).orElse(null);
		/*CompteBancaire c = compteBancaireRepository.findById(id).orElse(null);
	    if (c != null) {
	        System.out.println("Client de id " + id + ":");
	        System.out.print("*date de creation de compte bancaire : " + c.getDateCreation());
	        System.out.print("*solde de compte bancaire : " + c.getSolde());
	        System.out.print("*etat de compte bancaire : " + c.getEtat());
	    } else {
	        System.out.println("Aucun  compte bancaire trouvé avec l'ID " + id);
	    }*/
	}
	@Override
	public void modifier(CompteBancaire compteBancaire) {
		CompteBancaire CompteBancaireExistant = compteBancaireRepository.findById(compteBancaire.getId()).orElse(null);
	    if (CompteBancaireExistant != null) {	    
	    	CompteBancaireExistant.setDateCreation(compteBancaire.getDateCreation());
	    	CompteBancaireExistant.setSolde(compteBancaire.getSolde());
	    	CompteBancaireExistant.setEtat(compteBancaire.getEtat());
	    	// Enregistrer les modifications dans le référentiel
	    	compteBancaireRepository.save(CompteBancaireExistant);
	        
	        System.out.println("Modification compte bancaire avec succès");
	    } else {
	        System.out.println("Impossible de trouver le compte bancaire à modifier.");
	    }
	}
	@Override
	public void supprimer(Long id) {
		CompteBancaire c = compteBancaireRepository.findById(id).orElse(null);
		compteBancaireRepository.delete(c);
		System.out.println("Suppression du Compte Bancaire avec succés");
	}
	@Override
	public List<CompteBancaire> consulterComptes() {
		return compteBancaireRepository.findAll();
	}

}
