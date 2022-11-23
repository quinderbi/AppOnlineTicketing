package com.datscie.apponlineticketing.model.auth;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Random;
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

    public void addStudio(Seat[] seats) {
        byte[] array = new byte[4];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        Studio studio = new Studio("STD-" + generatedString, seats);
        DatabaseMock db = DatabaseMock.getInstance();
        db.addStudio(studio);
    }

    public void editStudio(Studio studio, String studioID) {
        studio.setStudioId(studioID);
        DatabaseMock db = DatabaseMock.getInstance();
        db.editStudio(studio);
    }

    public void deleteStudio(Studio studio) {
        DatabaseMock db = DatabaseMock.getInstance();
        db.deleteStudio(studio.getStudioId());
    }

    public Studio[] getStudios() {
        return new Studio[] {};
    }

    public void addSeat(Studio studio, Seat seat) {
        DatabaseMock db = DatabaseMock.getInstance();
        studio.addSeat(seat);
        db.editStudio(studio);
    }

    public void deleteSeat(Studio studio, Seat seat) {
        DatabaseMock db = DatabaseMock.getInstance();
        studio.removeSeat(seat);
        db.editStudio(studio);
    }

    public Seat[] getSeats(Studio studio) {
        return studio.getSeats();
    }

    public void viewReports() {
    }

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
