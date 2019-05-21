import { Component, OnInit } from '@angular/core';
import { PlayingfieldService } from 'src/app/services/playingfield.service';
import {Playingfield} from 'src/app/playingfield';

@Component({
  selector: 'app-playingfield-list',
  templateUrl: './playingfield-list.component.html',
  styleUrls: ['./playingfield-list.component.css']
})
export class PlayingfieldListComponent implements OnInit {

  private playingfields: Playingfield[];

  constructor(private playingfieldService: PlayingfieldService) { }

  ngOnInit() {
    this.playingfieldService.list().subscribe(data => {
      this.playingfields = data;
    });
  }

}
