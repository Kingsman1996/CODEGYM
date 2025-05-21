package com.example.demo.repository;

import com.example.demo.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    Optional<Promotion> findByTitle(String title);
    List<Promotion> findByDiscountGreaterThanEqual(Double discount);
    List<Promotion> findByStartTimeGreaterThanEqual(LocalDate startTime);
    List<Promotion> findByEndTimeLessThanEqual(LocalDate endTime);

}
