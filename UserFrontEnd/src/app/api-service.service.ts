import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from './modal/User'
import { Game } from './modal/Game';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  constructor(private HttpService:HttpClient) { }

  public signinUser(user:User):Observable<User>
  {
    return this.HttpService.post<User>("http://localhost:8080/user/auth",user);
  }
  public signupUser(user:User):Observable<User>
  {
    return this.HttpService.post<User>("http://localhost:8080/user/add",user);
  }
  public enrolGame(id:number,user:User):Observable<User>
  {
    return this.HttpService.put<User>("http://localhost:8080/user/enrollgame/"+ id,user);
  }
  public getAllGames():Observable<Game[]>
  {
    return this.HttpService.get<Game[]>("http://localhost:8080/services/allgames");
  }
}
