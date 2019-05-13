package nl.yer.middleman.dreampoint.persistence;

import nl.yer.middleman.dreampoint.model.player.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
