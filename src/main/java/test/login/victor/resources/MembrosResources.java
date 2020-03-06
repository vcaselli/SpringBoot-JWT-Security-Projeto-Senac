package test.login.victor.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
