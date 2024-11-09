package com.example.dojo.ninja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dojo.ninja.models.Dojo;
import com.example.dojo.ninja.models.Ninja;
import com.example.dojo.ninja.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	//returns all the ninjas
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	//creates a ninja
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
	
	//retrieves a ninja
	public Ninja findNinja(Long id) {
		return ninjaRepository.findById(id).orElse(null);
	}
	
	public List<Ninja> byDojo(Dojo dojo) {
    	return ninjaRepository.findAllByDojo(dojo);
    }

}
