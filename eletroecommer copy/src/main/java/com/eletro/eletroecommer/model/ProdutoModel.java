package com.eletro.eletroecommer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_produtos")
public class ProdutoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id ;
	

	@NotNull

	@Size(min = 4, max = 500)
private String nome;


	@NotBlank
	@Size(min = 2, max = 500)
private double preco;

	@NotBlank
private int quantidade;

	@NotBlank
	@Size(min=4,max = 100)
private String marca;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private TipoEletro tipoeletro;
	
 @ManyToOne
 @JsonIgnoreProperties("produto")
 private CategoriaModel categoria;
	

	public CategoriaModel getCategoria() {
	return categoria;
}

public void setCategoria(CategoriaModel categoria) {
	this.categoria = categoria;
}

	public TipoEletro getTipoeletro() {
		return tipoeletro;
	}

	public void setTipoeletro(TipoEletro tipoeletro) {
		this.tipoeletro = tipoeletro;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
