package me.dio.gameawards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import me.dio.gameawards.service.GameService;

@RestController
public class GameRestController {

	@Autowired
	private GameService businessLayer;
}
