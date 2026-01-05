# Parking Lot Management System (Java – LLD)

## 📌 Overview
This project is a console-based Parking Lot Management System designed using
Object-Oriented Principles and Low-Level Design concepts.

It supports vehicle entry, parking spot allocation, ticket generation,
and bill calculation using strategy patterns.

## 🛠 Tech Stack
- Java 17
- Maven
- OOP & SOLID Principles
- Design Patterns (Strategy, Factory)
- In-memory repositories

## 🧩 Features
- Multiple parking floors
- Vehicle-based parking spot allocation
- Entry & exit gates
- Ticket generation with timestamp
- Bill calculation using pricing strategy
- Clean separation of Controller, Service, Repository, and Model layers

## 🧠 Design Patterns Used
- Strategy Pattern (Bill Calculation)
- Factory Pattern (Strategy Selection)
- Repository Pattern

## 🚀 How to Run
1. Clone the repository
2. Open in IntelliJ / Eclipse
3. Run `Client.java`
4. Follow console instructions

## 📌 Sample Flow
- Enter vehicle number
- Choose vehicle type (2 or 4)
- Ticket is generated
- Exit and bill is calculated

## ⚠️ Limitations
- Console-based (no REST APIs yet)
- In-memory storage
- No authentication

## 🔮 Future Enhancements
- Convert to Spring Boot REST APIs
- Add database (MySQL)
- Add unit tests
- Add admin dashboard
