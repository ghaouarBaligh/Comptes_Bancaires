package com.fss.services;

import java.util.List;

import com.fss.entities.Operation;

public interface OperationService {

	void creer(Operation operation);
	Operation consulter(Long id) ;
	List<Operation> consulter();
	void verser(float montant,Long id);
	void retirer(float montant,Long id);
	void virement(float montant,Long ids,Long idd);

}
