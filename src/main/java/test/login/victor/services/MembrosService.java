package test.login.victor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.login.victor.entities.Membros;
import test.login.victor.repositories.MembrosRepository;

@Service
public class MembrosService {
	
	@Autowired
	MembrosRepository repo; 

	
	public List<Membros> findAll(){ 
		return repo.findAll(); 
	}

}
