package ds.mergeinterval;

import java.util.*;

class Meeting {
  int start;
  int end;

  public Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

public class MinimumMeetingRooms {
  public static void main(String[] args) {
    List<Meeting> input = new ArrayList<Meeting>() {
      {
        add(new Meeting(4, 5));
        add(new Meeting(2, 3));
        add(new Meeting(2, 4));
        add(new Meeting(3, 5));
      }
    };
    int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(1, 4));
        add(new Meeting(2, 5));
        add(new Meeting(7, 9));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(6, 7));
        add(new Meeting(2, 4));
        add(new Meeting(8, 12));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(1, 4));
        add(new Meeting(2, 3));
        add(new Meeting(3, 6));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input = new ArrayList<Meeting>() {
      {
        add(new Meeting(4, 5));
        add(new Meeting(2, 3));
        add(new Meeting(2, 4));
        add(new Meeting(3, 5));
      }
    };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);
  }

  public static int findMinimumMeetingRooms(List<Meeting> meetings) {
    if (meetings == null || meetings.size() == 0)
      return 0;

    Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

    int minRooms = 0;
    PriorityQueue<Meeting> minHeap =
            new PriorityQueue<>(meetings.size(), Comparator.comparingInt(meeting -> meeting.end));
    for (Meeting meeting : meetings) {
      while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end)
        minHeap.poll();

      minHeap.offer(meeting);

      // all active meeting are in the minHeap, so we need rooms for all of them.
      minRooms = Math.max(minRooms, minHeap.size());
    }
    return minRooms;
  }
}
