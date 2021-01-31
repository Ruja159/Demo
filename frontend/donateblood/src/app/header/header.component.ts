import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent  {

  @Input() deviceXs: boolean;

  constructor(private router: Router) { }



  Logout() {
    localStorage.removeItem('jwt');
    this.router.navigate(['/login']);
  }


}
