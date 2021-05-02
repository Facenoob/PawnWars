package hu.alkfejl.pawnwars.repositories;

import hu.alkfejl.pawnwars.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
}
