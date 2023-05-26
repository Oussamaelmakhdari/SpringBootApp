package com.crm.controllers;

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

import com.crm.entity.Employer;
import com.crm.services.EmpServices;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployerController {
	@Autowired
	EmpServices empServices;
	
	@RequestMapping(value="/employers", method=RequestMethod.GET)
	public List<Employer> getCustomers() {
		return empServices.getAllEmp(); 
	}
	
	@RequestMapping(value="/employer/{id}", method=RequestMethod.GET)
	public Optional<Employer> getCustomerById(@PathVariable("id") String id){
		return empServices.getEmpById(Integer.parseInt(id)); 
	}
	
	@RequestMapping(value="/employer", method=RequestMethod.POST)
	public Employer addCustomer(@Valid @RequestBody Employer employer) {
		return empServices.addEmp(employer);   
	}
	
	@RequestMapping(value="/employer/{id}", method=RequestMethod.PUT)
	public Optional<Employer> getEmp(@PathVariable("id") String id ,@Valid @RequestBody Employer employer) {
		return empServices.updateEmp(Integer.parseInt(id),employer); 
	}
	
	@RequestMapping(value="/employer/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteById(@PathVariable("id") String id ) {
		empServices.deleteById(Integer.parseInt(id)); 
		 return ResponseEntity.ok().body("Employer "+ id +" has been deleted!");
	}
	
	@RequestMapping(value="/employers/{ids}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteByIds(@PathVariable("ids") List<String> ids ) {
		ids.forEach(d -> {
			if(empServices.existByid(Integer.parseInt(d))) {
				empServices.deleteById(Integer.parseInt(d)); 
			};
		});
		
		return ResponseEntity.ok().body("Employers has been deleted ! ");
	} 
}



