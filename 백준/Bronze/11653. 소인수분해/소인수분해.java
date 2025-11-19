
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int k = 2;
        while(n != 1){
            if(n % k == 0){
                result.append(k).append("\n");
                n /= k;
                k = 2;
            } else{
                k++;
            }
        }

        bw.write(result.toString());
        bw.flush();
    }
}
