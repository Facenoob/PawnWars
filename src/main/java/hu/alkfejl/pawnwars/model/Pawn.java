package hu.alkfejl.pawnwars.model;



public class Pawn {
    private boolean isWhite;

    public Pawn(boolean isWhite) {
        this.isWhite = isWhite;
    }
    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }
}
