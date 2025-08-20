# Library Management System

This is a full-stack web application designed to manage the operations of a library. It provides a digital interface for both librarians and users to handle book borrowing, returns, and catalog management.

## 1. Problem Statement

The goal was to create a web-based system to replace manual, paper-based library processes. The application needed to handle multiple functions: managing a catalog of books, tracking user information, and processing book check-ins and check-outs, all through a user-friendly web interface.

## 2. Tech Stack

* **Backend:** Java, JSP, Servlets
* **Database:** MySQL (using JDBC)
* **Frontend:** HTML, CSS
* **Build Tool:** Apache Maven

## 3. Key Features

* **User Authentication:** A secure login system for library staff.
* **Book Management (CRUD):** Full Create, Read, Update, and Delete functionality for the library's book catalog. Librarians can add new books, edit existing entries, and remove books from the system.
* **Issue and Return Books:** An intuitive interface to manage the process of issuing books to users and processing their returns.
* **Dynamic Web Pages:** JavaServer Pages (JSP) are used to dynamically generate web content, such as displaying the current list of all books in the library.

## 4. Challenges and What I Learned

A key challenge was designing the relational database schema to correctly manage the relationships between books and users, especially for tracking issued books. This project was a practical application of my backend skills, from handling HTTP requests with Servlets to connecting to and manipulating a MySQL database with JDBC. It solidified my understanding of building a complete, data-driven web application.
