package com.hotelreservation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {

    @Test
    public void test() {

        HotelReservation.addHotel("Lakewood", 110);
        HotelReservation.addHotel("Bridgewood", 160);
        HotelReservation.addHotel("Ridgewood", 220);
        Assertions.assertEquals(3, HotelReservation.countNoOfHotels());
    }
}
