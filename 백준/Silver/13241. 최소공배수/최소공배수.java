
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
        long n = Long.parseLong(str[0]);
        long m = Long.parseLong(str[1]);

        long gcd = getGcd(n, m);
        long lcd = n * m / gcd;

        bw.write(lcd + "");
        bw.flush();
    }

    private static long getGcd(long a, long b) {
        if(b == 0){
            return a;
        }
        return getGcd(b, a%b);
    }
}
