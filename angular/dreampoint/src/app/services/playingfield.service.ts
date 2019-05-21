import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Playingfield } from 'src/app/playingfield';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayingfieldService {
  private url:string = "http://localhost:8080/api/playingfields";
  constructor(private httpClient:HttpClient) { }

  list(): Observable<Playingfield[]> {
    return this.httpClient.get<Playingfield[]>(this.url);
  }
}

  