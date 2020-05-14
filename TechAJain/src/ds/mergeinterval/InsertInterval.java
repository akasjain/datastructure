package ds.mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

  static class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public String toString() {
      return "Interval{" +
        "start=" + start +
        ", end=" + end +
        '}';
    }
  }

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(2, 3));
    input.add(new Interval(5, 7));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }

  private static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

    if(intervals == null || intervals.isEmpty())
      return Arrays.asList(newInterval);

    List<Interval> result = new ArrayList<>();
    int i = 0;

    while(i < intervals.size() && intervals.get(i).end < newInterval.start) {
      result.add(intervals.get(i));
      i++;
    }

    while(i < intervals.size() && intervals.get(i).start <= newInterval.end) {
      newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
      newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
      i++;
    }

    result.add(newInterval);

    while(i < intervals.size())
      result.add(intervals.get(i));

    return result;
  }
}
