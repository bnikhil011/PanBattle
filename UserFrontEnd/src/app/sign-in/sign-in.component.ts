import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ApiServiceService } from '../api-service.service';
import { HomeComponent } from '../home/home.component';
@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  constructor(private apiservice: ApiServiceService ) { }
  
  ngOnInit(): void {
  }

  signUpUser(formdata:NgForm)
  {
    
     this.apiservice.signinUser(formdata.value).subscribe((response)=>{
       console.log(response);
       localStorage.setItem("user",JSON.stringify(response));
      window.location.href = "http://localhost:4201/home";
      },(error)=>{alert("login ID and Password is incorrect")});
      
      
  }
}
