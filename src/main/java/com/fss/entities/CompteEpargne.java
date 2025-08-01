package com.fss.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("E")
public class CompteEpargne extends CompteBancaire {

	public CompteEpargne(Long id, Date dateCreation, double solde, CompteStatus etat, Client client,
			List<Operation> operation) {
		super(id, dateCreation, solde, etat, client, operation);
		// TODO Auto-generated constructor stub
	}

	private double tauxInteret;
}
