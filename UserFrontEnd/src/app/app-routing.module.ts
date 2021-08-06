import { NgModule } from '@angular/core';
import { RouterModule, Route } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { HomeComponent } from './home/home.component';
const routes: Route[] = [
  {path:"signup",component:SignUpComponent},
  {path:"signin",component:SignInComponent},
  {path:"home",component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
