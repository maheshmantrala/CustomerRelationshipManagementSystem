import { Component } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.css'
})
export class AdminDashboardComponent {
  customers: any[] = [];
  interactions: any[] = [];
  customerInteractions: any[] = [];
  activeView: string = '';

  constructor(private adminService: AdminService,private router: Router) {}

  ngOnInit(): void {}

  viewCustomers() {
    this.activeView = 'customers';
    this.adminService.getCustomers().subscribe(data => {
      this.customers = data;
    });
  }

  viewInteractions() {
    this.activeView = 'interactions';
    this.adminService.getInteractions().subscribe(data => {
      this.interactions = data;
    });
  }

  viewCustomerInteractions(customerId:number) {
    this.activeView = 'customerInteractions';
    this.adminService.getCustomerInteractions(customerId).subscribe(data => {
      this.customerInteractions = data;
      console.log(this.customerInteractions)
    });
  }

  deleteCustomer(customerId: number) {
    this.adminService.deleteCustomer(customerId).subscribe(() => {
      this.viewCustomers(); // Refresh the list after deletion
    });
  }
    deleteInteraction(interactionId: number) {
      this.adminService.deleteInteraction(interactionId).subscribe(() => {
      this.viewInteractions();
      });
  
  }
  viewCustomer1Interactions() {
    this.router.navigate(['/customerinteractions']); // Navigates to the customer interactions view
  }
}
