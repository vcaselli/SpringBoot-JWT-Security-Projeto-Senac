package test.login.victor.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import test.login.victor.entities.Membros;
import test.login.victor.entities.Tarefas;
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
	
	@PostMapping("/account/{id}")
	public ResponseEntity<Membros> insert(@PathVariable Integer id, @RequestBody Membros m, String email){ 
		Membros membros = service.insert(m, id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(membros.getId()).toUri();
		return ResponseEntity.created(uri).body(membros);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){ 
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Membros> update(@PathVariable Long id, @RequestBody Membros obj){ 
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping("points/{id}")
	public ResponseEntity<Membros> updatePoints(@PathVariable Long id, @RequestBody Tarefas obj){ 
		Membros entity = service.updatePoints(id, obj);
		return ResponseEntity.ok().body(entity);
	}

}
