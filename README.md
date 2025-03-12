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

## 📹 Demo Video  
<a href="https://www.loom.com/share/4b5bd2432f974578a0bebaab96c4d14c?sid=6f7c51c7-ad47-422e-a378-74b942ed5de6" target="_blank">
    <img src="https://github.com/user-attachments/assets/e84ac74f-0d7b-4450-8001-ee1886c8eb4b" width="400" alt="Watch the Video">
</a>



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
### Database
<img src="https://github.com/user-attachments/assets/b62ac73f-70e3-4a0f-b2d9-4d052277efed" alt="DB Screenshot" width="1200"/>

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
### API (POST BAD REQUEST)
<img src="https://github.com/user-attachments/assets/6a1f1ddc-bb0b-416e-82a8-d8f3ac528772" alt="API Screenshot" width="800"/>

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

### API GET
<img src="https://github.com/user-attachments/assets/34e49265-8467-4663-b621-ba217e052c62" alt="API Screenshot" width="800"/>

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









