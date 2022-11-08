package beakjoon.pm9095;

import java.util.Scanner;

public class Dynamic {
    static int[] d = new int[11];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int j=4;j<=10;j++) {
            d[j] = d[j - 1] + d[j - 2] + d[j - 3];
        }
        for(int i=0;i<T;i++) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }
}
