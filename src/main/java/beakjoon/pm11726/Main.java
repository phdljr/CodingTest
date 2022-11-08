package beakjoon.pm11726;

import java.util.Scanner;

public class Main {
    static int[] d = new int[1001];

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        d[0] = Integer.MAX_VALUE;
        d[1] = 1;
        d[2] = 2;
        for(int i=3;i<=n;i++){
            d[i] = (d[i-1] + d[i-2]) % 10007;
        }
        System.out.println(d[n]);
    }
}
