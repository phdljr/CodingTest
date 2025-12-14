package beakjoon.pm9461;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] d = new long[101];
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        d[4] = 2;
        d[5] = 2;

        for(int i=6;i < 101; i++){
            d[i] = d[i-1] + d[i-5];
        }

        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            result.append(d[Integer.parseInt(br.readLine())]).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}


