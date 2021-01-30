import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseUrl } from 'src/environments/environment';
import { AddUser } from './addUser';

@Injectable({
  providedIn: 'root'
})
export class RegistrationServiceService {

  constructor(private http: HttpClient) { }

  addUser(adduser: AddUser)
  {
    const headers = new HttpHeaders().set("Authorization", 'Bearer ' + localStorage.getItem('jwt'));
    return this.http.post(`${baseUrl}users`,adduser,{headers,responseType: 'text' as 'json'})
  }
}
