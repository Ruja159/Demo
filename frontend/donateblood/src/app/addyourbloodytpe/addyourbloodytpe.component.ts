import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { BloodType } from '../bloodType';
import { JwtClientService } from '../jwt-client.service';

@Component({
  selector: 'app-addyourbloodytpe',
  templateUrl: './addyourbloodytpe.component.html',
  styleUrls: ['./addyourbloodytpe.component.css']
})
export class AddyourbloodytpeComponent implements OnInit {

  bloodTypeGroup: FormGroup
  username = localStorage.getItem('userName')

  constructor(private service: JwtClientService) { }

bloodTypes: any;
bloodTypeModel= new BloodType('')



  ngOnInit(){

    this.service.getBloodTypes().subscribe((data:any)=>{
      this.bloodTypes = JSON.parse(data);
    })
  }

  onSubmit(){

    this.service.addBloodType(this.username,this.bloodTypeModel.id)
    .subscribe(
      response => console.log("Success" ,response)
    )
    console.log(this.bloodTypeModel);

  }
}
