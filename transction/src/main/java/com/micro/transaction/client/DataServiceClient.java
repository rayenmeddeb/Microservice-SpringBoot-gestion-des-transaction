package com.micro.transaction.client;

import com.micro.transaction.model.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "DATA-SERVICE")
public interface DataServiceClient {
    @GetMapping("/api/data/transactions")
    List<Transaction> getAllTransactions();
    
    @GetMapping("/api/data/transactions/{id}")
    Transaction getTransactionById(@PathVariable Integer id);
    
    @GetMapping("/api/data/transactions/user/{userId}")
    List<Transaction> getTransactionsByUserId(@PathVariable Integer userId);
}
