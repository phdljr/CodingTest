package beakjoon.pm2133;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[] d = new int[31];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d[0] = 1;
        for (int i = 2; i <= n; i += 2) {
            d[i] = d[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                d[i] += d[j] * 2;
            }
        }
        System.out.println(d[n]);
    }
}
