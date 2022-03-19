package com.travel.light.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.travel.light.entities.Pessoa;
import com.travel.light.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository Pessoa_repository;
	
	//POST
	public void savePessoa(Pessoa pessoa) {	
		Pessoa_repository.save(pessoa);
	}
	
	//GET BY ID
	/*public Optional<Pessoa> findById(Long Id) {
		return Pessoa_repository.findById(Id);
	}*/
	
	public Pessoa findById(Long Id) {
		Optional<Pessoa> pessoa = Pessoa_repository.findById(Id);
		return pessoa.get();
	}
	
	//GET ALL
	public List<Pessoa> findAll(){
		List<Pessoa> result = Pessoa_repository.findAll();
		return result;
	}
	
	//PUT = UPDATE
	/*public Pessoa Update(Pessoa pessoa) {
		return Pessoa_repository.save(pessoa);
	}*/
	
	
	//PUT = UPDATE
	public Pessoa update(Long id, Pessoa pessoa) {
		Pessoa novaPessoa = findById(id);
		novaPessoa.setNome(pessoa.getNome());
		novaPessoa.setSobrenome(pessoa.getSobrenome());
		novaPessoa.setEmail(pessoa.getEmail());
		novaPessoa.setSenha(pessoa.getSenha());
		novaPessoa.setOrigem(pessoa.getOrigem());
		novaPessoa.setDestino(pessoa.getDestino());

		return Pessoa_repository.save(novaPessoa);
	}
	
	//DELETE POR ID
	public void Delete(Long Id) {

		Optional<Pessoa> pessoa = Pessoa_repository.findById(Id);
		if(pessoa.isPresent()) {
			Pessoa_repository.delete(pessoa.get());
		}
		else {
			System.out.println("Failed to delete user.");
		}
	}
}
