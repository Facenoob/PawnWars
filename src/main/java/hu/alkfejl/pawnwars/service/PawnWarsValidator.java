package hu.alkfejl.pawnwars.service;

import hu.alkfejl.pawnwars.model.Pawn;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PawnWarsValidator {

    public boolean validateInput(String[] input) {
        for (String value : input) {
            if (Integer.parseInt(value) < 0 && Integer.parseInt(value) >= 8) {
                System.out.println("Invalid input: Out of table!");
                return false;
            }
        }
        return true;
    }

    public boolean validatePawn(String[] input) {
        final Pawn[][] board = PawnWarsService.getBoard();
        if (board[Integer.parseInt(input[0])][Integer.parseInt(input[1])] != null) {
            return true;
        }
        System.out.println("Invalid input: No pawn detected! ");
        return false;
    }


//    public boolean singleStepValidate(String[] from, String[] to) {
//        if((Math.abs(Integer.parseInt(to[0]) - Integer.parseInt(from[0])) == 1 && Math.abs(Integer.parseInt(to[1]) - Integer.parseInt(from[1])) == 1)){
//            return true;
//        }
//        System.out.println("Invalid input:  ");
//        return false;
//    }

    public boolean jumpValidate(String[] originalFrom, String[] to) {
        if (Arrays.equals(originalFrom, to)) {
            System.out.println("Valid step!");
            return true;
        }
        final String[] from = Arrays.copyOf(originalFrom, originalFrom.length);
        final Pawn[][] board = PawnWarsService.getBoard();
        final Pawn originalPawn = board[Integer.parseInt(from[0])][Integer.parseInt(from[1])];
        boolean rightDirection = Integer.parseInt(to[1]) > Integer.parseInt(from[1]);
        final int toRow = Integer.parseInt(to[0]);
        final int toColumn = Integer.parseInt(to[1]);
        final int fromRow = Integer.parseInt(from[0]);
        final int fromColumn = Integer.parseInt(from[1]);
        if (rightDirection) {
            Pawn diagonalPawn;
            if (originalPawn.isWhite()) {
                if (fromRow - 1 < 0 || fromColumn + 1 > 7) {
                    System.out.println("Invalid Input: This pawn is in a galaxy far far away");
                    return false;
                }
                diagonalPawn = board[fromRow - 1][fromColumn + 1];
                System.out.println("Diagonal white pawn right init");
            } else {
                if (fromRow + 1 > 7 || fromColumn + 1 > 7) {
                    System.out.println("Invalid Input: This pawn is in a galaxy far far away");
                    return false;
                }
                diagonalPawn = board[fromRow + 1][fromColumn + 1];
                System.out.println("Diagonal black pawn right init");
            }
            boolean multiStep = diagonalPawn != null /*&& diagonalPawn.isWhite() == originalPawn.isWhite()*/;
            if (multiStep && originalPawn.isWhite()) {
                if (fromRow - 2 < 0 || fromColumn + 2 > 7) {
                    System.out.println("Invalid Input: This pawn is in a galaxy far far away");
                    return false;
                }
                from[0] = String.valueOf(fromRow - 2);
                from[1] = String.valueOf(fromColumn + 2);
                System.out.println("White Right from pawn overwrite");
            }
            if (multiStep && !originalPawn.isWhite()) {
                if (fromColumn + 2 > 7) {
                    System.out.println("Invalid Input: This pawn is in a galaxy far far away");
                    return false;
                }
                from[0] = String.valueOf(fromRow + 2);
                from[1] = String.valueOf(fromColumn + 2);
                System.out.println("Black Right from pawn overwrite");
            }
            if (!multiStep && originalPawn.isWhite()) {
                if (fromRow - 1 < 0 || fromColumn + 1 > 7) {
                    System.out.println("Invalid Input: This pawn is in a galaxy far far away");
                    return false;
                }
                from[0] = String.valueOf(fromRow - 1);
                from[1] = String.valueOf(fromColumn + 1);
                System.out.println("White Right from pawn overwrite(not multistep)");
            }
            if (!multiStep && !originalPawn.isWhite()) {
                if (fromColumn + 1 > 7) {
                    System.out.println("Invalid Input: This pawn is in a galaxy far far away");
                    return false;
                }
                from[0] = String.valueOf(fromRow + 1);
                from[1] = String.valueOf(fromColumn + 1);
                System.out.println("Black Right from pawn overwrite(not multistep)");
            }
        } else {
            Pawn diagonalPawn;
            if (originalPawn.isWhite()) {
                if (fromRow - 1 < 0 || fromColumn - 1 < 0) {
                    System.out.println("Invalid Input: This pawn is in a galaxy far far away");
                    return false;
                }
                diagonalPawn = board[fromRow - 1][fromColumn - 1];
                System.out.println("Diagonal white pawn left init");
            } else {
                if (fromRow + 1 > 7 || fromColumn - 1 < 0) {
                    System.out.println("Invalid Input: This pawn is in a galaxy far far away");
                    return false;
                }
                diagonalPawn = board[fromRow + 1][fromColumn - 1];
                System.out.println("Diagonal black pawn left init");
            }
            boolean multiStep = diagonalPawn != null && diagonalPawn.isWhite() == originalPawn.isWhite();
            if (multiStep && originalPawn.isWhite()) {
                if (fromRow - 2 < 0 || fromColumn - 2 < 0) {
                    System.out.println("Invalid Input: This pawn is in a galaxy far far away");
                    return false;
                }
                from[0] = String.valueOf(fromRow - 2);
                from[1] = String.valueOf(fromColumn - 2);
                System.out.println("White left from pawn overwrite");
            }
            if (multiStep && !originalPawn.isWhite()) {
                if (fromRow + 2 > 7 || fromColumn - 2 < 0) {
                    System.out.println("Invalid Input: This pawn is in a galaxy far far away");
                    return false;
                }
                from[0] = String.valueOf(fromRow + 2);
                from[1] = String.valueOf(fromColumn - 2);
                System.out.println("Black left from pawn overwrite");
            }
            if (!multiStep && originalPawn.isWhite()) {
                if (fromRow - 1 < 0 || fromColumn - 1 < 0) {
                    System.out.println("Invalid Input: This pawn is in a galaxy far far away");
                    return false;
                }
                from[0] = String.valueOf(fromRow - 1);
                from[1] = String.valueOf(fromColumn - 1);
                System.out.println("White left from pawn overwrite(not multistep)");
            }
            if (!multiStep && !originalPawn.isWhite()) {
                if (fromRow + 1 > 7 || fromColumn - 1 <0 ) {
                    System.out.println("Invalid Input: This pawn is in a galaxy far far away");
                    return false;
                }
                from[0] = String.valueOf(fromRow + 1);
                from[1] = String.valueOf(fromColumn - 1);
                System.out.println("Black left from pawn overwrite(not multistep)");
            }
        }
        if (fromRow > toRow && !originalPawn.isWhite()) {
            System.out.println("Invalid input: Not in range!");
            return false;
        }
        if (fromRow < toRow && originalPawn.isWhite()) {
            System.out.println("Invalid input: Not in range!");
            return false;
        }

        return jumpValidate(from, to);
    }


}






