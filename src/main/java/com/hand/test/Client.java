package com.hand.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.dao.Imp.ConnectionFactory;
import com.hand.entity.Film;
import com.hand.event.CStartEventHandler;
import com.hand.event.CStopEventHandler;
import com.hand.service.FilmService;


public class Client {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmService filmService = (FilmService) ac.getBean("filmService");
		Film film  =(Film)ac.getBean("film");

		Connection conn = ConnectionFactory.getInstance().makeConnection();
		
		((AbstractApplicationContext) ac).start();
		Scanner sc =new Scanner(System.in);
		System.out.println("please input the title");
		String title=sc.next();
		System.out.println("please input the description");
		String description=sc.next();
		System.out.println("please input the Language_ID");
		int language_id=Integer.parseInt(sc.next());	
		film.setTitle(title);		
		film.setDescription(description);
		film.setLanguage_id(language_id);
		
		
		try {
			filmService.addFilm(conn, film);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		((AbstractApplicationContext) ac).stop();

	}

}
