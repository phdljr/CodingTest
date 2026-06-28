package beakjoon.pm24267;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long result = 0;
        long n = Integer.parseInt(br.readLine());

        while(true){
            if(n==0)
                break;
            result += (n-2) * (n-1) / 2;
            n--;
        }

        bw.write(result + "\n3");
        bw.flush();
    }
}