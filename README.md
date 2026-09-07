<!-- new -->
# Safaricom M-PESA Android Application (Practical Exam Solution)

A modern, high-performance, enterprise-ready Android application built for Safaricom using **Kotlin 2.x**, **Jetpack Compose (Material 3)**, and **Clean Architecture** principles.

---

## 📱 Features & Screen Flow

The application consists of three main screen components engineered with state hoisting and zero-dependency navigation for optimal runtime performance:

1. **Sign-In Screen (`SignInScreen`)**:
   - Minimalist entry screen featuring a custom-styled action button and brand headers.
   - Vertically centered alignment for adaptive phone displays.

2. **M-PESA Authentication (`MpesaPinScreen`)**:
   - Interactive custom numeric keypad supporting dynamic PIN entries and delete operations.
   - Integrated with asynchronous remote login API calls via coroutines.
   - 1/3 viewport branded header with user profile thumbnail and grey-shaded PIN input section.

3. **Dashboard (`HomeScreen`)**:
   - Personalized user greeting (`Good Morning, UserName`).
   - Balance overview section (Main Balance, Reward Balance, Errif Balance) with privacy masking.
   - Quick Action Grid (2x3 grid) for Safaricom M-PESA services.
   - Virtualized transaction history list built using `LazyColumn` with optimized key recycling.

---

## 🏗️ Architecture & Technology Stack

- **UI Framework**: Jetpack Compose with Material 3 components.
- **Language**: Kotlin 2.x (Idiomatic, functional, coroutine-based concurrency control).
- **Asynchronous Processing**: Kotlin Coroutines & `Dispatchers.IO` thread offloading.
- **Networking**: Ktor Client / HTTP Client with ContentNegotiation and JSON serialization.
- **State Management**: Reactive Unidirectional Data Flow (UDF) powered by Compose runtime state mechanics.
- **Security**: Manifest-level network permission encapsulation (`android.permission.INTERNET`).

---

## 🌐 API Specification

### Authentication Endpoint
- **URL**: `POST https://api.mockfly.dev/mocks/5064738f-5131-4b0a-8909-ca1634e26c27/login`
- **Headers**: `Content-Type: application/json`
- **Body**:
  ```json
  {
    "pin": "1111"
  }
