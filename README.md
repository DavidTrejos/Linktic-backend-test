# Linktic-backend-test
Backend solution for Linktic´s technical test, implemented with Java. 

I developed this application using a microservices architecture. The backend was built with Java using Spring Boot, which handles the business logic and RESTful API services for managing reservations. The frontend was developed with React, providing a user-friendly interface for creating, viewing, editing, and deleting reservations. The application interacts with a MySQL database, which stores all reservation data and ensures data integrity.

Instructions to Run the Project Locally
1. Clone the Repository:

Clone the project repository to your local machine using the following command:

bash
git clone <repository-url>

2. Backend Setup:

Navigate to the backend directory:

bash
cd reservation-system-backend

Ensure you have Java 17 and Maven installed.
Update the application.properties file located in src/main/resources with your local MySQL database credentials.
Run the following command to start the backend server:

bash
mvn spring-boot:run

3. Frontend Setup:

Navigate to the frontend directory:

bash
cd ../reservation-system-frontend

Ensure you have Node.js and npm installed.
Install the necessary dependencies:

bash
npm install

Start the frontend application:

bash
npm start

The backend will run on http://localhost:8080.

The application will run by default on http://localhost:3000.
Database Setup:

Ensure MySQL is running on your local machine.
Create a new database for the application:

sql
CREATE DATABASE reservation_system;

The application will automatically create the necessary tables upon running the backend.
Access the Application:

Open your browser and go to http://localhost:3000 to interact with the application.
Note:
Unfortunately, due to time constraints, I was unable to deploy the project to a cloud environment. However, the above instructions will help you run the application locally. I really appreciate the opportunity if you give me the space I can explain the project. Have a wonderful September.
