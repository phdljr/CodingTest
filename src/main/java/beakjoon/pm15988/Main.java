package beakjoon.pm15988;

import java.util.Scanner;

public class Main {

    static long[] d = new long[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        for(int i=3;i<=1000000;i++){
            d[i] = (d[i-1] + d[i-2] + d[i-3])%1000000009;
        }

        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            System.out.println(d[sc.nextInt()]);
        }
    }
}
