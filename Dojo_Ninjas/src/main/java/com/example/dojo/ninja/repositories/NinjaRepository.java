package com.example.dojo.ninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dojo.ninja.models.Dojo;
import com.example.dojo.ninja.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	// this method retrieves all the books from the database
	List<Ninja> findAll();
	
	List<Ninja> findAllByDojo(Dojo dojo);

}
