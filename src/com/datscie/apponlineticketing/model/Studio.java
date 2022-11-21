package com.datscie.apponlineticketing.model;

public class Studio {
    private String studioId;
    private Seat[] seats;

    public Studio(String studioId, Seat[] seats) {
        this.studioId = studioId;
        this.seats = seats;
    }

    public String getStudioId() {
        return studioId;
    }

    public void setStudioId(String studioId) {
        this.studioId = studioId;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) {
        Seat[] temp = new Seat[seats.length + 1];
        for (int i = 0; i < seats.length; i++) {
            temp[i] = seats[i];
        }
        temp[seats.length] = seat;
        seats = temp;
    }

    public void removeSeat(Seat seat) {
        Seat[] temp = new Seat[seats.length - 1];
        int index = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] != seat) {
                temp[index] = seats[i];
                index++;
            }
        }
        seats = temp;
    }
}
