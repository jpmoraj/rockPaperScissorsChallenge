package com.api.championship.constants;

public class Constants {
	public static final String SQL_FIND_PLAYER_BY_NAME = "SELECT * FROM PLAYERS WHERE PLAYER_NAME= ?";
	public static final String SQL_NEW_PLAYER = "INSERT INTO PLAYERS(PLAYER_NAME,POINTS) VALUES(?,?)";
	public static final String SQL_UPDATE_PLAYER = "UPDATE PLAYERS SET POINTS = ? WHERE PLAYER_NAME = ?";
	public static final String SQL_DELETE_ALL = "DELETE FROM PLAYERS";
	public static final String SQL_FIND_ALL_PLAYERS = "SELECT * FROM PLAYERS";
	public static final String SQL_FIND_TOP_PLAYERS = "SELECT TOP 10 FROM PLAYERS ORDER BY POINTS"; 
}
