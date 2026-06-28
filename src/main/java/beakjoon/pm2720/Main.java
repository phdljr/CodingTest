package beakjoon.pm2720;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] d = new int[16];
        d[0] = 4;
        d[1] = 9;
        int k = 3;
        for(int i=2;i<16;i++){
            d[i] = d[i-1] * 4 - 4 * k + 1;
            k = k * 2 - 1;
        }

        int n = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(d[n]));
        bw.flush();
    }
}
