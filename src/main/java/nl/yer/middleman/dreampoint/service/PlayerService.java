package nl.yer.middleman.dreampoint.service;

import nl.yer.middleman.dreampoint.model.player.Player;
import nl.yer.middleman.dreampoint.persistence.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player save(Player player){
        return this.playerRepository.save(player);
    }

    public Iterable<Player> findAll(){
        return this.playerRepository.findAll();
    }

    public Optional<Player> findById(long id){
        return this.playerRepository.findById(id);
    }
}
