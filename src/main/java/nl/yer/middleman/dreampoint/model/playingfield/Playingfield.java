package nl.yer.middleman.dreampoint.model.playingfield;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Playingfield {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int Width;
    private int Height;

    public long getId() {
        return id;
    }


    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }
}
