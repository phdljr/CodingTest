
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(str[j]);
                if (pq.size() == n) {
                    if (pq.peek() < num) {
                        pq.poll();
                        pq.add(num);
                    }
                } else {
                    pq.add(num);
                }
            }
        }

        bw.write(pq.peek() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
