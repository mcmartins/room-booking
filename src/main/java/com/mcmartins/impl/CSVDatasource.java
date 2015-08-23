package com.mcmartins.impl;

import com.mcmartins.api.BookingInfo;
import com.mcmartins.api.Datasource;
import com.mcmartins.api.Resource;
import com.mcmartins.api.User;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Datasource implementation class for CSV
 *
 * @author Manuel Martins
 */
public class CSVDatasource implements Datasource {

    // CSV Delimiter
    private static final String CVS_SPLIT_BY = ",";
    // CSV Structure
    private static final String BOOKING_ID = "bookingId";
    private static final String START_TIME = "startTime";
    private static final String END_TIME = "endTime";
    private static final String ROOM_ID = "roomId";
    private static final String BOOKER_NAME = "bookerName";
    // CSV Dates format
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss +0000");

    private final InputStreamReader csvReader;

    /**
     * Initializes the FileReader
     *
     * @param resource the path to the file to load
     */
    public CSVDatasource(String resource) {
        try {
            this.csvReader = new FileReader(resource);
        } catch (final FileNotFoundException e) {
            throw new RuntimeException("Cannot proceed...Cannot read the resource: " + resource, e);
        }
    }

    /**
     * Initializes the FileReader
     *
     * @param resource the stream to read
     */
    public CSVDatasource(InputStream resource) {
        this.csvReader = new InputStreamReader(resource);
    }

    /**
     * {@inheritDoc}
     */
    public Map<Resource, List<BookingInfo>> read() {
        final Map<Resource, List<BookingInfo>> roomBookingInfo = new HashMap<Resource, List<BookingInfo>>();
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(this.csvReader);
            // firs line provides index for the header columns
            line = br.readLine();
            line = line.replace("\"", "");
            final String[] headers = line.split(CVS_SPLIT_BY);
            final List<String> headersList = Arrays.asList(headers);
            int bookingIdIndex = headersList.indexOf(BOOKING_ID);
            int startDateIndex = headersList.indexOf(START_TIME);
            int endDateIndex = headersList.indexOf(END_TIME);
            int roomIdIndex = headersList.indexOf(ROOM_ID);
            int bookerNameIndex = headersList.indexOf(BOOKER_NAME);
            while ((line = br.readLine()) != null) {
                line = line.replace("\"", "");
                final String[] booking = line.split(CVS_SPLIT_BY);
                final LocalDateTime startDate = LocalDateTime.parse(booking[startDateIndex], DATE_FORMAT);
                final LocalDateTime endDate = LocalDateTime.parse(booking[endDateIndex], DATE_FORMAT);
                final User user = new Person(booking[bookerNameIndex]);
                final Resource resource = new Room(new Integer(booking[roomIdIndex]));
                final int bookingId = new Integer(booking[bookingIdIndex]);
                final BookingInfo bookingInfo = new BookingInfoImpl(bookingId, resource, user, startDate, endDate);
                if (roomBookingInfo.containsKey(bookingInfo.getResource())) {
                    roomBookingInfo.get(bookingInfo.getResource()).add(bookingInfo);
                } else {
                    roomBookingInfo.put(bookingInfo.getResource(), new ArrayList<BookingInfo>() {{
                        add(bookingInfo);
                    }});
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return roomBookingInfo;
    }
}
