package com.movie.base.initialization;

public class ScreenCapacity{
    public static int INIT_CAPACITY = 100; //static because we cannot change the capacity

    int numOfSeatsBooked;
    int numOfSeatsAvailable;

    ScreenRow[][] screenRows;

    public ScreenRow[][] getScreenRows() {
        return screenRows;
    }

    public void setScreenRows(ScreenRow[][] screenRows) {
        this.screenRows = screenRows;
    }

    public int getNumOfSeatsBooked() {
        return numOfSeatsBooked;
    }

    public void setNumOfSeatsBooked(int numOfSeatsBooked) {
        this.numOfSeatsBooked = numOfSeatsBooked;
    }

    public int getNumOfSeatsAvailable() {
        return numOfSeatsAvailable;
    }

    public void setNumOfSeatsAvailable(int numOfSeatsAvailable) {
        this.numOfSeatsAvailable = numOfSeatsAvailable;
    }
}
