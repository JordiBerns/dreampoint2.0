import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Piece } from '../piece';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PieceService {

  constructor(private httpClient:HttpClient) { }

  url = 'http://localhost:8080/api/pieces';


  list(): Observable<Piece[]> {
    return this.httpClient.get<Piece[]>(this.url);
  }

  move(move:string){
    return this.httpClient.post(this.url + '/move', move)
  }
}
