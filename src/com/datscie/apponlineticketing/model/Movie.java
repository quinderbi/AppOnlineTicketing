package com.datscie.apponlineticketing.model;

public class Movie {
    private String movieId;
    private String title;
    private String genre;
    private String director;
    private int duration;


    public Movie(String movieId, String title, String genre, String director, int duration) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.duration = duration;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
