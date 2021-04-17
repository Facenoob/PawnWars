package hu.alkfejl.pawnwars.service;
import hu.alkfejl.pawnwars.model.Pawn;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

@Service
public class PawnWarsService {
    @Autowired
    private PawnWarsValidator validator;
    private static Pawn [][] board = new Pawn[8][8];

    public static Pawn[][] getBoard() {
        return board;
    }

    public Pawn[][] createBoard(){


        board[0][1]=new Pawn(false,new ImmutablePair<>(0,1));
        board[0][3]=new Pawn(false,new ImmutablePair<>(0,3));
        board[0][5]=new Pawn(false,new ImmutablePair<>(0,5));
        board[0][7]=new Pawn(false,new ImmutablePair<>(0,7));
        board[1][0]=new Pawn(false,new ImmutablePair<>(1,0));
        board[1][2]=new Pawn(false,new ImmutablePair<>(1,2));
        board[1][4]=new Pawn(false,new ImmutablePair<>(1,4));
        board[1][6]=new Pawn(false,new ImmutablePair<>(1,6));

        board[7][0]=new Pawn(true,new ImmutablePair<>(7,0));
        board[7][2]=new Pawn(true,new ImmutablePair<>(7,2));
        board[7][4]=new Pawn(true,new ImmutablePair<>(7,4));
        board[7][6]=new Pawn(true,new ImmutablePair<>(7,6));
        board[6][1]=new Pawn(true,new ImmutablePair<>(6,1));
        board[6][3]=new Pawn(true,new ImmutablePair<>(6,3));
        board[6][5]=new Pawn(true,new ImmutablePair<>(6,5));
        board[6][7]=new Pawn(true,new ImmutablePair<>(6,7));
        return board;
    }

    public void handleStep(String from, String to) {
        final String[] fromIndex = from.split("-");
        final String[] toIndex = to.split("-");
        final boolean fromIsValid = validator.validateInput(fromIndex);
        final boolean toIsValid = validator.validateInput(toIndex);
    }
}

