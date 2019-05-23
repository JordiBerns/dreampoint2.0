package nl.yer.middleman.dreampoint.model.player;


import nl.yer.middleman.dreampoint.model.playingfield.Playingfield;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int age;
    private String gender;
    private int hiscore;

    @OneToOne
    private Playingfield playingfield;

    public Player() {
        this.playingfield = new Playingfield();
    }

    public void setPlayingfield(Playingfield playingfield) {
        this.playingfield = playingfield;
    }

    public Playingfield getPlayingfield() {
        return playingfield;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHiscore() {
        return hiscore;
    }

    public void setHiscore(int hiscore) {
        this.hiscore = hiscore;
    }
}
