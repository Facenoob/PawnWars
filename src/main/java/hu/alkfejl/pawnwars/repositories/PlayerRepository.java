package hu.alkfejl.pawnwars.repositories;

import hu.alkfejl.pawnwars.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
}