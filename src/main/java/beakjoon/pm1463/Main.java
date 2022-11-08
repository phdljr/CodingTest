package beakjoon.pm1463;

import java.io.*;

public class Main {
    static int[] D = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        D[1] = 0;
        go(n);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(D[n] + "");
        bw.flush();
    }

    private static int go(int n){
        if(n == 1){
            return 0;
        }
        if(D[n] > 0){
            return D[n];
        }
        D[n] = go(n-1) + 1; // 모든 경우의 수부터 먼저 구함
        if(n%2 == 0){
            int temp = go(n/2) + 1;
            if(D[n] > temp){
                D[n] = temp;
            }
        }
        if(n%3 == 0){
            int temp = go(n/3) + 1;
            if(D[n] > temp){
                D[n] = temp;
            }
        }
        return D[n];
    }
}
