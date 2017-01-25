package com.api.championship.utils;

public class StringUtil {
	/**
	 * This method finds out the depth for a string which is containing a tournament
	 * @return
	 */
	public int getDepth(String tournament){
		int depthCounter = 0;
		
		if(tournament == null || tournament.isEmpty()){
			return 0;
		}
		char charValue = tournament.charAt(0);
		while(charValue == '['){
			depthCounter++;
			charValue = tournament.charAt(depthCounter);
		}
		return depthCounter;
	}
	
	
	/**
	 * This method gets a string used to split the original string containing a tournament, in two pieces,
	 * for its recursive management.
	 * @param closedBracketsNumber
	 * @return
	 */
	public String getTokenToSplit(int closedBracketsNumber){
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < closedBracketsNumber; i++){
			stringBuilder.append("]");
		}
		return stringBuilder.toString();
	}
	
	
	public void printGameResults(String[] winner, String[] player1, String[] player2){
		if(winner[0].equalsIgnoreCase(player1[0])){
			System.out.println("First Place: " + player1[0] + ", strategy: " + player1[1]);
			System.out.println("Second Place: " + player2[0] + ", strategy: " + player2[1]);
		}
		else if(winner[0].equalsIgnoreCase(player2[0])){
			System.out.println("First Place: " + player2[0] + ", strategy: " + player2[1]);
			System.out.println("Second Place: " + player1[0] + ", strategy: " + player1[1]);
		}
	}
}
