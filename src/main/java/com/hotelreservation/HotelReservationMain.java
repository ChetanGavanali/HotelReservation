package com.hotelreservation;

import java.time.LocalDate;
import java.time.Month;

/**
 * This is a main class.
 * In this we are adding and displaying the hotel details.
 */
public class HotelReservationMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50);
        hotelReservation.addHotel("Ridgewood", 5, 220, 150);

        hotelReservation.displayHotel();


        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        Hotel hotelName = hotelReservation.getCheapestBestRatedHotel(startDate, endDate);
        System.out.println("The best rated hotel is : \n " + hotelName);
    }
}