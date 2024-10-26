import { Component } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { trigger, transition, style, animate } from '@angular/animations';
import { Interaction } from '../../../interaction';
@Component({
  selector: 'app-customerinteractions',
  templateUrl: './customerinteractions.component.html',
  styleUrl: './customerinteractions.component.css',
  animations: [
    trigger('fadeInAnimation', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate('300ms ease-out', style({ opacity: 1 }))
      ]),
      transition(':leave', [
        animate('300ms ease-in', style({ opacity: 0 }))
      ])
    ])
  ]
})
export class CustomerinteractionsComponent {
  customerInteractions: any[] = [];
  customer: any = {};
  id: number | null = null;
  constructor(private adminService: AdminService) {}
  ngOnInit(): void {
    // Optionally fetch some default data
  }

  // Method to search customer interactions based on customer ID
  searchInteractions(): void {
    if (this.id) {
      this.adminService.getCustomerInteractions(this.id).subscribe((response: any) => {
        // Check if the response structure is valid
        if (response && response.customer) {
          this.customer = response.customer; // Get customer details

          // Ensure interactions is an array before assigning
          if (Array.isArray(response.interactions)) {
            this.customerInteractions = response.interactions; // Get interactions
          } else {
            console.error('Expected interactions to be an array:', response.interactions);
            this.customerInteractions = []; // Reset if not an array
          }
        } else {
          console.error('Unexpected response format:', response);
        }
        console.log(this.customer, this.customerInteractions);
      });
    }
  }
  
}