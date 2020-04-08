package test.login.victor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.login.victor.entities.Membros;
import test.login.victor.entities.Tarefas;
import test.login.victor.repositories.MembrosRepository;
import test.login.victor.repositories.TarefasRepository;

@Service
public class TarefasService {
	
	@Autowired
	TarefasRepository repo; 
	@Autowired
	MembrosRepository mRepo; 
	
	
	public List<Tarefas> findAll(){ 
		return repo.findAll();
	}
	
	public Tarefas findById(Long id) { 
		Optional<Tarefas> obj = repo.findById(id);
		return obj.get();
	}
	
	
	public Tarefas  insert(Tarefas obj, Long id) { 
		Optional<Membros> m = mRepo.findById(id);
		obj.setMembros(m.get());
		return repo.save(obj);
		
	}
	
	public void delete(Long id) { 
		repo.deleteById(id);
	}
	
	
	public Tarefas update(Long id, Tarefas obj) { 
		Tarefas entity = repo.getOne(id);
		updateData(entity, obj);
		return repo.save(entity);
		
	}
	
	
	public void updateData(Tarefas entity, Tarefas obj) { 
		entity.setStatus(obj.getStatus());
		entity.setDataFinal(obj.getDataFinal());
		
	}
	
	

}
