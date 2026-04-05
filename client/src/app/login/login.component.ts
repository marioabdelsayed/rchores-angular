import { Component, inject, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { LoginRequest } from '../models/loginRequest';
import { ButtonModule } from 'primeng/button';
import { PasswordModule } from 'primeng/password';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { AuthService } from '../auth-service/auth.service';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule, RouterLink, ButtonModule, PasswordModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  private authService = inject(AuthService);

    form = new FormGroup({
      email: new FormControl<string> ('', [Validators.required, Validators.email]),
      password: new FormControl<string>('', [Validators.required]),
    });

  onSubmit(): void {
    let loginRequest : LoginRequest = {
      email: this.form.controls.email.value ?? '', 
      password: this.form.controls.password.value ?? ''
    }
    this.authService.login(loginRequest);
  }
}
