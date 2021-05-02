package hu.alkfejl.pawnwars.service;

import hu.alkfejl.pawnwars.model.Steps;
import hu.alkfejl.pawnwars.repositories.StepRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StepService {
    @Autowired
    StepRepository stepRepository;
    public List<Steps> getAllSteps(){
        List<Steps> steps =new ArrayList<Steps>();
        stepRepository.findAll().forEach(step->steps.add(step));
        return steps;
    }
    public Steps getStepById(int id){return stepRepository.findById(id).get();}
    public void saveOrUpdate(Steps step){stepRepository.save(step);}
    public Steps stepMaker(int game_ID,int playerOne,String step){
        Steps steps= new Steps();
        steps.setGame_ID(game_ID);
        steps.setPlayer_ID(playerOne);
        steps.setStep(step);
        return steps;
    }
}
