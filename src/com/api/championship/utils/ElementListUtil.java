package com.api.championship.utils;

import java.util.ArrayList;
import java.util.List;

public class ElementListUtil {
	
	public List<String[]> getPlayersList(String playersData) throws Exception{
		
		List<String[]> list = new ArrayList<>();
		String playersString = playersData.replaceAll("[\"\\[\\]]", "");
		
		String[] playersArray = playersString.split(",");
		
		for(int i = 0; i<playersArray.length; i++){
			String[] player = new String[2];
			player[0]=playersArray[i];
			player[1]=playersArray[++i];
			list.add(player);
		}
		
		if(list.size() != 2){
			throw new Exception("Number of players is not equal to 2");
		}
		
		return list;
	}
	
	public String getListOfElements(String[] player1, String[] player2){
		
		StringBuilder stringBuilder = new StringBuilder();
		
		if(player2!=null){
			stringBuilder.append("[[\"")
					.append(player1[0])
					.append("\",\"")
					.append(player1[1])
					.append("\"],[\"")
					.append(player2[0])
					.append("\",")
					.append(player2[1])
					.append("\"]]");
		
		}
		else{
			stringBuilder.append("[\"")
			.append(player1[0])
			.append("\",\"")
			.append(player1[1])
			.append("\"]");
		}
		
		return stringBuilder.toString();
	}
}
