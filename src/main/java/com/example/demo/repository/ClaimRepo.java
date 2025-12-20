=package com.example.demo.repository;

import com.example.demo.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClaimRepo extends JpaRepository<Claim, Long> {
    Optional<Claim> findById(Long id);
}
