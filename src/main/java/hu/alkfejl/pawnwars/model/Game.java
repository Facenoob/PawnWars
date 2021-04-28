package hu.alkfejl.pawnwars.model;
import javax.persistence.*;
@Entity
@Table
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Match_ID;
    @Column
    private int PlayerOne_ID;
    @Column
    private int PlayerTwo_ID;

    public int getMatch_ID() {
        return Match_ID;
    }

    public void setMatch_ID(int match_ID) {
        Match_ID = match_ID;
    }

    public int getPlayerOne_ID() {
        return PlayerOne_ID;
    }

    public void setPlayerOne_ID(int playerOne_ID) {
        PlayerOne_ID = playerOne_ID;
    }

    public int getPlayerTwo_ID() {
        return PlayerTwo_ID;
    }

    public void setPlayerTwo_ID(int playerTwo_ID) {
        PlayerTwo_ID = playerTwo_ID;
    }

    public Game() {
    }
    public Game(int playerOne_ID, int playerTwo_ID) {
        PlayerOne_ID = playerOne_ID;
        PlayerTwo_ID = playerTwo_ID;
    }
}
