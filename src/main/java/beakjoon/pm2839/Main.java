package beakjoon.pm2839;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;

        int i = 0; // 3키로 봉지 개수
        while(i * 3 <= n){
            int temp = n - i * 3;
            if(temp % 5 == 0){
                int count = temp / 5;
                if(i + count < min){
                    min = i + count;
                }
            }

            i++;
        }

        if(min == Integer.MAX_VALUE)
            min = -1;

        bw.write(min + "");
        bw.flush();
    }
}
