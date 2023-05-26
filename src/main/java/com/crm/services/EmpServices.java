package com.crm.services;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.data.repository.*;
import com.crm.entity.Employer;
import com.crm.repositories.EmpRepositories;
	
@Service
public class EmpServices {
	
	@Autowired
	EmpRepositories Emprepositories;
	public List<Employer> getAllEmp(){
		return Emprepositories.findAll();	
	}
	
	public Employer addEmp(Employer employer){
		return Emprepositories.save(employer);
	}
	
	public Boolean existByid(Integer id){
		return Emprepositories.existsById(id);
	}
	
	public Optional<Employer> getEmpById(Integer id){
		return Emprepositories.findById(id);
	}	
	
	public Optional<Employer> updateEmp(Integer id, Employer employer){
		return Emprepositories.findById(id).map((d)->{
			d.setName(employer.getName());
			d.setMaterial(employer.getMaterial());
			d.setType(employer.getType());
			d.setNSerie(employer.getNSerie());
			d.setRemarque(employer.getRemarque());
			d.setDepartement(employer.getDepartement());
			d.setDate(employer.getDate());
		return Emprepositories.save(d);
		});	
	}
	
	public void deleteById(Integer id){
		Emprepositories.deleteById(id);
	}
}
