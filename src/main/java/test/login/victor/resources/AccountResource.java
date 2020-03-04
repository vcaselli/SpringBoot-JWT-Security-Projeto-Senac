package test.login.victor.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import test.login.victor.dto.AccountNewDTO;
import test.login.victor.entities.Account;
import test.login.victor.services.AccountService;

@RestController
@RequestMapping("/account")
public class AccountResource {
	
	@Autowired
	AccountService service;
	
	//recurso que chama todos as contas
	//isso server para autorizar alguns tipos de contas em end-points especificos
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<Account>> findAll(){ 
		List<Account> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> findById(@PathVariable Integer id){
		Account obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Account> insert(@RequestBody AccountNewDTO obj){ 
		Account account = service.fromDTO(obj);
		account = service.insert(account);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(account.getId()).toUri();
		return ResponseEntity.created(uri).body(account);
	}
	
	

}
