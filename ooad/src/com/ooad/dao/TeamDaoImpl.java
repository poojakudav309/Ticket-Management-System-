package com.ooad.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ooad.models.Team;
import db.DbManager;


public class TeamDaoImpl implements TeamDao {


	public List<Team> getAllTeams() {
		System.out.println("In get all teams");
		List<Team> team_list=new ArrayList<Team>(); 
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();
		try{
			conn = db.getConnection();
			System.out.println("In get all teams before select");
			ps =conn.prepareStatement("select * from teams");
			System.out.println("In get all teams after select");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println("In while");
				int i=rs.getInt("team_id");
				String name=rs.getString("name");
				Team t=new Team();
				t.setId(i);
				t.setName(name);
				team_list.add(t);
			}
			System.out.println("after list creation");
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
	
		return team_list;
	}

}
