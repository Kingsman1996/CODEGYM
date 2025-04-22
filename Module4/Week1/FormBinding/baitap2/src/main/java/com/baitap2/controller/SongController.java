package com.baitap2.controller;

import com.baitap2.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SongController {
    private static final List<Song> songList = new ArrayList<>();

    @GetMapping("/home")
    public String showForm(Model model) {
        model.addAttribute("song", new Song());
        return "home";
    }

    @PostMapping("/home")
    public String upload(@ModelAttribute Song song,
                         RedirectAttributes redirectAttributes) throws IOException {
        MultipartFile file = song.getFilename();

        if (file == null || file.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Vui lòng chọn một file nhạc.");
            return "redirect:/home";
        }
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || !originalFilename.matches(".*\\.(mp3|wav|ogg|m4p)$")) {
            redirectAttributes.addFlashAttribute("error", "Chỉ chấp nhận .mp3, .wav, .ogg, .m4p");
            return "redirect:/home";
        }

        String uploadDir = "music";
        File destination = new File(uploadDir, originalFilename);
        file.transferTo(destination);
        songList.add(song);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("songs", songList);
        return "list";
    }
}
