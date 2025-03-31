import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { User } from '../../models/models';

@Injectable({ providedIn: 'root' })
export class SignupService {
  private httpClient = inject(HttpClient);
  public signUp(user: User) {
    console.log('hello?')
    this.httpClient.post('http://localhost:8080/api/signup', user).subscribe({
      next: (res) => console.log('Received ', res),
      error: (err) => console.log('oops, received an error', err) 
    });
  }
}
