package leetcode.challenge.august;

/**
 983. Minimum Cost For Tickets
 https://leetcode.com/problems/minimum-cost-for-tickets/

 In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
 Train tickets are sold in 3 different ways:

 a 1-day pass is sold for costs[0] dollars;
 a 7-day pass is sold for costs[1] dollars;
 a 30-day pass is sold for costs[2] dollars.
 The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

 Return the minimum number of dollars you need to travel every day in the given list of days.

 Example 1:
    Input: days = [1,4,6,7,8,20], costs = [2,7,15]
    Output: 11

 Example 2:
    Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
    Output: 17

 Note:
     1 <= days.length <= 365
     1 <= days[i] <= 365
     days is in strictly increasing order.
     costs.length == 3
     1 <= costs[i] <= 1000
 */
public class AG25_MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int[] dp = new int[len + 1];

        for(int i = 1; i <= len; i++) {
            int oneDayCost = dp[i-1] + costs[0];

            int sevenDayCost = costs[1];
            int previousSevenDay = days[i-1] - 7;
            if(previousSevenDay >= 0) {
                int current = i - 2;
                while(current >=0 && days[current] > previousSevenDay)
                    current--;
                sevenDayCost += dp[current + 1];
            }

            int thirtyDayCost = costs[2];;
            int previousThirtyDay = days[i-1] - 30;
            if(previousThirtyDay >= 0) {
                int current = i - 2;
                while(current >=0 && days[current] > previousThirtyDay)
                    current--;
                thirtyDayCost += dp[current + 1];
            }

            dp[i] = Math.min(oneDayCost, Math.min(sevenDayCost, thirtyDayCost));
        }

        return dp[len];
    }

    public static void main(String[] args) {
        AG25_MinimumCostForTickets obj = new AG25_MinimumCostForTickets();
        System.out.println(obj.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
    }
}
