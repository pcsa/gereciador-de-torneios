package com.br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.model.User;
import com.br.utils.ConnectionFactory;


public class UserDAO {
	
	private Connection connection;
	
	public UserDAO() {
		ConnectionFactory cf = new ConnectionFactory();
		this.connection = cf.getConnection();
	}
	
	public void close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(User user) {
		
		String sql = "insert into users" +
					"(name,email,password)" +
					"values(?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User getUserByEmail(String email) {
		
		String sql = "select * from users where email = ?";
		
		try {
			
			User user = new User();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
			}
			
			rs.close();
			stmt.close();
			return user;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public User checkLogin(String email, String password) throws SQLException {
		String sql = "SELECT * FROM users WHERE email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        User user = null;
 
        if (result.next()) {
            user = new User();
            user.setName(result.getString("name"));
            user.setEmail(email);
        }
        this.close();
        return user;
	}
}
