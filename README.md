# Prisma Project
<img src="image/prisma.png" alt="Prisma" width="500" height="350" position="centre">

## Prisma Website Architecture

Prisma follows a structured architecture based on the Model-View-Controller (MVC) pattern. It includes the following components:

* **Controller Layer**: Handles incoming requests, delegates tasks to the service layer, and returns responses to clients. Each dashboard (admin, author, reader) has its corresponding controllers.

* **Service Layer**: Contains business logic and coordinates tasks between the controller layer and the data access layer (repositories). It encapsulates operations related to users, books, subscriptions, etc.

* **Repository Layer**: Manages database operations such as CRUD operations (Create, Read, Update, Delete). Uses Spring Data JPA to interact with the MySQL database.

* **Model**: Represents entities and DTOs (Data Transfer Objects) used within the application. Includes entities like User, Book, Subscription, etc.

* **View**: Utilizes Thymeleaf templates for rendering HTML pages on the client side. Templates are structured to display data based on user roles and actions.

## Introduction
Prisma is a project designed to provide a platform for readers and authors using the Java framework Spring Boot, connected to a MySQL database. The project also features a dashboard page with three user roles: admin, author, and reader. Each dashboard provides specific features and functionalities tailored to its role.

## Table of Contents
* [Introduction](#introduction)
* [Prerequisites](#prerequisites)
* [Installation](#installation)
* [Usage](#usage)
* [Features](#features)
* [Architecture](#architecture)
* [Contributing](#contributing)
* [Testing](#testing)
* [Deployment](#deployment)
* [FAQ](#faq)
* [License](#license)
* [Acknowledgements](#acknowledgements)
* [Contact](#contact)

## Prerequisites
- **Software**:
  - Java Development Kit (JDK) 8 or later
  - IntelliJ IDEA (I used IntelliJ IDEA for this project)
  - Apache Maven
  - Spring Boot
  - MySQL
  - Apache Tomcat
  - Thymeleaf
  - A text editor or Integrated Development Environment (IDE)

## Installation
1. **Clone the repository**:
    ```bash
    git clone https://github.com/farheenimam/prisma.git
    cd prisma
    ```
2. **Set up the database**:
    - Create a MySQL database named `users`.
    - Create the necessary tables within the `users` database: `author`, `readers`, and `users`.
    - Configure the `application.properties` file with your MySQL database credentials.

3. **Install dependencies**:
    ```bash
    mvn install
    ```
4. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

## Thymeleaf and Tomcat Configuration
* Prisma utilizes Thymeleaf for server-side rendering of HTML templates and Apache Tomcat as the embedded servlet container provided by Spring Boot.

## Usage
1. **Access the application**:
    - Navigate to `http://localhost:9001` in your web browser.
2. **Register a new user** or **log in** with existing credentials.
3. **Use the dashboard**:
    - Admin Dashboard: Manage authors and readers.
    - Author Dashboard: Perform CRUD operations on books and manage subscriptions.
    - Reader Dashboard: View lists of books and authors, find creators, and buy subscriptions.

## Features
* User registration and login, redirects the user to the dashboard according to there assigned roles.
* Three dashboard roles: admin, author, and reader.
* CRUD operations for books in the author dashboard.
* Lists of books and subscriptions for the author dashboard.
* Lists of books and authors for the reader dashboard.
* Find creator feature for the reader dashboard.
* Admin dashboard includes features for managing authors, readers, and adding a new user.

## Architecture

Prisma's architecture is built upon modern web development principles, incorporating:

* **Backend Framework**: Spring Boot provides the foundation for robust backend services.
* **Database**: MySQL is used to persist data, ensuring reliability and scalability.
* **Design Pattern**: Follows a structured MVC (Model-View-Controller) pattern for clear separation of concerns.

### Detailed Architecture
For a more detailed breakdown, please look at the [Prisma Website Architecture](#prisma-website-architecture) section for insights into its MVC implementation, security layers, and more.

## Contributing
1. **Fork the repository**.
2. **Create a new branch**:
    ```bash
    git checkout -b feature-branch
    ```
3. **Commit your changes**:
    ```bash
    git commit -m 'Add new feature'
    ```
4. **Push to the branch**:
    ```bash
    git push origin feature-branch
    ```
5. **Open a pull request**.

## Testing
* Run unit tests:
    ```bash
    mvn test
    ```
* Ensure all tests pass before submitting a pull request.

## FAQ
**Q: What if I encounter a compatibility issue during setup?**
A: Ensure all software versions meet the prerequisites and consult the official documentation for troubleshooting.

**Q: Does the project restrict access?**
A: Since it was my first time on spring boot. I am working on setting up the sessions.

## License
This project is licensed under the MIT License.

## Acknowledgements
* Thanks to all the contributors and third-party libraries used in this project.

## Contact
For any inquiries or issues, please contact [farheenimam.offically@gmail.com].
