package nl.yer.middleman.dreampoint.persistence;

import nl.yer.middleman.dreampoint.model.Pieces.Piece;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PieceRepository extends CrudRepository<Piece, Long> {


    Optional<Piece> findByName(String name);
}
