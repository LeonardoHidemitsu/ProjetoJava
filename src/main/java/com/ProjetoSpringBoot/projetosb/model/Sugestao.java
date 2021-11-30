package com.ProjetoSpringBoot.projetosb.model;

public class Sugestao {
	private int id;
	private String nome, sinopse;
	
	public Sugestao() {
		
	}
	
	public Sugestao(int id, String nome, String sinopse) {
		this.id = id;
		this.nome = nome;
		this.sinopse = sinopse;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSinopse() {
		return sinopse;
	}
	
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
}