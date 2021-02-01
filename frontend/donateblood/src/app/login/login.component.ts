import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtClientService } from '../jwt-client.service';
import { User } from '../user';
import jwt_decode from 'jwt-decode';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  public userName: any;

  userModel = new User('', '');

  public response: any;
  isLoginError: boolean = false;

  constructor(private service: JwtClientService, private router: Router) {}
  ngOnInit() {}

  onSubmit() {
    console.log(this.userModel);

    this.service.generateToken(this.userModel).subscribe(
      (data: any) => {
        console.log(data);
        localStorage.setItem('jwt', data);
        const decodeToken  = jwt_decode(data);
        this.userName = decodeToken;
        localStorage.setItem('userName', this.userName.sub);
        console.log(this.userName.sub)

        this.router.navigate(['/home']);
      },
      (err: HttpErrorResponse) => {
        this.isLoginError = true;
      }
    );
  }
}
