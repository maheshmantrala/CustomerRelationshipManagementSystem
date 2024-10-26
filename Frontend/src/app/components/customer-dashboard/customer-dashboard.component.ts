import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-customer-dashboard',
  templateUrl: './customer-dashboard.component.html',
  styleUrl: './customer-dashboard.component.css'
})
export class CustomerDashboardComponent {
  customerForm: FormGroup;
  interactionForm: FormGroup;
  activeForm: string = 'customer'; 
  successMessage: string = '';
  interactionMessage: string = '';
  submitted = false;
  isLoggedIn=true;
  customerAdded: boolean = false;  


  constructor(private fb: FormBuilder, private customerService: CustomerService) {
    this.customerForm = this.fb.group({
      id: ['', Validators.required],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
    });

    this.interactionForm = this.fb.group({
      customerId: ['', Validators.required],
      type: ['', Validators.required],
      description: ['', Validators.required],
      details: ['', Validators.required], 
    });
  }

  showForm(formName: string) {
    this.activeForm = formName;
    this.successMessage = '';
    this.interactionMessage = '';
  }

  onCustomerSubmit() {
    this.submitted = true;
    if (this.customerForm.valid) {

      this.customerService.addCustomer(this.customerForm.value)
        .subscribe(response => {
          this.successMessage = 'Customer added successfully!';
          this.customerForm.reset();
          this.submitted = false;
          this.customerAdded = true;  
        }, error => {
          console.error('Error adding customer', error);
        });
    }
  }


  onInteractionSubmit() {
    this.submitted = true;
    if (this.interactionForm.valid) {
 
      this.customerService.addInteraction(this.interactionForm.value)
        .subscribe(response => {
          this.interactionMessage = 'Interaction added successfully!';
          this.interactionForm.reset();
          this.submitted = false;
        }, error => {
          console.error('Error adding interaction', error);
        });
    }
  }
}
