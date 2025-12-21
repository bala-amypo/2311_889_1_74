package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Policy;

public interface PolicyRepo extends JpaRepository<Policy, Long> {

    List<Policy> findByUserId(Long userId);

    boolean existsByPolicyNumber(String policyNumber);
}
