package thisisct.chap3greedy.pm2;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m, k; // n개의 자연수, m번 덧셈, k번까지 중복 허용
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        Integer[] arr = new Integer[n];
        s = in.readLine().split(" ");
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int sum = 0;
        int temp = 1;
        for(int i=0;i<m;i++){
            if(temp != k)
                sum += arr[0];
            else {
                sum += arr[1];
                temp = 0;
            }
            temp++;
        }

        out.write(String.valueOf(sum));
        out.flush();
    }
}
