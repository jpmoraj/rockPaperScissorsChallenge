package com.api.championship.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import com.api.championship.constants.*;
import com.api.championship.mapper.PlayerMapper;
import com.api.championship.model.Player;

public class ChampionshipDaoImpl implements ChampionshipDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void saveFirstAndSecondPlace(Player winner, Player secondPlace) {
		updateOrInsertPlayerData(winner, 3);
		updateOrInsertPlayerData(secondPlace, 1);
	}
	
	public void updateOrInsertPlayerData(Player player, int points){
		
		Player result = null;
		
		try{
			result = jdbcTemplate.queryForObject(Constants.SQL_FIND_PLAYER_BY_NAME, new PlayerMapper(),
					new Object[]{player.getName()});
		}
		catch(EmptyResultDataAccessException empty){
			result = null;
		}
		
		if(result == null){
			jdbcTemplate
	        .update(Constants.SQL_NEW_PLAYER,
	                new Object[] {player.getName(), points});
		}
		else{
			
			int newPointsData = points + Integer.parseInt(result.getPoints());
			
			jdbcTemplate
	        .update(Constants.SQL_UPDATE_PLAYER,
	                new Object[] {String.valueOf(newPointsData), player.getName()});
		}
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		jdbcTemplate
        .update(Constants.SQL_DELETE_ALL);
	}
	
	@Override
    public List<Player> findTopPlayers(int numberOfTopPlayers) {
        jdbcTemplate.setMaxRows(numberOfTopPlayers);
        List<Player> players = jdbcTemplate.query(Constants.SQL_FIND_ALL_PLAYERS,
                new PlayerMapper());
        return players;
        
    }

}
