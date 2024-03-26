package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TransactionDto;
import com.example.demo.entity.TransactionHistory;
import com.example.demo.service.TransactionService;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transactions")
public class TransactionController {
private final TransactionService transactionService;
@GetMapping
public ResponseEntity<List<TransactionHistory>> getAllTransactions() {
	return ResponseEntity.ok(transactionService.getAllTransactions());
}
@GetMapping("/{id}")
public ResponseEntity<TransactionHistory> getTransactionById(@PathVariable Integer id) {
	return ResponseEntity.ok(transactionService.getTransactionById(id));
}
@GetMapping("/user/{id}")
public ResponseEntity<List<TransactionHistory>> getTransactionByUserId(@PathVariable Integer id) {
	return ResponseEntity.ok(transactionService.getTransactionByUserId(id));
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteTransactionById(@PathVariable Integer id) {
	transactionService.deleteTransactionById(id);
	 return ResponseEntity.noContent().build();
}
@PostMapping
public ResponseEntity<TransactionHistory> createTransaction(@RequestBody TransactionDto transactionDto){
	return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.createTransaction(transactionDto));
}

}
