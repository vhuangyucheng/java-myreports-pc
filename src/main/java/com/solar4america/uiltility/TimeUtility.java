package com.solar4america.uiltility;

import java.time.LocalTime;

public class TimeUtility {
    // Define shift timings
    private static final LocalTime shift1Start = LocalTime.of(6, 45); // 6:45 AM
    private static final LocalTime shift1End = LocalTime.of(15, 15); // 3:15 PM
    private static final LocalTime shift2Start = LocalTime.of(15, 15); // 3:15 PM
    private static final LocalTime shift2End = LocalTime.of(23, 30); // 11:30 PM
    private static final LocalTime shift3Start = LocalTime.of(23, 30); // 11:30 PM
    private static final LocalTime shift3End = LocalTime.of(6, 45).plusHours(24);

    public static int getCurrentShift() {
        // Get the current time
        LocalTime currentTime = LocalTime.now();
        // Determine the current shift
        int currentShift = 0;

        if ((currentTime.isAfter(shift1Start) || currentTime.equals(shift1Start)) && currentTime.isBefore(shift1End)) {
            currentShift = 1;
        } else if ((currentTime.isAfter(shift2Start) || currentTime.equals(shift2Start)) && currentTime.isBefore(shift2End)) {
            currentShift = 2;
        } else if (currentTime.isAfter(shift3Start) || currentTime.isBefore(shift3End) || currentTime.equals(shift3Start)) {
            currentShift = 3;
        } else {
            currentShift = 4;
        }
        return currentShift;
    }

    public static int getCurrentShift2() {
        return 1;
    }
}

