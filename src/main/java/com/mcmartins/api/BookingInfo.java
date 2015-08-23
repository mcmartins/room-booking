package com.mcmartins.api;

import java.time.LocalDateTime;

/**
 * A BookingInfo object holds all the information related to a booking
 *
 * @author Manuel Martins
 */
public interface BookingInfo {

    /**
     * Returns the booking unique id
     *
     * @return bookingId
     */
    int getBookingId();

    /**
     * Returns the Resource booked
     *
     * @return reourceId
     */
    Resource getResource();

    /**
     * Returns the booker
     *
     * @return user
     */
    User getUser();

    /**
     * Returns the start date
     *
     * @return startDate
     */
    LocalDateTime getStartTime();

    /**
     * Returns the end date
     *
     * @return endDate
     */
    LocalDateTime getEndTime();
}
