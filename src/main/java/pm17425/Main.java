package pm17425;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        final int MAX = 1000000;
        long[] d = new long[MAX + 1];
        Arrays.fill(d, 1);
        for (int i = 2; i <= MAX; i++) {
            for (int j = 1; i * j <= MAX; j++) {
                d[i * j] += i;
            }
        }

        long[] s = new long[MAX + 1];
        s[1] = d[1];
        for(int i=2;i<MAX+1;i++){
            s[i] = s[i-1] + d[i];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testNum = Integer.parseInt(br.readLine());
        for(int i=0;i<testNum;i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(s[n] + "\n");
        }
        bw.flush();
    }
}
