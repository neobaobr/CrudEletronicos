package com.eletro.eletroecommer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eletro.eletroecommer.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	public List<ProdutoModel> findAllByNomeContainingIgnoreCase(String nome);
}
