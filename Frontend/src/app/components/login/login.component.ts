import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm: FormGroup;
  loginError: string | null = null;
 // isLoggedIn=false;
  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      role: ['', [Validators.required]]  // Default role as CUSTOMER
    });
  }

  get username() {
    return this.loginForm.get('username');
  }

  get password() {
    return this.loginForm.get('password');
  }

  onSubmit() {
    if (this.loginForm.valid) {
      const loginData = this.loginForm.value;

      this.authService.login(loginData).subscribe({
        next: (response) => {
          const role = response.role;

          if (role === 'ADMIN') {
            this.router.navigate(['/admindashboard']);
          } else if (role === 'CUSTOMER') {
            this.router.navigate(['/customerdashboard']);
          }

          localStorage.setItem('currentUser', JSON.stringify(response));
        },
        error: (err) => {
          this.loginError = 'Invalid username or password';
        }
      });
    }
  }
}
