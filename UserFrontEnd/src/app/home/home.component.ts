import { Component, OnInit } from '@angular/core';
import { Game } from '../modal/Game';
import { ApiServiceService } from '../api-service.service';
import { User } from '../modal/User';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  games:Game[]=[];
  user:User;
  // private static user : User = null;
  constructor(private apiservice:ApiServiceService) { 
   
  }

  ngOnInit(): void {
  this.getallgamesinUi();
  setInterval(()=>{this.getallgamesinUi()},2000);

  }

  public getallgamesinUi()
  {
    this.apiservice.getAllGames().subscribe((response)=>{this.games = response;
      console.log(response);
    });

  }
  enrollInGame(game:Game)
  {
    let user:User = JSON.parse(localStorage.getItem('user'));
    this.user = user;
    this.apiservice.enrolGame(game.id,this.user).subscribe((response)=>{this.user = response;
    console.log(this.user)
    });
  }
 

}
