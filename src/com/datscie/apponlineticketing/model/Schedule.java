package com.datscie.apponlineticketing.model;
import java.time.LocalDateTime;

public class Schedule {
    private String scheduleId;
    private Movie movie;
    private Studio studio;
    private LocalDateTime dateTime;
    private Ticket[] tickets;

    public Schedule(String scheduleId, Movie movie, Studio studio, LocalDateTime dateTime) {
        this.scheduleId = scheduleId;
        this.movie = movie;
        this.studio = studio;
        this.dateTime = dateTime;
        this.tickets = new Ticket[studio.getCapacity()];
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Studio getStudio() {
        return studio;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public Seat[] getAvailableSeats() {
        Seat[] availableSeats = new Seat[studio.getCapacity()];
        int index = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null) {
                availableSeats[index] = studio.getSeats()[i];
                index++;
            }
        }
        return availableSeats;
    }
}
