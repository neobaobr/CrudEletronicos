package com.eletro.eletroecommer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.eletro.eletroecommer.model.ProdutoModel;
import com.eletro.eletroecommer.repository.ProdutoRepository;

@RestController
@RequestMapping("/ProdutoModel")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@GetMapping
	public ResponseEntity<List<ProdutoModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/ProdutoModel/{produtomodel}")
	public ResponseEntity<List<ProdutoModel>> GetByProdutoModel(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));

	}

	@PostMapping
	public ResponseEntity<ProdutoModel> post(@RequestBody ProdutoModel nome) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nome));
	}

	@PutMapping
	public ResponseEntity<ProdutoModel> put(@RequestBody ProdutoModel nome) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(nome));
	}
	
	@GetMapping("/preco/{preco1}/{preco2}")
	public ResponseEntity<List<ProdutoModel>> GetbyPreco (@PathVariable double preco1, double preco2){
		return ResponseEntity.ok(repository.findAllByPrecoBetween(preco1, preco2));
	}
	
	@GetMapping("/prec0/{preco}/{descricao}")
	public ResponseEntity<List<ProdutoModel>> GetbyPreco (@PathVariable String descricao, @PathVariable double preco){
		return ResponseEntity.ok(repository.findAllByPrecoMenor(descricao, preco));
	}
	

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
