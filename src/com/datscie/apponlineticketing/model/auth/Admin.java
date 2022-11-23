package com.datscie.apponlineticketing.model.auth;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Random;

import com.datscie.apponlineticketing.model.Movie;
import com.datscie.apponlineticketing.model.Schedule;
import com.datscie.apponlineticketing.model.Seat;
import com.datscie.apponlineticketing.model.Studio;
import com.datscie.apponlineticketing.utils.DatabaseMock;

public class Admin extends User {
    public void addMovie(String title, String genre, String director, int duration) {
        byte[] array = new byte[4];
        new Random().nextBytes(array);
        String id = new String(array, Charset.forName("UTF-8"));
        
        Movie movie = new Movie("MOV-" + id, title, genre, director, duration);

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

    public void addSchedule(Movie movie, Studio studio, LocalDateTime dateTime, int price) {
        byte[] array = new byte[4];
        new Random().nextBytes(array);
        String id = new String(array, Charset.forName("UTF-8"));
        
        Schedule schedule = new Schedule("SCH-" + id, movie, studio, dateTime, price);
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
        return DatabaseMock.getInstance().getSchedules();
    }

    public void addStudio(Seat[] seats) {
        byte[] array = new byte[4];
        new Random().nextBytes(array);
        String id = new String(array, Charset.forName("UTF-8"));

        Studio studio = new Studio("STD-" + id, seats);
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
        DatabaseMock db = DatabaseMock.getInstance();
        int totalRevenue = 0;

        for (Schedule schedule : db.getSchedules()) {
            
        }
    }

    @Override
    public boolean login(String email, String password) {
        Admin[] admins = DatabaseMock.getInstance().getAdmins();

        for (Admin admin : admins) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                this.setId(admin.getId());
                this.setEmail(admin.getEmail());
                this.setPhone(admin.getPhone());
                this.setPassword(admin.getPassword());

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
        DatabaseMock.getInstance().addAdmin(this);
    }
}
