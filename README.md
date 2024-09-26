# School Application - CRUD System

This application is a school management system supporting CRUD (Create, Read, Update, Delete) features to manage data such as students, teachers, and classes. The backend is developed using **Java Spring Boot**, and the frontend is built with React + Vite. MySQL is used as the database to store all application data, with API connections facilitating seamless communication between the backend and frontend.

## Features

The **Student Registration** feature enables the addition of new student data by providing necessary fields such as name, assigned teacher, address, and contact information. The Student Data Management feature allows users to **create**, **view**, **edit**, and **delete** student details, ensuring that records remain accurate and up to date. Additionally, the Dashboard Overview provides a summary of students and other essential information, offering a clear snapshot of key metrics for quick reference.

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

# Student Management API

This API allows you to manage student records with the following operations: create, read, update, and delete (CRUD).

## Base URL
`http://localhost:8089/api/v1`

## Endpoints

### 1. Create Student

- **Method:** `POST`
- **Endpoint:** `/student/save`
  
**Request Body:**
```json
{
    "studentName": "Danny",
    "address": "Jalan Yuk",
    "mobile": "0099",
    "active": "true"
}
```
### 2. Get All Students

- **Method:** `GET`
- **Endpoint:** `/student/getAllStudents`
### 3. Update Students

- **Method:** `PUT`
- **Endpoint:** `/student/update`
  
**Request Body:**
```json
{
    "studentId": 2,
    "studentName": "Dassnny",
    "address": "Jalan Ysssuk",
    "mobile": "0099",
    "active": "true"
}
```
### 4. Delete

- **Method:** `PUT`
- **Endpoint:** `/student/deletestudentid/{id}`

### Documentation
**Create a Student**
![School App - Google Chrome 2024-09-26 13-44-37](https://github.com/user-attachments/assets/3d0fc153-92f3-4f26-a094-5b64f763d65d)


**View a Student**
![image](https://github.com/user-attachments/assets/b8d9fba7-6848-4a43-a7de-bcf09836cf7d)

**Edit/Update a Student**
![School App - Google Chrome 2024-09-26 13-44-37 (1)](https://github.com/user-attachments/assets/8fbab89f-e3f9-4f36-81e8-bad662c27aba)

**Delete a Student**
![School App - Google Chrome 2024-09-26 13-55-19](https://github.com/user-attachments/assets/f0182932-28e1-4c5d-84ad-0bf839591a84)

