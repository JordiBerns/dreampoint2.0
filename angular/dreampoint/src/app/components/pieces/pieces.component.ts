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
  constructor(private pieceService:PieceService) { }

  ngOnInit() {
  }

  listAll(){
    this.pieceService.list().subscribe(data => {
      this.pieces = data;
    });
  }
}
