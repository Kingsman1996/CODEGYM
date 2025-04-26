package com.service;

import com.model.Song;
import com.repo.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    private final SongRepository songRepository;
    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }
    public void save(Song song) {
        songRepository.save(song);
    }
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }
    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }
}
