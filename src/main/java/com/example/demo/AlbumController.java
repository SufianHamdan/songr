package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController {

    @GetMapping("/")
    String splashPage(){
        return "landingPage";
    }

    @GetMapping("/albums")
    String albums(Model album){
            Album a = new Album("High Way To hell", "AC/DC", 10, 454545, "https://upload.wikimedia.org/wikipedia/en/a/ac/Acdc_Highway_to_Hell.JPG");
            Album b = new Album("High Way To hell", "AC/DC", 10, 454545, "https://upload.wikimedia.org/wikipedia/en/a/ac/Acdc_Highway_to_Hell.JPG");
            Album c = new Album("High Way To hell", "AC/DC", 10, 454545, "https://upload.wikimedia.org/wikipedia/en/a/ac/Acdc_Highway_to_Hell.JPG");
            Album[] albums = {a, b, c};
            album.addAttribute("albums", albums);
            return "albums";
    }
}
