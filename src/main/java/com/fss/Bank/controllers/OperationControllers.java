package com.fss.Bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fss.entities.Client;
import com.fss.entities.Operation;
import com.fss.services.OperationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/bank_operation")
public class OperationControllers {

	@Autowired
	OperationService operationService;
	
	@GetMapping("/consulterOperation/{id}")
	public Operation consulter(@PathVariable Long id) {
		return operationService.consulter(id);
	}
	
	@GetMapping("/consulterOperations")
	public List<Operation> consulter() {
		return operationService.consulter();
	}
	
	@PostMapping("/verser")
	public void verser(@RequestParam("montant") float montant, @RequestParam("id") Long id) {
        	operationService.verser(montant, id);
	}
	
	@PostMapping("/retirer")
	public void retirer(@RequestParam("montant") float montant, @RequestParam("id") Long id) {
        	operationService.retirer(montant, id);
	}
	
	@PostMapping("/virement")
	public void virement(@RequestParam("montant") float montant, @RequestParam("ids") Long ids, @RequestParam("idd") Long idd) {
        	operationService.virement(montant, ids,idd);
	}
	
	
}
