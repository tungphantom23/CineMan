package com.cineman.dao;

import com.cineman.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsername(String username);
}
