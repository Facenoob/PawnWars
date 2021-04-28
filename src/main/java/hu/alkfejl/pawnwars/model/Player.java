package hu.alkfejl.pawnwars.model;

import javax.persistence.*;

@Entity
@Table
public class Player {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int PLAYER_ID;
    @Column
    private String name;
    public Player() {
    }

    public int getId(){
        return PLAYER_ID;
    }

    public void setId(int PLAYER_ID){
        this.PLAYER_ID = PLAYER_ID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}