package org.example.leetCodeTask;

import java.util.Arrays;

public class MeetingRoomsII253 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];
        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int rooms = 0;
        int endIdx = 0;
        for (int i = 0; i < n; i++) {
            if (startTimes[i] < endTimes[endIdx]) {
                rooms++;
            } else {
                endIdx++;
            }
        }
        return rooms;
    }

}
