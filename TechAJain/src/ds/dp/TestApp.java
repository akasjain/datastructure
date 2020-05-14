package ds.dp;

import java.lang.ref.SoftReference;

public class TestApp {
  public static void main(String[] args) {

    StringBuilder sb = new StringBuilder();
    sb.append("abcd");
    SoftReference<StringBuilder> sbRef = new SoftReference<>(sb);

    System.out.println(sb.hashCode());
    System.out.println(sbRef.get().hashCode());

    sb = null;
    System.out.println(sbRef.getClass());
    System.out.println(sbRef.get().toString());
    System.out.println(sb);
    System.gc();
    System.out.println(sbRef.get().toString());


  }
}
