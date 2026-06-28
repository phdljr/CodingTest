package beakjoon.pm13305;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        int[] distance = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long minCost = cost[0];
        long result = 0;

        for (int i = 0; i < cost.length - 1; i++) {
            if (cost[i] < minCost) {
                minCost = cost[i];
            }
            result += minCost * distance[i];
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
