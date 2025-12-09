
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            result.append(combination(k, n)).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }

    private static long combination(int n, int k) {
        BigInteger result = new BigInteger("1");

        for(int i=0;i<k;i++){
            result = result.multiply(new BigInteger(n-i + ""));
        }

        for(int i=1;i<=k;i++){
            result = result.divide(new BigInteger(i + ""));
        }

        return result.longValue();
    }
}




