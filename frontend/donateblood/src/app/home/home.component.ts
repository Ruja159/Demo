import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtClientService } from '../jwt-client.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {

  listOfUsers: any;


  constructor(private router: Router, private service: JwtClientService) {}

  ngOnInit() {
   
  }

  Logout() {
    localStorage.removeItem('jwt');
    this.router.navigate(['/login']);
  }

  getUsers() {
    this.service.getUsers().subscribe((data: any) => {
      this.listOfUsers = data
    });
  }
}