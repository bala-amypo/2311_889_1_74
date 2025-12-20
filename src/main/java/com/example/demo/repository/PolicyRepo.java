package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Policy;

public interface PolicyRepo extends JpaRepository<Policy , Long>{
    
}
public interface PolicyRepo extends JpaRepository<Policy, Long> {

    Optional<Policy> findByPolicyNumber(String policyNumber);
}
