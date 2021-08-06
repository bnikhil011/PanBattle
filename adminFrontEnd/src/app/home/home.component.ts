import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ApiCallsService } from '../api-calls.service';
import { Game } from '../modal/Game';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
   games:Game[];
   modalGame:Game = new Game();
  constructor(private apicallService:ApiCallsService) { }
  
  ngOnInit(): void {
    this.apicallService.getAllGames().subscribe((response)=>{this.games=response});
    setInterval(()=>{this.apicallService.getAllGames().subscribe((response)=>{this.games=response;
    });},1000);
    
  }
  assignModalGame(game:Game):void
  {
    this.modalGame = game;
  }
  deleteGame():void
  {
    this.apicallService.deleteGame(this.modalGame);

  }
  addGame(game:NgForm)
  { document.getElementById("addmodelcloase").click();
    console.log(game.value);
    this.apicallService.addGame(game.value);
  }

}
