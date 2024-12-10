# Event Ticket Booking System

## Overview

The Event Ticket Booking System is a full-stack application designed to manage the booking of event tickets. The backend is developed using Spring Boot and Java, while the frontend is built with Vite and React TypeScript. The application allows users to submit ticket details, start and stop the backend service, and manage the ticket booking process.

## Features

- Submit ticket details including total number of tickets, ticket release rate, customer retrieval rate, and maximum ticket capacity.
- Start and stop the backend service to manage the ticket booking process.
- Multi-threaded backend service to handle ticket release and customer retrieval.

## Technologies Used

- Backend: Spring Boot, Java, JPA, H2 Database
- Frontend: Vite, React, TypeScript, Axios

## Prerequisites

- Java 11 or higher
- Node.js and npm
- Maven
- Vite

## Setup Instructions

### Backend Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/nihilhesara/Full-Stack-Application.git
    cd backend
    ```

2. **Build the project:**

    ```bash
    mvn clean install
    ```

3. **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

    The backend server will start at `http://localhost:8080`.

### Frontend Setup

1. **Navigate to the frontend directory:**

    ```bash
    cd frontend
    ```

2. **Install dependencies:**

    ```bash
    npm install
    ```

3. **Start the frontend server:**

    ```bash
    npm run dev
    ```

    The frontend server will start at `http://localhost:5173`.

## API Endpoints

### Backend Endpoints

- **Submit Ticket Details:** `POST /api/submit`
  - Request Body:
    ```json
    {
      "totalNoTickets": 100,
      "ticketReleaseRate": 10,
      "customerRetrievalRate": 5,
      "maximumTicketCapacity": 200
    }
    ```
- **Start Backend Service:** `POST /api/start`
- **Stop Backend Service:** `POST /api/stop`

### Frontend

The frontend provides a user interface to interact with the backend API. It allows users to submit ticket details and start/stop the backend service.

## Project Structure

### Backend

- **Controller:** Contains the REST controller to handle API requests.
- **Service:** Contains the business logic for managing tickets.
- **Model:** Contains the entity classes representing the database tables.
- **Repository:** Contains the JPA repositories for data access.

### Frontend

- **App.tsx:** The main component containing the form and buttons to interact with the backend.
- **api.ts:** Contains the functions to make API calls to the backend using Axios.
- **App.css:** Contains the styling for the application.

## Running the Application

1. Start the backend server:
   ```bash
   cd backend
   mvn spring-boot:run
