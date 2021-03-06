import { PlayerService } from 'src/app/services/player.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Piece } from '../piece';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PieceService {

  constructor(private httpClient:HttpClient, private playerService:PlayerService) { }

  url = 'http://localhost:8080/api/pieces';


  list(): Observable<Piece[]> {
    return this.httpClient.get<Piece[]>(this.url);
  }

  move(move:string){
    return this.httpClient.post(this.url + '/move', move)
  }

  shootPiece(id:number){
    console.log(this.url + '/' + id) ;
    this.playerService.setHiscore(1);
    return this.httpClient.delete(this.url + '/' + id);

  }

}
