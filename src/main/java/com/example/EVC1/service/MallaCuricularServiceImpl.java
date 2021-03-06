package com.example.EVC1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EVC1.dto.MallaCurricularDTORequest;
import com.example.EVC1.dto.MallaCurricularDTOResponse;
import com.example.EVC1.model.MallaCurricular;
import com.example.EVC1.repository.IMallaCurricularRepository;

@Service
public class MallaCuricularServiceImpl implements IMallaCurricularService{

	@Autowired public IMallaCurricularRepository repository;

	@Override
	public void guardarMalla(MallaCurricularDTORequest malla) {
		MallaCurricular m = new MallaCurricular();
		m.setIdMalla(malla.getIdMallaDto());
		m.setAño(malla.getAñoDto());
		
		repository.save(m);
	}

	@Override
	public void editarMalla(MallaCurricularDTORequest malla) {
		
		MallaCurricular m = new MallaCurricular();
		m.setIdMalla(malla.getIdMallaDto());
		m.setAño(malla.getAñoDto());
		
		repository.saveAndFlush(m);
	}

	@Override
	public void eliminarMalla(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<MallaCurricularDTOResponse> listarMallas() {
		
		List<MallaCurricularDTOResponse>lista=new ArrayList<MallaCurricularDTOResponse>();
		MallaCurricularDTOResponse m=null;
		
		for(MallaCurricular malla: repository.findAll()) {
			m=new MallaCurricularDTOResponse();
			m.setIdMallaDto(malla.getIdMalla());
			m.setAñoDto(malla.getAño());
			
			lista.add(m);
		}
		
		return lista;
	}

	@Override
	public MallaCurricularDTOResponse obtenerMalla(Integer id) {
		
		MallaCurricularDTOResponse m=new MallaCurricularDTOResponse();
		MallaCurricular malla=repository.findById(id).orElse(null);
		
		m.setIdMallaDto(malla.getIdMalla());
		m.setAñoDto(malla.getAño());
		return m;
	}
}
