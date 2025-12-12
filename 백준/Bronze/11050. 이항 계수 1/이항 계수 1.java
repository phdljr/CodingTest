
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        int result = combination(n, k);

        bw.write(result + "");
        bw.flush();
    }

    private static int combination(int n, int k) {
        int result = 1;

        for(int i=0;i<k;i++){
            result *= n-i;
        }

        for(int i=1;i<=k;i++){
            result /= i;
        }

        return result;
    }
}




