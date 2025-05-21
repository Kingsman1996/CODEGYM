package com.example.demo.service;

import com.example.demo.dto.PromotionForm;
import com.example.demo.model.Promotion;
import com.example.demo.repository.PromotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@RequiredArgsConstructor

public class PromotionService {
    private final PromotionRepository promotionRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void validatePromotion(PromotionForm promotionForm) {
        LocalDate start, end;
        try {
            start = LocalDate.parse(promotionForm.getStartTime(), formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Thời gian bắt đầu không đúng định dạng dd/MM/yyyy");
        }

        try {
            end = LocalDate.parse(promotionForm.getEndTime(), formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Thời gian kết thúc không đúng định dạng dd/MM/yyyy");
        }

        if (start.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Thời gian bắt đầu phải lớn hơn hoặc bằng ngày hiện tại");
        }

        if (!end.isAfter(start.plusDays(0))) { // end phải lớn hơn start ít nhất 1 ngày
            throw new IllegalArgumentException("Thời gian kết thúc phải sau thời gian bắt đầu ít nhất 1 ngày");
        }
    }

    public void save(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    public Promotion convertPromotionFormToPromotion(PromotionForm promotionForm) {
        Promotion promotion = new Promotion();
        promotion.setTitle(promotionForm.getTitle());
        promotion.setStartTime(LocalDate.parse(promotionForm.getStartTime(), formatter));
        promotion.setEndTime(LocalDate.parse(promotionForm.getEndTime(), formatter));
        promotion.setDiscount(promotionForm.getDiscount());
        promotion.setDetails(promotionForm.getDetails());
        return promotion;
    }


    public List<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    public void deleteById(Long id) {
        promotionRepository.deleteById(id);
    }
    public List<Promotion> searchPromotions(Double minDiscount, String startTimeStr, String endTimeStr) {
        LocalDate startTime = null;
        LocalDate endTime = null;

        try {
            if (startTimeStr != null && !startTimeStr.isEmpty()) {
                startTime = LocalDate.parse(startTimeStr, formatter);
            }
            if (endTimeStr != null && !endTimeStr.isEmpty()) {
                endTime = LocalDate.parse(endTimeStr, formatter);
            }
        } catch (DateTimeParseException e) {
            // Xử lý lỗi định dạng ngày (bạn có thể throw exception hoặc trả về rỗng)
        }

        if (minDiscount != null && startTime == null && endTime == null) {
            return promotionRepository.findByDiscountGreaterThanEqual(minDiscount);
        }

        if (minDiscount == null && startTime != null && endTime == null) {
            return promotionRepository.findByStartTimeGreaterThanEqual(startTime);
        }

        if (minDiscount == null && startTime == null && endTime != null) {
            return promotionRepository.findByEndTimeLessThanEqual(endTime);
        }

        return promotionRepository.findAll();
    }

}
