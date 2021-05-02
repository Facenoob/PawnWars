package hu.alkfejl.pawnwars.controller;

import hu.alkfejl.pawnwars.model.Player;
import hu.alkfejl.pawnwars.model.Steps;
import hu.alkfejl.pawnwars.service.PawnWarsService;
import hu.alkfejl.pawnwars.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StepController {
    @Autowired
    StepService stepService;
    @Autowired
    PawnWarsService pawnWarsService;

    //creating a get mapping that retrieves all the students detail from the database
    @GetMapping("/steps")
    private List<Steps> getAllSteps() {
        return stepService.getAllSteps();
    }
    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/step/{id}")
    private Steps getStepById(@PathVariable("id") int id) {
        return stepService.getStepById(id);
    }
}
