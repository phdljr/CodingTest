package beakjoon.pm9184;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[][][] d = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        while(true){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]), b=Integer.parseInt(str[1]), c=Integer.parseInt(str[2]);
            if(a == -1 && b == -1 && c == -1)
                break;

            int num = w(a, b, c);
            result.append("w(").append(a).append(", ").append(b).append(", ").append(c)
                .append(") = ").append(num).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }

    private static int w(int a, int b, int c) {
        if(0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20 && d[a][b][c] != 0){
            return d[a][b][c];
        }

        if(a <= 0 || b <= 0 || c <= 0){
            return 1;
        }

        if(a > 20 || b > 20 || c > 20){
            d[20][20][20] = w(20, 20, 20);
            return d[20][20][20];
        }

        if(a < b && b < c) {
            d[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        } else{
            d[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }

        return d[a][b][c];
    }
}
