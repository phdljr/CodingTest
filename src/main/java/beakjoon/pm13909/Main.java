package beakjoon.pm13909;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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

        Deque<Node> deque = new ArrayDeque<>();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<n;i++){
            deque.add(new Node(i+1, arr[i]));
        }

        StringBuilder result = new StringBuilder();

        while (!deque.isEmpty()){
            Node node = deque.pollFirst();
            int index = node.order;
            int number = node.number;

            result.append(index).append(" ");

            if(deque.isEmpty())
                break;

            if(number > 0){
                number--;
                while(number > 0){
                    number--;
                    deque.addLast(deque.pollFirst());
                }
            } else{
                while(number < 0){
                    number++;
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}




