import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-standard-button',
  imports: [],
  templateUrl: './standard-button.component.html',
  styleUrl: './standard-button.component.css',
})
export class StandardButtonComponent {
  @Input() type: string = 'button';
  @Input() disabled: boolean = false;
}
