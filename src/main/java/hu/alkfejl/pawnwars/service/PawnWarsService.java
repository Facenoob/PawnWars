package hu.alkfejl.pawnwars.service;

import hu.alkfejl.pawnwars.model.Pawn;
import hu.alkfejl.pawnwars.model.Steps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PawnWarsService {
    @Autowired
    private PawnWarsValidator validator;
//    @Autowired
//    private StepService stepService;
    @Autowired
    private PawnWarsStepper stepper;
    private static Pawn[][] board;

    public static Pawn[][] getBoard() {
        return board;
    }

    public Pawn[][] createBoard() {
        board = new Pawn[8][8];
        board[0][1] = new Pawn(false);
        board[0][3] = new Pawn(false);
        board[0][5] = new Pawn(false);
        board[0][7] = new Pawn(false);
        board[1][0] = new Pawn(false);
        board[1][2] = new Pawn(false);
        board[1][4] = new Pawn(false);
        board[1][6] = new Pawn(false);

        board[7][0] = new Pawn(true);
        board[7][2] = new Pawn(true);
        board[7][4] = new Pawn(true);
        board[7][6] = new Pawn(true);
        board[6][1] = new Pawn(true);
        board[6][3] = new Pawn(true);
        board[6][5] = new Pawn(true);
        board[6][7] = new Pawn(true);
        return board;
    }

    public void handleStep(String from, String to) {
        final String[] fromIndex = from.split("-");
        final String[] toIndex = to.split("-");
        final boolean fromIsValid = validator.validateInput(fromIndex);
        final boolean toIsValid = validator.validateInput(toIndex);
        final boolean fromPawn = validator.validatePawn(fromIndex);
        final boolean toPawn = validator.validatePawn(toIndex);
        final boolean jumpValidate = validator.jumpValidate(fromIndex, toIndex);
//        final Steps steps= stepService.stepMaker();
        final int endValidate= validator.endGameValidator();
        if (fromIsValid && toIsValid && fromPawn && !toPawn && jumpValidate) {
            board = stepper.Stepper(fromIndex, toIndex);
        }
        if(endValidate!=0){
            if(endValidate==1){
                System.out.println("Az 1-es játékos nyert.");
            }
            else{
                System.out.println("A 2-es játékos nyert.");
            }

        }

    }
}

