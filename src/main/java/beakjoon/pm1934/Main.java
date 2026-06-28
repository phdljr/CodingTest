package beakjoon.pm1934;

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

        StringBuilder result = new StringBuilder();
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            int gcd = getGcd(a, b);

            int lcd = a * b / gcd;
            result.append(lcd).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
    }

    private static int getGcd(int a, int b) {
        if(b == 0){
            return a;
        }
        return getGcd(b, a%b);
    }
}
