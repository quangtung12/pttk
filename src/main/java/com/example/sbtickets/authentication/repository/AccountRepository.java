package com.example.sbtickets.authentication.repository;

import com.example.sbtickets.authentication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
