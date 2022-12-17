package com.table.relationship.service;

import com.table.relationship.entity.TransactionTypes;
import com.table.relationship.entity.UserTransaction;
import com.table.relationship.enumeration.ETYPE;
import com.table.relationship.exception.TransactionTypesUnknownException;
import com.table.relationship.repository.TransactionRepository;
import com.table.relationship.repository.TransactionTypesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserTransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionTypesRepository transactionTypesRepository;

    @Transactional
    public UserTransaction createTransaction(UserTransaction userTransaction, Long typesId){
        userTransaction.setTransactionTypes(getTransactionType(typesId));


        return transactionRepository.save(userTransaction);
    }

    public List<TransactionTypes> getTransactionType(Long typesId){
        List<TransactionTypes> typesList = new ArrayList<>();
        if(typesId.equals(1)){
            var TRANSFER =transactionTypesRepository.findTransactionTypeByTypes(ETYPE.TRANSFER);
            typesList.add(TRANSFER.get());
        } else if (typesId.equals(2)) {
            Optional<TransactionTypes> DEBIT = transactionTypesRepository.findTransactionTypeByTypes(ETYPE.DEBIT);
            typesList.add(DEBIT.get());
        }else {
            exceptionNullIsNotAllowed(typesId);
        }
        return typesList;
    }

    public void exceptionNullIsNotAllowed(Long typesId){
        if(typesId == null){
            throw new TransactionTypesUnknownException();
        }
    }





}
