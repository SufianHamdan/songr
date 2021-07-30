package com.example.demo.Controllers;

import com.example.demo.Model.Album;
import com.example.demo.Repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/")
    String splashPage(){
        return "landingPage";
    }

// previous lab
//    @GetMapping("/albums")
//    public String albums(Model model) {
//        Album a = new Album("High Way To hell", "AC/DC", 10, 454545, "https://upload.wikimedia.org/wikipedia/en/a/ac/Acdc_Highway_to_Hell.JPG");
//        Album b = new Album("High Way To hell", "AC/DC", 10, 454545, "https://upload.wikimedia.org/wikipedia/en/a/ac/Acdc_Highway_to_Hell.JPG");
//        Album c = new Album("High Way To hell", "AC/DC", 10, 454545, "https://upload.wikimedia.org/wikipedia/en/a/ac/Acdc_Highway_to_Hell.JPG");
//            Album[] albums = {a, b, c};
//            model.addAttribute("albums", albums);
//        return "albums";
//    }


    //image url
    // https://upload.wikimedia.org/wikipedia/en/a/ac/Acdc_Highway_to_Hell.JPG
    @GetMapping("/albums")
    public String albums(Model model){

        List<Album> albums = albumRepository.findAll();
        model.addAttribute("albums", albums);
        return "albums";
    }

    @PostMapping("/add/album")
    public RedirectView postAlbum(@RequestParam String title,
                                  @RequestParam String artist,
                                  @RequestParam int songCount,
                                  @RequestParam float length,
                                  @RequestParam String imageUrl
                                  ){
        Album albums = albumRepository.save(new Album(title, artist, songCount, length, imageUrl));
        return new RedirectView("/albums");
    }

    @GetMapping("/albums/{id}/songs")
    public String viewAlbumSongs(@PathVariable Long id, Model model){
        Album album = albumRepository.findById(id).orElseThrow();
        model.addAttribute("songs", album.getSongs());
        model.addAttribute("album", album);
       return "albumsongs";
    }

    @GetMapping("albums/{id}")
    public ResponseEntity<Album> getOneAlbum(@PathVariable Long id){
        Album returnedAlbum = albumRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(returnedAlbum, HttpStatus.OK);
    }

}
