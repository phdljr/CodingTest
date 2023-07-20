package thisisct.chap8dp.pm3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        int[] d = new int[100];
        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);
        for(int i=2;i<n;i++){
            d[i] = Math.max(d[i-1], d[i-2] + arr[i]);
        }

        System.out.println(d[n-1]);
    }
}
