package test.login.victor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.login.victor.entities.Tarefas;
import test.login.victor.repositories.TarefasRepository;

@Service
public class TarefasService {
	
	@Autowired
	TarefasRepository repo; 
	
	
	
	public List<Tarefas> findAll(){ 
		return repo.findAll();
	}
	
	public Tarefas findById(Long id) { 
		Optional<Tarefas> obj = repo.findById(id);
		return obj.get();
	}
	
	
	
	
	

}
