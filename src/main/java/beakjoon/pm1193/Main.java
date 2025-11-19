package beakjoon.pm1193;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine()); // 위치
        int line = 1;

        while(x > line){
            x -= line;
            line++;
        }

        int a, b;
        if(line % 2 == 0){
            a = x;
            b = line - x + 1;
        } else{
            a = line - x + 1;
            b = x;
        }

        bw.write(a + "/" + b);
        bw.flush();
    }
}