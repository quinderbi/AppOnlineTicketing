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

    public void buyTicket(Schedule schedule, Seat seat) {
        userTickets[userTickets.length] = new Ticket("TCK001", schedule.getMovie(), schedule.getDateTime(),
                schedule.getStudio(), seat);
    }

    @Override
    public boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        scanner.close();

        return email.equals("user@gmail.com") && password.equals("user");
    }

    @Override
    public boolean register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        scanner.close();

        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
        this.setPassword(password);

        return true;
    }
}
