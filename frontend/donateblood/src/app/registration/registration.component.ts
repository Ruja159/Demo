import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { forbiddenNameValidator } from '../shared/user-name.validator';
import { PasswordValidator } from '../shared/password.validator';
import { RegistrationServiceService } from '../registration-service.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  registrationForm: FormGroup;

  get userName() {
    return this.registrationForm.get('userName');
  }
  get name() {
    return this.registrationForm.get('name');
  }
  get lastName() {
    return this.registrationForm.get('lastName');
  }

  get email() {
    return this.registrationForm.get('email');
  }

  constructor(private fb: FormBuilder, private registrationService: RegistrationServiceService) {}

  ngOnInit() {
    this.registrationForm = this.fb.group(
      {
        userName: [
          '',
          [
            Validators.required,
            Validators.minLength(4),
            forbiddenNameValidator(/admin/),
            forbiddenNameValidator(/password/),
          ],
        ],
        password: ['', [Validators.minLength(8)],],
        confirmPassword: [''],
        name: ['',[ Validators.required]],
        lastName: ['',[ Validators.required]],
        email: ['',[ Validators.required]],
             },
      { validator: PasswordValidator }
    );
  }
  onSubmit(){
    console.log(this.registrationForm.value);
    this.registrationService.addUser(this.registrationForm.value)
    .subscribe(
      response => console.log('Success', response),
      error => console.error('Error', error)
    )
  }
}
