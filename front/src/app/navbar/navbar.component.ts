import { Component } from '@angular/core';
import { AccountsComponent } from '../accounts/accounts.component';
import { CustomerComponent } from '../customer/customer.component';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CustomerComponent,AccountsComponent],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

}
