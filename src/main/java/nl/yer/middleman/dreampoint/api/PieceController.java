package nl.yer.middleman.dreampoint.api;

import nl.yer.middleman.dreampoint.model.Pieces.Piece;
import nl.yer.middleman.dreampoint.model.playingfield.Playingfield;
import nl.yer.middleman.dreampoint.service.PieceService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/pieces")
@CrossOrigin("*")

public class PieceController {

    private PieceService pieceService;

    public PieceController(PieceService pieceService) {
        this.pieceService = pieceService;
    }

    @GetMapping
    public Iterable<Piece> list() {
        return pieceService.findByPlayingfieldId(1L);
    }

    @GetMapping("{id}")
    public Piece get(@PathVariable long id) {
        Optional<Piece> optionalPiece = this.pieceService.findById(id);
        if (optionalPiece.isPresent()) {
            Piece result = optionalPiece.get();
            return result;
        } else {
            return null;
        }
    }

    @PostMapping
    public Piece create(@RequestBody Piece piece) {
        return this.pieceService.save(piece);
    }

    @PutMapping("{id}")
    public Piece update(@PathVariable long id, @RequestBody Piece input) {
        Optional<Piece> optionalPiece = this.pieceService.findById(id);
        if (optionalPiece.isPresent()) {
            Piece target = optionalPiece.get();

            target.setyPosition(input.getyPosition());
            target.setxPosition(input.getxPosition());

            return this.pieceService.save(target);
        } else {
            return null;
        }
    }

    @PostMapping("/move")
    public void setPieceService(@RequestBody String move) {
        System.out.println("In move: " + move);
        Iterable<Piece> pieceList = this.pieceService.findByPlayingfieldId(1L);
        for(Piece piece : pieceList) {
        
        if (piece.getName().equals("Hero")){
                switch (move.charAt(0)) {
                    case 'w':
                        System.out.println("in w");
                        if(piece.getyPosition() -1 >= 0 && piece.getyPosition() -1 < 10) {
                            piece.setyPosition(piece.getyPosition() - 1);
                        }
                        break;
                    case 'a':
                        System.out.println("in a");
                        if(piece.getxPosition() -1 >= 0 && piece.getxPosition() -1 < 10) {
                            piece.setxPosition(piece.getxPosition() - 1);
                        }
                        break;
                    case 's':
                        System.out.println("in s");
                        if(piece.getyPosition() +1 >= 0 && piece.getyPosition() +1 < 10) {
                            piece.setyPosition(piece.getyPosition() + 1);
                        }
                        break;
                    case 'd':
                        System.out.println("in d");
                        if(piece.getxPosition() +1 >= 0 && piece.getxPosition() +1 < 10) {
                            piece.setxPosition(piece.getxPosition() + 1);
                        }
                        break;
                    default:
                        System.out.println("wrong input");
                }
                this.pieceService.save(piece);
            }
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        Optional<Piece> optionalPiece = this.pieceService.findById(id);
        if (optionalPiece.isPresent()) {
            this.pieceService.deleteById(id);
        }
    }

}
