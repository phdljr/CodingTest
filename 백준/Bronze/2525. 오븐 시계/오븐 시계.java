import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strArr = in.readLine().split(" ");
        int h = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);
        int t = Integer.parseInt(in.readLine());

        m += t;
        if (m >= 60) {
            int addH = m / 60;
            h += addH;
            m = m % 60;
            if (h >= 24) {
                h -= 24;
            }
        }

        String answer = h + " " + m;

        out.write(answer);
        out.flush();
    }
}