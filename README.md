# 🔐 Java Authentication System (CLI)

A secure command-line based authentication system built using Java.
This project demonstrates real-world security concepts like password hashing, login validation, and brute-force protection.

---

## 🚀 Features

* ✅ User Registration
* 🔐 Secure Password Hashing (SHA-256)
* 🔑 Login Authentication System
* 🚫 Duplicate Username Protection
* 🔁 Login Attempt Limit (3 Attempts)
* 📂 File-Based Data Storage

---

## 🧠 How It Works

### 🔹 Registration Flow

1. User enters username and password
2. Password is converted into a **SHA-256 hash**
3. Username + hashed password stored in `users.txt`

---

### 🔹 Login Flow

1. User enters credentials
2. Input password is hashed again
3. System compares:

   * Stored hash vs Input hash
4. If matched → Login Successful ✅
5. If not → Error + attempt count ↓

---

### 🔹 Security Implemented

* 🔐 Passwords are never stored in plain text
* ⚠️ Maximum 3 login attempts allowed
* 🚫 Duplicate usernames are blocked

---

## 🛠️ Tech Stack

* **Language:** Java
* **Concepts Used:**

  * File Handling (BufferedReader, FileWriter)
  * Hashing (SHA-256)
  * String Processing
  * CLI Interaction (Scanner)

---

## 📁 Project Structure

```
Authentication_system/
 ├── Login.java
 ├── users.txt (ignored or empty)
 └── README.md
```

---

## ⚙️ How to Run

### 1️⃣ Compile the program

```
javac Login.java
```

### 2️⃣ Run the program

```
java Login
```

---

## 🧪 Sample Output

```
===== AUTH SYSTEM =====
1. Register
2. Login
3. Exit

Enter choice: 1
Enter username: sagar
Enter password: 12345

User Registered ✅
```

---

## ⚠️ Important Notes

* Do not store `users.txt` with real data in public repos
* This is a **learning project**, not production-ready security
* For real systems, use:

  * Salting
  * Database (MySQL / MongoDB)
  * Secure frameworks

---

## 🚀 Future Improvements

* 🧂 Salted Password Hashing
* 💾 Database Integration (SQLite / MySQL)
* 🎨 Improved CLI UI (colors & formatting)
* 🔐 Account Lock System
* 🌐 Web-based Authentication

---

## 👨‍💻 Author

Developed by **Sagar Rathore**

---

## 📢 Notes & Learning Content

If you want:

* 📘 Programming Notes
* 🔐 Cybersecurity Content
* 🚀 Practical Projects

Follow on Instagram 👉 **@Mastercode.sagar**

---

## ⭐ Support

If you found this project helpful:

* ⭐ Star the repo
* 🍴 Fork it
* 📢 Share with others

---
