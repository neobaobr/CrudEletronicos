package com.eletro.eletroecommer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eletro.eletroecommer.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	public List<ProdutoModel> findAllByNomeContainingIgnoreCase(String nome);
	
	public List<ProdutoModel> findAllByPrecoBetween(double preco1,double preco2);
	
	@Query(value="select* from tb_produtos inner join tb_eletro on tb_produtos.id = tb_eletro.id where tb_eletro.decricao like : descricao% and tb_produtos.preco <= preco ",nativeQuery = true)
	
	public List<ProdutoModel> findAllByPrecoMenor(@Param ("descricao")String descricao,@Param ("preco")double preco);
}
