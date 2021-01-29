import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { JwtClientService } from '../jwt-client.service';

@Injectable()
export class AuthGuard implements CanActivate {
 
  constructor(private service : JwtClientService,
    private router: Router ) {}

    canActivate(): boolean {
      if(this.service.loggedIn()){
        return true
      }
      else {
        this.router.navigate(['/login'])
        return false
      }
    }
}
