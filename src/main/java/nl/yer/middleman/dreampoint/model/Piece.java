package nl.yer.middleman.dreampoint.model;

import nl.yer.middleman.dreampoint.model.playingfield.Playingfield;

import javax.persistence.*;

@Entity
public class Piece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int yPosition;
    private int xPosition;

    @ManyToOne
    private Playingfield playingfield;

    public Piece(){
    }

    public Piece(int yPosition, int xPosition) {
        this.yPosition = yPosition;
        this.xPosition = xPosition;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

}
