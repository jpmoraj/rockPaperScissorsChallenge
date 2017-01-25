package com.api.championship.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.championship.model.Player;
import com.api.championship.utils.ChampionshipRules;
import com.api.championship.utils.ElementListUtil;
import com.api.championship.utils.StringUtil;

public class Championship {
	private int numberOfDepthLevels;
	private Player firstPlace;
	private Player secondPlace;
	
	@Autowired
	private StringUtil stringUtil;
	
	@Autowired 
	ElementListUtil listUtil;
	
	@Autowired 
	ChampionshipRules championshipRules;
	
	public  void playGame(String championshipData){
		String text = championshipData.replaceAll("[\t\r\n ]", "").trim();
		int depth = stringUtil.getDepth(text);
		numberOfDepthLevels = depth;
		getGeneralWinner(text, depth);
	}
	
	public String[] getGeneralWinner (String textArray, int depth){
		
		String[] winner = null;
		try{
			
			if(depth == 2){
				winner= getWinnerOfTwoElements(textArray.substring(0, textArray.length()));
			}
			else{
				String stringDelim = stringUtil.getTokenToSplit(depth-1);
				int position = textArray.indexOf(stringDelim);
				
				String[] winner1 = getGeneralWinner(textArray.substring(1, position+(depth-1)), depth-1);
				String[] winner2 = getGeneralWinner(textArray.substring(position+depth, textArray.length()-1), depth-1);
				
				winner = getWinnerOfTwoElements(listUtil.getListOfElements(winner1, winner2));
				
				if(depth == numberOfDepthLevels){
					saveFirstAndSecondPlaces(winner1, winner2, winner);
				}
			}
		}
		catch(Exception e){
			System.out.println("An exception ocurred when trying to get the winner");
		}
		return winner;
	}
	
	public String[] getWinnerOfTwoElements(String playersData) throws Exception{
	   
		String winnerData[] = new String[2];
		
		try{
			List<String[]> playersList = listUtil.getPlayersList(playersData);
			String playerIsWinning = "";
			String strategyWinner = "";
			
			for(String[] data: playersList){
				if(championshipRules.validateRules(data, strategyWinner)){
					playerIsWinning = data[0];
					strategyWinner = data[1];
				}
			}
			winnerData[0]= playerIsWinning;
			winnerData[1]= strategyWinner;
		}
		catch(Exception e){
			throw e;
		}
		
		return winnerData;
	}
	
	public void saveFirstAndSecondPlaces(String[] player1, String[] player2, String[] winner){
		if(winner[0].equalsIgnoreCase(player1[0])){
			firstPlace = new Player(player1);
			secondPlace = new Player(player2);
			
			System.out.println("First Place: " + player1[0] + ", strategy: " + player1[1]);
			System.out.println("Second Place: " + player2[0] + ", strategy: " + player2[1]);
		}
		else if(winner[0].equalsIgnoreCase(player2[0])){
			firstPlace = new Player(player2);
			secondPlace = new Player(player1);
			
			System.out.println("First Place: " + player2[0] + ", strategy: " + player2[1]);
			System.out.println("Second Place: " + player1[0] + ", strategy: " + player1[1]);
		}
	}
	
	public Player getFirstPlace() {
		return firstPlace;
	}

	public Player getSecondPlace() {
		return secondPlace;
	}
}
