
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long k = Long.parseLong(br.readLine());

        StringBuilder result = new StringBuilder();
        for(long i=0;i<k;i++){
            long n = Long.parseLong(br.readLine());
            result.append(getNextPrime(n)).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }

    private static long getNextPrime(long n) {
        if(n <= 2)
            return 2;

        while(true){
            if(isPrime(n))
                return n;

            n++;
        }
    }

    private static boolean isPrime(long n){
        for(long i=2;i*i<=n;i++){
            if(n%i == 0)
                return false;
        }

        return true;
    }

}
