package hu.alkfejl.pawnwars.controller;

import java.util.List;

import hu.alkfejl.pawnwars.model.Player;
import hu.alkfejl.pawnwars.service.PawnWarsService;
import hu.alkfejl.pawnwars.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//creating RestController
@RestController
public class PlayerController {
    //autowired the StudentService class
    @Autowired
    PlayerService playerService;
    @Autowired
    PawnWarsService pawnWarsService;

    //creating a get mapping that retrieves all the students detail from the database
    @GetMapping("/players")
    private List<Player> getAllPlayer() {
        return playerService.getAllPlayer();
    }

    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/player/{id}")
    private Player getPlayer(@PathVariable("id") int id) {
        return playerService.getPlayerById(id);
    }

    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/player/{id}")
    private void deletePlayer(@PathVariable("id") int id) {
        playerService.delete(id);
    }

    //creating post mapping that post the student detail in the database
    @PostMapping(value = "/player")
    private String savePlayer(String player1,String player2, Model model) {
        playerService.saveOrUpdate(playerService.handlePlayer(player1));
        playerService.saveOrUpdate(playerService.handlePlayer(player2));
        model.addAttribute("board", pawnWarsService.createBoard());
        return "board";
    }
}