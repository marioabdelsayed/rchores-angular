import { Component, inject } from '@angular/core';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

import { RouterLink } from '@angular/router';
import { AuthService } from '../auth-service/auth.service';
import { User } from '../models/models';

@Component({
  selector: 'app-signup',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './signup.component.html',
  standalone: true,
  styleUrl: './signup.component.css',
})
export class SignupComponent {

  authService = inject(AuthService)
  form = new FormGroup({
    firstName: new FormControl<string>('', {
      validators: [Validators.required],
    }),
    lastName: new FormControl<string>('', {
      validators: [Validators.required],
    }),
    email: new FormControl<string>('', {
      validators: [Validators.required, Validators.email],
    }),
    password: new FormControl<string>('', {
      validators: [
        Validators.required,
        Validators.min(8),
        Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$/),
      ],
    }),
    confirmPassword: new FormControl('', {
      validators: [
        Validators.required,
        Validators.min(8),
        Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$/),
      ],
    }),
  });
  get passInvalid() {
    return (
      this.form.controls.password.touched &&
      this.form.controls.password.invalid &&
      this.form.controls.password.dirty
    );
  }

  get confirmPassInvalid() {
    return (
      this.form.controls.confirmPassword.touched &&
      this.form.controls.confirmPassword.invalid &&
      this.form.controls.confirmPassword.dirty
    );
  }

  get emailInvalid() {
    return (
      this.form.controls.email.touched &&
      this.form.controls.email.invalid &&
      this.form.controls.email.dirty
    );
  }

  onSubmit(): void {
    console.log(this.form);

    let user: User = {
      firstName : this.form.controls.firstName.value?? '',
      lastName : this.form.controls.lastName.value??  '',
      email: this.form.controls.email.value ?? '',
      password: this.form.controls.password.value ?? ''
    }

    this.authService.signUp(user)
  }
}
