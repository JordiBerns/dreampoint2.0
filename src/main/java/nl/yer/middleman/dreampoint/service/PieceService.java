package nl.yer.middleman.dreampoint.service;

import nl.yer.middleman.dreampoint.model.Pieces.Piece;
import nl.yer.middleman.dreampoint.persistence.PieceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PieceService {
    private PieceRepository pieceRepository;

    public PieceService(PieceRepository pieceRepository) {
        this.pieceRepository = pieceRepository;
    }

    public Piece save(Piece piece) {
        return this.pieceRepository.save(piece);
    }

    public Optional<Piece> findById(Long aLong) {return pieceRepository.findById(aLong);}

    public Iterable<Piece> findByPlayingfieldId(long id) {return pieceRepository.findByPlayingfieldId(id);}

    public Iterable<Piece> findAll() {return this.pieceRepository.findAll();}

    public void deleteById(Long aLong) {this.pieceRepository.deleteById(aLong);}

}
