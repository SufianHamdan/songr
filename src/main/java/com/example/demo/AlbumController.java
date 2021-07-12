package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

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
}
