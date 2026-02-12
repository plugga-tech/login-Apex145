[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/tvYu0Tjb)

# Elysian

Elysian is a very simplified webshop, that uses spring security for user authentication and also stores the 
user data by using encryption. It allows the user to create a new user and to login in with the newly created user.
<br>
This application was created as part of a school project


## Built with
* **Backend:** Java, Spring Boot
* **Security:** Spring Security
* **Frontend:** Thymeleaf and some Css

## Architecture
* **Config:** Handles Spring Security and also the 3 stores products in the applications database.
* **Controller:** Handles all the HTTP request from all pages the application has.
* **Model:** Handels the creation of the User and Product objects.
* **Repository:** Handels all the communication with the database.
* **Service:** Handels all the business logic, such as validation of the registration of a user.


## Spring security
This application uses Spring Security for password encryption and access to other parts of the application.
The password of the newly create user will be encryptet using BCryptEncoder befor it's sent to the database.
<br>
### Authorization Rules
| Route | Access Level | Description |
| :--- | :--- | :--- |
| `/`, `/registration` | **Public** | Homepage and account creation. |
| `/style.css`, `/images/**` | **Public** | Static assets. |
| `/itemdescription/{id}` | **Public** | Product details (Add to cart button hidden for guests). |
| `/orders` | **Protected** | Requires authenticated session. |
| `/logout` | **Protected** | Logsout user with a redirect to homepage. |

## Requirements
* **Java 17** or higher
* **Database:** I use mamp, but you can use anything that supports an SQL database.

### Installation & Setup

**Clone the repository:**
<br>
https://github.com/plugga-tech/login-Apex145.git

**Database Configuration:**
You need to create a database called logindb, if you don't do this the application will not start.

**Run the application:**
The applications uses tomcats default address which is: http://localhost:8080
