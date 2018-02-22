package arrays;

public class MajorityElement1 {

	public static void main(String[] args) {
		int[] a = {2,3,3,1,8,3,3,1,3,10,3,4,3};
		int element = getMajority(a);
		if(element != -1) {
			System.out.printf("Mojority element found : %d", element);
		} else
			System.out.println("No such element found");
	}

	private static int getMajority(int[] a) {
		int size = a.length;
		for (int i = 0; i < Math.ceil(size/2); i++) {
			int count=0;
			for (int j = i; j < size; j++) {
				if(a[i] == a[j]) {
					count++;
				}
			}
			if(count > size/2) {
				return a[i];
			}
		}
		return -1;
	}
}
