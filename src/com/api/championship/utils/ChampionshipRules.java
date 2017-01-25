package com.api.championship.utils;

public class ChampionshipRules {
	
	public boolean validateRules(String[] data, String strategyWinner){
		if(strategyWinner.equals("")){
			return true;
		}
		
		if(strategyWinner.equalsIgnoreCase("R") && data[1].equalsIgnoreCase("P")){
			return true;
		}
		
		if(strategyWinner.equalsIgnoreCase("P") && data[1].equalsIgnoreCase("S")){
			return true;
		}
		
		if(strategyWinner.equalsIgnoreCase("S") && data[1].equalsIgnoreCase("R")){
			return true;
		}
		return false;
	}
}
