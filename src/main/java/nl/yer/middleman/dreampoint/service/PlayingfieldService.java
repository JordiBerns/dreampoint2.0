package nl.yer.middleman.dreampoint.service;


import nl.yer.middleman.dreampoint.model.playingfield.Playingfield;
import nl.yer.middleman.dreampoint.persistence.PlayingfieldRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PlayingfieldService {
    private PlayingfieldRepository playingfieldRepository;

    public  PlayingfieldService (PlayingfieldRepository playingfieldRepository){

        this.playingfieldRepository = playingfieldRepository;
    }

    @Transactional
    public Playingfield save (Playingfield playingfield){ return  this.playingfieldRepository.save(playingfield);}

    public Optional<Playingfield> findById(Long aLong){ return playingfieldRepository.findById(aLong);}
    public Iterable<Playingfield> findAll(){return this.playingfieldRepository.findAll();}
    public void deleteById(Long aLong){this.playingfieldRepository.deleteById(aLong);}
}
