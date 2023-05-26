package com.crm.entity;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.loader.ast.spi.Loadable.*;

import jakarta.validation.constraints.*;

@Entity

public class Employer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull(message="name is required")
	private String name;
	
	@NotNull(message="dob is required")
	private String Material;
	
	@NotNull(message="Type is required")
	private String Type;
	
	@NotNull(message="NSerie is required")
	private String NSerie;
	
	@NotNull(message="Remarque is required")
	private String Remarque;
	
	@NotNull(message="Departement is required")
	private String Departement;
	
	@NotNull(message="Date is required")
	private Calendar Date;
	
	
	
	public Employer(@NotNull(message = "name is required") String name, @NotNull(message="Material is required") String material,
		@NotNull(message = "type is required") String type,@NotNull(message = "NSerie is required") String NSerie, 
		@NotNull(message = "Remarque is required") String Remarque,@NotNull(message = "Departement is required") String Departement,  @NotNull(message="Date is required") Calendar Date ){
		super(); 
		this.name = name;
		this.Material = material;
		this.Type = type;
		this.NSerie = NSerie;
		this.Remarque = Remarque;
		this.Departement=Departement;
		this.Date=Date;
		}
	
	public String getDepartement() {
		return Departement;
	}

	public void setDepartement(String departement) {
		Departement = departement;
	}

	public Calendar getDate() {
		return Date;
	}

	public void setDate(Calendar date) {
		Date = date;
	}

	public Employer() {							
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public String getType() {
		return Type;
	}
	
	
	public void setType(String type) {
		Type = type;
	}
	
	
	public String getNSerie() {
		return NSerie;
	}
	
	
	public void setNSerie(String nSerie) {
		NSerie = nSerie;
	}
	
	
	public String getRemarque() {
		return Remarque;
	}
	
	
	public void setRemarque(String remarque) {
		Remarque = remarque;
	}
}