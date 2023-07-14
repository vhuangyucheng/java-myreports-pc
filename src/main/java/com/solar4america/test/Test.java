package com.solar4america.test;


import java.time.LocalTime;


public class Test {
    public static void main(String[] args) {
        // Get the current time
        LocalTime currentTime = LocalTime.now();

        // Define shift timings
        LocalTime shift1Start = LocalTime.of(6, 45); // 6:45 AM
        LocalTime shift1End = LocalTime.of(15, 15); // 3:15 PM
        LocalTime shift2Start = LocalTime.of(15, 15); // 3:15 PM
        LocalTime shift2End = LocalTime.of(23, 30); // 11:30 PM
        LocalTime shift3Start = LocalTime.of(23, 30); // 11:30 PM
        LocalTime shift3End = LocalTime.of(6, 45).plusHours(24);

        // Determine the current shift
        String currentShift = "";

        if ((currentTime.isAfter(shift1Start) || currentTime.equals(shift1Start)) && currentTime.isBefore(shift1End)) {
            currentShift = "Shift 1";
        } else if ((currentTime.isAfter(shift2Start) || currentTime.equals(shift2Start)) && currentTime.isBefore(shift2End)) {
            currentShift = "Shift 2";
        } else if (currentTime.isAfter(shift3Start) || currentTime.isBefore(shift3End) || currentTime.equals(shift3Start)) {
            currentShift = "Shift 3";
        } else {
            currentShift = "No shift currently active";
        }

        System.out.println("Current shift: " + currentShift);
    }
}
