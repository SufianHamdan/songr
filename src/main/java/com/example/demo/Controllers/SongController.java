package com.example.demo.Controllers;

import com.example.demo.Model.Album;
import com.example.demo.Repositories.AlbumRepository;
import com.example.demo.Model.Song;
import com.example.demo.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @PostMapping("/addSong")
    public RedirectView addNewSong(String title , float length, int trackNumber , Long id){
        Album album = albumRepository.findById(id).orElseThrow();
        Song song = new Song(title,length,trackNumber,album);
        songRepository.save(song);

        return new RedirectView("/albums/"+id+"/songs");
    }

    @GetMapping("/songs")
    public String getAllSongs(Model model){

        model.addAttribute("songs", songRepository.findAll());
        return "songs";
    }
}
