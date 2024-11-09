package com.example.dojo.ninja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dojo.ninja.models.Dojo;
import com.example.dojo.ninja.repositories.DojoRepository;

@Service
public class DojoService {
	
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	//returns all the dojos
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	//creates a dojo
	public Dojo createDojo(Dojo d) {
    	System.out.println(d.getId());
		return dojoRepository.save(d);
	}
	
	//retrieves a dojo
	public Dojo findDojo(Long id) {
		return dojoRepository.findById(id).orElse(null);
	}

}
