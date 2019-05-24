import { Component, OnInit } from "@angular/core";
import { Piece } from "src/app/piece";
import { PieceService } from "src/app/services/piece.service";
import { TestBed } from "@angular/core/testing";

@Component({
  selector: "app-pieces",
  templateUrl: "./pieces.component.html",
  styleUrls: ["./pieces.component.css"]
})
export class PiecesComponent implements OnInit {
  pieces: Piece[];
  array = Array(10)
    .fill("../../../assets/GRASS32.png")
    .map(() => Array(10).fill("../../../assets/b32.png"));

  move: string;
  shot: string;

  constructor(private pieceService: PieceService) {}

  ngOnInit() {
    this.listAll();
  }

  test() {
    this.array = Array(10)
      .fill("../../../assets/b32.png")
      .map(() => Array(10).fill("../../../assets/b32.png"));
    for (let piece of this.pieces) {
      if (piece.name == "Hero") {
        this.array[piece.yPosition][piece.xPosition] =
          "../../../assets/e32.png";
      }
      if (piece.name == "Enemy") {
        this.array[piece.yPosition][piece.xPosition] =
          "../../../assets/p32.png";
      }
    }
  }

  listAll() {
    this.pieceService.list().subscribe(data => {
      this.pieces = data;
      this.test();
    });
  }

 

  movePiece() {
    this.pieceService.move(this.move).subscribe(() => {
      this.listAll();
    });
  }
  movePieceLeft() {
    console.log("in movepiece left");

    this.pieceService.move((this.move = "a")).subscribe(() => this.listAll());
  }

  movePieceRight() {
    this.pieceService.move((this.move = "d")).subscribe(() => this.listAll());
  }

  movePieceUp() {
    this.pieceService.move((this.move = "w")).subscribe(() => this.listAll());
  }

  movePieceDown() {
    this.pieceService.move((this.move = "s")).subscribe(() => this.listAll());
  }

  shootRight() {
    console.log("in shooting function");
    let player;
    for (let piece of this.pieces) {
      if (piece.name == "Hero") {
        player = piece;
        console.log("in shooting function/for loop player");
      }
    }
    for (let piece of this.pieces) {
      console.log("in shooting function/for loop enemy");
      if (
        piece.yPosition == player.yPosition &&
        piece.xPosition > player.xPosition
      ) {
        if (piece.name == "Enemy") {
          console.log("in shooting function/isEnemy");
          this.pieceService
            .shootPiece(piece.id)
            .subscribe(() => this.listAll());
        }
      }
    }
  }

  shootLeft() {
    console.log("in shooting function");
    let player;
    for (let piece of this.pieces) {
      if (piece.name == "Hero") {
        player = piece;
        console.log("in shooting function/for loop player");
      }
    }
    for (let piece of this.pieces) {
      console.log("in shooting function/for loop enemy");
      if (
        piece.yPosition == player.yPosition &&
        piece.xPosition < player.xPosition
      ) {
        if (piece.name == "Enemy") {
          console.log("in shooting function/isEnemy");
          this.pieceService
            .shootPiece(piece.id)
            .subscribe(() => this.listAll());
        }
      }
    }
  }

  shootUp() {
    console.log("in shooting function");
    let player;
    for (let piece of this.pieces) {
      if (piece.name == "Hero") {
        player = piece;
        console.log("in shooting function/for loop player");
      }
    }
    for (let piece of this.pieces) {
      console.log("in shooting function/for loop enemy");
      if (
        piece.yPosition < player.yPosition &&
        piece.xPosition == player.xPosition
      ) {
        if (piece.name == "Enemy") {
          console.log("in shooting function/isEnemy");
          this.pieceService
            .shootPiece(piece.id)
            .subscribe(() => this.listAll());
        }
      }
    }
  }

  shootDown() {
    console.log("in shooting function");
    let player;
    for (let piece of this.pieces) {
      if (piece.name == "Hero") {
        player = piece;
        console.log("in shooting function/for loop player");
      }
    }
    for (let piece of this.pieces) {
      console.log("in shooting function/for loop enemy");
      if (
        piece.yPosition > player.yPosition &&
        piece.xPosition == player.xPosition
      ) {
        if (piece.name == "Enemy") {
          console.log("in shooting function/isEnemy");
          this.pieceService
            .shootPiece(piece.id)
            .subscribe(() => this.listAll());
        }
      }
    }
  }


}
