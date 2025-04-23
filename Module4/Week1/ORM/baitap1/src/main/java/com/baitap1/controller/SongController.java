package com.baitap1.controller;

import com.baitap1.model.Song;
import com.baitap1.service.SongDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Controller
public class SongController {
    private final SongDAO songDAO;
    private final ServletContext servletContext;

    @Autowired
    public SongController(SongDAO songDAO, ServletContext servletContext) {
        this.songDAO = songDAO;
        this.servletContext = servletContext;
    }

    @GetMapping("home")
    public String showForm(Model model) {
        model.addAttribute("song", new Song());
        return "home";
    }

    @PostMapping("/upload")
    public String uploadSong(@ModelAttribute("song") Song song,
                             @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();

                String uploadPath = servletContext.getRealPath("/uploads/");

                file.transferTo(new File(uploadPath + File.separator + fileName));

                song.setUrlPath("/uploads/" + fileName);
                songDAO.add(song);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/list";
    }


    @GetMapping("/list")
    public String listSongs(Model model) {
        model.addAttribute("songs", songDAO.getAll());
        return "list";
    }
}
