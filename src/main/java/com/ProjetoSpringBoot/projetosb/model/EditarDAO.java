package com.ProjetoSpringBoot.projetosb.model;

import java.util.List;  
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EditarDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirSugeridos(Editar editar) {
		String sql = "INSERT INTO sugestao(nome, sinopse)" + "VALUES(?,?)";
		
		Object[] obj = new Object[2];
		
		obj[0] = editar.getNome();
		obj[1] = editar.getSinopse();
		
		jdbc.update(sql,obj);
	}
	
	public Map<String,Object> getSugeridos(int id) {
		String sql = "SELECT * FROM sugeridos WHERE sugeridos.id = ?";
		Object obj[] = new Object[1];
		obj[0] = id;
		
		return jdbc.queryForMap(sql,obj);
	}
	
	public List<Map<String,Object>> getSugeridos() {
		String sql = "SELECT * FROM sugeridos";
		List <Map<String,Object>> sugeridos = (List<Map<String,Object>>)
		jdbc.queryForList(sql);
		return sugeridos;
	}
	
	public void deletarSugeridos(int id) {
		String sql = "DELETE FROM sugeridos WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql,obj);
	}
	
	public void atualizarSugeridos(int id, Editar editar) {
		String sql = "UPDATE sugeridos"
						+ "SET nome = ?, sinopse = ?"
						+ "WHERE id = ?";
		Object[] obj = new Object[3];
		
		obj[0] = editar.getNome();
		obj[1] = editar.getSinopse();
		
		obj[2] = editar.getId();
		jdbc.update(sql,obj);
	}
}