import { Component } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-landing',
  imports: [HeaderComponent, LoginComponent],
  templateUrl: './landing.component.html',
  styleUrl: './landing.component.css',
})
export class LandingComponent {}
