package hu.alkfejl.pawnwars.service;

import hu.alkfejl.pawnwars.model.Pawn;
import org.springframework.stereotype.Service;

@Service
public class PawnWarsValidator {
    public boolean validateInput(String[] input) {
        for (String value : input) {
            if (Integer.parseInt(value) < 0 && Integer.parseInt(value) >= 8) {
                return false;
            }
        }
        return true;
    }

    public boolean validatePawn(String[] input) {
        final Pawn[][] board = PawnWarsService.getBoard();
        return board[Integer.parseInt(input[0])][Integer.parseInt(input[1])] != null;
    }

    public boolean validateStep() {
    }

}


