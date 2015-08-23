package com.mcmartins.impl;

import com.mcmartins.api.BookingInfo;
import com.mcmartins.api.BookingRequest;
import com.mcmartins.api.Resource;
import com.mcmartins.api.Datasource;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Booking implementation class for Rooms
 *
 * @author Manuel Martins
 */
public class RoomBooking implements com.mcmartins.api.Booking {

    private final Map<Resource, List<BookingInfo>> bookings;
    //private final LocalDateTime initialDateTime = LocalDateTime.parse("2015-04-01T00:00:00Z");

    public RoomBooking(Datasource datasource) {
        this.bookings = datasource.read();
    }

    public RoomBooking(Map<Resource, List<BookingInfo>> bookings) {
        this.bookings = bookings;
    }

    /**
     * {@inheritDoc}
     */
    public List<BookingInfo> getInfo(Resource resource) {
        return this.bookings.get(resource);
    }

    /**
     * {@inheritDoc}
     */
    public BookingInfo create(final BookingRequest bookingRequest) {

        BookingInfo bookingInfo = null;
        LocalDateTime lastPicketDate = LocalDateTime.MAX;
        // we need to go through all the rooms and check which room is available the soone possible
        for (Map.Entry<Resource, List<BookingInfo>> entry : this.bookings.entrySet()) {
            final Iterator<BookingInfo> bookingInfoIterator = entry.getValue().listIterator();
            final BookingInfo previousBooking = bookingInfoIterator.next();
            while (bookingInfoIterator.hasNext()) {
                final BookingInfo currentBooking = bookingInfoIterator.next();
                final long freeBetweenBookings =
                        Duration.between(previousBooking.getEndTime(), currentBooking.getStartTime()).toMillis() * 1000;
                final LocalDateTime currentPickedDate = previousBooking.getEndTime();
                if (freeBetweenBookings > bookingRequest.getDuration() && currentPickedDate.isBefore(lastPicketDate)) {
                    lastPicketDate = currentPickedDate;
                    bookingInfo = new BookingInfoImpl(BookingInfoImpl.bookingIdGenerator, entry.getKey(),
                            new Person("Anonymous"), currentPickedDate,
                            previousBooking.getEndTime().plusSeconds(bookingRequest.getDuration()));
                }
            }
        }

        if (bookingInfo != null) {
            this.bookings.get(bookingInfo.getResource()).add(bookingInfo);
        }

        return bookingInfo;
    }

    /**
     * {@inheritDoc}
     */
    public void delete(BookingInfo bookingInfo) {
        this.bookings.get(bookingInfo.getResource()).remove(bookingInfo);
    }
}
