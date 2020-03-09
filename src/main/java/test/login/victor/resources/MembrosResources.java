package test.login.victor.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import test.login.victor.entities.Membros;
import test.login.victor.services.MembrosService;

@RestController
@RequestMapping("/membros")
public class MembrosResources {
	
	
	@Autowired
	MembrosService service;
	
	@GetMapping
	public ResponseEntity<List<Membros>> findAll(){
		List<Membros> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Membros> findById(@PathVariable Long id){ 
		Membros obj = service.findById(id); 
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Membros> insert(@RequestBody Membros m){ 
		Membros membros = service.insert(m);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(membros.getId()).toUri();
		return ResponseEntity.created(uri).body(membros);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@PathVariable Long id){ 
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
