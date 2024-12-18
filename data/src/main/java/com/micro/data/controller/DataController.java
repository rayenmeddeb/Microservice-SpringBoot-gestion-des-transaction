package com.micro.data.controller;

import com.micro.data.model.Transaction;
import com.micro.data.model.Location;
import com.micro.data.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
public class DataController {
    private final DataService dataService;

    // Transaction endpoints
    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return dataService.getAllTransactions();
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Integer id) {
        return dataService.getTransactionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/transactions/user/{userId}")
    public List<Transaction> getTransactionsByUserId(@PathVariable Integer userId) {
        return dataService.getTransactionsByUserId(userId);
    }

    @PostMapping("/transactions")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(dataService.createTransaction(transaction));
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<Transaction> updateTransaction(
            @PathVariable Integer id,
            @RequestBody Transaction transaction) {
        return dataService.updateTransaction(id, transaction)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id) {
        return dataService.deleteTransaction(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    // Location endpoints
    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return dataService.getAllLocations();
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Integer id) {
        return dataService.getLocationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/locations")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        return ResponseEntity.ok(dataService.createLocation(location));
    }
}
