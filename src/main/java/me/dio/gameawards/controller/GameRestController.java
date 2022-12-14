package me.dio.gameawards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.dio.gameawards.controller.games.BaseRestController;
import me.dio.gameawards.domain.model.Game;
import me.dio.gameawards.service.GameService;

@RestController
public class GameRestController extends BaseRestController{

	@Autowired
	private GameService businessLayer;
	
	@GetMapping("games")
	public ResponseEntity<List<Game>>findAll(){
		List<Game> games = businessLayer.findAll();
		return ResponseEntity.ok(games);
	}
	
	@GetMapping("games/{id}")
	public ResponseEntity<Game> findById(@PathVariable Long id){
		Game game = businessLayer.findById(id);
		return ResponseEntity.ok(game);
	}
	
	@PostMapping("games")
	public ResponseEntity<Game> insert(@RequestBody Game game){
		businessLayer.insert(game);
		return ResponseEntity.ok(game);
	}
	
	@PutMapping("games/{id}")
	public ResponseEntity<Game> update(@PathVariable Long id,@RequestBody Game game){
		businessLayer.update(id,game);
		return ResponseEntity.ok(game);
	}
	
	@DeleteMapping("games")
	public ResponseEntity<Game> delete(@PathVariable Long id){
		businessLayer.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PatchMapping("games/{id}/votes")
	public ResponseEntity<Game> update(@PathVariable Long id){
		businessLayer.vote(id);
		return ResponseEntity.ok().build();
	}
}
