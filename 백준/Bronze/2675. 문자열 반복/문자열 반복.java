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
            String[] nStr = in.readLine().split(" ");

            int n = Integer.parseInt(nStr[0]);
            String str = nStr[1];

            String answer = "";
            for (char ch: str.toCharArray()){
                for(int j=0;j<n;j++){
                    answer += ch;
                }
            }
            out.write(answer);
            out.newLine();
        }
        out.flush();
    }
}