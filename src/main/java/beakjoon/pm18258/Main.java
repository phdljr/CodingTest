package beakjoon.pm18258;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            String command = str[0];
            switch (command){
                case "push":
                    int num = Integer.parseInt(str[1]);
                    queue.add(num);
                    break;
                case "pop":
                    int pop = queue.isEmpty() ? -1 : queue.poll();
                    result.append(pop).append("\n");
                    break;
                case "size":
                    result.append(queue.size()).append("\n");
                    break;
                case "empty":
                    result.append((queue.isEmpty() ? 1 : 0)).append("\n");
                    break;
                case "front":
                    result.append((queue.isEmpty() ? -1 : queue.getFirst())).append("\n");
                    break;
                case "back":
                    result.append((queue.isEmpty() ? -1 : queue.getLast())).append("\n");
                    break;
            }
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}


