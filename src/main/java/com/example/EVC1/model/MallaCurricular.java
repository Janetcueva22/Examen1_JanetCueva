package com.example.EVC1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="mallas_curriculares")
@Entity
public class MallaCurricular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	private String año;
	
	@OneToOne(mappedBy = "malla")
	private Universidad universidad;
	
	@OneToMany(mappedBy = "m_curricular")
	private List<Curso> cursos=new ArrayList<Curso>();
	
	public MallaCurricular() {
		super();
	}

	public Integer getIdMalla() {
		return idMalla;
	}

	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}
}
