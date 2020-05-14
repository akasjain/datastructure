package ds.bitwise;

public class ComplementofBase10Integer {
    public int bitwiseComplement(int N) {



        int temp = N;
        int count = 0;
        while(temp > 0) {
            count++;
            temp = temp >> 1;
        }

        int allOnes = 1;
        while(count > 1) {
            allOnes = (allOnes << 1) + 1;
            count--;
        }
        return allOnes - N;
    }

    public static void main(String[] args) {
        ComplementofBase10Integer obj = new ComplementofBase10Integer();
        System.out.println(obj.bitwiseComplement(2147483646));
        System.out.println(obj.bitwiseComplement(0));
        System.out.println(obj.bitwiseComplement(1));
        System.out.println(obj.bitwiseComplement(2147483647));
    }
}
