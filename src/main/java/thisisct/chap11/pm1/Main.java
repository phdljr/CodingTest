package thisisct.chap11.pm1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];

        String[] str = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(arr);

        int result = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += 1;
            if (count >= arr[i]) {
                result++;
                count = 0;
            }
        }

        System.out.println(result);
    }
}
