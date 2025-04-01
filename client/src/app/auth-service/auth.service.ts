import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { User } from '../models/models';
import { LoginRequest } from '../models/loginRequest';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private httpClient = inject(HttpClient);
  public signUp(user: User) {
    console.log('hello?')
    this.httpClient.post('http://localhost:8080/api/auth/signup', user).subscribe({
      next: (res) => console.log('Received ', res),
      error: (err) => console.log('oops, received an error', err) 
    });
  }


  public login(request: LoginRequest){
    console.log("Login");
    this.httpClient.post('http://localhost:8080/api/auth/login', request).subscribe({
      next: (res) => console.log('Received ', res),
      error: (err) => console.log('oops, received an error', err) 
    });

  }
}
