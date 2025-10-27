package com.moneymanager.app.repository;

import com.moneymanager.app.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Extends JpaRepository<Entity, ID_Type>
// This gives us: findAll(), save(), findById(), deleteById(), etc.
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // No code needed! Spring handles everything for basic CRUD operations.
}
