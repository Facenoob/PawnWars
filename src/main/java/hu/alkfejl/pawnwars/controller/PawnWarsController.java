package hu.alkfejl.pawnwars.controller;
import hu.alkfejl.pawnwars.service.PawnWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PawnWarsController {
    @Autowired
    private PawnWarsService pawnWarsService;


    @GetMapping(value = "/board")
    public String board(Model model) {
        model.addAttribute("board", pawnWarsService.createBoard());
        return "board";
    }

    @PatchMapping(value ="/step")
    public void step(String from,String to){
        pawnWarsService.handleStep(from,to);

    }


}
