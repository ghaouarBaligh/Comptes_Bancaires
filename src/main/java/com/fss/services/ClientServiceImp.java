package com.fss.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.entities.Client;
import com.fss.repositories.ClientRepository;
@Service
public class ClientServiceImp implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	@Override
	public Client creer(Client client) {
		clientRepository.save(client);
		System.out.println("Enregistrement Client avec succés");
		return client;
	}
	@Override
	public Client consulter(Long id) {
	    return clientRepository.findById(id).orElse(null);
	}

	@Override
	public void modifier(Client client) {
	    Client clientExistant = clientRepository.findById(client.getId()).orElse(null);
	    if (clientExistant != null) {	    
	        clientExistant.setEmail(client.getEmail());
	        clientExistant.setNom(client.getNom());
	        clientExistant.setPrenom(client.getPrenom());
	        // Enregistrer les modifications dans le référentiel
	        clientRepository.save(clientExistant);
	        
	        System.out.println("Modification du client avec succès");
	    } else {
	        System.out.println("Impossible de trouver le client à modifier.");
	    }
	}
	public void supprimer(Long id) {
	    Client c = clientRepository.findById(id).orElse(null);
		clientRepository.delete(c);
		System.out.println("suppression de Client avec succés");

	}
	@Override
	public List<Client> consulterClients(){
		return clientRepository.findAll();		
	}

}
