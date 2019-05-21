package nl.yer.middleman.dreampoint.model.Pieces;

import javax.persistence.Entity;

@Entity
public class Enemy extends Piece{

    public Enemy(int yPosition, int xPosition) {
        super(yPosition, xPosition);
        this.setName("Enemy");
    }

    public Enemy(){
        this.setName("Enemy");
    }
}
