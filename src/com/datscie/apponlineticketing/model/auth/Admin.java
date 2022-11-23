package com.datscie.apponlineticketing.model.auth;

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

    public void editMovie(String movieID) {
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
        Scanner scanner = new Scanner(System.in);
        Movie movie;

        while (true) {
            System.out.print("Movie ID to delete: ");
            String id = scanner.nextLine();

            movie = DatabaseMock.getInstance().getMovie(id);

            if (movie == null) {
                System.out.println("Movie not found!");
            } else {
                break;
            }
        }

        scanner.close();

        DatabaseMock.getInstance().deleteMovie(movie.getMovieId());
    }

    public Movie[] getMovies() {
        return DatabaseMock.getInstance().getMovies();
    }

    public void addSchedule() {
    }

    public void editSchedule(String scheduleID) {
    }

    public void deleteSchedule(String scheduleID) {
    }

    public Schedule[] getSchedules() {
        return new Schedule[] {};
    }

    public void addStudio() {
    }

    public void editStudio(String studioID) {
    }

    public void deleteStudio(String studioID) {
    }

    public Studio[] getStudios() {
        return new Studio[] {};
    }

    public void addSeat() {
    }

    public void editSeat(String seatID) {
    }

    public void deleteSeat(String seatID) {
    }

    public Seat[] getSeats() {
        return new Seat[] {};
    }

    public void viewReports() {

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
