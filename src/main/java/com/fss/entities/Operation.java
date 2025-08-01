package com.fss.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
@Entity
public class Operation implements Serializable {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateOperation;
	private double montant;
	private TypeOperation type;
	
	
	
	
	
	
	
	
}
