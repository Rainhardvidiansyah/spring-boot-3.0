package com.table.relationship.service;

import com.table.relationship.entity.TransactionHistory;
import com.table.relationship.entity.TransactionTypes;
import com.table.relationship.entity.User;
import com.table.relationship.entity.UserTransaction;
import com.table.relationship.enumeration.ETYPE;
import com.table.relationship.exception.UserNotFoundException;
import com.table.relationship.repository.HistoryRepository;
import com.table.relationship.utils.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class HistoryServiceTest {

    @Mock
    private HistoryRepository historyRepository;

    @InjectMocks
    private HistoryService historyService;

    @Test
    void createTransaction() { //PASSED
        var user = new User();
        user.setUserName("Rainhard");
        user.setAccountNumber(RandomStringUtils.generateRandomString());
        user.setEmail("email@gmail.com");
        var transaction = new UserTransaction();
        transaction.setId(1L);

        var history = new TransactionHistory();
        history.setUserTransaction(transaction);
        history.setUser(user);

        Mockito.when(historyRepository.save(Mockito.any(TransactionHistory.class))).thenReturn(history);
        var service = historyService.saveHistory(history);
        Mockito.verify(historyRepository, Mockito.times(1)).save(history);
        Assertions.assertNotNull(service);
        Assertions.assertNotNull(service.getUser());
        Assertions.assertNotNull(service.getUserTransaction());
        System.out.println(service.getTimestamp());
        Mockito.verifyNoMoreInteractions(historyRepository);
    }

    @Test
    void getUserTransaction() { //PASSED
        var user = new User();
        user.setUserID(1L);
        user.setUserName("Rainhard");
        var transaction = new UserTransaction();

        var history = new TransactionHistory();
        history.setUserTransaction(transaction);
        history.setUser(user);

        Mockito.when(historyRepository.findTransactionHistoryByUser(user)).thenReturn(new ArrayList<>());
        var service = historyService.getUserTransaction(user);
        Mockito.verify(historyRepository, Mockito.times(1)).findTransactionHistoryByUser(user);
        Assertions.assertNotNull(service);
        List<String> name = service.stream().map(item -> item.getUser().getUserName())
                        .collect(Collectors.toList());
        assertThat(name).isEmpty();
        Mockito.verifyNoMoreInteractions(historyRepository);

    }

    @Test
    void userCannotBeNull() { //PASSED. If user is null then exception will be thrown
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            historyService.userCannotBeNull(null);
        });
    }

    @Test
    void givenUserIsNull(){ //This must throw an exception (UserNotFoundException)
        var service = historyService.getUserTransaction(null);
    }
}