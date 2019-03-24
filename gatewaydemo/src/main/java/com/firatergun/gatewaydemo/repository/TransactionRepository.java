package com.firatergun.gatewaydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firatergun.gatewaydemo.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>, TransactionRepositoryCustom{

}
