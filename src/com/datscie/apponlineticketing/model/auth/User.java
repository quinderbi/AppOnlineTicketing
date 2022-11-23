package com.datscie.apponlineticketing.model.auth;

import java.util.Scanner;

import com.datscie.apponlineticketing.model.Schedule;
import com.datscie.apponlineticketing.model.Seat;
import com.datscie.apponlineticketing.model.Ticket;

public class User extends Auth {
    private Ticket[] userTickets;

    public User() {
        this.userTickets = new Ticket[] {};
    }

    public Ticket[] getUserTickets() {
        return userTickets;
    }

    public Schedule[] getAvailableSchedules() {
        return new Schedule[] {};
    }

    // public void buyTicket(Schedule schedule, Seat seat) {
    //     userTickets[userTickets.length] = new Ticket("TCK001", schedule.getMovie(), schedule.getDateTime(),
    //             schedule.getStudio(), seat);
    // }

    public Ticket buyTicket(String ticketID, Schedule schedule, Seat seat) {
        Ticket ticket = new Ticket(ticketID, schedule.getMovie(), schedule.getDateTime(), schedule.getStudio(), seat);
        userTickets[userTickets.length] = ticket;
        return ticket;
    }

    @Override
    public boolean login(String email, String password) {
        return email.equals("user@gmail.com") && password.equals("user");
    }

    @Override
    public boolean register(String name, String email, String phone, String password) {
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
        this.setPassword(password);

        return true;
    }
}
