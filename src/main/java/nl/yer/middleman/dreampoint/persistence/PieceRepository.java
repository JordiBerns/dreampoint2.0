package nl.yer.middleman.dreampoint.persistence;

import nl.yer.middleman.dreampoint.model.Piece;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceRepository extends CrudRepository<Piece, Long> {
}
