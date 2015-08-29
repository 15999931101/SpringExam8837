package com.hand.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hand.entity.Film;

public class FilmServiceImpl implements FilmService{

public void addFilm(Connection conn, Film film) throws SQLException {
		
		
		
		String rental_duration="6";
		String rental_rate="1.00";
		String replacement_cost="20.00";
		String last_update="2015-8-16 ";
		
		String insertSql = "insert into film(title,description,language_id,"
				+ "rental_duration,rental_rate,replacement_cost,last_update) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(insertSql);	
		
		ps.setString(1, film.getTitle());
		ps.setString(2, film.getDescription());
		ps.setLong(3, film.getLanguage_id());	
		ps.setString(4, rental_duration);
		ps.setString(5, rental_rate);
		ps.setString(6, replacement_cost);	
		ps.setString(7, last_update);			
		ps.execute();
//		System.out.println("添加成功");
		
	}

}
