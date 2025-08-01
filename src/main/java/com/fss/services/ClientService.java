package com.fss.services;

import java.util.List;

import com.fss.entities.Client;

public interface ClientService {
	
	Client creer(Client client) ;
	void modifier(Client client) ;
	Client consulter(Long id);
	List<Client> consulterClients();
	void supprimer(Long id);
	

}
