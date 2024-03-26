package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TransactionHistory;

public interface TransactionRepository extends JpaRepository<TransactionHistory, Integer>{
public List<TransactionHistory> findByUserId(Integer id);
}
