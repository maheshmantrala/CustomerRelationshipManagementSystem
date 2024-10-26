import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private baseUrl = 'http://localhost:8083'; // Adjust based on your backend URL

  constructor(private http: HttpClient) {}

  addCustomer(customer: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/customers/add`, customer);
  }

  addInteraction(interaction: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/interactions/add`, interaction);
  }
}
