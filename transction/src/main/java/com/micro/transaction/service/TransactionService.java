package com.micro.transaction.service;

import com.micro.transaction.client.DataServiceClient;
import com.micro.transaction.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final DataServiceClient dataServiceClient;

    public List<Transaction> getAllTransactions() {
        return dataServiceClient.getAllTransactions();
    }

    public Optional<Transaction> getTransactionById(Integer id) {
        try {
            return Optional.of(dataServiceClient.getTransactionById(id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<Transaction> getTransactionsByUserId(Integer userId) {
        return dataServiceClient.getTransactionsByUserId(userId);
    }
}
