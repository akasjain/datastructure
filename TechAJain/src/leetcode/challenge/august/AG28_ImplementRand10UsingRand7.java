package leetcode.challenge.august;

import java.util.Random;

/**
 470. Implement Rand10() Using Rand7()
 https://leetcode.com/problems/implement-rand10-using-rand7/

 Given the API rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10. You can only call the API rand7 and you shouldn't call any other API. Please don't use the system's Math.random().
 Notice that Each test case has one argument n, the number of times that your implemented function rand10 will be called while testing.

 Follow up:
    What is the expected value for the number of calls to rand7() function?
    Could you minimize the number of calls to rand7()?

 Example 1:
    Input: n = 1
    Output: [2]

 Example 2:
    Input: n = 2
    Output: [2,8]

 Example 3:
    Input: n = 3
    Output: [3,8,10]

 Constraints:
    1 <= n <= 105
 */
public class AG28_ImplementRand10UsingRand7 extends SolBase {
    public int rand10() {
        int result = 40;
        while (result >= 40) {result = 7 * (rand7() - 1) + (rand7() - 1);}
        return result % 10 + 1;
    }
}

class SolBase {
    int rand7() {
        return (new Random()).nextInt(8);
    }
}
