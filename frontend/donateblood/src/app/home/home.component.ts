import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtClientService } from '../jwt-client.service';
import { MediaObserver, MediaChange} from '@angular/flex-layout'
import { Subscription} from 'rxjs'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit , OnDestroy{

  listOfUsers: any;

  mediaSub:Subscription;
  deviceXs: boolean;

  constructor(private router: Router, private service: JwtClientService, public mediaObserver:MediaObserver) {}


  ngOnInit() {
   this.mediaSub=this.mediaObserver.media$.subscribe((result:MediaChange) =>{
  
     console.log(result.mqAlias);
     this.deviceXs = result.mqAlias ==='xs' ? true : false
   })
  }

  ngOnDestroy() {
   this.mediaSub.unsubscribe();
  }
}
