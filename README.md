# School Application - CRUD System

This application is a school management system supporting CRUD (Create, Read, Update, Delete) features to manage data such as students, teachers, and classes. The backend is developed using **Java Spring Boot**, and the frontend is built with **React + Vite**. **MySQL** is used as the database to store all application data.

## Features

1. **Student Registration**  
   Enable adding new student data with necessary fields such as name, address, and contact information.

2. **Student Data Management**  
   Allow viewing, editing, and deleting student details to ensure accurate and up-to-date records.

3. **Dashboard Overview**  
   Display a summary of key school data, including the total number of students, active classes, and other essential information.

4. **Search & Filter**  
   Implement a search and filter feature within the student management system to quickly locate specific students based on criteria like name, address, and contact information.

## Technologies Used

### Backend:
- **Java Spring Boot**: To build the RESTful API that handles application logic and database communication.
- **Spring Data JPA**: For database interactions.
- **Spring Security**: For authentication and authorization features (optional).
- **MySQL**: The database used to store school data.

### Frontend:
- **React**: To build an interactive user interface.
- **Vite**: A modern development tool used to build and run the frontend project.
- **Axios**: To communicate with the backend via API.
- **Tailwind CSS**: For efficient and responsive styling.

## System Requirements

- **Java 17**: v17.0.10
- **Node.js**: v20.11.1
- **MySQL**: v8.0 
- **Maven**: v3.9.9

## Installation and Configuration

### Backend (Spring Boot)
1. Clone this repository:
   ```bash
   git clone https://github.com/dannylukmana/Sekolah-App.git
   cd schoolapplication
2. Create a MySQL database and adjust the configuration in the `application.properties` file:
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/schoolapp
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
3. Run Application 
   ```bash
   mvn spring-boot:run

### Frontend (React + Vite)
4. Navigate to the frontend application:
   ```bash
   cd my-school
5. Install frontend dependencies:
   ```bash
   npm install
6. Instal Axios:
   ```bash
   npm install axios
7. Instal Tailwind CSS:
   ```bash
   npm install -D tailwindcss postcss autoprefixer
8. Run the Frontend : 
   ```bash
   npm run dev
