package com.api.championship.response;

import java.util.ArrayList;
import java.util.List;


import com.api.championship.model.Player;

public class TopPlayersListResponse {
	
	private List<String> players;

	
	public TopPlayersListResponse(){}
	
	public TopPlayersListResponse(List<Player> listOfPlayers){
		players = new ArrayList<String>();
		for(Player player: listOfPlayers){
			players.add(player.getName());
		}
	}
	
	public List<String> getPlayers() {
		return players;
	}

	public void setPlayers(List<String> players) {
		this.players = players;
	}
}
