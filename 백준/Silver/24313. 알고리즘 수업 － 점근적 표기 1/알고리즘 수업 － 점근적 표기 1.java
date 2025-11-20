
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
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        if (c < a) 
            result = 0;
        else if(a * n + b <= c * n)
            result = 1;

        bw.write(result + "");
        bw.flush();
    }
}