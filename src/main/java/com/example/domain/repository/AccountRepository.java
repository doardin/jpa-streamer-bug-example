package com.example.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
