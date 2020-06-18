package leetcode.challenge.june;

/**
 https://leetcode.com/problems/h-index-ii/

 H-Index II
 Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
 write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each,
 and the other N − h papers have no more than h citations each."

 Example:
    Input: citations = [0,1,3,5,6]
    Output: 3
     Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
     received 0, 1, 3, 5, 6 citations respectively.
     Since the researcher has 3 papers with at least 3 citations each and the remaining
     two with no more than 3 citations each, her h-index is 3.

 Note:
 If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class J18_H_IndexII {

    public int hIndex(int[] citations) {
        int len = citations.length;

        if(len ==0) {
            return 0;
        }

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

    public static void main(String[] args) {
        J18_H_IndexII obj = new J18_H_IndexII();
        System.out.println(obj.hIndex(new int[]{}));
        System.out.println(obj.hIndex(new int[]{0,1,3,5,6}));
        System.out.println(obj.hIndex(new int[]{0,1,4,5,6,7}));
        System.out.println(obj.hIndex(new int[]{0,3,5,6,7,8}));
        System.out.println(obj.hIndex(new int[]{0,0,1})); //1
        System.out.println(obj.hIndex(new int[]{0,1,5,6,7,8}));
        System.out.println(obj.hIndex(new int[]{0}));
        System.out.println(obj.hIndex(new int[]{-1}));
    }
}
