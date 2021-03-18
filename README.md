# HW 03
- Establish connection to Database.
- Create class Client. Records should be stored in your Database.

```java
public class Client { 
    private Long id;
    private String name;
    private BigDecimal amount;
    private String accountNumber;
}
```
- Create `BankSystemDao` and `BankSystemService`, and their implementations.

DAO methods
```java
- Client register(Client client);
- Optional<Client> find(Long id);
- Optional<Client> findByAccount(String accountNumbet);
- List<Client> getAllByAmountRange(BigDecimal from, BigDecimal to);
- boolean updateBalance(BigDecimal amount);
- boolean transfer(BigDecimal amount, String toAccount);
- boolean closeAccount(Client client);
```
Service methods
```java
- Client register(Client client);
- Client find(Long id);
- Client findByAccount(String accountNumber);
- List<Client> getAllByAmountRange(BigDecimal from, BigDecimal to);
- boolean withdrawMoney(BigDecimal ammount); // money withdrawal from account
- boolean replenishBalance(BigDecimal amount); // payment to bank account
- boolean transfer(BigDecimal amount, String toAccount); // money transfer between accounts
- boolean closeAccount(Client client); // delete client from bank database
```
- When client will withdraw cash, replenish balance or transfer money to another account - there will be a fee percentage.
    - 0% - amount is less than 100
    - 1% - amount is between 100 and 5000 inclusively
    - 3% - amount is more than 5000 exclusively
- Test your functionality in `main`.

__You can check yourself using this__ [checklist](https://mate-academy.github.io/jv-program-common-mistakes/java-JDBC/dao-vs-service/dao-vs-service_checklist.html)
