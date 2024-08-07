# Bill-Calculation-Engine

## Project Overview

The **Bill-Calculation-Engine** is a web application designed to assist bank administrators with generating and calculating customer bills based on transaction data. This project includes both a user interface (UI) and a REST API that work together to provide accurate billing information.

## Problem Statement

The application provides the following functionalities:

1. **User Interface for Bill Calculation:**
   - Design a screen where the bank admin can enter customer details along with the billing period (Customer ID, Bill Month, Bill Year) and submit the request.

2. **REST API Integration:**
   - On clicking the "Submit" button, a REST API is invoked with the input parameters (Customer ID, Bill Month, Bill Year).
   - The REST API will call a business service to calculate the total bill amount by referencing the `Transaction` and `Product` tables and using the provided input parameters.

3. **Response Handling:**
   - The REST API will respond with the total bill amount and customer name.
   - The response will be displayed on the UI, showing the total bill amount along with Customer ID, Bill Month, and Bill Year.

## Technologies Used

- **Backend:**
  - Java
  - REST Web Service
  - JPA (Java Persistence API)

- **Frontend:**
  - HTML5
  - css
  - JavaScript

- **Database:**
  - Oracle Sql Database.

## Database Schema

### Tables

1. **Customer Table**
   - `CustomerID` (INT, Primary Key)
   - `Name` (VARCHAR(100))
   - `Address` (VARCHAR(255))
   - `Contact` (VARCHAR(50))

2. **Product Table**
   - `ProductCode` (VARCHAR(20), Primary Key)
   - `ProductName` (VARCHAR(100))
   - `UnitPrice` (DECIMAL(10, 2))

3. **Transaction Table**
   - `TransactionID` (INT, Primary Key)
   - `TransactionDate` (DATE)
   - `CustomerID` (INT, Foreign Key)
   - `ProductCode` (VARCHAR(20), Foreign Key)
   - `Quantity` (DECIMAL(10, 2))

### Relationships

- The `Transaction` table has foreign key relationships with the `Customer` and `Product` tables:
  - `CustomerID` in `Transaction` references `CustomerID` in `Customer`
  - `ProductCode` in `Transaction` references `ProductCode` in `Product`

## API Endpoints

1. **GET /api/transactions**
   - **Description:** Calculate the total bill amount for a specific customer and billing period.
   - **Transaction Body:**
     ```json
     {
      "transactionId": 1,
      "transactionDate": "2024-08-03",
      "customer":{
         "customerId": 1,
         "name": "mohit",
         "address": "Baner Square, maharashtra.",
         "contact": "0987654321"
      },
      "product":{
         "productCode": "P001",
         "productName": "ORMB",
         "unitPrice": 500.0
      },
      "quantity": 10.0
      }
     ```

2. **POST /api/products**
   - **Description:** Post the product in the Product table.
   - **Product Body:**
     ```json
     {
      "productCode": "P001",
      "productName": "ORMB",
      "unitPrice": 500.0
     }
     ```
3. **POST /api/transactions**
   - **Description:** Post the transaction in the Transaction table.
   - **Transaction Body:**
     ```json
     {
       "transactionDate": "2024-01-26",
       "customer": {
           "customerId": 13
       },
       "product": {
           "productCode": "P003"
       },
       "quantity": 10
     }
     ```
 

## Setup and Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-repo/bill-calculation-engine.git
