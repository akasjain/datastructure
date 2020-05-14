package leetcode.challenge.april;

import java.util.Stack;

/**
 https://leetcode.com/problems/min-stack/

 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.


 Example 1:
     Input
     ["MinStack","push","push","push","getMin","pop","top","getMin"]
     [[],[-2],[0],[-3],[],[],[],[]]

     Output
     [null,null,null,null,-3,null,0,-2]

     Explanation
     MinStack minStack = new MinStack();
     minStack.push(-2);
     minStack.push(0);
     minStack.push(-3);
     minStack.getMin(); // return -3
     minStack.pop();
     minStack.top();    // return 0
     minStack.getMin(); // return -2


 Constraints: Methods pop, top and getMin operations will always be called on non-empty stacks.

 */
public class C10_MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    int min;


    /** Whenever a number is inserted which is smaller than the current minimum, we push the current minimum and then the new number.
     * Also set new minimum to the new number being processed.
     */
    public C10_MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    /**
     * If number x is smaller than the current minimum, we push the current minimum and then the new number x.
     * Also set new minimum to the new number being processed.
     *
     * If x is greater than the current minimum, push it on the stack.
     */
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    /**
     * If the popped number is the current minimum, then after popping top element, assign min to the stack top.
     */
    public void pop() {
        int peek = stack.pop();
        if (peek == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        C10_MinStack obj1 = new C10_MinStack();
        obj1.push(2147483646);
        obj1.push(2147483646);
        obj1.push(2147483647);
        System.out.println(obj1.top());
        obj1.pop();
        System.out.println(obj1.getMin());
        obj1.pop();
        System.out.println(obj1.getMin());
        obj1.pop();
        obj1.push(2147483647);
        System.out.println(obj1.top());
        System.out.println(obj1.getMin());
        obj1.push(-2147483648);
        System.out.println(obj1.top());
        System.out.println(obj1.getMin());
        obj1.pop();
        System.out.println(obj1.getMin());

        System.out.println("**************");

        C10_MinStack obj2 = new C10_MinStack();
        obj2.push(2);
        obj2.push(0);
        obj2.push(3);
        obj2.push(0);
        System.out.println(obj2.getMin());
        obj2.pop();
        System.out.println(obj2.getMin());
        obj2.pop();
        System.out.println(obj2.getMin());
        obj2.pop();
        System.out.println(obj2.getMin());

        System.out.println("**************");


        C10_MinStack obj3 = new C10_MinStack();
        obj3.push(1);
        obj3.push(2);
        System.out.println(obj3.top());
        System.out.println(obj3.getMin());
        obj3.pop();
        System.out.println(obj3.getMin());
        System.out.println(obj3.top());




    }
}
