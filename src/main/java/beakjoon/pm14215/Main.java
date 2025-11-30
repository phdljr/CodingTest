package beakjoon.pm14215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        int max = Math.max(a, Math.max(b, c));
        if (a + b + c - max <= max) {
            int temp = a + b + c - max - 1; // 나머지 2개의 변 길이의 합 - 1
            result = temp + a + b + c - max;
        } else {
            result = a + b + c;
        }

        bw.write(result + "");
        bw.flush();
    }
}
