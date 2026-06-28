

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

        for(int i=0;i<n;i++){
            int d = Integer.parseInt(br.readLine());
            int r1 = d / 25;
            d %= 25;
            int r2 = d / 10;
            d %= 10;
            int r3 = d / 5;
            d %= 5;
            int r4 = d;
            bw.write(r1 + " " + r2 + " " + r3 + " " + r4);
            bw.newLine();
        }
        bw.flush();
    }
}
