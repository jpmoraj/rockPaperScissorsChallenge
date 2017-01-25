package com.api.championship.mapper;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import com.api.championship.model.Player;

public class PlayerMapper implements RowMapper<Player> {
	public Player mapRow(ResultSet rs, int rowNum){
		Player player = new Player();
		
		try{
			player.setName(rs.getString("PLAYER_NAME"));
			player.setPoints(rs.getString("POINTS"));
		}
		catch(Exception e){
			
		}
		return player;
	}
}
