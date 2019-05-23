package nl.yer.middleman.dreampoint.api;

import nl.yer.middleman.dreampoint.model.Pieces.Piece;
import nl.yer.middleman.dreampoint.model.player.Player;
import nl.yer.middleman.dreampoint.model.playingfield.Playingfield;
import nl.yer.middleman.dreampoint.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/players")
@CrossOrigin("*")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public Iterable<Player> list() {
        return this.playerService.findAll();
    }

    @GetMapping("{id}")
    public Player get(@PathVariable long id) {
        Optional<Player> optionalResult = this.playerService.findById(id);
        if (optionalResult.isPresent()) {
            Player result = optionalResult.get();
            return result;
        } else {
            return null; // moet veranderen
        }
    }

    @GetMapping("hiscore/"+ "{id}")
    public int gethiscore(@PathVariable long id) {
        Optional<Player> optionalResult = this.playerService.findById(id);
        int hiscore = 0;
        if (optionalResult.isPresent()) {
            Player result = optionalResult.get();
            hiscore = result.getHiscore();
        } else {
            hiscore = 0;
        }
        return hiscore;
    }

    @PostMapping
    public Player create(@RequestBody Player player) {
        return this.playerService.save(player);
    }


    @PutMapping
    public Player setHiscoreController(@RequestBody long id) {
        Optional<Player> optionalPlayer = this.playerService.findById(id);
        if (optionalPlayer.isPresent()) {
            Player target = optionalPlayer.get();
            target.setHiscore(target.getHiscore() + 10);
            return this.playerService.save(target);
        }
        else {
            return null;
        }
    }
}
