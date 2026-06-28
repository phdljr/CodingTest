package beakjoon.pm10845;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();
        int n =  Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            switch (str[0]){
                case "push": queue.add(Integer.parseInt(str[1])); break;
                case "pop": result.append(queue.isEmpty() ? -1 : queue.poll()).append("\n"); break;
                case "size": result.append(queue.size()).append("\n"); break;
                case "front": result.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n"); break;
                case "back": result.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n"); break;
                case "empty": result.append(queue.isEmpty() ? 1 : 0).append("\n"); break;
            }
        }

        bw.write(result.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}


