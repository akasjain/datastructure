package leetcode.challenge.august;

import java.util.Arrays;

/**

 Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

 Example:
    Input: citations = [3,0,6,1,5]
    Output: 3
    Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
     received 3, 0, 6, 1, 5 citations respectively.
     Since the researcher has 3 papers with at least 3 citations each and the remaining
     two with no more than 3 citations each, her h-index is 3.
 */
public class AG11_HIndex {
    public int hIndex(int[] citations) {

        int len = citations.length;

        if(len == 0) {
            return 0;
        }
        Arrays.sort(citations);

        int start = 0;
        int end = len - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(citations[mid] < len - mid)
                start = mid + 1;
            else
                end = mid-1;

        }
        return len - start;
    }
}
