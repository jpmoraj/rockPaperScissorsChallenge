package com.api.championship.model;

public class Player {
	private String name;
	
	private String strategy;
	
	private String points;
	
	public Player(){
		
	}

	public Player(String[] data){
		name = data[0];
		strategy = data[1];
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}	
	
	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}
}
