package com.example.demo;

import javax.persistence.*;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Album_Title", length=50, nullable=false, unique=true)
    private String title;

    @Column(name="Album_Artist", length=50, nullable=false, unique=true)
    private String artist;

    @Column(name="Album_Song_Count", length=50, nullable=false, unique=true)
    private int songCount;

    @Column(name="Album_Length", length=50, nullable=false, unique=true)
    private float length;

    @Column(name="Album_Image_URL", length=50, nullable=false, unique=true)
    private String imageUrl;

    public Album(String title, String artist, int songCount, float length, String imageUrl) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public Album(){

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
