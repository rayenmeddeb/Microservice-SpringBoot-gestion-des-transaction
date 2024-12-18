package com.micro.data.service;

import com.micro.data.model.Transaction;
import com.micro.data.model.Location;
import com.micro.data.repository.TransactionRepository;
import com.micro.data.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DataService {
    private final TransactionRepository transactionRepository;
    private final LocationRepository locationRepository;

    // Transaction methods
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Integer id) {
        return transactionRepository.findById(id);
    }

    public List<Transaction> getTransactionsByUserId(Integer userId) {
        return transactionRepository.findByUserId(userId);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> updateTransaction(Integer id, Transaction transaction) {
        if (transactionRepository.existsById(id)) {
            transaction.setId(id);
            return Optional.of(transactionRepository.save(transaction));
        }
        return Optional.empty();
    }

    public boolean deleteTransaction(Integer id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Location methods
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Optional<Location> getLocationById(Integer id) {
        return locationRepository.findById(id);
    }

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }
}
