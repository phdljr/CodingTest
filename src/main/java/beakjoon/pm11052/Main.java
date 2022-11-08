package beakjoon.pm11052;

import java.util.Scanner;

public class Main {
    static int[] d = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] p = new int[n + 1];
        String[] str = sc.nextLine().split(" ");
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(str[i - 1]);
        }

        d[1] = p[1];
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + p[1];
            for (int j = 1; j <= j; j++) {
                if (d[i] < d[i - j] + p[j]) {
                    d[i] = d[i - j] + p[j];
                }
            }
        }

        System.out.println(d[n]);

    }
}
