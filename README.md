# Rental Management System

A lightweight JavaFX desktop application for managing vehicle records, usage logs, and maintenance records. This project was developed as part of a workshop to demonstrate the use of JavaFX, FXML, and basic MVC architecture.

## Project Overview

The Rental Management System allows users to:

- Record and manage vehicle details (make, model, type, year).
- Log vehicle usage (start/end dates and kilometers driven).
- Maintain records of vehicle maintenance (description, cost, date).
- View summaries of the above data in a user-friendly interface.

## Tech Stack

- **Java 23**: Core programming language.
- **JavaFX**: For building the graphical user interface.
- **FXML**: For defining the UI layout.
- **Maven**: For dependency management and build automation.
- **ControlsFX & BootstrapFX**: For additional UI components and styling.

## Project Structure

The project follows a modular structure with clear separation of concerns:

### 1. **Application Entry Point**

- **`RentalManagementApplication.java`**: The main class that initializes and launches the JavaFX application.

### 2. **UI Layout**

- **`main-view.fxml`**: Defines the structure and layout of the user interface. It includes placeholders for input fields, buttons, and summary displays.

### 3. **Controller**

- **`VehicleRecordsController.java`**: Handles user interactions, updates the UI, and manages the flow of data between the UI and the application logic.

### 4. **Models**

- **`VehicleDetails.java`**: Represents vehicle information such as make, model, type, and year.
- **`UsageLogs.java`**: Represents usage logs, including start/end dates and kilometers driven.
- **`MaintenanceRecords.java`**: Represents maintenance records, including description, cost, and date.

## Component Relationships

The application follows a simplified Model-View-Controller (MVC) architecture:

1. **View (UI)**:

   - Defined in `main-view.fxml`.
   - Displays input fields, buttons, and summary areas for user interaction.

2. **Controller**:

   - `VehicleRecordsController.java` acts as the bridge between the UI and the application logic.
   - Handles user actions (e.g., button clicks) and updates the models or the view accordingly.

3. **Models**:
   - Represent the application's data (vehicles, usage logs, maintenance records).
   - The controller interacts with these models to store and retrieve data.

## How to Run the Project

This project can be run directly using IntelliJ IDEA or any other Java IDE with JavaFX support. Simply open the project, ensure the JavaFX libraries are configured, and run the `RentalManagementApplication` class.
