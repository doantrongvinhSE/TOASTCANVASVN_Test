Book Management API

📌 Giới thiệu

Dự án Book Management API là một hệ thống RESTful API sử dụng Spring Boot, giúp quản lý sách với các chức năng CRUD.
Swagger UI được tích hợp để dễ dàng kiểm thử API.

🚀 Hướng dẫn chạy dự án

1️⃣ Yêu cầu hệ thống

Java 17 trở lên

Maven 3.8+

PostgreSQL (hoặc MongoDB nếu sử dụng NoSQL)

2️⃣ Clone source code

git clone https://github.com/doantrongvinhSE/TOASTCANVASVN_Test

3️⃣ Cấu hình môi trường

Cập nhật application.yml:

# Cấu hình server

server.port=9023

# Cấu hình database (ví dụ: PostgreSQL)

spring.datasource.url=jdbc:postgresql://localhost:5432/book_db
spring.datasource.username=your_username
spring.datasource.password=your_password

# Hibernate

dialect=org.hibernate.dialect.PostgreSQLDialect

4️⃣ Build & Run

mvn clean install
mvn spring-boot:run

Ứng dụng sẽ chạy trên http://localhost:9023

📖 Sử dụng Swagger UI

Swagger UI giúp kiểm thử API một cách trực quan.

📌 Truy cập Swagger:

http://localhost:9023/swagger-ui/index.html#/book-controller

📌 Truy cập tài liệu OpenAPI:

http://localhost:9023/v3/api-docs

Các API chính:

GET /api/books - Lấy danh sách sách

GET /api/books/id - Lấy danh sách theo id

POST /api/books - Thêm sách mới

PUT /api/books/{id} - Cập nhật sách

GET /api/books/search - Lấy danh sách theo filter

DELETE /api/books/{id} - Xóa sách

