import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddyourbloodytpeComponent } from './addyourbloodytpe.component';

describe('AddyourbloodytpeComponent', () => {
  let component: AddyourbloodytpeComponent;
  let fixture: ComponentFixture<AddyourbloodytpeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddyourbloodytpeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddyourbloodytpeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
