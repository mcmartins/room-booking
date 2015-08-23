package com.mcmartins.api;

import java.util.List;

/**
 * Defined all the operations for booking resources
 *
 * @author Manuel Martins
 */
public interface Booking {

    /**
     * Creates a new Booking by accepting a BookingRequest
     *
     * @param bookingRequest the booking request
     * @return the BookingInfo object containing the booking details
     */
    BookingInfo create(BookingRequest bookingRequest);

    /**
     * Deletes a Booking by Passing a booking info object
     *
     * @param bookingInfo the BookingInfo object containing the booking details to remove
     */
    void delete(BookingInfo bookingInfo);

    /**
     * Returns the booking info for a specific Resource
     *
     * @param resource the resource to get info
     * @return a list containing all the bookings
     */
    List<BookingInfo> getInfo(Resource resource);

    /**
     * Returns the booking info for a specific Person
     *
     * @param resource the resource to get info
     * @return a list containing all the bookings
     */
    //List<BookingInfo> getInfo(User user);

    /**
     * Returns the booking info for a specific Resource and Person
     *
     * @param resource the resource to get info
     * @return a list containing all the bookings
     */
    //List<BookingInfo> getInfo(Resource resource, User user);
}
