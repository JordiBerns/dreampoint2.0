package nl.yer.middleman.dreampoint.model.playingfield;

import nl.yer.middleman.dreampoint.model.Pieces.Piece;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Playingfield {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int width;
    private int height;

    @OneToMany
    private Set<Piece> pieces = new HashSet<>();

    public Playingfield(){
        this.width = 10;
        this.height = 10;
    }

    public void addPiece(Piece piece){
        this.pieces.add(piece);
    }

    public long getId() {
        return id;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
