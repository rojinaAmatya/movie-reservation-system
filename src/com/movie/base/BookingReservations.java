package com.movie.base;

import com.movie.base.initialization.*;
import com.movie.base.payment.Payment;
import com.movie.base.payment.PaymentMode;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;


public class BookingReservations {
    static ScreenCapacity screenCapacity = new ScreenCapacity();
    static PaymentMode payment= new PaymentMode();
    static ShowTimings showTimings = new ShowTimings();
    static Movie movie = new Movie ("TENET", "2hrs 30 min", "2020");
    static TicketPrices ticketPrices = new TicketPrices();
    static int screenSize;
    static ScreenRow[][] screenRows;




    //static ShowTimings movieTimes = new ShowTimings();

    public static void main(String[] args) {
        /* variables:
            CAPACITY = 100
            SHOW TIMINGS
            NOW PLAYING
            TICKET PRICES
            PAYMENT METHODS
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the initial size: ");
        screenSize= scanner.nextInt();

        screenCapacity.INIT_CAPACITY = screenSize;

        int rowsColumns = (int) Math.sqrt(screenSize);
        screenRows = new ScreenRow[rowsColumns][rowsColumns];


        //initScreenCapacity(new ScreenCapacity());
        initBookingCounter();
        System.out.println("--WELCOME TO MOVIE.COM--");

        //Display name of the movie
        String movieName = scanner.nextLine();
        System.out.println("Movie Name: " + movieName);
        System.out.println("----------------------------");

        System.out.println("--Enter the number of tickets--");
        String numberOfSeats = scanner.nextLine();
        System.out.println("----------------------------");

        LocalTime[] movieTimesAvailable = showTimings.getMovieTime();
        System.out.println("Available Movie Timings are: " + Arrays.toString(movieTimesAvailable));

        System.out.println("--Pick a time--");
        String pickedTime = scanner.nextLine();
        System.out.println("Your Picked time is: " + pickedTime);
        System.out.println("----------------------------");

        //Display Available Seats
        ScreenRow[][] screenRows = screenCapacity.getScreenRows();
        System.out.print("Screen Rows Available" + Arrays.deepToString(screenRows));

        System.out.println("--Pick a seat--");
        String seatAlloc = scanner.nextLine();
        String[] seats = seatAlloc.split(" ");
        ScreenRow screenRow = new ScreenRow(seats[0].charAt(0),seats[1]);
        System.out.println("Seat selected is: " + screenRow);
        System.out.println("----------------------------");

        //Display Price
        System.out.println("Ticket Price: " + ticketPrices.getTicketPrice());

        //Accept Payment mode
        System.out.println("Enter the payment method: Cash/Card only");
        String paymentMode = scanner.nextLine();

        boolean paymentAccepted = false;
        for(int i= 0; i < 2; i++){
            if(paymentMode.equalsIgnoreCase(payment.getPaymentType()[i].toString())){
                System.out.println("Payment is accepted");
                paymentAccepted= true;
                break;
            }
            else {
                System.out.println("Payment Declined");
            }
        }

        System.out.println("Booking Confirmation Code: " + UUID.randomUUID());

        //Return Confirmation
        System.out.println("Your ticket is confirmed for " + movieName + " at " + pickedTime + " : number of Tickets: " + numberOfSeats);
    }

    //init the screen capacity at 100
    public static void initBookingCounter(){
        //initialization logics
            screenCapacity.setScreenRows(initScreenCapacity(screenCapacity));
            showTimings.setMovieTime(new LocalTime[]{LocalTime.parse("11:00"),LocalTime.parse("12:00"),LocalTime.parse("13:00")});
            ticketPrices.setTicketPrice(BigDecimal.valueOf(6.25));

            Payment[] payments = new Payment[2];
            payments[0]= Payment.CASH;
            payments[1]= Payment.CARD;
            payment.setPaymentType(payments);
    }

        public static ScreenRow[][] initScreenCapacity(ScreenCapacity screenCapacity){

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


