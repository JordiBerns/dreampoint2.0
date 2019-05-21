package nl.yer.middleman.dreampoint.model.Pieces;

import javax.persistence.Entity;

@Entity
public class Hero extends Piece {


    public Hero(int yPosition, int xPosition) {
        super(yPosition, xPosition);
        this.setName("Hero");
    }

    public Hero(){
        this.setName("Hero");
    }
}
