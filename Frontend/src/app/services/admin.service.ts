import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl = 'http://localhost:8083'; 

  constructor(private http: HttpClient) {}

  getCustomers(): Observable<any> {
    return this.http.get(`${this.baseUrl}/customers`);
  }

  getInteractions(): Observable<any> {
    return this.http.get(`${this.baseUrl}/interactions/getall`);
  }

  getCustomerInteractions(customerId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/interactions/interaction/customer/${customerId}`);
  }

  deleteCustomer(customerId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/customers/${customerId}`);
  }
  deleteInteraction(interactionId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/interactions/${interactionId}`);
  }
}
