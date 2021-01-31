import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-card2',
  templateUrl: './card2.component.html',
  styleUrls: ['./card2.component.css'],
})
export class Card2Component implements OnInit {
  constructor() {}
  showShortDesciption: boolean = true;

  ngOnInit(): void {}

  alterDescriptionText() {
    this.showShortDesciption = !this.showShortDesciption;
  }
}
