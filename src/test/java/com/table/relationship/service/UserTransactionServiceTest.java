package com.table.relationship.service;

import com.table.relationship.entity.TransactionTypes;
import com.table.relationship.entity.UserTransaction;
import com.table.relationship.enumeration.ETYPE;
import com.table.relationship.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserTransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private UserTransactionService transactionService;


    @Test
    void createTransaction() {//PASSED. BUT REMEMBER THIS: HISTORY TRANSACTION HAS NOT BEEN FOLLOWED IN THIS METHOD
        List<TransactionTypes> types = new ArrayList<>();
        TransactionTypes DEBIT = new TransactionTypes();
        DEBIT.setTypes(ETYPE.DEBIT);
        types.add(DEBIT);
        Long typesID = 1L;
        var transaction = new UserTransaction();
        transaction.setId(1L);
        transaction.setTransactionTypes(types);

        Mockito.when(transactionRepository.save(Mockito.any(UserTransaction.class))).thenReturn(transaction);
        var Service = transactionService.createTransaction(transaction, typesID);
        //Assertions.assertNotNull(Service);
        Mockito.verify(transactionRepository, Mockito.times(1)).save(transaction);
        Mockito.verifyNoMoreInteractions(transactionRepository);
    }



    @Test
    void givenTransactionTypeIsUnknown_ThenThrowAnError(){
        Assertions.assertThrows(RuntimeException.class, () ->
                transactionService.getTransactionType(null));
    }

    @Test
    void throwExceptionIfArgumentIsNull() {
        Assertions.assertThrows(RuntimeException.class, () ->
                transactionService.exceptionNullIsNotAllowed(null));
    }
}