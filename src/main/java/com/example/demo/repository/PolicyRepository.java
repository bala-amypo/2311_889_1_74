package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    boolean existsByPolicyNumber(String policyNumber); // ✅ ADD
    List<Policy> findByUserId(Long userId);             // ✅ ADD
}
