package hu.alkfejl.pawnwars.service;

import hu.alkfejl.pawnwars.model.Game;
import hu.alkfejl.pawnwars.model.Player;
import hu.alkfejl.pawnwars.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    @Autowired
    GameRepository gameRepository;

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<Game>();
        gameRepository.findAll().forEach(game -> games.add(game));
        return games;
    }
    public Game getPlayerById(int id) {
        return playerRepository.findById(id).get();
    }

    public void saveOrUpdate(Player player) {
        playerRepository.save(player);
    }
}
