package com.fss.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data@AllArgsConstructor@NoArgsConstructor
@Entity
public class Client implements Serializable {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<CompteBancaire> compteBancaire;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<CompteBancaire> getCompteBancaire() {
		return compteBancaire;
	}
	public void setCompteBancaire(List<CompteBancaire> compteBancaire) {
		this.compteBancaire = compteBancaire;
	}
	
	

	
	
	
}
