package com.eletro.eletroecommer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.eletro.eletroecommer.model.TipoEletro;

public interface TipoEletroRepository extends JpaRepository<TipoEletro, Long>{
	public List<TipoEletro> findAllByDescricaoContainingIgnoreCase(String descricao);
}
