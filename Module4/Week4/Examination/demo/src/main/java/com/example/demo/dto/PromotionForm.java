package com.example.demo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PromotionForm {
    @NotBlank(message = "Tiêu đề không được để trống")
    private String title;

    @NotBlank(message = "Thời gian bắt đầu không được để trống")
    private String startTime;

    @NotBlank(message = "Thời gian kết thúc không được để trống")
    private String endTime;

    @NotNull(message = "Mức giảm giá không được để trống")
    @DecimalMin(value = "10000.0", message = "Mức giảm giá phải lớn hơn hoặc bằng 10,000")
    private Double discount;

    @NotBlank(message = "Chi tiết không được để trống")
    private String details;
}
