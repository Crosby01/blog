https://roadmap.sh/projects/personal-blog

# blog
My first Springboot based project that is basically an article blog


Here’s a clean, professional **README.md** you can drop straight into your project. It’s written to make your Spring Boot blog look like a real portfolio backend project.

---

# 📘 C's World Blog (Spring Boot Project)

A simple full-stack blog application built with **Spring Boot, Thymeleaf, and JSON-based storage**.
This project demonstrates CRUD operations, MVC architecture, and basic admin functionality.

---

## 🚀 Features

*  Create new articles (Admin)
*  Edit existing articles
*  Delete articles
*  View all articles on homepage
*  Read full article pages
*  Admin dashboard
*  File-based JSON storage (no database required)

---

## 🛠️ Tech Stack

* Java 21
* Spring Boot
* Spring MVC
* Thymeleaf
* Jackson (for JSON handling)
* HTML, CSS

---

## 📁 Project Structure

```
src/main/java/com/example/blog
│
├── controller      # Handles HTTP routes
├── service         # Business logic + JSON handling
├── model           # Article class (data structure)
│
src/main/resources
│
├── templates       # Thymeleaf HTML pages
│   ├── index.html
│   ├── article.html
│   ├── admin/
│       ├── dashboard.html
│       ├── create-article.html
│       ├── edit-article.html
│
├── static          # CSS files
```

---

## ⚙️ How to Run the Project

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
```

### 2. Navigate into project

```bash
cd blog
```

### 3. Run the application

```bash
mvn spring-boot:run
```

### 4. Open in browser

```
http://localhost:8080
```

---

## 🧠 How It Works

* Articles are stored in a **local JSON file**
* Spring Boot reads/writes this file using Jackson
* Thymeleaf renders dynamic pages from controller data
* Admin routes handle creation, editing, and deletion

---

## 🔐 Admin Routes

| Action         | URL                  |
| -------------- | -------------------- |
| Dashboard      | `/admin`             |
| Create Article | `/admin/create`      |
| Edit Article   | `/admin/edit/{id}`   |
| Delete Article | `/admin/delete/{id}` |

---

## 📌 Learning Goals

This project was built to understand:

* Spring Boot MVC architecture
* Routing and controllers
* Template engines (Thymeleaf)
* Basic CRUD operations
* File-based persistence before databases

---

## ⚠️ Notes

* This project uses **JSON file storage (not a database)**
* It is intended for learning backend fundamentals
* Can be upgraded to MySQL/PostgreSQL later

---

## 🚀 Future Improvements

* Add Spring Security (login system)
* Switch JSON storage → MySQL database
* Add REST API version
* Add image upload instead of URL links
* Deploy online (Render / Railway / VPS)

---

## 👨‍💻 Author

Built by **Victor**
Backend learning project focused on Spring Boot fundamentals.

---
