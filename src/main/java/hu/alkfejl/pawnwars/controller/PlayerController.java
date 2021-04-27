package hu.alkfejl.pawnwars.controller;

import java.util.List;

import hu.alkfejl.pawnwars.model.Player;
import hu.alkfejl.pawnwars.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//creating RestController
@RestController
public class PlayerController {
    //autowired the StudentService class
    @Autowired
    PlayerService playerService;

    //creating a get mapping that retrieves all the students detail from the database
    @GetMapping("/player")
    private List<Player> getAllStudent() {
        return playerService.getAllStudent();
    }

    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/player/{id}")
    private Player getStudent(@PathVariable("id") int id) {
        return playerService.getStudentById(id);
    }

    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/player/{id}")
    private void deleteStudent(@PathVariable("id") int id) {
        playerService.delete(id);
    }

    //creating post mapping that post the student detail in the database
    @PostMapping("/player")
    private int saveStudent(@RequestBody Player player) {
        playerService.saveOrUpdate(player);
        return player.getId();
    }
}