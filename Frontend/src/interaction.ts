export interface Interaction {
    customerId: number;
    type: string;
    description: string;
   // date: string; // Add other fields as needed
    firstname?: string; // Optional, populated from customer data
    lastname?: string;  // Optional, populated from customer data
  }
  