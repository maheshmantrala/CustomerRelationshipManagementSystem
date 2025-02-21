import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent  {
  constructor(private authService: AuthService, private router: Router) {}
  isLoggedIn = true;


  logout() {
    // Perform logout logic here, e.g., clearing tokens and redirecting
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }
}
