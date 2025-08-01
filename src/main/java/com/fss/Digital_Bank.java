package com.fss;

import java.util.ArrayList; 
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fss.entities.Client;
import com.fss.entities.CompteBancaire;
import com.fss.entities.CompteCourant;
import com.fss.entities.CompteEpargne;
import com.fss.entities.CompteStatus;
import com.fss.entities.Operation;
import com.fss.entities.TypeOperation;
import com.fss.services.ClientService;
import com.fss.services.CompteBancaireService;
import com.fss.services.OperationService;

@SpringBootApplication
public class Digital_Bank implements CommandLineRunner {

	@Autowired
	ClientService clientService;
	@Autowired
	CompteBancaireService compteBancaireService;
	@Autowired
	OperationService operationService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Digital_Bank.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		/*// Étape 1 : Créer une liste vide de comptes pour le client
		List<CompteBancaire> comptesBancaires = new ArrayList<>();

		// Étape 2 : Créer et sauvegarder le client
		Client nouveauClient = new Client(null, "Ali", "Ben Salah", "ali@gmail.com", comptesBancaires);
		Client clientSauvegarde = clientService.creer(nouveauClient); // Maintenant l'ID est généré

		// Étape 3 : Créer un compte bancaire lié au client sauvegardé
		List<Operation> operations = new ArrayList<>();
		CompteBancaire compteBancaire = new CompteBancaire(null, new Date(), 1000.0, CompteStatus.ACTIVE, clientSauvegarde, operations);

		// Étape 4 : Sauvegarder le compte bancaire
		CompteBancaire compteSauvegarde = compteBancaireService.creer(compteBancaire);

		// ✅ Correction ici : utiliser setCompteBancaire au lieu de setComptes
		comptesBancaires.add(compteSauvegarde);
		clientSauvegarde.setCompteBancaire(comptesBancaires);
		clientService.modifier(clientSauvegarde);

		System.out.println("✅ Compte bancaire créé pour le client : " + clientSauvegarde.getNom());*/

        /*List<CompteBancaire> comptesBancaires=new ArrayList<>(); 
        CompteBancaire compteBancaire1=new CompteBancaire(5L, new Date(), 88, CompteStatus.ACTIVE, new Client(null,"baligh","12","amin@gmail.com",comptesBancaires), operations);
        CompteBancaire compteBancaire2=new CompteBancaire(6L, new Date(), 72, CompteStatus.ACTIVE, new Client(null,"amin","454","amin@gmail.com",comptesBancaires), operations);
        comptesBancaires.add(compteBancaire1);
        comptesBancaires.add(compteBancaire2);*/
		/*Client c1=new Client();
		clientService.creer(c1);
		List<Operation> operations=new ArrayList<Operation>();
        CompteBancaire compteBancaire13=new CompteBancaire(null, new Date(),(double) 560, CompteStatus.ACTIVE, c1, operations);
        compteBancaireService.creer(compteBancaire13);*/
        //Ajout d'un client
        /*Client client5=new Client(null,"tahr","jafr","tahir@gmail.com",comptesBancaires);
        Client client1=new Client(null, null, null, null, comptesBancaires);*/

        //clientService.creer(client5);
        //clientService.consulter(1L);
        //clientService.modifier(new Client(3L,"hatem","ghaouar","hatem123@gmail.com",comptesBancaires));                 new Client(null,"hatem","ghaouar","hatem@gmail.com",comptesBancaires);
        //clientService.supprimer(20L);
        
       // List<Operation> operations = new ArrayList<>();
	    
     // Initialisation d'un objet Operation
        //Operation operation4 = new Operation(null,new Date(),(double)22,TypeOperation.CREDIT);
        //operationService.consulter();
        //operation4

        /*operation1.setId(1L);
        operation1.setDateOperation(new Date());
        operation1.setMontant(100.0);
        operation1.setType(TypeOperation.CREDIT); 
	
	     Operation operation2 = new Operation();
	     operation2.setDateOperation(new Date());
	     operation2.setMontant(50.0);
	     operation2.setType(TypeOperation.DEBIT);*/
	
	     // Ajouter les nouveaux objets Operation à la liste
	     //operations.add(operation1);
	     //operations.add(operation2);
        
	  // Assigner la liste d'opérations au compte bancaire
	     //compteBancaire1.setOperation(operations);
	     
        //Ajout d'un compte bancaire
        /*CompteBancaire comptebancaire=new CompteBancaire(2L, new Date(), 68, CompteStatus.ACTIVE, client5, operations);
        compteBancaireService.creer(comptebancaire);
        CompteBancaire comptebancaire2=new CompteBancaire(2L, new Date(), 68, CompteStatus.ACTIVE, new Client(null,"amin","amin","amin@gmail.com",comptesBancaires), operations);
        compteBancaireService.creer(comptebancaire);*/
        
     // Ajout d'un compte bancaire
     /*  CompteEpargne compteEpargne = new CompteEpargne();
       compteEpargne.setDateCreation(new Date());
       compteEpargne.setSolde(10);
       compteEpargne.setEtat(CompteStatus.ACTIVE);
       compteEpargne.setClient(client5);
       compteEpargne.setOperation(operations);
        compteBancaireService.creer(compteEpargne);*/
        //compteBancaireService.consulter(2L);
        //compteBancaireService.supprimer(3L);
        //compteBancaireService.modifier(comptebancaire);
        
        //operationService.virement(10, 7L, 2L);
        //operationService.verser(78, 5L);
        //operationService.retirer(20, 5L);
        //operationService.consulter(2L);
        
        //System.out.println(clientService.consulterClients());
        
        
        
	}
}
