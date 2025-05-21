package com.example.demo.repository;

import com.example.demo.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    List<Promotion> findByDiscountGreaterThanEqual(Double discount);
    List<Promotion> findByStartTimeGreaterThanEqual(LocalDate startTime);
    List<Promotion> findByEndTimeLessThanEqual(LocalDate endTime);

    List<Promotion> findByDiscountGreaterThanEqualAndStartTimeGreaterThanEqual(Double discount, LocalDate startTime);
    List<Promotion> findByDiscountGreaterThanEqualAndEndTimeLessThanEqual(Double discount, LocalDate endTime);
    List<Promotion> findByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(LocalDate startTime, LocalDate endTime);

    List<Promotion> findByDiscountGreaterThanEqualAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(Double discount, LocalDate startTime, LocalDate endTime);


}
