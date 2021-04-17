package hu.alkfejl.pawnwars.model;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class Pawn {
    private boolean isWhite;
    private ImmutablePair<Integer, Integer> position;

    public Pawn(boolean isWhite, ImmutablePair<Integer, Integer> position) {
        this.isWhite = isWhite;
        this.position = position;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public ImmutablePair<Integer, Integer> getPosition() {
        return position;
    }

    public void setPosition(ImmutablePair<Integer, Integer> position) {
        this.position = position;
    }
}
