package thisisct.chap8dp.pm5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        int[] narr = new int[n];
        for(int i=0;i<n;i++){
            narr[i] = Integer.parseInt(in.readLine());
        }

        int[] d = new int[m+1];
        Arrays.fill(d, 20000);

        d[0] = 0;
        for(int i=0;i<n;i++){
            for(int j=narr[i];j<=m;j++){
                if(d[j - narr[i]] != -1){
                    d[j] = Math.min(d[j - narr[i]] + 1, d[j]);
                }
            }
        }

        System.out.println(d[m]);
    }
}