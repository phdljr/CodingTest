package pm1978;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count;
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        int[] arr = new int[count];
        for(int i=0;i<arr.length;i++)
            arr[i] = sc.nextInt();

        int result = getPrimeCount(arr);
        System.out.println(result);
    }

    public static int getPrimeCount(int[] arr) {
        int result = 0;
        for(int n: arr) {
            if(isPrime(n)) result++;
        }

        return result;
    }

    private static boolean isPrime(int n) {
        if(n < 2) return false;

        for (int i = 2; i * i <= n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
