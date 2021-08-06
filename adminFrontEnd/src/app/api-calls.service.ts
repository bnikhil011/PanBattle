import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Game } from './modal/Game';

@Injectable({
  providedIn: 'root'
})
export class ApiCallsService {

  constructor(private httpService : HttpClient) { }

  public getAllGames():Observable<Game[]>
  {
    return this.httpService.get<Game[]>("http://localhost:8080/services/allgames");
  }
  public deleteGame(game :Game)
  {
    this.httpService.delete("http://localhost:8080/admin/delete-game/"+game.id).subscribe((response)=>{console.log("Game Deleted")});
  }
  public addGame(game :Game)
  {
    this.httpService.post("http://localhost:8080/admin/addgame",game).subscribe((response)=>{console.log("Game added")});
  }
}
