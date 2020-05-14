package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RotateLeft {

    private static final Scanner scanner = new Scanner(System.in);

    static int[] rotLeft(int[] a, int d) {
        int len = a.length;
        d = d % len;
        int i;
        int[] temp = new int[d];
        for(i=0; i<d; i++)
            temp[i] = a[i];
        for(i=0; i<len-d; i++)
            temp[i] = a[i+d];
        int j=0;
        System.out.println(a);
        while(i < len) {
            a[i] = temp[j];
            i++;
            j++;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        /*for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }


}
