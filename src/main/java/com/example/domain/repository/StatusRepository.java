package com.example.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.entity.Status;

public interface StatusRepository extends JpaRepository<Status, String> {

}
