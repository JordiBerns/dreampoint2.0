import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Player } from '../player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  private url:string = 'http://localhost:8080/api/players';

  constructor(private httpClient:HttpClient) { }

  list(): Observable<Player[]> {
    return this.httpClient.get<Player[]>(this.url);
  }

}
