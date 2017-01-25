package com.api.championship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.championship.model.Player;
import com.api.championship.response.TopPlayersListResponse;
import com.api.championship.response.WinnerResponse;
import com.api.championship.service.ChampionshipService;
 
@RestController
public class ChampionshipRestController {
 
	@Autowired
	private ChampionshipService service;
	
	@RequestMapping(value="/championship/result", method=RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void storeFirstSecondPlace(@RequestParam (value = "first") String first, @RequestParam (value = "second") String second){
		service.storeFirstAndSecond(first, second);
	}
	
	@RequestMapping(value="/championship/top", method=RequestMethod.GET)
	public TopPlayersListResponse retrieveTopPlayersList(@RequestParam (value = "count", defaultValue = "10") int numberOfTopPlayers){
		List<Player> topListOfPlayers = service.retrieveTopPlayersList(numberOfTopPlayers);
		TopPlayersListResponse response = new TopPlayersListResponse(topListOfPlayers);
		return response;
	}
	
	@RequestMapping(value="/championship/new", method=RequestMethod.POST, headers="Accept=application/json")
	public WinnerResponse newChampionship(@RequestBody String championshipData){
		WinnerResponse response = service.playGame(championshipData);
		return response;
	}
}