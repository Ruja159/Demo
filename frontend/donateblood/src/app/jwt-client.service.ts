import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { baseUrl } from 'src/environments/environment';
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

   getUsers()
  {
    // let tokenStr = 'Bearer ' + localStorage.getItem('jwt');
    const headers = new HttpHeaders().set("Authorization", 'Bearer ' + localStorage.getItem('jwt'));
    return this.http.get("http://localhost:8080/users",{headers,responseType: 'text' as 'json'})
  }
}
