package test.login.victor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.login.victor.entities.Account;
import test.login.victor.entities.Membros;
import test.login.victor.entities.Tarefas;
import test.login.victor.repositories.AccountRepository;
import test.login.victor.repositories.MembrosRepository;

@Service
public class MembrosService {
	
	@Autowired
	MembrosRepository repo; 
	@Autowired
	AccountRepository acRep;

	
	public List<Membros> findAll(){ 
		return repo.findAll(); 
	}

	
	public Membros findById(Long id) { 
		Optional<Membros> obj = repo.findById(id);
		return obj.get();
	}
	
	
	public Membros insert(Membros obj, Integer id) { 
		Optional<Account> ac = acRep.findById(id);
		obj.setAccount(ac.get());
		return repo.save(obj);
	}
	
	public void delete(Long id) { 
		repo.deleteById(id);
	}
	
	
	
	public Membros update(Long id, Membros obj) { 
		Membros entity = repo.getOne(id);
		//System.out.println(entity.getNome());
		//System.out.println(obj.getNome());
		updateData(entity, obj);
		return repo.save(entity);
	}
	
	public void updateData(Membros entity, Membros obj) { 
		System.out.println("Entidade: "+ entity.getNome());
		System.out.println("Obj: "+ obj.getNome());
		entity.setNome(obj.getNome());
		entity.setNascimento(obj.getNascimento());
		entity.setPin(obj.getPin());
		entity.setSexo(obj.getSexo());
		entity.setAccount(obj.getAccount());
		
	}
	
	
	public Membros updatePoints(Long id, Tarefas obj) { 
		Membros entity = repo.getOne(id); 
		updateDataPoints(entity, obj);
		return repo.save(entity);
	}
	
	
	public void updateDataPoints(Membros entity, Tarefas obj) { 
		Double points = entity.getPontuacao() + obj.getPontuacao();
		entity.setPontuacao(points);
	}
	
}
