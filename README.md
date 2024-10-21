<h2>Hello! Welcome to my Codex Utilities pre-qualification test (v1.10).</h2>
<p>This repository contains a program written in Java, with the Gradle build tool module. This means that once downloaded and opened in an IDE, the program will automatically implement the necessary dependencies and will be (almost) ready to work. As for the "Simple Todo List" new users must provide a local address in their PC reassigning variable "filename" in method showMenu() with it in order to persist the tasks between executions. There is an interactive menu with the 6 test question options in the main class. 
<br>Below are screenshots of questions 1 to 6 for demonstration purposes.  
<br>The solution to question number 7 (Entity Relationship Diagram - Simple Order Manager) is available right here in the README, a little further down.  
<br>I hope you like it, I did everything with great dedication and care, thank you! : )</p>

---
><h4>Menu:</h4>

![image](https://github.com/user-attachments/assets/02f7adf5-70c7-4398-a53b-59bf30c4ea60)

---
><h4>1 - CNPJ validator:</h4>

![image](https://github.com/user-attachments/assets/909fd5f1-3b87-42b5-a4ba-46d889d25643)

---
><h4>2 - Test if two rectangles intersect</h4>

![image](https://github.com/user-attachments/assets/429935bf-bcb1-4a85-bd7d-8c20219f2808)

---

><h4>3 - Compute the area of intersection between two rectangles</h4>

![image](https://github.com/user-attachments/assets/b3f519c3-dca2-4914-855f-927e6e32b69d)

---

><h4>4 - Simple Todo List</h4>

![image](https://github.com/user-attachments/assets/ef8bc214-cca5-4d15-bd9f-eb4961d3f85f)

---

><h4>5 - Rest Client - World Clock</h4>

![image](https://github.com/user-attachments/assets/695473c3-00da-48be-80e3-17d3c0aa364b)

---

><h4>6 - Rest Server - World Clock</h4>

![image](https://github.com/user-attachments/assets/9a7b4e4f-70ec-4c51-9bac-a9bcd6e9b1a8)

---

><h4>7 - Simple Order Manager System demo. Here I show how I would use SQL to create tables with basic configuration for the system. There are also some clarifications on how Entities and Relationships work.</h4>

![image](https://github.com/user-attachments/assets/14597d32-521e-4492-9fda-1deec8c536cc)

![image](https://github.com/user-attachments/assets/a0cf3f0f-15a5-450b-8fd1-efce6835fe2d)

![image](https://github.com/user-attachments/assets/0e1091a4-478d-4fe1-9994-ae4f7256bf78)

![image](https://github.com/user-attachments/assets/8a5ab84b-a415-4537-8cec-b9f430822f63)

- We have three main tables / entities:<br>

**Client**: Stores client information. A client places orders.<br>
**Product**: Stores product details. Products are ordered by clients.<br>
**Order**: Stores orders made by clients. Orders are placed by clients, contain one or more products.<br>
**Order_Item**: (Join table between Order and Product) Stores the relationship between orders and products (i.e., which products were ordered, and in what quantity).<br>

- Important:<br>
One **Client** can place many **Orders** (one to many relationship).<br>
One **Order** can contain many **Products**, and one **Product** can belong to many **Orders**(many to many relationship).<br>



