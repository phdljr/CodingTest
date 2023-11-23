import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nStr = in.readLine().split(" ");
        int a = Integer.parseInt(new StringBuilder(nStr[0]).reverse().toString());
        int b = Integer.parseInt(new StringBuilder(nStr[1]).reverse().toString());
        
        if(a>b){
            out.write(a+"");
        } else{
            out.write(b+"");
        }
        
        out.flush();
    }
}