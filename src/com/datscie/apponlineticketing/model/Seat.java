package com.datscie.apponlineticketing.model;

public class Seat {
    private String seatID;

    public Seat(String seatID) {
        this.seatID = seatID;
    }

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }
}
