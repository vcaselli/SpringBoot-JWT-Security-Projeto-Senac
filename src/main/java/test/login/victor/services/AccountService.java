package test.login.victor.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import test.login.victor.dto.AccountNewDTO;
import test.login.victor.entities.Account;
import test.login.victor.entities.Membros;
import test.login.victor.entities.enums.Perfil;
import test.login.victor.repositories.AccountRepository;
import test.login.victor.resources.exceptions.AuthorizationException;
import test.login.victor.security.UserSS;

@Service
public class AccountService {
	
	
	@Autowired
	private AccountRepository ar; 
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public List<Account> findAll(){ 
		return ar.findAll();
	}
	
	
	public Account findById(Integer id) { 
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Account> obj = ar.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Account.class.getName()));
	}
	
	
	public Account findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}
	
		Account obj = ar.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Account.class.getName());
		}
		return obj;
	}
	
	public Account insert(Account obj) { 
		return ar.save(obj);
	}
	
	public Account fromDTO(AccountNewDTO objDto) {
		Account ac = new Account(null, objDto.getNome(), objDto.getEmail(), pe.encode(objDto.getSenha()));
	
		return ac;
	}
	
	
	public void updateData(Account entity, Account obj) { 
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setMembros(obj.getMembros());
		
	}
	
	public Account update(Integer id, Account obj) { 
		Account entity = ar.getOne(id);
		updateData(entity, obj);
		return ar.save(entity);
	}
	
	public Account addMembro(Integer id, Membros obj) { 
		Account entity = ar.getOne(id); 
		entity.getMembros().addAll(Arrays.asList(obj));
		return ar.save(entity);
		
	}
	

}
