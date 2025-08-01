package com.fss.Bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fss.entities.Client;
import com.fss.entities.CompteBancaire;
import com.fss.services.CompteBancaireService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/bank_compte_bancaire")
public class CompteBancaireControllers {
	
	@Autowired
	CompteBancaireService compteBancaireService;
	
	@PostMapping("/creer")
	public void creer(@RequestBody CompteBancaire compteBancaire) {
		compteBancaireService.creer(compteBancaire);
	}

	@GetMapping("/consulterComptes")
	public List<CompteBancaire> consulter() {
	    return compteBancaireService.consulterComptes();
	}
	
	@GetMapping("/consulter/{id}")
	public ResponseEntity<CompteBancaire> consulter(@PathVariable Long id) {
	    CompteBancaire compteBancaire = compteBancaireService.consulter(id);
	    if (compteBancaire != null) {
	        return ResponseEntity.ok(compteBancaire);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	/*@GetMapping("/consulter/{id}")
	public void consulter(@PathVariable Long id) {
		compteBancaireService.consulter(id);
	}*/
	
	@PutMapping("/compte_bancaire/{id}")
	public void modifier(@PathVariable Long id, @RequestBody CompteBancaire compteBancaire) {
		
		// Assurez-vous que l'ID du compte bancaire dans le chemin correspond à l'ID du compte bancaire dans le corps de la requête
        if (id.equals(compteBancaire.getId())) {
        	compteBancaireService.modifier(compteBancaire);
        } else {
        	System.out.println("l'ID du compte bancaire dans le chemin ne correspond pas à l'ID du compte bancaire dans le corps de la requête");
        }	
	}
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimer(@PathVariable Long id) {
		compteBancaireService.supprimer(id);
	}
	

}





