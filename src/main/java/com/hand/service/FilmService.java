package com.hand.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.hand.entity.Film;

public interface FilmService {
	
	//添加用户
	public void addFilm(Connection conn,Film film) throws SQLException;

}
