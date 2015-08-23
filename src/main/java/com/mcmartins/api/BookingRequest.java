package com.mcmartins.api;

/**
 * A BookingRequest represents the request for a booking into the API
 *
 * @author Manuel Martins
 */
public interface BookingRequest {

    /**
     * The duration of the booking
     *
     * @return duration
     */
    long getDuration();

    /**
     * The requester name (it would be the user interface but I don't have more time to continue the implementaiton :S)
     *
     * @return userName
     */
    String getRequesterName();
}
