
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
        int c = Integer.parseInt(str[2]);
        int d = Integer.parseInt(str[3]);
        int e = Integer.parseInt(str[4]);
        int f = Integer.parseInt(str[5]);

        String result = "";
        for(int x = -999; x <= 999; x++){
            for(int y = -999; y <= 999; y++){
                if(a*x + b*y == c && d*x + e*y == f){
                    result += x + " " + y;
                }
            }
        }

        bw.write(result);
        bw.flush();
    }
}