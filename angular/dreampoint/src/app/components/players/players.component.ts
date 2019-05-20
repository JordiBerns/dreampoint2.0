import { Component, OnInit } from '@angular/core';
import { PlayerService } from 'src/app/services/player.service';
import { Player } from 'src/app/player';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent implements OnInit {

  private players: Player[];

  constructor(private playerService: PlayerService) { }

  ngOnInit() {

    this.playerService.list().subscribe(data => {
      this.players = data;
    });

  }

}
