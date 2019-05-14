package nl.yer.middleman.dreampoint.model.playingfield;

import nl.yer.middleman.dreampoint.model.Piece;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
public class Playingfield {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int width;
    private int height;

    @OneToMany(mappedBy = "playingfield")
    private Set<Piece> pieces = new HashSet<>();

    public Playingfield(){
        this.width = 10;
        this.height = 10;
    }

    public void addPiece(Piece piece){
        this.pieces.add(piece);
        piece.setPlayingfield(this);
    }

    public Set<Piece> getPieces() {
        return this.pieces;
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

    public Set<Piece> generatePieceSet(int difficulty){
        Set<Piece> pieceMap = new HashSet<>();
        int nrEnemies = difficulty*2 + 2;
        int x;
        int y;
        for(int i = 0; i <= nrEnemies; i++){
            x = (int) (Math.random()*this.width);
            y = (int) (Math.random()*this.height);
            pieceMap.add(new Piece(y, x));
        }

        return pieceMap;
    }

}
