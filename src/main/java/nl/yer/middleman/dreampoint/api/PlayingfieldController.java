package nl.yer.middleman.dreampoint.api;


import nl.yer.middleman.dreampoint.model.playingfield.Playingfield;
import nl.yer.middleman.dreampoint.service.PlayingfieldService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/playingfields")
@CrossOrigin("*")
public class PlayingfieldController {

    private  PlayingfieldService playingfieldService;

    public PlayingfieldController(PlayingfieldService playingfieldService){
        this.playingfieldService = playingfieldService;
    }

    @GetMapping
    public  Iterable<Playingfield> list(){
        return  playingfieldService.findAll();
    }

    @GetMapping("{id}")
    public Playingfield get(@PathVariable long id){
        Optional<Playingfield> optionalResult = this.playingfieldService.findById(id);
        if(optionalResult.isPresent()){
            Playingfield result = optionalResult.get();
            return result;
        }
        else {
            return null;
        }
    }
    @PostMapping
    public Playingfield create(@RequestBody Playingfield playingfield) {
        return this.playingfieldService.save(playingfield);
    }

    /*@PutMapping("{id}")
    public Playingfield update(@PathVariable long id, @RequestBody Playingfield input){
        Optional<Playingfield> optionalTarget = this.playingfieldService.findById(id);
        if(optionalTarget.isPresent()){
            Playingfield target = optionalTarget.get();
            return this.playingfieldService.save(target);
        }
        else {
            return null;
        }


    }
    */

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        Optional<Playingfield> optionalResult = this.playingfieldService.findById(id);
        if(optionalResult.isPresent()){
            this.playingfieldService.deleteById(id);
        }
    }
}
