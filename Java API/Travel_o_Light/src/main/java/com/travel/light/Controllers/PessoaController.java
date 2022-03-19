package com.travel.light.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.light.entities.Pessoa;
import com.travel.light.servicies.PessoaService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping
	public List<Pessoa> findAll() {
		return service.findAll();
	}
	
	/*@GetMapping(path = "/{id}")
    public Optional<Pessoa> getId(@PathVariable Long id) {
		return service.findById(id);
	}*/
	//GET BY ID
	@GetMapping(path = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
		Pessoa pessoa = this.service.findById(id);
		return ResponseEntity.ok().body(pessoa);
	}
	//POST
	@PostMapping
	public void CriarPessoa (@RequestBody Pessoa pessoa) {
		service.savePessoa(pessoa);
	}
	
	@DeleteMapping(path = "/{id}")
	public void Delete (@PathVariable Long id) {
		service.Delete(id);
	}
	
	//UPDATE by Name
	/*@PutMapping(path = "/{id}")
	public Pessoa Update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		Pessoa pessoa_atual = service.findById(id).get();
		BeanUtils.copyProperties(pessoa, pessoa_atual, "id");
		return service.Update(pessoa_atual);
	}*/
	
	//Update 2
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> Update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		Pessoa p = service.update(id, pessoa);
		
		return ResponseEntity.ok().body(p);
	}
	
}

