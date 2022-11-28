package com.datscie.apponlineticketing.model.auth;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// import javax.xml.crypto.Data;

import com.datscie.apponlineticketing.model.Schedule;
import com.datscie.apponlineticketing.model.Seat;
import com.datscie.apponlineticketing.model.Ticket;
import com.datscie.apponlineticketing.utils.DatabaseMock;

public class User extends Auth {
    private List<Ticket> userTickets;

    public User() {
        this.userTickets = new ArrayList<Ticket>();
    }

    public Ticket[] getUserTickets() {
        return userTickets.toArray(new Ticket[userTickets.size()]);
    }

    public Schedule[] getAvailableSchedules() {
        return DatabaseMock.getInstance().getSchedules();
    }

    public Ticket buyTicket(Schedule schedule, Seat seat) {
        byte[] array = new byte[4];
        new Random().nextBytes(array);
        String id = new String(array, Charset.forName("UTF-8"));
        
        Ticket ticket = new Ticket("TIX-" + id, schedule.getMovie(), schedule.getDateTime(), schedule.getStudio(), seat);
        userTickets.add(ticket);
        schedule.addTicket(ticket);
        return ticket;
    }

    @Override
    public boolean login(String email, String password) {
        User[] users = DatabaseMock.getInstance().getUsers();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                this.setId(user.getId());
                this.setName(user.getName());
                this.setEmail(user.getEmail());
                this.setPhone(user.getPhone());
                this.setPassword(user.getPassword());

                for (Ticket ticket : user.getUserTickets()) {
                    this.userTickets.add(ticket);
                }

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
