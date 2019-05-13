package nl.yer.middleman.dreampoint.persistence;

import nl.yer.middleman.dreampoint.model.playingfield.Playingfield;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayingfieldRepository extends CrudRepository <Playingfield, Long> {

}
