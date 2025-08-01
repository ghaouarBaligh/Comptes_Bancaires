package com.fss.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
public class CompteBancaire implements Serializable {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateCreation; 
	private double solde;
	private CompteStatus etat;
	@ManyToOne
	private Client client;
	@OneToMany
	private List<Operation> operation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public CompteStatus getEtat() {
		return etat;
	}
	public void setEtat(CompteStatus etat) {
		this.etat = etat;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Operation> getOperation() {
		return operation;
	}
	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}
	public CompteBancaire(Long id, Date dateCreation, double solde, CompteStatus etat, Client client,
			List<Operation> operation) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.etat = etat;
		this.client = client;
		this.operation = operation;
	}
	public CompteBancaire() {
		super();
	}
	
	
	

	

}
