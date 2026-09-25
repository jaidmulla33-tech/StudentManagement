# Student Management System

A console-based **Student Management System** built using **Java, JDBC, and MySQL**. The application allows users to manage student records through basic CRUD (Create, Read, Update, Delete) operations via a command-line interface.

The project follows the **DAO (Data Access Object)** design pattern to separate database access logic from application logic.

---

##  Features

- Add a new student
- Display all students
- Update student details
- Delete a student
- Exit the application
- Store student records in a MySQL database
- Connect the Java application to MySQL using JDBC

---

##  Tech Stack

| Technology     | Purpose                                             |
|----------------|------------------------------------------------------|
| **Java**       | Application logic and OOP                            |
| **JDBC**       | Database connectivity                                 |
| **MySQL**      | Database management                                   |
| **Maven**      | Dependency and project management                     |
| **DAO Pattern**| Separating database operations from application logic |

---

##  Project Structure

```
src/main/java/org/example/
├── dao/
│   └── StudentDAO.java     # Handles database operations (Insert, Update, Delete, Retrieve)
├── db/
│   └── CreateDB.java       # Database connection setup
├── model/
│   └── Student.java        # Student entity class
└── Main.java                # Application entry point and console menu
```

### Package Responsibilities

- **`model`** — Contains the `Student.java` entity class representing student information.
- **`dao`** — Contains `StudentDAO.java`, handling insert, update, delete, and retrieve operations.
- **`db`** — Contains `CreateDB.java` database connection and setup logic.
- **`Main.java`** — Entry point of the application; provides the console-based menu.

---

##  Database

The application uses **MySQL** to store student information, with **JDBC** connecting the Java application to the database.

```
Java Application → JDBC → MySQL Database
```

---

##  Getting Started

### Prerequisites

- JDK 8 or later
- MySQL
- Maven
- IntelliJ IDEA (or any Java-compatible IDE)

### 1. Clone the repository

```bash
git clone <https://github.com/jaidmulla33-tech/StudentManagement.git>
cd student-management-jdbc
```

### 2. Configure MySQL

Make sure your MySQL server is running, then create the required database and configure the connection details in `CreateDB.java`.

### 3. Install dependencies

```bash
mvn clean install
```

### 4. Run the application

Open the project in your IDE and run `Main.java`, or use:

```bash
mvn compile exec:java -Dexec.mainClass="org.example.Main"
```

---

##  Application Menu

```
====================================
      STUDENT MANAGEMENT SYSTEM
====================================

1. Add Student
2. Delete Student
3. Update Student
4. Display All Students
5. Exit

Enter your choice:
```

---

##  CRUD Operations

| Operation | Description |
|-----------|-------------|
|  Create | Add a new student record to the database |
|  Read   | Display all student records |
|  Update | Modify details of an existing student |
|  Delete | Remove an existing student record |

---

##  Application Architecture

```
Main.java → Student (model) → StudentDAO → JDBC → MySQL Database
```

The DAO layer isolates database-related operations, keeping the codebase organized and easier to maintain.

---

##  Future Improvements

- [ ] Add input validation
- [ ] Add student search functionality
- [ ] Improve exception handling
- [ ] Add confirmation before deleting a student
- [ ] Add pagination for large datasets
- [ ] Improve console UI
- [ ] Add a GUI using JavaFX or Swing

---

##  Learning Outcomes

Through this project, I practiced and improved my understanding of:

- Java fundamentals & OOP
- JDBC and MySQL database connectivity
- SQL queries and CRUD operations
- DAO design pattern
- Maven project management
- Database-driven application development

---

## 👤 Author

**Jaid Mulla**

## 📄 License

This project was created for learning and educational purposes.
