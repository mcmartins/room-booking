package com.mcmartins;

import com.mcmartins.api.BookingInfo;
import com.mcmartins.impl.BookingRequestImpl;
import com.mcmartins.impl.CSVDatasource;
import com.mcmartins.impl.RoomBooking;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("Missing parameters: <csv> <duration>");
        }
        final String file = args[0];
        final int duration = Integer.parseInt(args[1]);
        final RoomBooking roomBooking = new RoomBooking(new CSVDatasource(file));
        final BookingInfo bookingInfo = roomBooking.create(new BookingRequestImpl(duration));
        System.out.println(bookingInfo);
    }
}
