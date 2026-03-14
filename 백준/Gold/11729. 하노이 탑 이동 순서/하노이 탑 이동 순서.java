
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int count = 0;
    static StringBuilder log = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 3, 2);

        bw.write(count + "\n");
        bw.write(log.toString().trim());
        bw.flush();
    }

    private static void hanoi(int n, int from, int to, int sup) {
        count++;
        if(n==1){
            log.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n-1, from, sup, to);
        log.append(from).append(" ").append(to).append("\n");
        hanoi(n-1, sup, to, from);
    }
}
