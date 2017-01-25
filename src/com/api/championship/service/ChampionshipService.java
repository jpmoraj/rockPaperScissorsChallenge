package com.api.championship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.championship.dao.ChampionshipDao;
import com.api.championship.logic.Championship;
import com.api.championship.model.Player;
import com.api.championship.response.WinnerResponse;
import com.api.championship.utils.ElementListUtil;

@Service
public class ChampionshipService {
	
	@Autowired 
	Championship championship;
	
	@Autowired 
	ChampionshipDao championshipDao;
	
	@Autowired 
	ElementListUtil listUtil;
	
	public WinnerResponse playGame(String championshipData){
		championship.playGame(championshipData);
		Player winner = championship.getFirstPlace();
		Player secondPlace = championship.getSecondPlace();
		championshipDao.saveFirstAndSecondPlace(winner, secondPlace);
		WinnerResponse response = new WinnerResponse(winner);
		return response;
	}
	
	public List<Player> retrieveTopPlayersList(int numberOfPlayersTop){
		List<Player> listOfTopPlayers = championshipDao.findTopPlayers(numberOfPlayersTop);
		return listOfTopPlayers;
	}
	
	public void deleteAllBDData(){
		championshipDao.deleteAllData();
	}
	
	public void storeFirstAndSecond(String first, String second){
		Player firstPlayer = new Player();
		Player secondPlayer = new Player();
		
		firstPlayer.setName(first);
		secondPlayer.setName(second);
		
		championshipDao.saveFirstAndSecondPlace(firstPlayer, secondPlayer);
	}
}
