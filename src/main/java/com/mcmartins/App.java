package com.mcmartins;

import com.mcmartins.api.BookingInfo;
import com.mcmartins.impl.BookingRequestImpl;
import com.mcmartins.impl.CSVDataSource;
import com.mcmartins.impl.RoomBooking;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        RoomBooking roomBooking = new RoomBooking(new CSVDataSource("c://largeSet.csv"));
        BookingInfo bookingInfo = roomBooking.create(new BookingRequestImpl(3600));
        System.out.println(bookingInfo);
    }
}