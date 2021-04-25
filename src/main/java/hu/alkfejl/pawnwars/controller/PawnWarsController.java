package hu.alkfejl.pawnwars.controller;

import hu.alkfejl.pawnwars.service.PawnWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PawnWarsController {
    @Autowired
    private PawnWarsService pawnWarsService;


    @PostMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("board", pawnWarsService.createBoard());
        return "board";
    }

    @PostMapping(value = "/step")
    public String step(String from, String to,Model model) {
        pawnWarsService.handleStep(from, to);
        model.addAttribute("board", PawnWarsService.getBoard());
        return "board";
    }

    @GetMapping(value = "/board")
    public String board(Model model) {
        model.addAttribute("board", PawnWarsService.getBoard());
        return "board";
    }


}
