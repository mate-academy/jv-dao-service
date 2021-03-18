# HW 03
- Establish connection to Database.
- Create class Client. Records should be stored in your Database.

```java
public class Client { 
    private Long id;
    private String name;
    private BigDecimal amount;
    private String accountNumber;
    private AccountType accountType;
}
```
AccountType
```java
public enum AccountType {
    REGULAR, 
    GOLD, 
    PLATINUM
}
```
- Create `BankSystemDao` and `BankSystemService`, and their implementations. Your system should be able to manage whole client lifecycle: registration, 

DAO methods
```java
- Client register(Client client);
- Optional<Client> find(Long id);
- Optional<Client> findByAccount(String accountNumbet);
- List<Client> getAllByAccountType(AccountType type);
- boolean updateBalance(BigDecimal amount);
- boolean transfer(BigDecimal amount, String toAccount);
- boolean closeAccount(Client client);
```
Service methods
```java
- Client register(Client client);
- Client find(Long id);
- Client findByAccount(String accountNumber);
- List<Client> getAllByAccountType(AccountType type);
- boolean withdrawMoney(BigDecimal ammount); // money withdrawal from account
- boolean replenishBalance(BigDecimal amount); // payment to bank account
- boolean transfer(BigDecimal amount, String toAccount); // money transfer between accounts
- boolean closeAccount(Client client); // delete client from bank database
```
- When client will withdraw cash, replenish balance or transfer money to another account - there will be a fee percentage based no client's account type:
    - 3% - PLATINUM
    - 1% - GOLD
    - 0% - REGULAR
- Test your functionality in `main`.

__You can check yourself using this__ [checklist](https://mate-academy.github.io/jv-program-common-mistakes/java-JDBC/dao-vs-service/dao-vs-service_checklist.html)
