package com.datscie.apponlineticketing.model.auth;

import com.datscie.apponlineticketing.model.Movie;
import com.datscie.apponlineticketing.model.Schedule;
import com.datscie.apponlineticketing.model.Seat;
import com.datscie.apponlineticketing.model.Studio;

public class Admin extends User {
    public void addMovie() {}

    public void editMovie(String movieID) {}

    public void deleteMovie(String movieID) {}

    public Movie[] getMovies() {
        return new Movie[]{};
    }

    public void addSchedule() {}

    public void editSchedule(String scheduleID) {}

    public void deleteSchedule(String scheduleID) {}

    public Schedule[] getSchedules() {
        return new Schedule[]{};
    }

    public void addStudio() {}

    public void editStudio(String studioID) {}

    public void deleteStudio(String studioID) {}

    public Studio[] getStudios() {
        return new Studio[]{};
    }

    public void addSeat() {}

    public void editSeat(String seatID) {}

    public void deleteSeat(String seatID) {}

    public Seat[] getSeats() {
        return new Seat[]{};
    }

    public void viewReports() {}
}
