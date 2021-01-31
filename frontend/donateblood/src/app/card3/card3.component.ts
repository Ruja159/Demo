import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-card3',
  templateUrl: './card3.component.html',
  styleUrls: ['./card3.component.css']
})
export class Card3Component implements OnInit {
  showShortDesciption: boolean = true;
  constructor() { }

  ngOnInit(): void {
  }
  alterDescriptionText() {
    this.showShortDesciption = !this.showShortDesciption;
  }
}
