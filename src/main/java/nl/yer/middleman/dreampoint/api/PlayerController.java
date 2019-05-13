package nl.yer.middleman.dreampoint.api;

import nl.yer.middleman.dreampoint.model.player.Player;
import nl.yer.middleman.dreampoint.model.playingfield.Playingfield;
import nl.yer.middleman.dreampoint.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public Iterable<Player> list(){
        return this.playerService.findAll();
    }

    @GetMapping("{id}")
    public Player get(@PathVariable long id){
        Optional<Player> optionalResult = this.playerService.findById(id);
        if (optionalResult.isPresent()) {
            Player result = optionalResult.get();
            return result;
        }
        else {
            return null; // moet veranderen
        }
    }

    @PostMapping
    public Player create(@RequestBody Player player){
        return this.playerService.save(player);
    }
}
