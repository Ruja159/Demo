import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegistrationServiceService {

  _url = "http://localhost:8080/"

  constructor(private http: HttpClient) { }

  register(userData){
    return this.http.post<any>(this._url, userData);
  }
}
