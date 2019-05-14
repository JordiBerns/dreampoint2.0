package nl.yer.middleman.dreampoint.service;

import nl.yer.middleman.dreampoint.model.Piece;
import nl.yer.middleman.dreampoint.model.player.Player;
import nl.yer.middleman.dreampoint.model.playingfield.Playingfield;
import nl.yer.middleman.dreampoint.persistence.PieceRepository;
import nl.yer.middleman.dreampoint.persistence.PlayerRepository;
import nl.yer.middleman.dreampoint.persistence.PlayingfieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Set;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayingfieldRepository playingfieldRepository;

    @Autowired
    private PieceRepository pieceRepository;



    public Player save(Player player){

        Playingfield playingfield = new Playingfield();
        this.playingfieldRepository.save(playingfield);
        player.setPlayingfield(playingfield);

        Set<Piece> pieces = playingfield.generatePieceSet(1); //For future: player.getDifficulty()
        for (Piece piece : pieces){
            this.pieceRepository.save(piece);
            playingfield.addPiece(piece);
        }

        return this.playerRepository.save(player);
    }

    public Iterable<Player> findAll(){
        return this.playerRepository.findAll();
    }

    public Optional<Player> findById(long id){
        return this.playerRepository.findById(id);
    }
}
