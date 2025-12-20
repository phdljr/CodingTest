package beakjoon.pm11286;

import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            if(Math.abs(n1) > Math.abs(n2))
                return 1;
            else if(Math.abs(n1) < Math.abs(n2))
                return -1;
            else {
                if(n1 > n2)
                    return 1;
                else if(n1 < n2)
                    return -1;
                else
                    return 0;
            }
        });
        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == 0) {
                if (pq.isEmpty())
                    result.append(0);
                else
                    result.append(pq.poll());
                result.append("\n");
            } else {
                pq.add(cmd);
            }
        }

        bw.write(result.toString());
        bw.flush();
    }
}
