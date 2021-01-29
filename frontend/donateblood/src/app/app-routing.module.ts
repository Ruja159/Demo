import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';

export const routes: Routes = [
    // redirect to login page
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    
    path:'login' ,
     component: LoginComponent
   },
   {
     path: 'home',
     component: HomeComponent,
      canActivate:[AuthGuard]
   },

   {
    path: 'registration',
    component: RegistrationComponent
  },

 

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomeComponent,RegistrationComponent]
