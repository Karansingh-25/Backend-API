package com.moneymanager.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

// @Data from Lombok automatically creates getters, setters, toString, equals, and hashCode.
@Data
// @NoArgsConstructor is needed by JPA to create new instances of the entity.
@NoArgsConstructor
// @Entity marks this class as a JPA entity, mapped to a table named 'transaction'.
@Entity
public class Transaction {

    // Primary Key with Auto-Increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    // Amount, stored as positive/negative based on income/expense.
    private Double amount;

    // Type: "INCOME" or "EXPENSE"
    private String type;

    // Automatically set the date when the transaction is created
    private LocalDateTime date;

    public void setDate(LocalDateTime now) {
    }
}
