package hu.alkfejl.pawnwars.service;

import hu.alkfejl.pawnwars.model.Pawn;
import org.springframework.stereotype.Service;

import java.awt.*;
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

    public boolean diagonalValid(String[] input) {
        final Pawn[][] board = PawnWarsService.getBoard();
        return board[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1])+1] == null;
        /*átlósan kell nézni a mezőket. Ha a közvetlen jobb/bal átlón van azonos színű akkor abban az irányban lehetnek jó lépések.
        Ezt kb addig kell ellenőrizni amíg lehetnek lehetséges lépesek az átlókon*/
    }

    public List possibleMoves(String[] input) {
        LinkedList<String> moves = new LinkedList<String>();
        final Pawn[][] board = PawnWarsService.getBoard();
        if (board[Integer.parseInt(input[0]) -1][Integer.parseInt(input[1])] == null) {
            moves.add(String.valueOf(Integer.parseInt(input[0])-1));//előre már tudunk lépni ha minden igaz
        }


    }
}

    /*public boolean validateStep() {
    }*/




