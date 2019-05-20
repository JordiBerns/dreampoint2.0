package nl.yer.middleman.dreampoint.api;

import nl.yer.middleman.dreampoint.model.Piece;
import nl.yer.middleman.dreampoint.service.PieceService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/pieces")
@CrossOrigin("*")

public class PieceController {

    private PieceService pieceService;

    public PieceController(PieceService pieceService) {this.pieceService = pieceService;}

    @GetMapping
    public Iterable<Piece> list() {return pieceService.findAll();}

    @GetMapping("{id}")
    public Piece get(@PathVariable long id) {
        Optional<Piece> optionalPiece = this.pieceService.findById(id);
        if(optionalPiece.isPresent()) {
            Piece result = optionalPiece.get();
            return result;
        }
        else {
            return null;
        }
    }

    @PostMapping
    public Piece create(@RequestBody Piece piece) {return this.pieceService.save(piece);}

    @PutMapping("{id}")
    public Piece update(@PathVariable long id, @RequestBody Piece input) {
        Optional<Piece> optionalPiece = this.pieceService.findById(id);
        if(optionalPiece.isPresent()) {
            Piece target = optionalPiece.get();

//            target.setName(input.getName());
            target.setyPosition(input.getyPosition());
            target.setxPosition(input.getxPosition());

            return this.pieceService.save(target);
        }
        else {
            return null;
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        Optional<Piece> optionalPiece = this.pieceService.findById(id);
        if(optionalPiece.isPresent()) {
            this.pieceService.deleteById(id);
        }
    }

}
