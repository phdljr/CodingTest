package beakjoon.pm4779;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);

            char[] arr = new char[(int) Math.pow(3, n)];
            Arrays.fill(arr, '-');
            makeBlank(arr, 0, arr.length - 1);

            result.append(String.valueOf(arr)).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }

    public static void makeBlank(char[] arr, int left, int right) {
        int size = right - left + 1;
        if(size <= 1)
            return;

        int blankSize = size / 3;
        for (int i = left + blankSize; i < right - blankSize + 1; i++) {
            arr[i] = ' ';
        }

        makeBlank(arr, left, left + blankSize-1);
        makeBlank(arr, left + blankSize * 2, right);
    }
}