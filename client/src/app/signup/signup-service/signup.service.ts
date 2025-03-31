import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { User } from '../../models/models';

@Injectable({ providedIn: 'root' })
export class SignupService {
  httpClient = inject(HttpClient);
  public signUp(user: User) {
    this.httpClient.post('http://localhost:8080/api/signup', user);
  }
}
