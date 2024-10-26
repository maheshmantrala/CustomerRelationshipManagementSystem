import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  private apiUrl = 'http://localhost:3000';


  constructor(private http: HttpClient) { }

  // Register method to send registration data to the backend
  login(credentials: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/users`, credentials);
  }

  register(user: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/registrations`, user);
  }

}
