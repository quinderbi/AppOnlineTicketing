package com.datscie.apponlineticketing.model.auth;

import com.datscie.apponlineticketing.model.Schedule;
import com.datscie.apponlineticketing.model.Seat;
import com.datscie.apponlineticketing.model.Ticket;

public class User extends Auth {
    private Ticket[] userTickets;

    public Ticket[] getUserTickets() {
        return userTickets;
    }

    public Schedule[] getAvailableSchedules() {
        return new Schedule[]{};
    }

    public void buyTicket(Schedule schedule, Seat seat) {
        
    }
}
