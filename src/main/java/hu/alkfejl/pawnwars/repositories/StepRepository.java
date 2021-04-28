package hu.alkfejl.pawnwars.repositories;
import org.hamcrest.Condition;
import org.springframework.data.repository.CrudRepository;


public interface StepRepository extends CrudRepository<Condition.Step, Integer> {
}
