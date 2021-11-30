package com.ProjetoSpringBoot.projetosb.model;

import java.util.List;  
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SugestaoService {
	
	@Autowired
	SugestaoDAO sdao;
	
	public void inserirSugestao(Sugestao s) {
		sdao.inserirSugestao(s);
	}
	
	public Map<String,Object> getSugestao(int id) {
		return sdao.getSugestao(id);
	}
	
	public List<Map< String,Object>> getSugestao(){
		return sdao.getSugestao();
	}
	
	public void deletarSugestao(int id) {
		sdao.deletarSugestao(id);
	}
	
	public void atualizarSugestao(int id, Sugestao s){
		sdao.atualizarSugestao(id, s);
	}
}