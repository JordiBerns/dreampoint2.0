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
  move:string
  constructor(private pieceService:PieceService) { }

  ngOnInit() {
  }

  listAll(){
    this.pieceService.list().subscribe(data => {
      this.pieces = data;
    });
  }

  movePieceLeft(){
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

}
