package ds.heap;

import java.util.PriorityQueue;

class Element{
  char ch;
  int frequency;

  Element(char ch, int frequency) {
    this.ch = ch;
    this.frequency = frequency;
  }
}
public class RearrangeCharacters {
  public static void main(String[] args) {
    String str = "aabacacbb";
    str = rearrangeCharacters(str);
    System.out.println(str);
  }

  private static String rearrangeCharacters(String str) {
    StringBuilder result = new StringBuilder();
    char[] count = new char[26];

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      count[ch - 'a']++;
    }

    PriorityQueue<Element> pq = new PriorityQueue<>((o1, o2) -> {
      if(o1.frequency > o2.frequency)
        return -1;
      else
        return 1;
    });

    for (int i = 0; i < count.length; i++) {
      if(count[i] > 0) {
        pq.add(new Element((char)(i + 'a'), count[i]));
      }
    }

    Element previous = new Element('#', -1);

    while(!pq.isEmpty()) {
      Element top = pq.peek();
      pq.poll();
      result.append(top.ch);
      top.frequency--;

      if(previous.frequency > 0)
        pq.add(previous);
      previous = top;
    }

    if(str.length() != result.length())
      return "NAN";

    return result.toString();
  }
}
