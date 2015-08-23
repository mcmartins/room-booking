package com.mcmartins.impl;

import com.mcmartins.api.BookingInfo;
import com.mcmartins.api.Resource;
import com.mcmartins.api.User;

import java.time.LocalDateTime;

/**
 * BookingInfo implementation class
 *
 * @author Manuel Martins
 */
public class BookingInfoImpl implements BookingInfo {

    public static int bookingIdGenerator = 0;
    private int bookingId;
    private Resource resource;
    private User user;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public BookingInfoImpl(final int bookingId, final Resource resource,
                           final User user, final LocalDateTime startTime, final LocalDateTime endTime) {
        this.bookingId = bookingId;
        this.resource = resource;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        bookingIdGenerator = bookingId + 1;
    }

    /**
     * {@inheritDoc}
     */
    public int getBookingId() {
        return this.bookingId;
    }

    /**
     * {@inheritDoc}
     */
    public Resource getResource() {
        return this.resource;
    }

    /**
     * {@inheritDoc}
     */
    public User getUser() {
        return this.user;
    }

    /**
     * {@inheritDoc}
     */
    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    /**
     * {@inheritDoc}
     */
    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    @Override
    public String toString() {
        return "Booking ID [" + this.bookingId
                + "] for User [" + this.user
                + "] in Room [" + this.resource
                + "] on [" + this.startTime
                + "] till [" + this.endTime + "].";
    }
}
