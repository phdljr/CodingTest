import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] arr = in.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            if( a == 0 && a == b){
                out.flush();
                return;
            }
            out.write(String.format("%d\n", a + b));
        }
    }
}