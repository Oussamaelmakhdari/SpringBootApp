package com.crm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.entity.*;
import com.crm.repositories.*;
import java.util.Calendar;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.util.*;

import org.springframework.stereotype.Service;
//import org.springframework.data.repository.*;
	
@Service
public class RecupServices {

	@Autowired
	RecupRepositories RecupRepositories;
	public List<RecupEmp> getAllRecup(){
		return RecupRepositories.findAll();	
	}
	
	public RecupEmp addRecup(RecupEmp RecupEmp){
		return RecupRepositories.save(RecupEmp);
	}
	
	public Boolean existByid(Integer id){
		return RecupRepositories.existsById(id);
	}
	
	public Optional<RecupEmp> getRecupById(Integer id){
		return RecupRepositories.findById(id);
	}	
	
	public Optional<RecupEmp> updateRecup(Integer id, RecupEmp RecupEmp){
		return RecupRepositories.findById(id).map((d)->{
			d.setName(RecupEmp.getName());
			d.setMaterial(RecupEmp.getMaterial());
			d.setType(RecupEmp.getType());
			d.setNSerie(RecupEmp.getNSerie());
			d.setRemarque(RecupEmp.getRemarque());
			d.setDepartement(RecupEmp.getDepartement());
			d.setDate(RecupEmp.getDate());
			d.setMp(RecupEmp.getMp());
		return RecupRepositories.save(d);
		});	
	}
	
	public void deleteById(Integer id){
		RecupRepositories.deleteById(id);
	}
}


