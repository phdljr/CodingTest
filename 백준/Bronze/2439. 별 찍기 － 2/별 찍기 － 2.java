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

        for (int i = 0; i < count; i++) {
            for(int j=0;j<count - i - 1;j++){
                out.write(" ");    
            }
            for(int j=0;j<i + 1;j++){
                out.write("*");    
            }
            out.write("\n");
        }
        out.flush();
    }
}