package com.java.dvd_rental.Entity;

import java.time.LocalDate;

import jakarta.persistence.*;
//import java.time.LocalDateTime;

@Entity
@Table(name = "dvds")
public class DVD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Unique identifier for the DVD
    private String title; // Title of the DVD
    private String director; // Director of the DVD

    @Column(name = "is_new")
    private boolean isNew;

    @Column(name = "release_date")
    private LocalDate releaseDate; // Release date of the DVD
    private String genre; // Genre of the DVD
    private String rating; // Rating of the DVD


    // Getters and Setters
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDirector() {
        return director;
    }


    public void setDirector(String director) {
        this.director = director;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
