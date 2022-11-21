package com.datscie.apponlineticketing.model;

import java.time.LocalDateTime;

public class Ticket {
    String ticketID;
    Movie movie;
    LocalDateTime dateTime;
    Studio studio;
    Seat seat;

    public Ticket(String ticketID, Movie movie, LocalDateTime dateTime, Studio studio, Seat seat) {
        this.ticketID = ticketID;
        this.movie = movie;
        this.dateTime = dateTime;
        this.studio = studio;
        this.seat = seat;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
