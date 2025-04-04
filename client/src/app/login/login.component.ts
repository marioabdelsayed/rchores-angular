import { Component, inject, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { PasswordModule } from 'primeng/password';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { AuthService } from '../auth-service/auth.service';
import { LoginRequest } from '../models/loginRequest';
import { FormButtonComponent } from '../shared/form-button/form-button.component';

@Component({
  selector: 'app-login',
  imports: [
    ReactiveFormsModule,
    RouterLink,
    ButtonModule,
    PasswordModule,
    FormButtonComponent,
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  private authService = inject(AuthService);
  private router = inject(Router);
  form = new FormGroup({
    email: new FormControl<string>('', [Validators.required, Validators.email]),
    password: new FormControl<string>('', [Validators.required]),
  });

  onSubmit(): void {
    const loginReq: LoginRequest = {
      email: this.form.controls.email.value ?? '',
      password: this.form.controls.password.value ?? '',
    };
    this.authService.login(loginReq).subscribe({
      next: (res) => {
        console.log('Login Successful', res);
        this.router.navigate(['/home']);
      },
    });
  }
}
