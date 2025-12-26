package beakjoon.pm9251;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        d = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < a.length; i++) {
            d[i][0] = 0;
        }
        for (int i = 0; i < b.length; i++) {
            d[0][i] = 0;
        }

        calc(a, b, a.length, b.length);

        bw.write(d[a.length][b.length] + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void calc(char[] a, char[] b, int al, int bl) {
        for(int i=1; i<=al; i++){
            for(int j=1; j<=bl; j++){
                if(a[i-1] == b[j-1]){
                    d[i][j] = d[i-1][j-1] + 1;
                } else{
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                }
            }
        }
    }
}
