package com.fss.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.entities.CompteBancaire;
import com.fss.entities.Operation;
import com.fss.entities.TypeOperation;
import com.fss.repositories.CompteBancaireRepository;
import com.fss.repositories.OperationRepository;

@Service
public class OperationServiceImp implements OperationService {

	@Autowired
	OperationRepository operationRepository;
	@Autowired
	CompteBancaireRepository compteBancaireRepository;
	@Override
	public Operation consulter(Long id) {
		return operationRepository.findById(id).orElse(null);
	    /*if (o != null) {
	        System.out.println("Client de id " + id + ":");
	        System.out.print("*date d'operation : " + o.getDateOperation());
	        System.out.print("*montant d'operation : " + o.getMontant());
	        System.out.print("*type d'operation : " + o.getType());
	    } else {
	        System.out.println("Aucune opération trouvée avec l'ID " + id);
	    }*/
	}
	@Override
	public void verser(float montant, Long id) {
		CompteBancaire c = compteBancaireRepository.findById(id).orElse(null);
		 if (c != null) {
			 double solde= c.getSolde();
			 c.setSolde( solde + montant );
			 compteBancaireRepository.save(c);
			 
			 // Créer une nouvelle opération
		        Operation operation = new Operation();
		        operation.setDateOperation(new Date());
		        operation.setMontant(montant);
		        operation.setType(TypeOperation.DEBIT); //modifiable
		        
		        // Sauvegarder l'opération dans la base de données
		        operationRepository.save(operation);
			 
			 System.out.print("Virement fait avec succees");
		 }else {
			 System.out.print("le compte n'existe pas");
		 }
	}
	@Override
	public void retirer(float montant, Long id) {
		CompteBancaire c = compteBancaireRepository.findById(id).orElse(null);
		 if (c != null && c.getSolde()>montant) {
			 double solde= c.getSolde();
			 c.setSolde( solde - montant );
			 compteBancaireRepository.save(c);
			 
			// Créer une nouvelle opération
		        Operation operation = new Operation();
		        operation.setDateOperation(new Date());
		        operation.setMontant(montant);
		        operation.setType(TypeOperation.CREDIT); //modifiable
		        
		        // Sauvegarder l'opération dans la base de données
		        operationRepository.save(operation);
			 
			 System.out.print("Retir avec succees ");
		 }else {
			 System.out.print("le compte n'existe pas");
		 }		
	}
	@Override
	public void virement(float montant, Long ids, Long idd) {
		CompteBancaire cs = compteBancaireRepository.findById(ids).orElse(null);
		CompteBancaire cd = compteBancaireRepository.findById(idd).orElse(null);
		 if (cs != null && cd != null && cs.getSolde()>=montant) {
			 double soldeSource= cs.getSolde();
			 double soldeDestination= cd.getSolde();
			 cs.setSolde( soldeSource - montant );
			 cd.setSolde( soldeDestination + montant );
			 compteBancaireRepository.save(cs);
			 compteBancaireRepository.save(cd);
			 
			// Créer une nouvelle opération
		        Operation operation = new Operation();
		        operation.setDateOperation(new Date());
		        operation.setMontant(montant);
		        operation.setType(TypeOperation.CREDIT); //modifiable
		        
		        // Sauvegarder l'opération dans la base de données
		        operationRepository.save(operation);
			 
			 System.out.print("virement fait avec succees");
		 }else {
			 System.out.print("le compte n'existe pas ou le montant>solde");
		 }		
	}
	@Override
	public List<Operation> consulter() {
		return operationRepository.findAll();
	}
	@Override
	public void creer(Operation operation) {
		operationRepository.save(operation);
		System.out.print("operation créer avec succée");
	}
	
	
	
}
