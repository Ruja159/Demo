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

  getBloodTypes(){
    const headers = new HttpHeaders().set("Authorization", 'Bearer ' + localStorage.getItem('jwt'));
    return this.http.get(`${baseUrl}bloodType`,{headers,responseType: 'text' as 'json'})
  }

  getUser(userName){
    const headers = new HttpHeaders().set("Authorization", 'Bearer ' + localStorage.getItem('jwt'));
    return this.http.get(`${baseUrl}users/${userName}`,{headers,responseType: 'text' as 'json'})
  }

  addBloodType(userName,id){
    const headers = new HttpHeaders().set("Authorization", 'Bearer ' + localStorage.getItem('jwt'));
    return this.http.post(`${baseUrl}bloodType/${id}/users/${userName}/add`, {headers,responseType: 'text' as 'json'})
  }
}
