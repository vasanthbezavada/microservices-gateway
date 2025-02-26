# Microservices Architecture with Spring Boot

## Services and Ports
- **account-service** → Runs on **8085**
- **transaction-service** → Runs on **8086**
- **gateway** → Runs on **8088**

## API Endpoints

### account-service (http://localhost:8085)
- `GET /api/v1/accounts/{accountNumber}/transactions` → Get account and all linked transactions
- `GET /api/v1/accounts/{accountNumber}` → Get account by accountNumber
- `POST /api/v1/accounts/create` → Create a new account

### transaction-service (http://localhost:8086)
- `GET /api/v1/transactions/{accountNumber}` → Get transaction for accountNumber

### gateway (http://localhost:8088)
- `GET /api/v1/accounts` → Routes to **account-service**
- `GET /api/v1/transactions` → Routes to **transaction-service**

## Running the Services
```sh
# Start account-service
cd account-service
mvn spring-boot:run

# Start transaction-service
cd ../transaction-service
mvn spring-boot:run

# Start gateway
cd ../gateway
mvn spring-boot:run
```
