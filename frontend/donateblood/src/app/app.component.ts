import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // location: string;
  // constructor( private _location: Location){
  //   this.location = _location.path();
  //   console.log(this.location);
  // }

  title = 'donateblood';
}
