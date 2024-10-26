A robust, full-featured Customer Relationship Management System built to streamline customer and interaction data management. This project leverages Spring Boot and MySQL for backend services, while the frontend is developed with Angular to provide an interactive and user-friendly interface.

🚀 Features
Customer Management: Add, view, update, and delete customer records.
Interaction Tracking: Record customer interactions with type and description fields.
Role-Based Access Control: Separate dashboards for Admin and Customer roles.
Authentication: JWT-based secure login and registration for Admins and Customers.
Responsive Design: Built with Angular and styled for an intuitive, responsive experience.
🛠️ Tech Stack
Frontend
Angular 18.2.4
HTML5/CSS3 for structure and styling
TypeScript for type-safe development
Bootstrap (CSS Framework)
Backend
Spring Boot for API development
MySQL as the primary database
Eureka Client for microservices communication
Spring Security with JWT for authentication
JWT tokens for secure login and data protection.
Role-based access provides customized access to the Admin and Customer.
Form Validations with Angular to ensure accurate user input.
📜 API Endpoints
Customer Service
Endpoint	Method	Description
/api/customers	GET	Get all customers
/api/customers/{id}	GET	Get customer by ID
/api/customers	POST	Create a new customer
/api/customers/{id}	PUT	Update an existing customer
/api/customers/{id}	DELETE	Delete a customer by ID
Interaction Service
Endpoint	Method	Description
/api/interactions	GET	Get all interactions
/api/interactions/{id}	GET	Get interaction by ID
/api/interactions	POST	Create a new interaction
🖥️ Setup & Installation
Prerequisites
Java 11 or higher
Node.js and Angular CLI
MySQL
Backend Setup
Clone the repository and navigate to the backend folder.
Configure the database connection in application.properties.
Run the backend with:
bash
Copy code
./mvnw spring-boot:run
Frontend Setup
Navigate to the frontend folder.
Install dependencies:
bash
Copy code
npm install
Run the frontend with:
bash
Copy code
ng serve
Access the application at http://localhost:4200.

👤 User Roles
Admin
Access to manage customers and view interactions.
Role-based display and controls.
Customer
Access to personal profile and own interactions.
🧪 Testing
To run tests:

Backend: Run mvn test for unit and integration testing.
Frontend: Use Angular CLI's ng test for component and service tests.
📋 Future Enhancements
Advanced Analytics for customer interaction insights.
Notification System for automated customer follow-ups.
Reports on customer behavior and interaction trends.
