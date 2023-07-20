package thisisct.chap8dp.pm4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] d = new int[1001];
        d[1] = 1;
        d[2] = 3;
        for(int i=3;i<=n;i++){
            d[i] = d[i-1] + d[i-2] * 2;
        }

        System.out.println(d[n]);
    }
}
