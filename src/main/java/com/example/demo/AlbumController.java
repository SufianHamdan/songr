package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;
    private SongRepository songRepository;

    @GetMapping("/")
    String splashPage(){
        return "landingPage";
    }

    @GetMapping("/albums")
    public String albums(Model album){
            Album a = new Album("High Way To hell", "AC/DC", 10, 454545, "https://upload.wikimedia.org/wikipedia/en/a/ac/Acdc_Highway_to_Hell.JPG");
            Album b = new Album("High Way To hell", "AC/DC", 10, 454545, "https://upload.wikimedia.org/wikipedia/en/a/ac/Acdc_Highway_to_Hell.JPG");
            Album c = new Album("High Way To hell", "AC/DC", 10, 454545, "https://upload.wikimedia.org/wikipedia/en/a/ac/Acdc_Highway_to_Hell.JPG");
            Album[] albums = {a, b, c};
            album.addAttribute("albums", albums);
            return "albums";
    }

    @PostMapping("/ablums")
    public String postAlbum(@ModelAttribute Album album, Model model){
        Album albums = albumRepository.save(album);
        model.addAttribute("album", album);
        return "albums";
    }

    @PostMapping("/albums/{id}/songs")
    public ResponseEntity<Album> addAblumSongs(@PathVariable Long id, Long songId){
        Song song = songRepository.findById(songId).orElseThrow();

        Album album = albumRepository.findById(id).orElseThrow();
        album.setSong(song);

        return new ResponseEntity<>(albumRepository.save(album), HttpStatus.OK);
    }

    @GetMapping("albums/{id}")
    public ResponseEntity<Album> getOneAlbum(@PathVariable Long id){
        Album returnedAlbum = albumRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(returnedAlbum, HttpStatus.OK);
    }

}
