package com.crm.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crm.entity.*;
import com.crm.services.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class RecupController {
	@Autowired
	RecupServices recupServices;
	
	@RequestMapping(value="/recupemps", method=RequestMethod.GET)
	public List<RecupEmp> getRecup() {
		return recupServices.getAllRecup(); 
	}
	
	@RequestMapping(value="/recupemp/{id}", method=RequestMethod.GET)
	public Optional<RecupEmp> getCustomerById(@PathVariable("id") String id){
		return recupServices.getRecupById(Integer.parseInt(id)); 
	}
	
	@RequestMapping(value="/recupemp", method=RequestMethod.POST)
	public RecupEmp addRecup(@Valid @RequestBody RecupEmp recupEmp) {
		return recupServices.addRecup(recupEmp);   
	}
	
	@RequestMapping(value="/recupemp/{id}", method=RequestMethod.PUT)
	public Optional<RecupEmp> getRecup(@PathVariable("id") String id ,@Valid @RequestBody RecupEmp recupEmp) {
		return recupServices.updateRecup(Integer.parseInt(id),recupEmp); 
	}
	
	@RequestMapping(value="/recupemp/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteById(@PathVariable("id") String id ) {
		recupServices.deleteById(Integer.parseInt(id)); 
		 return ResponseEntity.ok().body("Employer "+ id +" has been deleted!");
	}
	
	@RequestMapping(value="/recupemps/{ids}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteByIds(@PathVariable("ids") List<String> ids ) {
		ids.forEach(d -> {
			if(recupServices.existByid(Integer.parseInt(d))) {
				recupServices.deleteById(Integer.parseInt(d)); 
			};
		});
		
		return ResponseEntity.ok().body("Employers has been deleted ! ");
	} 

}
