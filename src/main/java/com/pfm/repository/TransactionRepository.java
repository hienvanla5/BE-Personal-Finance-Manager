package com.pfm.repository;

import com.pfm.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByWalletId(Long walletId);

    List<Transaction> findByCategoryId(Long categoryId);

    Optional<Transaction> findByIdAndWalletUserId(Long id, Long userId);
}
