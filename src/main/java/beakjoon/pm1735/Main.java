package beakjoon.pm1735;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        long a1 = Long.parseLong(str[0]);
        long b1 = Long.parseLong(str[1]);

        str = br.readLine().split(" ");
        long a2 = Long.parseLong(str[0]);
        long b2 = Long.parseLong(str[1]);

        long a = a1 * b2 + a2 * b1;
        long b = b1 * b2;

        long gcd = getGcd(a, b);

        a /= gcd;
        b /= gcd;

        String result = a + " " + b;

        bw.write(result);
        bw.flush();
    }

    private static long getGcd(long a, long b) {
        if(b == 0){
            return a;
        }
        return getGcd(b, a%b);
    }
}
