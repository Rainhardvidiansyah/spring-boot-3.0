package com.table.relationship.repository;

import com.table.relationship.entity.TransactionHistory;
import com.table.relationship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<TransactionHistory, Long> {

    List<TransactionHistory> findTransactionHistoryByUser(User user);
}
