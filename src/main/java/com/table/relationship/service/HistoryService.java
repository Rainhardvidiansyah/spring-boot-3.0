package com.table.relationship.service;

import com.table.relationship.entity.TransactionHistory;
import com.table.relationship.entity.User;
import com.table.relationship.exception.UserNotFoundException;
import com.table.relationship.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository historyRepository;


    public TransactionHistory saveHistory(TransactionHistory history){
        return historyRepository.save(history);
    }



    /*
    Flow:
    1. User do a transaction.
    2. During doing that, user can choose what transaction he/she wants.
    4. Record that transaction in history. IS THIS TRUE FLOW?
     */

    public List<TransactionHistory> getUserTransaction(User user){
        userCannotBeNull(user);
        return historyRepository.findTransactionHistoryByUser(user);
    }

    public void userCannotBeNull(User user){
        if(user == null){
            throw new UserNotFoundException();
        }
    }


}
