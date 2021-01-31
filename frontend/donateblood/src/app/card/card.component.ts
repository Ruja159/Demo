import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  constructor() { }

  showShortDesciption: boolean = true

  ngOnInit(): void {

    
  }
  alterDescriptionText(){
    this.showShortDesciption = !this.showShortDesciption
  }


}
