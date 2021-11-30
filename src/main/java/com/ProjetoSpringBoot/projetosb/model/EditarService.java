package com.ProjetoSpringBoot.projetosb.model;

import java.util.List;   
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditarService {
	
	@Autowired
	EditarDAO edao;
	
	public void listarSugestao(Editar e) {
		edao.listarSugestao(e);
	}
	
	public Map<String,Object> getSugestao(int id) {
		return edao.getSugestao(id);
	}
	
	public List<Map<String, Object>> getSugestao(){
		return edao.getSugestao();
	}
	
	public void deletarSugestao(int id) {
		edao.deletarSugestao(id);
	}
	
	public void atualizarSugestao(int id, Editar e){
		edao.atualizarSugestao(id, e);
	}
}