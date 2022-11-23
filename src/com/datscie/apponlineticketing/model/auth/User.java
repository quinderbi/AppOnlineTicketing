package com.datscie.apponlineticketing.model.auth;

// import javax.xml.crypto.Data;

import com.datscie.apponlineticketing.model.Schedule;
import com.datscie.apponlineticketing.model.Seat;
import com.datscie.apponlineticketing.model.Ticket;
import com.datscie.apponlineticketing.utils.DatabaseMock;

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

    public void buyTicket(Schedule schedule, Seat seat) {
        userTickets[userTickets.length] = new Ticket("TCK001", schedule.getMovie(), schedule.getDateTime(),
                schedule.getStudio(), seat);
    }

    public Ticket buyTicket(String ticketID, Schedule schedule, Seat seat) {
        Ticket ticket = new Ticket(ticketID, schedule.getMovie(), schedule.getDateTime(), schedule.getStudio(), seat);
        userTickets[userTickets.length] = ticket;
        return ticket;
    }

    @Override
    public boolean login(String email, String password) {
        User[] users = (User[]) DatabaseMock.getInstance().getUsers();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                this.setId(user.getId());
                this.setEmail(user.getEmail());
                this.setPhone(user.getPhone());
                this.setPassword(user.getPassword());
                this.userTickets = user.getUserTickets();

                return true;
            }
        }
        
        return false;
    }

    @Override
    public void register(String name, String email, String phone, String password) {
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
        this.setPassword(password);

        DatabaseMock.getInstance().addUser(this);
    }
}
