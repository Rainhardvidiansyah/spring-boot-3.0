package com.table.relationship.repository;

import com.table.relationship.entity.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<UserTransaction, Long> {
}
