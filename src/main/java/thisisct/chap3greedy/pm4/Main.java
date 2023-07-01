package thisisct.chap3greedy.pm4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, k;
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        int res = 0;
        while (n >= k) {
            n /= k;
            res++;
        }

        System.out.println(res+(n-1));
    }
}