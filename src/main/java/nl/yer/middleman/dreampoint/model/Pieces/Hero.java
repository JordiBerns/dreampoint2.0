package nl.yer.middleman.dreampoint.model.Pieces;

import javax.persistence.Entity;

@Entity
public class Hero extends Piece {
    private String name = "Hero";

    public Hero(int yPosition, int xPosition) {
        super(yPosition, xPosition);
    }

    public Hero(){

    }
}
