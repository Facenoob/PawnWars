package hu.alkfejl.pawnwars.model;
import javax.persistence.*;
@Entity
@Table
public class Steps {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Step_ID;
    @Column
    private String step;
    @Column
    private int player_ID;
    @Column
    private int Game_ID;

    public int getPlayer_ID() {
        return player_ID;
    }

    public void setPlayer_ID(int player_ID) {
        this.player_ID = player_ID;
    }

    public int getGame_ID() {
        return Game_ID;
    }

    public void setGame_ID(int game_ID) {
        Game_ID = game_ID;
    }

    public int getStep_ID() {
        return Step_ID;
    }

    public void setStep_ID(int step_ID) {
        Step_ID = step_ID;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Steps(String step) {
        this.step = step;
    }

    public Steps() {
    }
}
