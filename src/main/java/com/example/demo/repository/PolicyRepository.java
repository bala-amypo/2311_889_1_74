package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    List<Policy> findByUserId(Long userId);

    boolean existsByPolicyNumber(String policyNumber);
}
