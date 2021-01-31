import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { AddyourbloodytpeComponent } from './addyourbloodytpe/addyourbloodytpe.component';
import { AuthGuard } from './auth/auth.guard';
import { CardComponent } from './card/card.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { TableComponent } from './table/table.component';

export const routes: Routes = [
  // redirect to login page
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'home',
    component: HomeComponent,
    children: [{ path: '', component: TableComponent }],
    canActivate: [AuthGuard],
  },
  {
    path: 'home',
    component: HomeComponent,
    children:[{path: 'bloodtype', component: AddyourbloodytpeComponent}],
    canActivate: [AuthGuard],
  },
  {
    path: 'home',
    component: HomeComponent,
    children:[{path: 'about', component: AboutusComponent}],
    canActivate: [AuthGuard],
  },
  {
    path: 'card',
    component: HomeComponent,
    children: [{ path: '', component: CardComponent }],
    canActivate: [AuthGuard],
  },

  {
    path: 'registration',
    component: RegistrationComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
export const routingComponents = [HomeComponent, RegistrationComponent];
