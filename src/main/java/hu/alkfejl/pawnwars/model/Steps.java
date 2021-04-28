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
