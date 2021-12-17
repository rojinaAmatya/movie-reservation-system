package com.movie.base.initialization;
import java.time.LocalTime;
import java.util.Date;

public class ShowTimings {
    //creating an array for showtimes
     LocalTime[] movieTime; //no static because timings could be changed

    public LocalTime[] getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(LocalTime[] movieTime) {

        this.movieTime = movieTime;
    }
}
