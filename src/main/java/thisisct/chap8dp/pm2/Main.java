package thisisct.chap8dp.pm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int[] d = new int[30000];
        d[1] = 0;

        for(int i=2;i<=n;i++){
            d[i] = d[i-1] + 1;

            if(i % 5 == 0){
                d[i] = Math.min(d[i/5] + 1, d[i]);
            }
            if(i % 3 == 0){
                d[i] = Math.min(d[i/3] + 1, d[i]);
            }
            if(i % 2 == 0){
                d[i] = Math.min(d[i/2] + 1, d[i]);
            }
        }

        System.out.println(d[n]);
    }
}
