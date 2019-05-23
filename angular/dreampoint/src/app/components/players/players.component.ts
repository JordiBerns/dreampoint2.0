import { Component, OnInit } from '@angular/core';
import { PlayerService } from 'src/app/services/player.service';
import { Player } from 'src/app/player';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent implements OnInit {
  
  name:string;
  age:number;
  gender:string;
  hiscore:number;

  private players: Player[];

  constructor(private playerService: PlayerService) { }

  ngOnInit() {
      this.listAll();
  }

  listAll(){
    this.playerService.list().subscribe(data => {
      this.players = data;
    });
  }

  send(){
    this.playerService.send(this.name, this.age, this.gender)
  }

  setHiscore(id:number) {
    console.log("in set hiscore to playerservice");
    this.playerService.setHiscore(id);
  }

  showHiscore(id:number) {
    this.playerService.showHiscore(id);
  }
}
