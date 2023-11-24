import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = in.readLine();
        if(new StringBuilder(str).reverse().toString().equals(str)){
             out.write("" + 1);   
        } else{
            out.write("" + 0);
        }
        out.flush();
    }
}
