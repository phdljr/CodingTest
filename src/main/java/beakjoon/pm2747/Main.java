package beakjoon.pm2747;

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

        int[] d = new int[46];

        d[0] = 0;
        d[1] = 1;
        for(int i=2;i<46;i++)
            d[i] = d[i-1] + d[i-2];

        int n = Integer.parseInt(br.readLine());

        bw.write(d[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

