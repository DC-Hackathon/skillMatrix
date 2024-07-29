import { Component, Input, signal } from '@angular/core';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

export type MenuItems = {
  icon: string;
  label: string;
  route: string;
}

@Component({
  selector: 'app-sidenav',
  standalone: true,
  imports: [MatListModule, MatIconModule, CommonModule, RouterModule],
  templateUrl: './sidenav.component.html',
  styleUrl: './sidenav.component.css'
})
export class SidenavComponent {

  sidenavCollapsed = signal(false);
  @Input() set collapsed(val: boolean){
    this.sidenavCollapsed.set(val)
  };

  menuItems = signal<MenuItems[]>([
    {
      icon: 'dashboard',
      label: 'Skill Master',
      route: 'admin'
    },
    {
      icon: 'comment',
      label: 'Add Product',
      route: 'dashboard'
    },
    {
      icon: 'analytics',
      label: 'Skill Mapping',
      route: 'user'
    }
  ])

}
