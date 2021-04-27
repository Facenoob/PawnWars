package hu.alkfejl.pawnwars.service;

import java.util.ArrayList;
import java.util.List;

import hu.alkfejl.pawnwars.model.Player;
import hu.alkfejl.pawnwars.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    //getting all student records
    public List<Player> getAllStudent() {
        List<Player> players = new ArrayList<Player>();
        playerRepository.findAll().forEach(student -> players.add(student));
        return players;
    }

    //getting a specific record
    public Player getStudentById(int id) {
        return playerRepository.findById(id).get();
    }

    public void saveOrUpdate(Player student) {
        playerRepository.save(student);
    }

    //deleting a specific record
    public void delete(int id) {
        playerRepository.deleteById(id);
    }
}