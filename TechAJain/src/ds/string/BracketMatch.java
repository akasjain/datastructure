package ds.string;

public class BracketMatch {

    static int bracketMatch(String text) {
        int currentCount = 0;
        int ans = 0;
        for(char ch : text.toCharArray()) {
            if(ch == '(') {
                currentCount++;
            } else if(ch == ')') {
                currentCount--;
            }

            if(currentCount < 0) {
                ans++;
                currentCount++;
            }

        }

        return ans + currentCount;
    }

    public static void main(String[] args) {
        System.out.print(bracketMatch("(())")); // 1
        System.out.print(bracketMatch("(())")); // 0
        System.out.print(bracketMatch("())(")); // 2
    }
}
