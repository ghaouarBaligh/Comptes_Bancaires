import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { routes } from './app.routes';
import { FooterComponent } from './footer/footer.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,NavbarComponent,FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ebank-front';
}
