package beakjoon.pm31403;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String result = "";
        int result1 = 0;
        String result2 = "";
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        result1 = a + b - c;

        result2 += a + "" + b;
        result2 = Integer.parseInt(result2) - c + "";

        result = result1 + "\n" + result2;
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}


