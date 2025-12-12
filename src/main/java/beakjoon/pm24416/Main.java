package beakjoon.pm24416;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int count1 = 0;
    static int count2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);

        bw.write(count1 + " " + count2);
        bw.flush();
    }

    private static int fibonacci(int n) {
        int[] f = new int[41];
        f[1] = f[2] = 1;
        for(int i=3;i<=n;i++){
            count2++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    private static int fib(int n) {
        if (n == 1 || n == 2){
            count1++;
            return 1;
        }
        return (fib(n - 1) + fib(n - 2));
    }
}

