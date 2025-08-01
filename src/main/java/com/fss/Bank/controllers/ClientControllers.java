package com.fss.Bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.fss.services.ClientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/bank_client")
public class ClientControllers {
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("/creer")
	public void creer(@RequestBody Client client) {
		clientService.creer(client);
	}

	@GetMapping("/consulter")
	public List<Client> consulterClients(){
		return clientService.consulterClients();
	}

	
	@GetMapping("/consulter/{id}")
	public Client consulter(@PathVariable Long id) {
		return clientService.consulter(id);
	}

	@PutMapping("/client/{id}")
	public void modifier(@PathVariable Long id, @RequestBody Client client) {
		
		// Assurez-vous que l'ID du client dans le chemin correspond à l'ID du client dans le corps de la requête
        if (id.equals(client.getId())) {
        	clientService.modifier(client);
        } else {
        	System.out.println("l'ID du client dans le chemin ne correspond pas à l'ID de client dans le corps de la requête");
        }
		
	}
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimer(@PathVariable Long id) {
		clientService.supprimer(id);
	}

	
}











