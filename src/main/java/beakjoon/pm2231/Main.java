package beakjoon.pm2231;

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

        int n = Integer.parseInt(br.readLine());
        int min = 10000000;

        for(int i=1;i<=n;i++){
            int s = i + Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();
            if(s == n && s < min)
                min = i;
        }

        if(min == 10000000)
            min = 0;

        bw.write(min + "");
        bw.flush();
    }
}