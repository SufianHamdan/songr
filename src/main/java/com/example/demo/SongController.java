package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class SongController {

    @Autowired
    private SongRepository songRepository;

    @PostMapping("/song")
    public ResponseEntity<Song> createSong(String title, float length, int trackNumber){
        Song savedSong = songRepository.save(new Song(title, length, trackNumber));
        return new ResponseEntity<>(savedSong, HttpStatus.CREATED);
    }

    @GetMapping("/song/{id}")
    public ResponseEntity<Song> getOneAlbum(@PathVariable Long id){
        Song returnedSong = songRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(returnedSong, HttpStatus.OK);
    }
}
