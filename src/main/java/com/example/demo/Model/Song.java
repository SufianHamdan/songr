package com.example.demo.Model;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private float length ;
    private int trackNumber;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public Song(){

    }

    public Song(String title, float length, int trackNumber, Album album) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = album;
    }

    public Song(String title, float length, int trackNumber) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Long getId() {
        return id;
    }

    public Album getAlbum() {
        return album;
    }
}
