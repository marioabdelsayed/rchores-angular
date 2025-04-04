import { Component } from '@angular/core';
import { GroupContainerComponent } from './group-container/group-container.component';
import { GroupsComponent } from './groups/groups.component';

@Component({
  selector: 'app-home',
  imports: [GroupContainerComponent, GroupsComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {}
