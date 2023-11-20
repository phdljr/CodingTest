import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(in.readLine());
        for(int i=0;i<count;i++){
            String str = in.readLine();
            String first = str.charAt(0) + "";
            String last = str.charAt(str.length()-1) + "";
            String answer = first + last;

            out.write(answer);
            out.newLine();
        }
        out.flush();
    }
}