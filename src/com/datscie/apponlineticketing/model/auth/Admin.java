package com.datscie.apponlineticketing.model.auth;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.datscie.apponlineticketing.model.Movie;
import com.datscie.apponlineticketing.model.Schedule;
import com.datscie.apponlineticketing.model.Seat;
import com.datscie.apponlineticketing.model.Studio;
import com.datscie.apponlineticketing.utils.DatabaseMock;

public class Admin extends User {
    public void addMovie() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Movie title: ");
        String title = scanner.nextLine();
        System.out.print("Movie genre: ");
        String genre = scanner.nextLine();
        System.out.print("Director: ");
        String director = scanner.nextLine();
        System.out.println("Duration (in minutes): ");
        int duration = scanner.nextInt();

        scanner.close();

        Movie movie = new Movie("MOV001", title, genre, director, duration);

        DatabaseMock db = DatabaseMock.getInstance();

        db.addMovie(movie);
    }

    public void editMovie() {
        Scanner scanner = new Scanner(System.in);
        Movie movie;

        while (true) {
            System.out.print("Movie ID to edit: ");
            String id = scanner.nextLine();

            movie = DatabaseMock.getInstance().getMovie(id);

            if (movie == null) {
                System.out.println("Movie not found!");
            } else {
                break;
            }
        }

        System.out.print("Movie title (" + movie.getTitle() + "): ");
        String title = scanner.nextLine();

        System.out.print("Movie genre (" + movie.getGenre() + "): ");
        String genre = scanner.nextLine();

        System.out.print("Director (" + movie.getDirector() + "): ");
        String director = scanner.nextLine();

        System.out.println("Duration (in minutes) (" + movie.getDuration() + "): ");
        int duration = scanner.nextInt();

        scanner.close();

        movie.setTitle(title.isEmpty() ? movie.getTitle() : title);
        movie.setGenre(genre.isEmpty() ? movie.getGenre() : genre);
        movie.setDirector(director.isEmpty() ? movie.getDirector() : director);
        movie.setDuration(duration == 0 ? movie.getDuration() : duration);
    }

    public void deleteMovie(String movieID) {
        DatabaseMock db = DatabaseMock.getInstance();
        for (int i = 0; i < db.movies.size(); i++) {
            if (db.movies.get(i).getMovieId().equals(movieID)) {
                db.movies.remove(i);
                break;
            }
        }
        // db.deleteMovie(movieID);
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

    public void addStudio() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Studio ID: ");
        String studioID = scanner.nextLine();
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

    public void addSeat(String studioID) {
        if (studioID == null) {
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seat ID: ");
        String seatID = scanner.nextLine();

        scanner.close();

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
