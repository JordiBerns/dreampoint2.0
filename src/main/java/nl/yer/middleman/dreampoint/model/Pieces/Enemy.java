package nl.yer.middleman.dreampoint.model.Pieces;

import javax.persistence.Entity;

@Entity
public class Enemy extends Piece{
    private String name = "Enemy";

    public Enemy(int yPosition, int xPosition) {
        super(yPosition, xPosition);
    }
}
