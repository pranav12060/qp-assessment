# Grocery Booking API

### Overview

This project is a Grocery Booking API built using Spring Boot. It provides functionalities for admins to manage grocery items and for users to place orders. The API includes CRUD operations for grocery items and an order management system.

### Features

- Admin Features

  - Add new grocery items
  
  - View all grocery items
  
  - Update grocery item details
  
  - Remove grocery items
  
  - Manage inventory stock levels

- User Features

  - View available grocery items
  
  - Book multiple grocery items in a single order

### Tech Stack

- Backend: Spring Boot, Spring Data JPA, MySQL

- Database: MySQL

- Containerization: Docker, Docker Compose

### Setup and Installation

##### Prerequisites

Ensure you have the following installed:

- Java 17+

- Maven

- Docker & Docker Compose

###### Running Locally

Clone the Repository

```
 git clone <repo-url>
 cd <repo-directory>
```

Run with Docker Compose

```
docker-compose up --build
```

This will start the MySQL database and the Spring Boot application.

##### Running Without Docker

Set up MySQL Database

1. Install MySQL

2. Create a database named grocerydb

3. Configure the database credentials in application.properties

Run the Spring Boot Application
`mvn spring-boot:run`

### API Endpoints

#### Admin Endpoints

Method | Endpoint | Description
------ | -------- | -----------
POST | /api/admin | Add a new grocery item
GET | /api/admin | Get all grocery items
DELETE | /api/admin/{id} | Delete a grocery item by ID
PUT | /api/admin/ | Update grocery item details
PUT | /api/admin/{id} | Update stock for an item

#### User Endpoints

Method | Endpoint | Description
------ | -------- | -----------
GET | /api/user/items | View available grocery items
POST | /api/user/order | Place an order




## Docker Compose Configuration

```
version: '3.8'

services:
  mysql-db:
    image: mysql:8
    container_name: grocery-mysql
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: grocerydb
      MYSQL_USER: groceryuser
      MYSQL_PASSWORD: grocerypass
    ports:
      - "3307:3306"
    networks:
      - grocery-network
    volumes:
      - mysql_data:/var/lib/mysql

  grocery-app:
    build: .
    container_name: grocery-app
    restart: always
    depends_on:
      - mysql-db
    ports:
      - "8080:8080"
    environment:
      DB_HOST: mysql-db
      DB_PORT: 3306
      DB_NAME: grocerydb
      DB_USERNAME: groceryuser
      DB_PASSWORD: grocerypass
      SPRING_JPA_HIBERNATE_DDL_AUTO: update
    networks:
      - grocery-network

volumes:
  mysql_data:

networks:
  grocery-network:
```

#### Contributing

- Fork the repository

- Create a feature branch

- Commit your changes

- Push to the branch

- Submit a Pull Request


## Author

### Pranav Shinde
