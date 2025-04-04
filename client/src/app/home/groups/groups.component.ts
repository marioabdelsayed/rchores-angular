import { Component, inject } from '@angular/core';
import { GroupsService } from '../../groups-service/groups.service';
import { Group } from '../../models/models';

@Component({
  selector: 'app-groups',
  imports: [],
  templateUrl: './groups.component.html',
  styleUrl: './groups.component.css',
})
export class GroupsComponent {
  groupsService = inject(GroupsService);
  groups: Group[] = [];

  ngOnInit(): void {
    this.groups = this.groupsService.getGroups();
  }
}
