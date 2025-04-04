import { HttpClient } from '@angular/common/http';
import { inject, Injectable, OnInit } from '@angular/core';
import { Group } from '../models/models';

const groupsList: Group[] = [
  {
    id: 1,
    name: 'Hanover',
    address: '8040 Big Roundtop Rd',
    description: 'Mario, Mena, Jena, and Moms house',
  },
  // {
  //   id: 2,
  //   name: 'Hanover2',
  //   address: '8040 Big Roundtop Rd',
  //   description: 'Mario, Mena, Jena, and Moms house',
  // },
  // {
  //   id: 3,
  //   name: 'Hanover3',
  //   address: '8040 Big Roundtop Rd',
  //   description: 'Mario, Mena, Jena, and Moms house',
  // },
  // {
  //   id: 4,
  //   name: 'Hanover4',
  //   address: '8040 Big Roundtop Rd',
  //   description: 'Mario, Mena, Jena, and Moms house',
  // },
  // {
  //   id: 5,
  //   name: 'Hanover5',
  //   address: '8040 Big Roundtop Rd',
  //   description: 'Mario, Mena, Jena, and Moms house',
  // },
];

@Injectable({ providedIn: 'root' })
export class GroupsService {
  constructor() {
    console.log('HELLOOOOO');
    this.httpClient
      .get('http://localhost:8080/api/memberships/groups', {
        withCredentials: true,
      })
      .subscribe({
        next: (res) => console.log('Received ', res),
        error: (err) =>
          console.log('oops, received an error fetching groups', err),
      });
  }

  private httpClient = inject(HttpClient);
  private groups = groupsList;
  addGroup(group: Group) {
    this.groups.push(group);
  }

  removeGroup(groupId: number) {
    this.groups = this.groups.filter((group) => group.id !== groupId);
  }

  getGroups() {
    return this.groups;
  }

  setGroups(groups: Group[]) {
    this.groups = groups;
  }
}
