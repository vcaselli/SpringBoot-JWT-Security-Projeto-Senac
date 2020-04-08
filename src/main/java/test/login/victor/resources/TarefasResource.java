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

import test.login.victor.entities.Tarefas;
import test.login.victor.services.TarefasService;

@RestController
@RequestMapping("/tarefas")
public class TarefasResource {
	
	
	@Autowired
	TarefasService service; 
	
	
	
	@GetMapping
	public ResponseEntity<List<Tarefas>> findAll(){ 
		List<Tarefas> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefas> findById(@PathVariable Long id){ 
		Tarefas obj = service.findById(id); 
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/membros/{id}")
	public ResponseEntity<Tarefas> insert(@RequestBody Tarefas obj, @PathVariable Long id){ 
		Tarefas t = service.insert(obj, id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(t.getId()).toUri();
		return ResponseEntity.created(uri).body(t);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){ 
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tarefas> update(@PathVariable Long id, @RequestBody Tarefas obj){ 
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	

}
