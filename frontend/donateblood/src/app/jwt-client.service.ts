import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { baseUrl } from 'src/environments/environment';
import { AddUser } from './addUser';
import { User } from './user';

@Injectable({
  providedIn: 'root',
})
export class JwtClientService {

  constructor(private http: HttpClient) {}

  public generateToken(user: User) {
    return this.http.post(`${baseUrl}authenticate`,user,{responseType: 'text' as 'json'})
  }


  public loggedIn(){
    return !!localStorage.getItem('jwt')
  }
  

   getUsers() {
    const headers = new HttpHeaders().set("Authorization", 'Bearer ' + localStorage.getItem('jwt'));
    return this.http.get(`${baseUrl}users`,{headers,responseType: 'text' as 'json'})
  }
}
