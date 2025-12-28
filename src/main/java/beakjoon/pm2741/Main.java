package beakjoon.pm2741;

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

        StringBuilder result = new StringBuilder();

        for(int i=0;i<n;i++)
            result.append(i + 1).append("\n");

        bw.write(result.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}

