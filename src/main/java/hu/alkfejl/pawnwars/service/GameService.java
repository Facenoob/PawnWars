package hu.alkfejl.pawnwars.service;

import hu.alkfejl.pawnwars.model.Game;
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
    public Game getGameById(int id) {
        return gameRepository.findById(id).get();
    }

    public void saveOrUpdate(Game game) {
        gameRepository.save(game);
    }
    public void delete(int id) {
        gameRepository.deleteById(id);
    }
    public Game handleGame(int game_ID,int playerOne,int playerTwo){
        Game match= new Game();
        match.setMatch_ID(game_ID);
        match.setPlayerOne_ID(playerOne);
        match.setPlayerTwo_ID(playerTwo);
        return match;
    }
}
