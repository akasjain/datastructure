package leetcode.challenge.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 274. H-Index
 https://leetcode.com/problems/pascals-triangle-ii/

 Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
 Notice that the row index starts from 0.

 In Pascal's triangle, each number is the sum of the two numbers directly above it.
 Follow up: Could you optimize your algorithm to use only O(k) extra space?
 */
public class AG12_PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex==0)return Arrays.asList(1);
        if(rowIndex==1)return Arrays.asList(1,1);
        for(int i=0;i<=rowIndex;i++){
            res.add(-1);
        }
        res.set(0,1);
        res.set(1,1);
        for(int i=2; i<=rowIndex;i++){
            int prev = 1;
            for(int j=1;j<i;j++){
                int val = prev+res.get(j);
                prev = res.get(j);
                res.set(j,val);
            }
            res.set(i,1);
        }
        return res;
    }
}
