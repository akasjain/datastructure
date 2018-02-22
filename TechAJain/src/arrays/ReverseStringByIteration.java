package arrays;

public class ReverseStringByIteration {

	public static void main(String[] args) {
		String str = "reversalarray";
		System.out.println("Original string : " + str);
		String reversed = reverseString(str);
		System.out.println("Reversed string : " + reversed);
	}

	private static String reverseString(String str) {
		String reversed = "";
		int size = str.length();
		if(size == 1) {
			return str;
		}
		int i = size - 1;
		while (i >= 0) {
			char temp = str.charAt(i);
			reversed = reversed + temp;
			i--;
		}
		return reversed;
	}
}
