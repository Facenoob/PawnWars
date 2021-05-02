package hu.alkfejl.pawnwars.repositories;

import hu.alkfejl.pawnwars.model.Steps;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends CrudRepository<Steps, Integer> {
}
