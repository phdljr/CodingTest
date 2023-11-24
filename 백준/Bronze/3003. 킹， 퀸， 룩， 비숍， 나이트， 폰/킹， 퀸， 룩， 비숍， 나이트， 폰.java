import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = {1,1,2,2,2,8};
        String[] str = in.readLine().split(" ");
        for(int i=0;i<6;i++){
            out.write((arr[i] - Integer.parseInt(str[i])) + " ");
        }
        
        out.write("");
        out.flush();
    }
}
