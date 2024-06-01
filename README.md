# Ecommerce Web Application API

## Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Custom Exceptions](#custom-exceptions)
- [Contributing](#contributing)

- [Contact](#contact)

## About the Project

This project aims to deliver a robust backend API for managing e-commerce operations, including product management, order processing, customer management, and more. Built with **Spring Boot**, the API ensures high performance, scalability, and ease of use.

## Features


- **Product Management** (CRUD operations)
- **Order Management**
- **Customer Management**
- **QR Code Generation** for Products
- **API Documentation** with Swagger
- **Custom Exception Handling**

## Technologies Used

- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
- ![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
- **MySQL Database**
- **Lombok**
- **Swagger**
- **Zxing for QR Code Generation**

## Getting Started

To get a local copy up and running, follow these steps.

### Prerequisites

Ensure you have the following installed:
- [Java Development Kit (JDK) 8 or later](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/your-username/ecommerce-web-application-api.git
    ```
2. Navigate to the project directory:
    ```sh
    cd ecommerce-web-application-api
    ```
3. Configure the MySQL database in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your-database
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```
4. Install the dependencies and build the project:
    ```sh
    mvn clean install
    ```

### Usage

Run the application:
```sh
mvn spring-boot:run
