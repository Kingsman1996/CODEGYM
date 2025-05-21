package com.example.demo.controller;

import com.example.demo.dto.PromotionForm;
import com.example.demo.model.Promotion;
import com.example.demo.service.PromotionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class PromotionController {
    private final PromotionService promotionService;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("promotion", new PromotionForm());
        return "add";
    }

    @PostMapping("/add")
    public String addPromotion(@Valid @ModelAttribute("promotion") PromotionForm promotionForm,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "add";
        }

        try {
            promotionService.validatePromotion(promotionForm);
            promotionService.save(promotionService.convertPromotionFormToPromotion(promotionForm));
            return "redirect:/list";
        } catch (IllegalArgumentException e) {
            model.addAttribute("formatError", e.getMessage());
            return "add";
        }
    }

    @GetMapping("/list")
    public String listPromotions(
            @RequestParam(required = false) Double minDiscount,
            @RequestParam(required = false) String startTime,
            @RequestParam(required = false) String endTime,
            Model model) {

        List<Promotion> promotions = promotionService.searchPromotions(minDiscount, startTime, endTime);
        model.addAttribute("promotions", promotions);

        // Để giữ giá trị tìm kiếm trên form
        model.addAttribute("minDiscount", minDiscount);
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);

        return "list";
    }


    @GetMapping("/delete/{id}")
    public String deletePromotion(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            promotionService.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Xóa khuyến mãi thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Xóa khuyến mãi thất bại");
        }
        return "redirect:/list";
    }
}
