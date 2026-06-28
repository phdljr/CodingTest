
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[1000000 + 1];

        arr[0] = -1;
        arr[1] = -1;
        for (int i = 2; i < arr.length; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            for (int j = i * 2; j < arr.length; j += i) {
                arr[j] = -1;
            }

            if (isPrime) {
                arr[i] = i;
            } else {
                arr[i] = -1;
            }
        }

        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for(int j=2;j<=n/2;j++){
                if(arr[j] + arr[n-j] == n)
                    count++;
            }
            result.append(count).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}
