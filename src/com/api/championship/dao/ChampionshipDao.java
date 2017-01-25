package com.api.championship.dao;

import java.util.List;

import com.api.championship.model.Player;

public interface ChampionshipDao {
	//List<Player> findAllPlayers();
	void saveFirstAndSecondPlace(Player winner, Player secondPlace);
	void deleteAllData();
	List<Player> findTopPlayers(int numberOfTopPlayers);
}
