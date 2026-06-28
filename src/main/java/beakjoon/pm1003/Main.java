package beakjoon.pm1003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] d = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        d[0][0] = 1;
        d[0][1] = 0;
        d[1][0] = 0;
        d[1][1] = 1;

        for(int i=2;i<=40;i++){
            d[i][0] = d[i-1][0] + d[i-2][0];
            d[i][1] = d[i-1][1] + d[i-2][1];
        }

        int k = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for(int i=0;i<k;i++){
            int n = Integer.parseInt(br.readLine());
            result.append(d[n][0]).append(" ").append(d[n][1]).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}
