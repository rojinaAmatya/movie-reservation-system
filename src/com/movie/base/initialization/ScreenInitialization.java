package com.movie.base.initialization;

public abstract class ScreenInitialization {

    ScreenRow[][] screenRows;
    public  void intiBookingCounter(){
        initScreenCapacity();
    }

    public ScreenRow[][] initScreenCapacity(){

        char row = 'A';
        //row => A1, A2, A3, -----, A10
        //row++ => B1, B2, B3,----, B10

        int rC = (int)Math.sqrt(ScreenCapacity.INIT_CAPACITY);

        for (int i =0; i <  rC; i++){
            for(int j =0; j< rC; j++) {
                screenRows[i][j] = new ScreenRow(row, " " + (j + 1));
            }
            row++;
        }

        return screenRows;
    }


}
