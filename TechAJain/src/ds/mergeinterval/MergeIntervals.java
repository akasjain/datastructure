package ds.mergeinterval;

import java.util.*;

public class MergeIntervals {
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
    Interval i1 = new Interval(1,4);
    Interval i2 = new Interval(7,9);
    Interval i3 = new Interval(2,5);

    List<Interval> list = new ArrayList<>();
    list.add(i1);
    list.add(i2);
    list.add(i3);

    List<Interval> mergedIntervals = merge(list);
    System.out.println(mergedIntervals);

    list = new ArrayList<Interval>();
    list.add(new Interval(6, 7));
    list.add(new Interval(2, 4));
    list.add(new Interval(5, 9));

    mergedIntervals = merge(list);
    System.out.println(mergedIntervals);

    list = new ArrayList<Interval>();
    list.add(new Interval(1, 4));
    list.add(new Interval(2, 6));
    list.add(new Interval(3, 5));

    mergedIntervals = merge(list);
    System.out.println(mergedIntervals);
  }

  private static List<Interval> merge(List<Interval> list) {

    Collections.sort(list, (o1, o2) -> Integer.compare(o1.start, o2.start));
    Iterator<Interval> iter = list.iterator();
    Interval first = iter.next();
    int start = first.start;
    int end = first.end;

    List<Interval> mergedList = new ArrayList<>();

    while(iter.hasNext()) {
      Interval interval = iter.next();

      if(interval.start <= end) {
        end = Math.max(interval.end, end);
      } else {
        mergedList.add(new Interval(start, end));
        start = interval.start;
        end = interval.end;
      }
    }
    mergedList.add(new Interval(start, end));

    return mergedList;

  }

  private static boolean isTwoIntervalsOverlap(List<Interval> intervals) {

    Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
    Iterator<Interval> iter = intervals.iterator();
    Interval first = iter.next();
    int start = first.start;
    int end = first.end;

    while(iter.hasNext()) {
      Interval interval = iter.next();
      if(interval.start <= end) {
        return false;
      }
    }
    return true;
  }
}
