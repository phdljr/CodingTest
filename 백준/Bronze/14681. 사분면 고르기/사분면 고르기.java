import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        String answer = "";

        if(a * b > 0){
            if(a > 0){
                answer = "1";
            } else {
                answer = "3";
            }
        } else{
            if(a > 0){
                answer = "4";
            } else {
                answer = "2";
            }
        }

        out.write(answer);
        out.flush();
    }
}