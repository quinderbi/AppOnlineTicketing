package com.datscie.apponlineticketing.model.auth;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.datscie.apponlineticketing.model.Movie;
import com.datscie.apponlineticketing.model.Schedule;
import com.datscie.apponlineticketing.model.Seat;
import com.datscie.apponlineticketing.model.Studio;
import com.datscie.apponlineticketing.utils.DatabaseMock;

public class Admin extends User {
    public void addMovie(String title, String genre, String director, int duration) {
        Movie movie = new Movie("MOV001", title, genre, director, duration);

        DatabaseMock db = DatabaseMock.getInstance();
        db.addMovie(movie);
    }

    public void editMovie(Movie movie, String title, String genre, String director, int duration) {
        movie.setTitle(title.isEmpty() ? movie.getTitle() : title);
        movie.setGenre(genre.isEmpty() ? movie.getGenre() : genre);
        movie.setDirector(director.isEmpty() ? movie.getDirector() : director);
        movie.setDuration(duration == 0 ? movie.getDuration() : duration);

        DatabaseMock db = DatabaseMock.getInstance();
        db.editMovie(movie);
    }

    public void deleteMovie(Movie movie) {
        DatabaseMock db = DatabaseMock.getInstance();
        db.deleteMovie(movie.getMovieId());
    }

    public Movie[] getMovies() {
        return DatabaseMock.getInstance().getMovies();
    }

    public void addSchedule(Movie movie, Studio studio) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Schedule ID: ");
        String scheduleID = scanner.nextLine();
        System.out.println("Date: ");
        LocalDateTime date = LocalDateTime.parse(scanner.nextLine());
        
        scanner.close();

        Schedule schedule = new Schedule(scheduleID, movie, studio, date);
        DatabaseMock db = DatabaseMock.getInstance();
        db.addSchedule(schedule);
    }

    public void editSchedule(String scheduleID, Movie movie, Studio studio) {
        DatabaseMock db = DatabaseMock.getInstance();
        for (int i = 0; i < db.schedules.size(); i++) {
            if (db.schedules.get(i).getScheduleId().equals(scheduleID)) {
                db.schedules.get(i).setMovie(movie);
                db.schedules.get(i).setStudio(studio);
                break;
            }
        }
    }

    public void deleteSchedule(String scheduleID) {
        DatabaseMock db = DatabaseMock.getInstance();
        for (int i = 0; i < db.schedules.size(); i++) {
            if (db.schedules.get(i).getScheduleId().equals(scheduleID)) {
                db.schedules.remove(i);
                break;
            }
        }
    }

    public Schedule[] getSchedules() {
        return new Schedule[] {};
    }

    public void addStudio(String studioID) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Studio seats: ");
        Seat[] seats = new Seat[scanner.nextInt()];
        for (int i = 0; i < seats.length; i++) {
            System.out.println("Seat " + (i + 1) + ": ");
            seats[i] = new Seat(scanner.nextLine());
        }

        scanner.close();

        Studio studio = new Studio(studioID, seats);
        DatabaseMock db = DatabaseMock.getInstance();
        db.addStudio(studio);
    }

    public void editStudio(String studioID) {
        Scanner scanner = new Scanner(System.in);

        Seat[] seats = new Seat[scanner.nextInt()];
        for (int i = 0; i < seats.length; i++) {
            System.out.println("Seat " + (i + 1) + ": ");
            seats[i] = new Seat(scanner.nextLine());
        }

        scanner.close();

        Studio studio = new Studio(studioID, seats);
        DatabaseMock db = DatabaseMock.getInstance();
        db.editStudio(studio);
    }

    public void deleteStudio(String studioID) {
        DatabaseMock db = DatabaseMock.getInstance();
        for (int i = 0; i < db.studios.size(); i++) {
            if (db.studios.get(i).getStudioId().equals(studioID)) {
                db.studios.remove(i);
                break;
            }
        }
    }

    public Studio[] getStudios() {
        return new Studio[] {};
    }

    public void addSeat(String seatID, String studioID) {
        if (studioID == null) {
            return;
        }
        Seat seat = new Seat(seatID);
        DatabaseMock db = DatabaseMock.getInstance();
        for (int i = 0; i < db.studios.size(); i++) {
            if (db.studios.get(i).getStudioId().equals(studioID)) {
                db.studios.get(i).addSeat(seat);
                break;
            }
        }
    }

    public void editSeat(String studioID, String seatID) {
        if (studioID == null || seatID == null) {
            return;
        }
        Seat seat = new Seat(seatID);
        DatabaseMock db = DatabaseMock.getInstance();
        for (int i = 0; i < db.studios.size(); i++) {
            if (db.studios.get(i).getStudioId().equals(studioID)) {
                db.studios.get(i).editSeat(seat, i);
                break;
            }
        }
    }

    public void deleteSeat(String studioID, String seatID) {
        if (studioID == null || seatID == null) {
            return;
        }
        Seat seat = new Seat(seatID);
        DatabaseMock db = DatabaseMock.getInstance();
        for (int i = 0; i < db.studios.size(); i++) {
            if (db.studios.get(i).getStudioId().equals(studioID)) {
                db.studios.get(i).removeSeat(seat);
                break;
            }
        }
    }

    public Seat[] getSeats() {
        return new Seat[] {};
    }

    public void viewReports() {}

    @Override
    public boolean login(String email, String password) {
        return email.equals("user@gmail.com") && password.equals("user");
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
