package com.api.championship.response;

import java.util.ArrayList;
import java.util.List;

import com.api.championship.model.Player;

public class WinnerResponse {
	
	//It has the winner's data, in form of a list. It contains: the name of the winner and his/her strategy
	private List<String> winner;
	
	public WinnerResponse(){}

	public WinnerResponse(Player player){
		winner = new ArrayList<>();
		winner.add(player.getName());
		winner.add(player.getStrategy());
	}
	
	public List<String> getWinner() {
		return winner;
	}
}
