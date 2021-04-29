package hu.alkfejl.pawnwars.controller;

import hu.alkfejl.pawnwars.model.Game;
import hu.alkfejl.pawnwars.model.Player;
import hu.alkfejl.pawnwars.service.GameService;
import hu.alkfejl.pawnwars.service.PawnWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class GameController {
    @Autowired
    private PawnWarsService pawnWarsService;
    @Autowired
    private GameService gameService;

    @GetMapping(value = "/board")
    public String board(Model model) {
        model.addAttribute("board", PawnWarsService.getBoard());
        return "board";
    }
    @GetMapping("/games")
    private List<Game> getAllGames() {
        return gameService.getAllGames();
    }
    @GetMapping("/game/{id}")
    private Game getGame(@PathVariable("id") int id) {
        return gameService.getGameById(id);
    }
    @DeleteMapping("/game/{id}")
    private void deleteGame(@PathVariable("id") int id) {gameService.delete(id);
    }
    @PostMapping(value = "/game")
    private String saveGame(int player1,int player2, Model model) {
        gameService.saveOrUpdate(gameService.handlePlayer(player1,player2));
        model.addAttribute("board", pawnWarsService.createBoard());
        return "board";
    }
}
