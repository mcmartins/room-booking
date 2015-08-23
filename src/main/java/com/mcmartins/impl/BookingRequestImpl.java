package com.mcmartins.impl;

import com.mcmartins.api.BookingRequest;

/**
 * BookingRequest implementation class
 *
 * @author Manuel Martins
 */
public class BookingRequestImpl implements BookingRequest {

    private long duration;
    private String requesterName;

    public BookingRequestImpl(final long duration) {
        this.duration = duration;
        this.requesterName = "Anonymous";
    }

    public BookingRequestImpl(final long duration, final String requesterName) {
        this.duration = duration;
        this.requesterName = requesterName;
    }

    /**
     * {@inheritDoc}
     */
    public long getDuration() {
        return this.duration;
    }

    /**
     * {@inheritDoc}
     */
    public String getRequesterName() {
        return this.requesterName;
    }
}
