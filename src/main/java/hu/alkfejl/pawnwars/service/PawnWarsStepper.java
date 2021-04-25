package hu.alkfejl.pawnwars.service;

import hu.alkfejl.pawnwars.model.Pawn;
import org.springframework.stereotype.Service;

@Service
public class PawnWarsStepper {
    public Pawn[][] Stepper(String[] fromInput, String[] toInput) {
        final Pawn[][] board = PawnWarsService.getBoard();
        board[Integer.parseInt(toInput[0])][Integer.parseInt(toInput[1])] = board[Integer.parseInt(fromInput[0])][Integer.parseInt(fromInput[1])];
        board[Integer.parseInt(fromInput[0])][Integer.parseInt(fromInput[1])] = null;
        return board;
    }
}
