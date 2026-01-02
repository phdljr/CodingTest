package beakjoon.pm1966;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String result = "";
        int t = Integer.parseInt(br.readLine());
        Queue<int[]> queue = new LinkedList<>(); // {순서, 중요도}
        for(int i=0;i<t;i++){
            queue.clear();
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            str = br.readLine().split(" ");
            for(int j=1;j<=n;j++){
                queue.add(new int[]{j, Integer.parseInt(str[j-1])});
            }

            int count = 0;
            while (!queue.isEmpty()){

            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
