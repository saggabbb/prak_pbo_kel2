# Struktur Proyek SetorSampah

## Deskripsi
Aplikasi Spring Boot untuk sistem manajemen pengumpulan sampah dengan fitur poin pengguna.

## Struktur Direktori

```
src/main/java/com/example/setorsampah/
├── SetorsampahApplication.java      # Main application entry point
├── controller/
│   └── UserController.java          # REST API endpoints untuk User
├── model/
│   └── User.java                    # Entity User dengan JPA annotations
├── repository/
│   └── UserRepository.java          # Data access layer
└── service/
    └── UserService.java             # Business logic layer
```

## Layer Architecture

### 1. Controller Layer (UserController)
- Menangani HTTP requests
- REST API endpoints untuk operasi CRUD
- Mapping: `/api/users`

### 2. Service Layer (UserService)
- Business logic
- Validasi data
- Transaksi database

### 3. Repository Layer (UserRepository)
- Data access abstraction
- Query methods

### 4. Model Layer (User)
- Entity JPA
- Lombok annotations untuk boilerplate code

## API Endpoints

| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| POST | `/api/users` | Buat user baru |
| GET | `/api/users` | Dapatkan semua user |
| GET | `/api/users/{id}` | Dapatkan user by ID |
| GET | `/api/users/email/{email}` | Dapatkan user by email |
| PUT | `/api/users/{id}` | Update user |
| DELETE | `/api/users/{id}` | Hapus user |
| PUT | `/api/users/{id}/points` | Tambah poin user |

## Teknologi
- Spring Boot 4.0.6
- Spring Data JPA
- MySQL 8
- Lombok
- Java 21

## Database Setup

```sql
CREATE DATABASE setorsampah;
```

## Menjalankan Aplikasi

```bash
mvn spring-boot:run
```

## Build

```bash
mvn clean package
```
