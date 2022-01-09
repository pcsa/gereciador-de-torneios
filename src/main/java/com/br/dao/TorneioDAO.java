package com.br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.br.model.Torneio;
import com.br.utils.ConnectionFactory;

public class TorneioDAO {
	
	private Connection conn;
	
	public TorneioDAO() {
		ConnectionFactory cf = new ConnectionFactory();
		this.conn = cf.getConnection();
	}
	
	public void fechar() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void adiciona(Torneio Torneio) {
		
		//1. string de inserção
		
		String sql = "insert into torneios" +
					"(title,times)" +
					"values(?,?)";
		
		try {
			//2. preparar a senteça
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			//3. passar dados que estão no objeto TorneioBean
			
			stmt.setString(1, Torneio.getTitle());
			stmt.setString(2, Torneio.getTimes().toString());
			
			//4. executar a setença
			stmt.execute();
			stmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Torneio> getTorneios(){
		
		String sql = "select * from torneios";
		
		try {
			
			ArrayList<Torneio> Torneios = 
					new ArrayList<Torneio>();
			
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Torneio Torneio = new Torneio();
				Torneio.setId(rs.getInt("id"));
				Torneio.setTitle(rs.getString("title"));
				Torneio.setTimes(rs.getString("times"));
				Torneios.add(Torneio);
				
			}
			
			rs.close();
			stmt.close();
			
			return Torneios;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
		
		
	}
	
	public Torneio getTorneio(int id) {
		
		String sql = "select * from torneios where id = ?";
		
		try {
			
			Torneio Torneio = new Torneio();
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {	
				Torneio.setId(rs.getInt("id"));
				Torneio.setTitle(rs.getString("title"));
				Torneio.setTimes(rs.getString("times"));
			}
			
			rs.close();
			stmt.close();
			return Torneio;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	public void atualiza(Torneio Torneio) {
		
		String sql = "update torneios set title=?, times=? "+
		"where id=?";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			
			stmt.setString(1, Torneio.getTitle());
			stmt.setString(2, Torneio.getTimes().toString());
			
			stmt.setInt(3, Torneio.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	
	public void remove(Torneio Torneio) {
		
		String sql = "delete from torneios where id=?";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			
			stmt.setInt(1, Torneio.getId());
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	public Torneio getTorneioPeloTitle(String title) {
		
		String sql = "select * from Torneios where title = ?";
		Torneio Torneio = null;
		
		try {
			
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, title);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Torneio = new Torneio();
				
				Torneio.setId(rs.getInt("id"));
				Torneio.setTitle(rs.getString("title"));
				Torneio.setTimes(rs.getString("times"));
			}
			
			rs.close();
			stmt.close();
			
			return Torneio;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}
	
	

}