import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtClientService } from '../jwt-client.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  userModel = new User('', '');

  public response: any 
  isLoginError : boolean = false


  constructor(private service: JwtClientService, private router: Router) {}

  ngOnInit() {}

  onSubmit() {
    console.log(this.userModel);
  
    this.service.generateToken(this.userModel).
    subscribe((data:any) => {console.log(data);
      localStorage.setItem('jwt', data);
      this.router.navigate(['/home']);
    },
    (err: HttpErrorResponse) =>{
      this.isLoginError = true;
    }
      );
      
    }
  }
  