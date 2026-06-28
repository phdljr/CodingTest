package beakjoon.pm2346;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Node{
    int order;
    int number;

    public Node(int order, int number) {
        this.order = order;
        this.number = number;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Node> deque = new ArrayList<>();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<n;i++){
            deque.add(new Node(i + 1, arr[i]));
        }

        StringBuilder result = new StringBuilder();
        int index = 0;
        while(!deque.isEmpty()){
            Node node = deque.remove(index);
            if(!deque.isEmpty()) {
                if (node.number > 0) {
                    index = Math.abs(index + node.number - 1) % deque.size();
                } else {
                    index = Math.abs(index + node.number - 1) % deque.size();
                }
            }

            result.append(node.order).append(" ");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}



