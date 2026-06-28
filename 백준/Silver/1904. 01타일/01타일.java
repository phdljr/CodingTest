
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] d = new long[1000001];
        d[1] = 1;
        d[2] = 2;

        for(int i=3;i <= 1000000;i++){
            d[i] = (d[i-1] + d[i-2]) % 15746;
        }

        int n = Integer.parseInt(br.readLine());

        bw.write(d[n] + "");
        bw.flush();
    }
}

