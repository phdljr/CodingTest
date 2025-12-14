package beakjoon.pm2579;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] d = new int[301];
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[301];
        for(int i=0;i<n;i++){
            arr[i+1] = Integer.parseInt(br.readLine());
        }

        d[0] = 0;
        d[1] = arr[1];
        d[2] = d[1] + arr[2];
        for(int i=3;i <= n; i++){
            d[i] = Math.max(d[i-3] + arr[i-1], d[i-2]) + arr[i];
        }

        bw.write(d[n] + "");
        bw.flush();
    }
}


