package com.mcmartins;

import com.mcmartins.api.BookingInfo;
import com.mcmartins.impl.BookingRequestImpl;
import com.mcmartins.impl.RoomBooking;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Test reading both example files
     */
    public void testApp() {
        // test load file from invalid path
        try {
            new RoomBooking(new CSVDataSource("fake_path"));
            fail();
        } catch (final Exception e) {
            // expected
            assertTrue(true);
        }
        // test load large csv
        RoomBooking roomBookingLarge = new RoomBooking(new CSVDataSource(getClass().getResourceAsStream("/largeSet.csv")));
        assertNotNull(roomBookingLarge);
        BookingInfo bookingInfoLarge = roomBookingLarge.create(new BookingRequestImpl(3600));
        assertNotNull(bookingInfoLarge);
        // test load small csv
        RoomBooking roomBookingSmall = new RoomBooking(new CSVDataSource(getClass().getResourceAsStream("/smallSet.csv")));
        assertNotNull(roomBookingSmall);
        BookingInfo bookingInfoSmall = roomBookingSmall.create(new BookingRequestImpl(3600));
        assertNotNull(bookingInfoSmall);
    }
}
