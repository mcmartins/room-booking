# Room Booking

Marks&amp;Spencer API Design Task

## Java API (Java 8!)

The project is configured with Maven and can be compiled and archived using: mvn clean package

### Run

There is a folder dist containing the runnable jar and scripts to run on windows and linux systems. e.g:

**Windows:** booking.bat c:\largeSet.csv 3600<br/>
**Linux:**   chmod +x booking.sh; ./booking.sh /tmp/largeSet.csv 3600

## REST API

A possible REST API for handling Booking request could be as follows:

### (a) Seeing all bookings

**URL:** https://api.marksandspencer.com/booking/v1/rooms<br/>
**METHOD:** GET<br/>
**EXAMPLE Request:**
```bash
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET https://api.marksandspencer.com/booking/v1/rooms
```
**EXAMPLE Response:** 
```bash
[{"bookingId":1,"resource":"Room 1","user":"Manuel","2015-04-01 00:00:00 +0000","2015-04-01 01:00:00 +0000"},...]
```

### (b) Seeing all bookings for a room

**URL:** https://api.marksandspencer.com/booking/v1/rooms/1<br/>
**METHOD:** GET<br/>
**EXAMPLE Request:** 
```bash
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET https://api.marksandspencer.com/booking/v1/rooms/1
```
**EXAMPLE Response:** 
```bash
{"bookingId":1,"resource":"Room 1","user":"Manuel","2015-04-01 00:00:00 +0000","2015-04-01 01:00:00 +0000"}
```

### (c) Creating a booking for a room

**URL:** https://api.marksandspencer.com/booking/v1/rooms<br/>
**METHOD:** POST<br/>
**EXAMPLE Request:** 
```bash
curl -H "Content-Type: application/json" -X POST -d '{"duration":3600,"requesterName":"Manuel"}' https://api.marksandspencer.com/booking/v1/rooms
```
**EXAMPLE Response:** 
```bash
{"bookingId":1,"resource":"Room 1","user":"Manuel","2015-04-01 00:00:00 +0000","2015-04-01 01:00:00 +0000"}
```

### (d) Updating a booking for a room

**URL:** https://api.marksandspencer.com/booking/v1/rooms/1<br/>
**METHOD:** PUT<br/>
**EXAMPLE Request:** 
```bash
curl -i -X PUT -H "Content-Type:application/json" https://api.marksandspencer.com/booking/v1/rooms/1 -d '{"bookingId":1,"resource":"Room 1","user":"Manuel Martins","2015-04-01 00:00:00 +0000","2015-04-01 01:00:00 +0000"}'
```
**EXAMPLE Response:**
```bash
{"status":"OK"}
```

### (e) Cancelling a booking for a room

**URL:** https://api.marksandspencer.com/booking/v1/rooms/1<br/>
**METHOD:** DELETE<br/>
**EXAMPLE Request:** 
```bash
curl -v -X DELETE https://api.marksandspencer.com/booking/v1/rooms/1
```
**EXAMPLE Response:** 
```bash
{"status":"OK"}
```
