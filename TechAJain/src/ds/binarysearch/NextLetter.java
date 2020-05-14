package ds.binarysearch;

class NextLetter {

    public static char searchNextLetter(char[] letters, char key) {
        // TODO: Write your code here
        int len = letters.length;
        if(key > letters[len - 1])
            return letters[0];

        int start = 0, end = len - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            char currentChar = letters[mid];

            if(key < currentChar) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % len];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
