# BankMangementSys
# Bank Management System

The **Bank Management System** is a simple yet functional console-based application written in Java. It simulates basic banking operations, enabling users to create and manage accounts, perform transactions like deposits and withdrawals, and inquire about account balances. This project is designed to showcase object-oriented programming principles, file handling for persistent data storage, and an intuitive user interface.

## Features

### 1. Account Creation
- Register a new user by providing details such as:
  - **Name**
  - **Account Number**
  - **Age**
  - **Initial Balance**

### 2. Account Operations
- **Deposit Money**: Add funds to an existing account.
- **Withdraw Money**: Deduct funds from an account, ensuring a minimum balance of ₹1000 is maintained.
- **Balance Inquiry**: Display the current balance of an account.

### 3. Account Management
- **Update Customer Details**: Modify existing account information (e.g., Name, Age).
- **Delete an Account**: Remove an account when no longer needed.

### 4. Additional Features
- **Mini Bank Statement**: Generate a summary of account details and recent transactions.

### 5. Data Persistence
- Accounts are stored persistently using Java's file handling capabilities, ensuring data remains available even after the application is closed.

## How It Works

1. The application provides a **menu-driven interface** for easy navigation and interaction.
2. Account details are stored in a serialized file (`accounts.dat`), ensuring secure and persistent storage.
3. The system loads existing account data on startup and saves changes automatically after every operation.

## Technologies Used
- **Java**: Core programming language.
- **Object-Oriented Programming (OOP)**: To implement features like encapsulation, inheritance, and polymorphism.
- **File Handling**: To manage persistent storage of account data.

## Requirements
- **Java Development Kit (JDK)**: Version 8 or above.
- Any IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor with Java support.

## How to Run

1. **Clone the Repository**:
   ```bash
   https://github.com/prashant8920/BankMangementSys.git
   cd bank-management-system
   ```

2. **Compile the Application**:
   ```bash
   javac BankManagementSystem.java
   ```

3. **Run the Application**:
   ```bash
   java BankManagementSystem
   ```

## File Details
- `BankManagementSystem.java`: Main class that runs the application.
- `Account.java`: Represents individual bank accounts.
- `accounts.dat`: Binary file used to store account data persistently.

## Future Enhancements
- Add transaction history for each account.
- Implement user authentication for added security.
- Enhance the UI for better user experience.
- Integrate database support (e.g., MySQL, PostgreSQL).

## Contribution
Contributions are welcome! Please fork the repository, make changes, and submit a pull request.

