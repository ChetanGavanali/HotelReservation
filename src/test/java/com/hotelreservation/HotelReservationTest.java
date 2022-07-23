package com.hotelreservation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 * In this we are creating the test cases. If the hotel is added it will return true.
 */
public class HotelReservationTest {
    @Test
    public void givenHotelDetails_WhenValuesEnteredAreCorrect_ShoulReturnTrue() {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
        hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
        int hotelListSize = hotelReservation.getHotelListSize();
        hotelReservation.printHotelList();
        Assertions.assertEquals(3, hotelListSize);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelName() {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
        String hotelName = hotelReservation.getHotelList().get(0).getHotelName();
        Assertions.assertEquals("Bridgewood", hotelName);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelRating() {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
        int hotelRating = hotelReservation.getHotelList().get(0).getRating();
        Assertions.assertEquals(5, hotelRating);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelWeekdayRegularCustomerCost() {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
        int hotelRegularCustomerCost = (int) hotelReservation.getHotelList().get(0).getWeekdayRegularCustomerCost();
        Assertions.assertEquals(150, hotelRegularCustomerCost);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelWeekendRegularCustomerCost() {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
        int hotelRegularCustomerCost = (int) hotelReservation.getHotelList().get(0).getWeekendRegularCustomerCost();
        Assertions.assertEquals(50, hotelRegularCustomerCost);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelWeekdayRewardCustomerCost() {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
        int hotelRewardCustomerCost = (int) hotelReservation.getHotelList().get(0).getWeekdayRewardCustomerCost();
        hotelReservation.printHotelList();
        Assertions.assertEquals(110, hotelRewardCustomerCost);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelWeekendRewardCustomerCost() {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
        int hotelRegularCustomerCost = (int) hotelReservation.getHotelList().get(0).getWeekendRewardCustomerCost();
        hotelReservation.printHotelList();
        Assertions.assertEquals(50, hotelRegularCustomerCost);
    }

    @Test
    public void givenHotelDetails_shouldReturnCheapestHotel() {

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        ArrayList<Hotel> hotel = hotelReservation.getCheapestHotel(startDate, endDate);
        String hotelName = hotel.get(0).getHotelName() + " " + hotel.get(1).getHotelName();
        Assertions.assertEquals("Lakewood Bridgewood", hotelName);
    }

    @Test
    public void givenHotelDetails_WhenHotelPricesAreSame_shouldReturnHighestRatedHotel() {

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        Hotel hotel = hotelReservation.getCheapestBestRatedHotel(startDate, endDate);
        Assertions.assertEquals("Bridgewood", hotel.getHotelName());
    }

    @Test
    public void givenHotelDetails_shouldReturnHighestRatedHotel() {

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
        hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        Hotel hotel = hotelReservation.getBestRatedHotel(startDate, endDate);
        Assertions.assertEquals("Ridgewood", hotel.getHotelName());
    }
}