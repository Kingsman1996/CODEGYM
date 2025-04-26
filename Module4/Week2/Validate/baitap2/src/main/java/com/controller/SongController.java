package com.controller;

import com.model.Song;
import com.repo.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongRepository songRepository;
    @Autowired
    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("song", new Song());
        return "form";
    }

    @PostMapping("/save")
    public String saveSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        songRepository.save(song);
        return "redirect:/songs/list";
    }

    @GetMapping("/edit/{id}")
    public String editSong(@PathVariable Long id, Model model) {
        Song song = songRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid song ID"));
        model.addAttribute("song", song);
        return "form";
    }

    @GetMapping("/list")
    public String listSongs(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "list";
    }
}
