package thisisct.chap6sort.pm4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");

        int len = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[] a1 = new int[len];
        Integer[] a2 = new Integer[len];

        s = in.readLine().split(" ");
        for (int i = 0; i < a1.length; i++) {
            a1[i] = Integer.parseInt(s[i]);
        }
        s = in.readLine().split(" ");
        for (int i = 0; i < a1.length; i++) {
            a2[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(a1);
        Arrays.sort(a2, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (a1[i] < a2[i]) {
                a1[i] = a2[i];
            }
        }

        System.out.println(Arrays.stream(a1).sum());
    }
}
