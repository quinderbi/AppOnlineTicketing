package com.datscie.apponlineticketing.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private String scheduleId;
    private Movie movie;
    private Studio studio;
    private LocalDateTime dateTime;
    private List<Ticket> tickets;
    private int price;

    public Schedule(String scheduleId, Movie movie, Studio studio, LocalDateTime dateTime, int price) {
        this.scheduleId = scheduleId;
        this.movie = movie;
        this.studio = studio;
        this.dateTime = dateTime;
        this.tickets = new ArrayList<Ticket>();
        this.price = price;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Ticket[] getTickets() {
        return tickets.toArray(new Ticket[tickets.size()]);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public Seat[] getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<Seat>();
        for (Seat seat : studio.getSeats()) {
            boolean isAvailable = true;
            for (Ticket ticket : tickets) {
                if (ticket.getSeat().equals(seat)) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable)
                availableSeats.add(seat);
        }
        return availableSeats.toArray(new Seat[availableSeats.size()]);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
