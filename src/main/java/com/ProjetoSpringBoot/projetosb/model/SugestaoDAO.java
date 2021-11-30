package com.ProjetoSpringBoot.projetosb.model;

import java.util.List;  
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SugestaoDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirSugestao(Sugestao sugestao) {
		String sql = "INSERT INTO sugestao(nome, sinopse)" + "VALUES(?,?)";
		
		Object[] obj = new Object[2];
		
		obj[0] = sugestao.getNome();
		obj[1] = sugestao.getSinopse();
		
		jdbc.update(sql,obj);
	}
	
	public Map<String,Object> getSugestao(int id) {
		String sql = "SELECT * FROM sugestao WHERE sugestao.id = ?";
		Object obj[] = new Object[1];
		obj[0] = id;
		
		return jdbc.queryForMap(sql,obj);
	}
	
	public List<Map<String,Object>> getSugestao() {
		String sql = "SELECT * FROM sugestao";
		List <Map<String,Object>> sugestoes = (List<Map<String,Object>>)
		jdbc.queryForList(sql);
		return sugestoes;
	}
	
	public void deletarSugestao(int id) {
		String sql = "DELETE FROM sugestao WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql,obj);
	}
	
	public void atualizarSugestao(int id, Sugestao sugestao) {
		String sql = "UPDATE sugestao"
						+ "SET nome = ?, sinopse = ?"
						+ "WHERE id = ?";
		Object[] obj = new Object[3];
		
		obj[0] = sugestao.getNome();
		obj[1] = sugestao.getSinopse();
		
		obj[2] = sugestao.getId();
		jdbc.update(sql,obj);
	}
}