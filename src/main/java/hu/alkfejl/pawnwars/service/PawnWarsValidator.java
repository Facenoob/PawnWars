package hu.alkfejl.pawnwars.service;

import hu.alkfejl.pawnwars.model.Pawn;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.LinkedList;

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

    public boolean validateNoPawn(String[] input) {
        final Pawn[][] board = PawnWarsService.getBoard();
        return board[Integer.parseInt(input[2])][Integer.parseInt(input[3])] == null;
    }
    //ez a rész ami nekem feladta leckét de nagyon
    public boolean diagonalValid(String[] input) {
        final Pawn[][] board = PawnWarsService.getBoard();
        int index = 0;
        for (int i = Integer.parseInt(input[0]) - 1; i > 0; i--) {

        }
    }

    public LinkedList<String> possibleMoves(String[] input) {
        LinkedList<String> moves = new LinkedList<String>();
        final Pawn[][] board = PawnWarsService.getBoard();
        if (board[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1])] == null) {
            moves.add(String.valueOf(Integer.parseInt(input[0]) - 1));//előre már tudunk lépni ha minden igaz
        }
        return moves;

    }

    public boolean validateStep(String[] input, LinkedList moves) {
        return moves.contains(input);
    }

    public Pawn[][] Stepper(String[] fromInput, String[] toInput) {
        final Pawn[][] board = PawnWarsService.getBoard();
        board[Integer.parseInt(toInput[0])][Integer.parseInt(toInput[1])] = board[Integer.parseInt(fromInput[0])][Integer.parseInt(fromInput[1])];
        board[Integer.parseInt(fromInput[0])][Integer.parseInt(fromInput[1])] = null;
        return board;
    }
}






