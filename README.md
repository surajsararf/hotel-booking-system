# Hotel Booking System

This is a hotel booking system developed using Java, Spring Boot, and Maven.

## Description

This application allows users to book hotels based on location, latitude/longitude within a 5km radius, capacity per room, and number of available rooms. It also provides features like user authentication and JWT token generation for secure access.

## Installation

### Prerequisites

- Java 17 or higher
- Maven
- MySQL 8.0 or higher

### Setup Database
1. Create a database named `hotel_booking_system`
2. Update the database configuration in `application.properties` file
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_booking_system
spring.datasource.username=root
spring.datasource.password=root
```
3. import the data dump from `hotel_booking/db_dumb/db-dump.sql`

### Steps
1. Clone the repository
```bash
git clone https://github.com/surajsararf/hotel-booking-system.git

```
2. Navigate to the project directory

```bash
cd hotel-booking-system
```
3. Build the project
```bash
 mvn clean install
```
4. Run the application
```bash
mvn spring-boot:run
```
### Swagger Url
```url
http://localhost:8089/swagger-ui.html
```

### Postman Collection 2.0
`hotel_booking/hotel booking system.postman_collection.json`

### Postman Documentation
https://documenter.getpostman.com/view/6701564/2sA3QzbUUE


