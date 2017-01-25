package com.api.championship.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.api.championship.response.TopPlayersListResponse;
import com.api.championship.response.WinnerResponse;
import com.api.championship.service.ChampionshipService;

@Controller
public class ChampionshipUIController {
	
	@Autowired
	private ChampionshipService service;
	
	
	@RequestMapping (value = "/listTopPlayers", method=RequestMethod.GET)
	public ModelAndView listTopPlayers(){
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/championship/top";
		TopPlayersListResponse topList = restTemplate.getForObject(url, TopPlayersListResponse.class);
		return new ModelAndView("listTopPlayers", "topList", topList);
	}
	
	@RequestMapping(value="/deleteAllBDDataUI", method=RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteAllBDData(){
		service.deleteAllBDData();
	}
	
	@RequestMapping (value = "/uploadFile", method=RequestMethod.POST)
	ModelAndView uploadFile(@RequestParam("file") MultipartFile file){
		if(!file.isEmpty()){
			try{
				ByteArrayInputStream stream = new   ByteArrayInputStream(file.getBytes());
				String fileContent = IOUtils.toString(stream, "UTF-8");
				
				if(fileContent != null && !fileContent.isEmpty()){
					RestTemplate restTemplate = new RestTemplate();
					String text = fileContent.replaceAll("[\t ]", "").trim();
					String url = "http://localhost:8080/api/championship/new";
					WinnerResponse response = restTemplate.postForObject(url, text, WinnerResponse.class);
					return new ModelAndView("rockPaperScissors", "winnerData", response);
				}
				else{
					return returnEmptyResult();
				}
			}
			catch(IOException e){
				return returnEmptyResult();
			}
			
		}
		return returnEmptyResult();
	}
	
	public ModelAndView returnEmptyResult(){
		return new ModelAndView("redirect:/rockPaperScissors", "winner", null);
	}
	
	
	
}
