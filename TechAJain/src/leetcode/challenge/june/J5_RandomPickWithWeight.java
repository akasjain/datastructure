package leetcode.challenge.june;

import java.util.Arrays;

/**
 https://leetcode.com/problems/random-pick-with-weight/

 Random Pick with Weight

 Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which
 randomly picks an index in proportion to its weight.

 For example, given an input list of values [1, 9], when we pick up a number out of it, the chance is that 9 times out
 of 10 we should pick the number 9 as the answer.

 Example 1:
    Input:
        ["Solution","pickIndex"]
        [[[1]],[]]
    Output: [null,0]

 Example 2:
    Input:
        ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
        [[[1,3]],[],[],[],[],[]]
    Output: [null,0,1,1,1,0]
 */
class Solution {
    private double[] probabilities;

    public Solution(int[] w) {
        double sum = 0;
        this.probabilities = new double[w.length];
        for(int weight : w)
            sum += weight;
        for(int i = 0; i < w.length; i++){
            w[i] += (i == 0) ? 0 : w[i - 1];
            probabilities[i] = w[i]/sum;
        }
    }

    public int pickIndex() {
        return Math.abs(Arrays.binarySearch(this.probabilities, Math.random())) - 1;
    }
}

public class J5_RandomPickWithWeight {
    public static void main(String[] args) {
        int[] w = {1,3};
        Solution obj = new Solution(w);
        System.out.print(obj.pickIndex() + " ");
        System.out.print(obj.pickIndex() + " ");
        System.out.print(obj.pickIndex() + " ");
        System.out.print(obj.pickIndex() + " ");
        System.out.println(obj.pickIndex() + " ");

        w = new int[]{1,5,3};
        obj = new Solution(w);
        System.out.print(obj.pickIndex() + " ");
        System.out.print(obj.pickIndex() + " ");
        System.out.print(obj.pickIndex() + " ");
        System.out.print(obj.pickIndex() + " ");
        System.out.print(obj.pickIndex() + " ");
        System.out.print(obj.pickIndex() + " ");
        System.out.print(obj.pickIndex() + " ");
        System.out.print(obj.pickIndex() + " ");
        System.out.print(obj.pickIndex() + " ");
        System.out.print(obj.pickIndex() + " ");

        w = new int[]{3,14,1,7};
    }
}