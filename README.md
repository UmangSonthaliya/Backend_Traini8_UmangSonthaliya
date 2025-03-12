# Training Center API (Spring Boot)

A **Spring Boot** project for managing government-funded **training centers**.  
It allows users to **register training centers** and **fetch registered centers** with filtering options.

---

## 🚀 Features  
✅ Register a new training center  
✅ Fetch all registered centers  
✅ Proper validation & error handling  
✅ Uses Spring Boot & JPA for database interactions  

---

## 🛠 Tech Stack  
- **Backend:** Java, Spring Boot, Spring JPA (Hibernate)  
- **Database:** MySQL/PostgreSQL (can use H2 for testing)  
- **Validation:** Java Bean Validation (JSR-303)  
- **Testing:** JUnit, Mockito _(Not implemented yet)_  

---

## 📂 Project Structure  

📂 src/main/java/com/example/trainingcenter
- **┣ 📂 controller**        // Handles API requests
- **┣ 📂 service**           // Business logic implementation
- **┣ 📂 repository**       // JPA Repository interface
- **┣ 📂 model**             // Entity classes (TrainingCenter, Address)
- **┣ 📂 exception**        // Custom exceptions and handlers

---

## ⚙️ Installation & Setup  

### **1️⃣ Clone the Repository** 
```sh
git clone https://github.com/UmangSonthaliya/Backend_Traini8_UmangSonthaliya.git
cd Backend_Traini8_UmangSonthaliya
```
---


## ⚙️ Configure Database (PostgreSQL)  

Edit `src/main/resources/application.properties`:
properties
```sh
spring.datasource.url=jdbc:postgresql://localhost:5432/traini8
spring.datasource.username=postgres
spring.datasource.password=1234
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
```

---

## 🚀 Build & Run the Project
```
mvn clean install
mvn spring-boot:run
```
---

## 📡 API Endpoints
1️⃣ Register Training Center (POST)
- **📌 URL: /api/training-centers/**
- **📌 Method: POST**
- **📌 Request Body (JSON):**

```sh
{
  "centerName": "Tech Skills Academy",
  "centerCode": "TSK123456789",
  "address": {
    "detailedAddress": "123 Tech Park",
    "city": "Bangalore",
    "state": "Karnataka",
    "pincode": "560001"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot", "Microservices"],
  "contactEmail": "info@techskills.com",
  "contactPhone": "9876543210"
}
```

📌 Validation Errors (400 Bad Request)

```sh
{
  "message": "Center code must be 12 characters long."
}
```
---

## 2️⃣ Get Training Centers (GET)
-**📌 URL: /api/training-centers**
-**📌 Method: GET**
-**📌 Query Parameters (Optional):**


```sh
GET /api/training-centers?city=Bangalore&course=Java
📌 Response (200 OK)
```
```sh
[
  {
    "centerName": "Tech Skills Academy",
    "centerCode": "TSK123456789",
    "address": {
      "city": "Bangalore",
      "state": "Karnataka"
    },
    "coursesOffered": ["Java", "Spring Boot"]
  }
]
```

---
## ❌ Error Handling
-**Error Type	HTTP Status	Example Message**
-**Validation Error	400 Bad Request	"Center code must be 12 characters."**
-**Not Found	404 Not Found	"Training center not found."**
-**Internal Error	500 Internal Server Error	"Unexpected error occurred."**









