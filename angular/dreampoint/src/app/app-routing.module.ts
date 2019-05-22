import { PiecesComponent } from './components/pieces/pieces.component';
import { MainmenuComponent } from './components/mainmenu/mainmenu.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlayersComponent } from './components/players/players.component';

const routes: Routes = [
  {
    path: '',
    component: MainmenuComponent
  },
  
  {
    path: 'player', 
    component: PlayersComponent
  },

  {
    path: 'pieces', 
    component: PiecesComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
