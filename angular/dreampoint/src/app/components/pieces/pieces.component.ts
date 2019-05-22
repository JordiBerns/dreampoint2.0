import { Component, OnInit } from '@angular/core';
import { Piece } from 'src/app/piece';
import { PieceService } from 'src/app/services/piece.service';

@Component({
  selector: 'app-pieces',
  templateUrl: './pieces.component.html',
  styleUrls: ['./pieces.component.css']
})
export class PiecesComponent implements OnInit {

  pieces:Piece[];
  move:string;
  shot:string;

  constructor(private pieceService:PieceService) { }

  ngOnInit() {
  }

  listAll(){
    this.pieceService.list().subscribe(data => {
      this.pieces = data;
    });
  }

  movePieceLeft(){
    console.log("in movepiece left")
    this.pieceService.move(this.move="a").subscribe(() => this.listAll())
  }

  movePieceRight(){
    this.pieceService.move(this.move="d").subscribe(() => this.listAll())
  }

  movePieceUp(){
    this.pieceService.move(this.move="w").subscribe(() => this.listAll())
  }

  movePieceDown(){
    this.pieceService.move(this.move="s").subscribe(() => this.listAll())
  }

  shootLeft(){
    this.pieceService.shoot(this.shot="j").subscribe(() => this.listAll())
  }

  shootRight(){
    this.pieceService.shoot(this.shot="l").subscribe(() => this.listAll())
  }

  shootUp(){
    this.pieceService.shoot(this.shot="i").subscribe(() => this.listAll())
  }

  shootDown(){
    this.pieceService.shoot(this.shot="k").subscribe(() => this.listAll())
  }

}
