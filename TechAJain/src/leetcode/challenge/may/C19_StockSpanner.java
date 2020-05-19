package leetcode.challenge.may;

/**
 https://leetcode.com/problems/online-stock-span/

 Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

 The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

 For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 */
class StockSpanner {

    private int[] pricesStack;
    private int[] spansStack;
    private int top;

    public StockSpanner() {
        pricesStack = new int[10000];
        spansStack = new int[10000];
        top = -1;
    }

    // My solution was not the most optimal but with same logic. Using solution of the most optimal solution timewise.
    public int next(int price) {
        int span = 1;
        while (top >= 0 && pricesStack[top] <= price) {
            span += spansStack[top--];
        }
        top++;
        pricesStack[top] = price;
        spansStack[top] = span;
        return span;
    }

}

public class C19_StockSpanner {
    public static void main(String[] args) {
        StockSpanner S = new StockSpanner();
        System.out.println(S.next(100));
        System.out.println(S.next(80));
        System.out.println(S.next(60));
        System.out.println(S.next(70));
        System.out.println(S.next(60));
        System.out.println(S.next(75));
        System.out.println(S.next(85));

        System.out.println("*********");

        StockSpanner S2 = new StockSpanner();
        System.out.println(S.next(31));
        System.out.println(S.next(41));
        System.out.println(S.next(51));
        System.out.println(S.next(45));
    }
}

