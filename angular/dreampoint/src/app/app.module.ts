import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlayersComponent } from './components/players/players.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { PiecesComponent } from './components/pieces/pieces.component'
import {PlayingfieldListComponent} from './components/playingfield-list/playingfield-list.component'

@NgModule({
  declarations: [
    AppComponent,
    PlayersComponent,
    PiecesComponent,
    PlayingfieldListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HttpClientModule,
    FormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
