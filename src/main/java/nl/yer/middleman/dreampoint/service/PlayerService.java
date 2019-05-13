package nl.yer.middleman.dreampoint.service;

import nl.yer.middleman.dreampoint.model.player.Player;
import nl.yer.middleman.dreampoint.model.playingfield.Playingfield;
import nl.yer.middleman.dreampoint.persistence.PlayerRepository;
import nl.yer.middleman.dreampoint.persistence.PlayingfieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayingfieldRepository playingfieldRepository;



    public Player save(Player player){
        Playingfield playingfield = new Playingfield();
        this.playingfieldRepository.save(playingfield);
        player.setPlayingfield(playingfield);
        return this.playerRepository.save(player);
    }

    public Iterable<Player> findAll(){
        return this.playerRepository.findAll();
    }

    public Optional<Player> findById(long id){
        return this.playerRepository.findById(id);
    }
}
